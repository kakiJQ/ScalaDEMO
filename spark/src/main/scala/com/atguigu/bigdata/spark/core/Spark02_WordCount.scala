package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-01-11:09 PM
  */
object Spark01_WordCount {

  def main(args: Array[String]): Unit = {

    /*val sparkConf : SparkConf = new SparkConf().setMaster("local").setAppName("WordCount")

    val context = new SparkContext(sparkConf)


    val fileRDD : RDD[String] = context.textFile("input")

    val wordRDD : RDD[String] = fileRDD.flatMap(line=>{line.split(" ")})

    val mapRDD : RDD[(String, Int)] = wordRDD.map(word=>{(word,1)})

    val wordToSum : RDD[(String, Int)] = mapRDD.reduceByKey(_+_)


    val wordCountArray : Array[(String, Int)] = wordToSum.collect()

    val finalResult : String = wordCountArray.mkString(",")

    println(finalResult)

    context.stop()*/

  }

}
