package cn.llynsyw.bigdata.scala.chapter05

object Test16_DynamicBinding {
  def main(args: Array[String]): Unit = {
    val person = new Student16
    println(person.name)
    person.hello()
  }
}

class Person16 {
  val name : String = "person_abc"

  def hello(): Unit = {
    println(s"hello Person, $name")
  }
}

class Student16 extends Person16{
  override val name : String = "student_bcn"

  override def hello(): Unit = {
    println(s"hello cn.llynsyw.scala.Student, $name")
  }
}