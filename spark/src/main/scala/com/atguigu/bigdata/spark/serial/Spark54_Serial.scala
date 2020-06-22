package com.atguigu.bigdata.spark.serial

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-06-2:35 PM
  */
object Spark54_Serial {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val rdd : RDD[String] = sc.makeRDD(List(
      "hello scala", "hello spark"
    ))

    println(rdd.toDebugString)
    println("---------------")

    val wordRDD: RDD[String] = rdd.flatMap(
      string => {
        string.split(" ")
      }
    )

    println(wordRDD.toDebugString)
    println("---------------")

    val mapRDD : RDD[(String, Int)] = wordRDD.map(
      word => (word, 1)
    )

    println(mapRDD.toDebugString)
    println("---------------")

    val reduceRDD : RDD[(String, Int)] = mapRDD.reduceByKey(_+_)

    println(reduceRDD.toDebugString)
    println("---------------")

    reduceRDD.collect().foreach(println)


    sc.stop()
  }

}

