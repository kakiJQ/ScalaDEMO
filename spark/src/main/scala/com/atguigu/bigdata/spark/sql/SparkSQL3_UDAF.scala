package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-12-7:55 PM
  */
object SparkSQL3_UDAF {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark : SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import spark.implicits._

    val rdd : RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List(
      (1, "zhangsan", 30),
      (2, "lisi", 20),
      (3, "wangwu", 40)
    ))



    // TODO 使用 自定义函数在SQL中完成数据的转换操作
    val df : DataFrame = rdd.toDF("id","name","age")
    df.createOrReplaceTempView("user")


    val udaf = new MyAvgAgeUDAF
    spark.udf.register("avgAge",udaf)

    spark.sql("select avgAge(age) from user").show()

    spark.stop()

  }

  class MyAvgAgeUDAF extends UserDefinedAggregateFunction{
    override def inputSchema: StructType = {
      StructType(Array(StructField("age",LongType)))
    }

    override def bufferSchema: StructType = {
      StructType(Array(
        StructField("totalage",LongType),
        StructField("count",LongType)
      ))
    }

    override def dataType: DataType = {
      LongType
    }

    override def deterministic: Boolean = true

    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0) = 0L
      buffer(1) = 0L
    }

    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer(0) = buffer.getLong(0) + input.getLong(0)
      buffer(1) = buffer.getLong(1) + 1
    }

    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
      buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
    }

    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0) / buffer.getLong(1)
    }
  }

}
