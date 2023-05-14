package cn.llynsyw.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("data")
    println
    val words: RDD[String] = lines.flatMap(_.split(" "))
    println(words)
    val group: RDD[(String, Iterable[String])] = words.groupBy(word => word)
    println(group)
    val wordcount: RDD[(String, Int)] = group.map(kv => (kv._1, kv._2.size))
    println(wordcount)
    val result: List[(String, Int)] = wordcount.collect().toList
    println(result)


    sc.stop()
  }

}
