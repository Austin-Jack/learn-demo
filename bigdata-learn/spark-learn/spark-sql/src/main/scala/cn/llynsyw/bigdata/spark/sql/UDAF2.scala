package cn.llynsyw.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql._

object UDAF2 {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQLBasic")
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    //DataFrame
    val df: DataFrame = spark.read.json("data/user.json")
    import spark.implicits._
    val ds: Dataset[User] = df.as[User]
    ds.createOrReplaceTempView("user")


    //早起无法在SQL中用udaf
    //将 UDAF 函数转换为查询的列对象
    val udafColumn: TypedColumn[User, Long] = new MyAggregator().toColumn
    ds.select(udafColumn).show()
    spark.close()

  }

  case class Buff(var total: Long, var count: Long)

  case class User(username: String, age: Long)

  /*自定义聚合函数类：计算年龄的平均值
  1.继承 org.apache.spark.sql.expressions..Aggregator，定义泛型
      IN：输入的数据类型 User
      BUFF：缓冲区的数据类型
      BuffOUT：输出的数据类型 Long
  2.重写方法（6）
  */
  class MyAggregator extends Aggregator[User, Buff, Long] {
    override def zero: Buff = Buff(0, 0)

    override def reduce(b: Buff, user: User): Buff = {
      b.total += user.age
      b.count += 1
      b
    }

    override def merge(b1: Buff, b2: Buff): Buff = {
      b1.total += b2.total
      b1.count += b2.count
      b1
    }

    override def finish(reduction: Buff): Long = {
      reduction.total / reduction.count
    }

    override def bufferEncoder: Encoder[Buff] = Encoders.product

    override def outputEncoder: Encoder[Long] = Encoders.scalaLong
  }
}
