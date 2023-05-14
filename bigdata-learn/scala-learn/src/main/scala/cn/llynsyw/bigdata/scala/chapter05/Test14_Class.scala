package cn.llynsyw.bigdata.scala.chapter05

object Test14_Class {
  def main(args: Array[String]): Unit = {
    val student1 = new Student("lly", 23)
    val student2 = new Student("bob", 25, "atguigu")
    student1.printInfo()
    student2.printInfo()
  }
}


class Student(var name: String, var age: Int) {
  var school: String = _

  def this(name: String, age: Int, school: String) {
    this(name, age)
    this.school = school
  }

  def printInfo(): Unit = {
    println(s"name: $name, age: $age, school: $school")
  }
}