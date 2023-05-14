package cn.llynsyw.spark.core.req

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object HotCategoryTop10AnalysisImprove2 {
  def main(args: Array[String]): Unit = {
    //  TODO: TOP10热门商品
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
    val sc = new SparkContext(sparkConf)

    // 1. 读取原始数据
    val rawRdd: RDD[String] = sc.textFile("data/user_visit_action.txt")
    rawRdd.cache()

    val sourceRdd: RDD[(String, (Int, Int, Int))] = rawRdd.flatMap(
      row => {
        val data: Array[String] = row.split("_")

        if (data(6) != "-1") {
          List((data(6), (1, 0, 0)))
        } else if (data(8) != "null") {
          val ids: Array[String] = data(8).split(",")
          ids.map((_, (0, 1, 0)))
        } else if (data(10) != "null") {
          val ids: Array[String] = data(10).split(",")
          ids.map((_, (0, 0, 1)))
        } else {
          Nil
        }
      }
    )


    val analysisResult: RDD[(String, (Int, Int, Int))] = sourceRdd.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )

    //6. 将结果打印到控制台
    val resultRdd: Array[(String, (Int, Int, Int))] = analysisResult.sortBy(_._2, ascending = false).take(10)
    resultRdd.foreach(println)


    sc.stop()
  }
}
