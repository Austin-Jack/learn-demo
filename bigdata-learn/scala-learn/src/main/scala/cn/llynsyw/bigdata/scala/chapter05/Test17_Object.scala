package cn.llynsyw.bigdata.scala.chapter05

object Test17_Object {
  def main(args: Array[String]): Unit = {
    val student1 = Student17.newStudent("Bob", 23)
    student1.printInfo()


//  apply方法优惠政策
    val student2 = Student17("alice", 18)
    student2.printInfo()
  }
}

class Student17 private(val name: String, val age: Int) {
  def printInfo(): Unit = {
    println(s"name : $name, age: $age, school: ${Student17.school}")
  }
}

object Student17 {
  val school: String = "atguigu"

  def newStudent(name : String, age : Int) : Student17 = {
    new Student17(name, age)
  }

  def apply(name: String, age : Int) : Student17 = {
    new Student17(name, age)
  }
}