package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-12-7:55 PM
  */
object SparkSQL6_UDAF_LoadSave1 {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark : SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    val df: DataFrame = spark.read.format("json").load("input/user.json")




    //df.write.format("json").save("output")

    spark.stop()

  }



}
