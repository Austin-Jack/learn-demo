package cn.llynsyw.bigdata.scala.chapter06

object Test18_Array {
  def main(args: Array[String]): Unit = {
    val arr = new Array[Int](2)
    arr.update(0, 99)
    arr(1) = 2

    val b = arr.apply(1)
    println(b)
    for (i <- 0 until arr.length) {
      println(arr(i))
    }

    for(i <- arr.indices) {
      println(arr(i))
    }

    val iterator = arr.iterator
    while(iterator.hasNext)
      println(iterator.next())

    for (elem <- arr) println(elem)

    arr.foreach(println)

    println(arr.mkString("--"))

    val newArray = 20 +: arr :+ 19
    println(newArray.mkString("--"))


    val list = List(1, 2, 3)
    val arr2 = Array apply  (1, "2")
  }

}
