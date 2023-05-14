package cn.llynsyw.bigdata.scala.chapter01

import scala.collection.mutable.ListBuffer
import scala.io.Source

object CommonWordCount {
  def main(args: Array[String]): Unit = {
    val strings = readData()
    val words: List[String] = strings.flatMap(_.split("[\\s\\.,\\n]+"))
    println(words)
    val wordMap: Map[String, List[String]] = words.groupBy(word => word)
    val countMap: Map[String, Int] = wordMap.map(kv => (kv._1, kv._2.length))
    val result: List[(String, Int)] = countMap.toList
      .sortWith(_._2 > _._2)
      .take(3)

    println(result)
  }

  def readData(): List[String] = {
    val source = Source.fromFile("src/main/resources/words.txt")
    val listBuffer = ListBuffer[String]()
    source.getLines().foreach(line => listBuffer.append(line))
    source.close()
    listBuffer.toList
  }
}
