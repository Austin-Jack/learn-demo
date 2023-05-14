package cn.llynsyw.bigdata.scala.chapter02

import scala.io.StdIn

object Test05_StdIn {
  def main(args: Array[String]): Unit = {
    println("请输入你的大名：")
    val name: String = StdIn.readLine()
    println("请输入你的年龄：")
    val age : Int = StdIn.readInt()
    println(s"${name}，您好，您今年${age}岁")
  }
}
