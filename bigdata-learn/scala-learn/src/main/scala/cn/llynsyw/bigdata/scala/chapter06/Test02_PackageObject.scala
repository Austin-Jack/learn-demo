//package chapter06
//
//object Test02_PackageObject {
//  def main(args: Array[String]): Unit = {
//    commonMethod()
//    println(commonValue)
//  }
//}

package chapter06{

  import cn.llynsyw.bigdata.scala.chapter06.{commonMethod, commonValue}


  object Test02_PackageObject {
    def main(args: Array[String]): Unit = {
      commonMethod()
      println(commonValue)
    }
  }
}

package ccc{
  package ddd{
    object Test02_PackageObject{
      def main(args: Array[String]): Unit = {
        println(school)
      }
    }
  }
}

// 定义一个包对象
package object ccc{
  val school: String = "atguigu"
}