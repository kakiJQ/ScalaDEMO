package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-12-7:55 PM
  */
object SparkSQL11_Load_Hive {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark : SparkSession = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()


    //spark.sql("create table aa(id int)")
    //spark.sql("show tables").show()

    spark.sql("load data local inpath 'input/id.txt' into table aa")

    spark.sql("select * from aa").show



    spark.stop()

  }



}
