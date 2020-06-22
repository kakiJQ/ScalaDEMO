package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-12-7:55 PM
  */
object SparkSQL9_UDAF_MySQL {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark : SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()


    import spark.implicits._

    spark.read.format("jdbc")
      .option("url", "jdbc:mysql://hadoop102:3306/spark-sql")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      .option("dbtable", "user")
      .load().show






    spark.stop()

  }



}
