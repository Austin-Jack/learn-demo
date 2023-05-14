package cn.llynsyw.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.{col, column, udf}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object Basic {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQLBasic")
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    //DataFrame
    var df: DataFrame = spark.read.json("data/user.json")
    df.show()
    //sql
    df.createOrReplaceTempView("user")
    spark.sql(
      """
        |SELECT age
        |FROM user
        |""".stripMargin).show()

    //dsl
    //在使用 DataFrame 时，观果涉及到转换操作，需要引入转换规则,注意spark是对象名
    import spark.implicits._
    df.select("age", "username").show()
    df.select($"age" + 1).show()

    //DataFrame是特定泛型(ROW)的DataSet
    val seq = Seq(1, 2, 3, 4, 5)
    val ds: Dataset[Int] = seq.toDS()
    //RDD <=>DataFrame
    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List((1, "zhangsan", 30), (2, "lisi", 40)))
    df = rdd.toDF(colNames = "id", "name", "age")
    val rowRDD: RDD[Row] = df.rdd

    //DataFrame<=>DataSet
    var userDS: Dataset[User] = df.as[User]
    df = userDS.toDF()

    //RDD<=>DataSet
    userDS = rdd.map {
      case (id, name, age) => User(id, name, age)
    }.toDS()
    userDS.rdd

    val upperName: UserDefinedFunction = udf((name: String) => name.toUpperCase())
    userDS.withColumn("newName",upperName(col("name"))).show()
    spark.close()
  }

  case class User(id: Int, name: String, age: Int)
}
