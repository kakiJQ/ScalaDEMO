package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark33_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD1 : RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val dataRDD2 : RDD[Int] = sc.makeRDD(List(3,4,5,6),2)

    val uRDD : RDD[Int] = dataRDD1.union(dataRDD2)
    println(uRDD.collect().mkString(","))

    val iRDD : RDD[Int] = dataRDD1.intersection(dataRDD2)
    println(iRDD.collect().mkString(","))

    val sRDD : RDD[Int] = dataRDD1.subtract(dataRDD2)
    println(sRDD.collect().mkString(","))

    val zipRDD : RDD[(Int, Int)] = dataRDD1.zip(dataRDD2)
    println(zipRDD.collect().mkString(","))
    

    sc.stop()


  }

}
