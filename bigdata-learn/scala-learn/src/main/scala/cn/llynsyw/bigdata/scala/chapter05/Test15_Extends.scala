package cn.llynsyw.bigdata.scala.chapter05

object Test15_Extends {
  def main(args: Array[String]): Unit = {
    val student1 = new Student2("lly", 2, 110)
    student1.printInfo()
  }
}


class Person {
  var name: String = _
  var age: Int = _

  println("1. 父类主构造器被调用")

  def this(name: String, age: Int) {
    this()
    println("2. 父类的辅助构造器被调用")
    this.name = name
    this.age = age
  }

  def printInfo(person: Person): Unit = {
    person.printInfo()
  }

  def printInfo(): Unit = {
    println(s"name: $name, age: $age")
  }
}

class Student2(name: String, age: Int) extends Person(name, age) {
  var stdNo: Int = _

  println("3. 子类的主构造器被调用")

  def this(name: String, age : Int, stdNo: Int) = {
    this(name, age)
    println("4. 子类的辅助构造器被调用")
    this.stdNo = stdNo
  }

  override def printInfo(): Unit = {
    println(s"name: $name, age: $age, stNo: $stdNo")
  }
}
