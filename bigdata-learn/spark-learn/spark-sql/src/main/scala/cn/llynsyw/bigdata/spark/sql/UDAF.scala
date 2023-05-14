package cn.llynsyw.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{DataFrame, Encoder, Encoders, SparkSession, functions}

object UDAF {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQLBasic")
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    //DataFrame
    var df: DataFrame = spark.read.json("data/user.json")
    df.createOrReplaceTempView("user")

    spark.udf.register("ageAvg",functions.udaf(new MyAggregator()))
    spark.sql(
      """
        |SELECT ageAvg(age)
        |FROM user
        |""".stripMargin).show()

    spark.close()
  }

  case class Buff(var total: Long, var count: Long)

  /*自定义聚合函数类：计算年龄的平均值
  1.继承 org.apache.spark.sql.expressions..Aggregator，定义泛型
      IN：输入的数据类型 Long
      BUFF：缓冲区的数据类型
      BuffOUT：输出的数据类型 Long
  2.重写方法（6）
  */
  class MyAggregator extends Aggregator[Long, Buff, Long] {
    override def zero: Buff = Buff(0, 0)

    override def reduce(b: Buff, a: Long): Buff = {
      b.total += a
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
