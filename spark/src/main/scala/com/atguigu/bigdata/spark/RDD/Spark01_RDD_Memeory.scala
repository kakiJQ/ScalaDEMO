package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark01_RDD_Memeory {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val fileRDD : RDD[String] = sc.textFile("input/apache.log")

    val urlRDD : RDD[String] = fileRDD.map(
      line => {
        val strings: Array[String] = line.split(" ")
        strings(6)
      }
    )

    urlRDD.collect().foreach(println)

    sc.stop()


  }

}
