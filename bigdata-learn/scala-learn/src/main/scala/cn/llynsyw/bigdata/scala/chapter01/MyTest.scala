package cn.llynsyw.bigdata.scala.chapter01

import scala.collection.mutable


object MyTest {
  def main(args: Array[String]): Unit = {
    def splitter(str: String): Array[String] = {
      str.split(" ")
    }

    val strings = List[String]("hello world", "hello scala", "hello spark")
    val words: List[Array[String]] = strings.map(splitter)
    println(words.flatten)

    println(strings.flatMap(_.split(" ")))

    val list = List(1, 2, 3, 4, 5)
    val group1: Map[Int, List[Int]] = list.groupBy(_ % 2)
    val group2 = list.groupBy(data => if (data % 2 == 0) "偶数" else "奇数")
    println(group1)
    println(group2)

    val list2 = List(5, 4, 3, 2, 1)
    println(list.reduceRight(_ - _))
    println(list2.foldLeft(10)(_ + _))

    val map1 = Map("a" -> 1, "b" -> 3, "c" -> 5, "f" -> 3)
    val map2 = mutable.Map("a" -> 1, "b" -> 3, "c" -> 5, "d" -> 6, "e" -> 3)

    val mergedMap = map1.foldLeft(map2)(
      (mergedMap, kv) => {
        val key = kv._1
        val value = kv._2
        mergedMap(key) = mergedMap.getOrElse(key, 0) + value
        mergedMap
      }
    )

    println(mergedMap)
  }
}
