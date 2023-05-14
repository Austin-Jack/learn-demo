package cn.llynsyw.bigdata.scala.chapter01

class Student(name: String, var age: Int) {
  def printInfo(): Unit = {
    println("name:" + name + " age:" + age + " from " + Student.school)
  }
}

object Student {
  val school = "atguigu"

  def main(args: Array[String]): Unit = {
    val alice: Student = new Student("alice", 20)
    val bob: Student = new Student("Bob", 23)

    alice.printInfo()
    bob.printInfo()
  }
}