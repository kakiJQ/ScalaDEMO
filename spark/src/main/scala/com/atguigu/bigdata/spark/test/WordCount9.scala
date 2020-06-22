package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-07-2:37 PM
  */
object WordCount9 {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc : SparkContext = new SparkContext(sparkConf)

    val dataRDD : RDD[String] = sc.makeRDD(List("hello scala","hello spark"),2)

    val fmRDD : RDD[String] = dataRDD.flatMap(line=>{line.split(" ")})

    val mapRDD : RDD[(String, Int)] = fmRDD.map(word=>{(word,1)})


    //TODO: countByKey
    val countValue : collection.Map[String, Long] = mapRDD.countByKey()

    countValue.foreach(println)
    
    sc.stop()

  }

}
