package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-04-10:22 PM
  */
object Test1 {

  def main(args: Array[String]): Unit = {

    //小功能：将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组。
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc: SparkContext = new SparkContext(sparkConf)

    val dataRDD : RDD[String] = sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"))

    val gRDD : RDD[(String, Iterable[String])] = dataRDD.groupBy(key=>{key.substring(0,1)})

    println(gRDD.collect().mkString(","))


  }

}
