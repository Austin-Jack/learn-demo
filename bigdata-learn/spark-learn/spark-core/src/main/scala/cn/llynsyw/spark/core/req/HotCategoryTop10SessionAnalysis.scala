package cn.llynsyw.spark.core.req

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable


object HotCategoryTop10SessionAnalysis {
  def main(args: Array[String]): Unit = {
    //  TODO: Top10 热门品类中每个品类的Top10 活跃Session 统计
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
    val sc = new SparkContext(sparkConf)

    // 1. 读取原始数据
    val rawRdd: RDD[String] = sc.textFile("data/user_visit_action.txt")
    rawRdd.cache()

    val targetIds = List(1, 2, 3, 4, 5, 6, 7)


    val userActionRdd: RDD[UserVisitAction] = rawRdd
      .map(_.split("_"))
      .map(data => UserVisitAction(data(0), data(1).toLong, data(2), data(3).toLong, data(4), data(5), data(6).toLong, data(7).toLong, data(8), data(9), data(10), data(11), data(12).toLong))
    userActionRdd.cache()

    val pageIdToCountMap: Map[Long, Long] =
      userActionRdd
        .filter(action =>  targetIds.init.contains(action.page_id))
        .map(action => (action.page_id, 1L))
        .reduceByKey(_ + _)
        .collect()
        .toMap

    val targetFlows: List[(Int, Int)] = targetIds.zip(targetIds.tail)
    val pageFlowRdd: RDD[((Long, Long), Long)] = userActionRdd
      .groupBy(_.session_id)
      .mapValues(
        iter => {
          val flowIds: List[Long] = iter.toList.sortBy(_.action_time).map(_.page_id)
          flowIds.zip(flowIds.tail)
            .filter(targetFlows.contains(_))
            .map((_, 1L))
        }
      )
      .flatMap(_._2)
      .reduceByKey(_ + _)


    pageFlowRdd
      .foreach {
        case ((fromPageId, toPageId), count) =>
          val sum: Long = pageIdToCountMap.getOrElse(fromPageId, 0L)
          println(s"页面${fromPageId}到${toPageId}单跳转转换率为" + count.toDouble / sum)
      }


    sc.stop()
  }

  case class UserVisitAction(
                              date: String, //用户点击行为的日期
                              user_id: Long, // 用 户 的 ID
                              session_id: String, //Session 的ID
                              page_id: Long, // 某 个 页 面 的 ID
                              action_time: String, //动作的时间点
                              search_keyword: String, //用户搜索的关键词
                              click_category_id: Long, // 某 一 个 商 品 品 类 的 ID
                              click_product_id: Long, // 某 一 个 商 品 的 ID
                              order_category_ids: String, //一次订单中所有品类的 ID 集合
                              order_product_ids: String, //一次订单中所有商品的 ID 集合
                              pay_category_ids: String, //一次支付中所有品类的 ID 集合
                              pay_product_ids: String, //一次支付中所有商品的 ID 集合
                              city_id: Long //城市id
                            )
}
