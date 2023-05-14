package cn.llynsyw.spark.core.req

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object HotCategoryTop10AnalysisImprove1 {
  def main(args: Array[String]): Unit = {
    //  TODO: TOP10热门商品
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
    val sc = new SparkContext(sparkConf)

    // 1. 读取原始数据
    val rawRdd: RDD[String] = sc.textFile("data/user_visit_action.txt")
    rawRdd.cache()

    // 2. 统计品类的点击数量 （品类id，点击数量）
    val clickCountRdd: RDD[(String, (Int, Int, Int))] =
      rawRdd
        .filter(_.split("_")(6) != "-1")
        .map(_.split("_")(6))
        .map((_, 1))
        .reduceByKey(_ + _)
        .map {
          case (cid, cnt) => (cid, (cnt, 0, 0))
        }

    // 3. 统计品类的下单数量  （品类id，下单数量）

    val orderCountRdd: RDD[(String, (Int, Int, Int))] = rawRdd
      .filter(_.split("_")(8) != "null")
      .map(_.split("_")(8))
      .flatMap(_.split(","))
      .map((_, 1))
      .reduceByKey(_ + _)
      .map {
        case (cid, cnt) => (cid, (0, cnt, 0))
      }

    //4. 统计品类的支付数量    （品类id，支付数量）
    val payCountRdd =
      rawRdd
        .filter(_.split("_")(10) != "null")
        .map(_.split("_")(10))
        .flatMap(_.split(","))
        .map((_, 1))
        .reduceByKey(_ + _)
        .map(t => (t._1, (0, 0, t._2)))

    //5. 将品类进行排序并取前10名
    //点击数量排序、下单数量排序、支付数量排序
    //（品类id，（点击数量，下单数量，支付数)）
    val sourceRdd: RDD[(String, (Int, Int, Int))] = clickCountRdd.union(orderCountRdd).union(payCountRdd)

    val analysisResult: RDD[(String, (Int, Int, Int))] = sourceRdd.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )

    //6. 将结果打印到控制台
    val resultRdd: Array[(String, (Int, Int, Int))] = analysisResult.sortBy(_._2, false).take(10)
    resultRdd.foreach(println)


    sc.stop()
  }
}
