package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark20_RDD_Test {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    /*val rdd : RDD[Array[Int]] = dataRDD.glom()


    val pMax : RDD[Int] = rdd.flatMap(list=>{List(list.max)})

    println(pMax.collect().sum)*/

    val pMax : RDD[Int] = dataRDD.mapPartitions(
      iter => {
        List(iter.max).iterator
      }
    )

    println(pMax.collect().sum)





    sc.stop()


  }

}
