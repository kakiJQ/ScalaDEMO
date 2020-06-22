package com.atguigu.bigdata.spark.sql

import org.apache.spark.{Aggregator, SparkConf}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-12-7:55 PM
  */
object SparkSQL4_UDAF_class {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark : SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import spark.implicits._

    val rdd : RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List(
      (1, "zhangsan", 30),
      (2, "lisi", 20),
      (3, "wangwu", 40)
    ))

    val df : DataFrame = rdd.toDF("id","name","age")
    val ds : Dataset[User] = df.as[User]





    spark.sql("select avgAge(age) from user").show()

    spark.stop()

  }

  case class User(id:Int,name:String,age:Int)

  case class AvgBuffer(var totalage:Long, var count:Long)




}
