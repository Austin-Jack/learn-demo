package cn.llynsyw.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

case object WordCount2 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount2")
    val sc = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("data")
    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordMarkWithOne: RDD[(String, Int)] = words.map((_, 1))
    val group: RDD[(String, Iterable[(String, Int)])] = wordMarkWithOne.groupBy(_._1)
    val wordCount: RDD[(String, Int)] = group.map {
      case (word, list) => {
        list.reduce(
          (t1, t2) => {
            (t1._1, t2._2 + t2._2)
          }
        )
      }
    }
    val result: Array[(String, Int)] = wordCount.collect()
    result.foreach(println)
    sc.stop()
  }
}
