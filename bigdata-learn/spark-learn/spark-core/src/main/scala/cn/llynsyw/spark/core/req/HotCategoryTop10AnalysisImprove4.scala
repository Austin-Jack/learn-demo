package cn.llynsyw.spark.core.req

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable


object HotCategoryTop10AnalysisImprove4 {
  def main(args: Array[String]): Unit = {
    //  TODO: TOP10热门商品
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
    val sc = new SparkContext(sparkConf)

    // 1. 读取原始数据
    val rawRdd: RDD[String] = sc.textFile("data/user_visit_action.txt")
    val hotCategoryAccumulator = new HotCategoryAccumulator
    sc.register(hotCategoryAccumulator, "hotCategoryAccumulator")
    rawRdd.foreach {
      row =>
        val data: Array[String] = row.split("_")

        if (data(6) != "-1") {
          hotCategoryAccumulator.add(data(6), (1, 0, 0))
        } else if (data(8) != "null") {
          val ids: Array[String] = data(8).split(",")
          ids.foreach(hotCategoryAccumulator.add(_, (0, 1, 0)))
        } else if (data(10) != "null") {
          val ids: Array[String] = data(10).split(",")
          ids.foreach(hotCategoryAccumulator.add(_, (0, 0, 1)))
        }
    }

    hotCategoryAccumulator
      .value.values
      .map(
        category =>
          (category.cid, (category.clickCount, category.orderCount, category.payCount))
      )
      .toList
      .sortBy(_._2)(Ordering.Tuple3[Int, Int, Int].reverse)
      .take(10)
      .foreach(println)


    sc.stop()
  }

  case class HotCategory(cid: String, var clickCount: Int, var orderCount: Int, var payCount: Int) {
    def add(inTuple: (Int, Int, Int)): Unit = {
      this.clickCount += inTuple._1
      this.orderCount += inTuple._2
      this.payCount += inTuple._3
    }
  }

  class HotCategoryAccumulator extends AccumulatorV2[(String, (Int, Int, Int)), mutable.Map[String, HotCategory]] {
    private val hcMap: mutable.Map[String, HotCategory] = mutable.Map()

    override def isZero: Boolean = hcMap.isEmpty

    override def copy(): AccumulatorV2[(String, (Int, Int, Int)), mutable.Map[String, HotCategory]] = new HotCategoryAccumulator

    override def reset(): Unit = hcMap.clear()

    override def value: mutable.Map[String, HotCategory] = hcMap

    override def add(inTuple: (String, (Int, Int, Int))): Unit = {
      val category: HotCategory = hcMap.getOrElse(inTuple._1, HotCategory(inTuple._1, 0, 0, 0))
      category.add(inTuple._2)
      hcMap.update(inTuple._1, category)
    }

    override def merge(other: AccumulatorV2[(String, (Int, Int, Int)), mutable.Map[String, HotCategory]]): Unit = {
      other.value.foreach {
        case (cid, category) =>
          val targetCategory: HotCategory = hcMap.getOrElse(cid, HotCategory(cid, 0, 0, 0))
          targetCategory.clickCount += category.clickCount
          targetCategory.orderCount += category.orderCount
          targetCategory.payCount += category.payCount
          hcMap.update(cid, targetCategory)
      }
    }
  }
}
