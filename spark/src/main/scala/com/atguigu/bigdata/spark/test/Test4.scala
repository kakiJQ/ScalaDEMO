package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-04-10:22 PM
  */
object Test4 {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc: SparkContext = new SparkContext(sparkConf)

    //val dataRDD : RDD[String] = sc.textFile("input/apache.log")
    val dataRDD : RDD[Int] = sc.makeRDD(List(1,2,3,4,5),4)

    dataRDD.saveAsTextFile("output")


    sc.stop()

  }

}
