package cn.llynsyw.bigdata.scala.chapter01

object ComplexWordCount {
  def main(args: Array[String]): Unit = {
    val tupleList: List[(String, Int)] = List(
      ("hello", 1),
      ("hello world", 2),
      ("hello scala", 3),
      ("hello spark from scala", 1),
      ("hello flink from scala", 2)
    )

    val newList: List[String] = tupleList.map(
      tuple => (tuple._1.trim + " ") * tuple._2
    )

    val wordCountList: List[(String, Int)] = newList
      .flatMap(_.split(" "))
      .groupBy(word => word)
      .map(kv => (kv._1, kv._2.length))
      .toList
      .sortBy(_._2)(Ordering[Int].reverse)
      .take(3)

    println(wordCountList)


    val countList: List[(String, Int)] = tupleList
      .flatMap(tuple => tuple._1.split(" ")
        .map((_, tuple._2)))
      .groupBy(_._1)
      .mapValues(tupleList => tupleList.map(_._2).sum)
      .toList
      .sortWith(_._2 > _._2)
      .take(3)

    println(countList)


  }
}
