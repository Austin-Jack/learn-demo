package cn.llynsyw.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

case object WordCount3 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount2")
    val sc = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("data")
    val words: RDD[String] = lines.flatMap(_.split(" "))
    val result: RDD[(String, Int)] = words.map((_, 1)).reduceByKey(_ + _)
    result.collect.foreach(println)
    sc.stop()
  }
}
