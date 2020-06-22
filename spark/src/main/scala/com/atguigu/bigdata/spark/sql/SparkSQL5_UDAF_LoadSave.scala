package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-12-7:55 PM
  */
object SparkSQL5_UDAF_LoadSave {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark : SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import spark.implicits._

    val frame: DataFrame = spark.read.format("json").load("input/user.json")
    frame.show()

    spark.stop()

  }



}
