package cn.llynsyw.bigdata.scala.chapter01

import scala.annotation.tailrec

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("hello world!")
    System.out.print("hello scala from java!")

    //    for (i <- 10 until 5 by -1 if i != 6) println(i)
    //    //    for (i <- 1 to 9) {
    //    //      for (j <- 1 to i) {
    //    //        print(s"$j * $i = ${i * j}   ")
    //    //      }
    //    //      println("")
    //    //    }
    //    for (i <- 1 to 9; j <- 1 to i) {
    //      print(s"$j * $i = ${i * j}  ")
    //      if (i == j) println()
    //    }
    def opTwoVal(arr: Array[Int], op: Int => Int) = for (elem <- arr) yield op(elem)


    println(opTwoVal(Array(1, 2, 3, 4, 5), _ + 1).mkString(","))

    val fun = (i: Int, s: String, ch: Char) => i != 0 || s != "" || ch != '0'
    println(fun(0, "", '1'))

    def func(num: Int): String => Char => Boolean = {
      def f1(str: String): Char => Boolean = {
        def f2(char: Char): Boolean = num != 0 || str != "" || char != '0'

        f2
      }

      f1
    }

    def func2(num: Int): String => Char => Boolean = str => char => num != 0 || str != "" || char != '0'

    println(func2(0)("")('0'))

    def add(a: Int): Int => Int = a + _

    val addByFour = add(4)
    val addByFive = add(5)

    println(addByFive(31))
    println(addByFour(12))

    def addCurrying(a: Int)(b: Int): Int = a + b


    var n = 10
    while (n >= 1) {
      println(n)
      n -= 1
    }

    n = 10

    println("===========myWhile===============")

    def myWhile(condition: => Boolean): (=> Unit) => Unit = {
      def doLoop(op: => Unit): Unit = {
        if (condition) {
          op
          myWhile(condition)(op)
        }
      }

      doLoop _
    }

    myWhile(n >= 1) {
      println(n)
      n -= 1
    }

    println("===========myWhile2===============")

    def myWhile2(condition: => Boolean): (=> Unit) => Unit = {
      op => {
        if (condition) {
          op
          myWhile2(condition)(op)
        }
      }

    }

    n = 10

    myWhile2(n >= 1) {
      println(n)
      n -= 1
    }

    n = 10

    println("===========myWhile3===============")
    def myWhile3(condition: => Boolean)(op: => Unit): Unit = {
      if (condition) {
        op
        myWhile3(condition)(op)
      }
    }

    myWhile3(n >= 1) {
      println(n)
      n -= 1
    }

  }

}
