package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark13_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    /*val rdd : RDD[Int] = dataRDD.mapPartitions(iter => {
      //iter.foreach(println)
      //iter
      iter.map(_*2)
    })

    println(rdd.collect().mkString(","))*/

    val rdd : RDD[Int] = dataRDD.mapPartitions(
      iter => {
        iter.filter(_ % 2 == 0)
      }
    )

    val str : String = rdd.collect().mkString(",")


    println(str)

    sc.stop()


  }

}
