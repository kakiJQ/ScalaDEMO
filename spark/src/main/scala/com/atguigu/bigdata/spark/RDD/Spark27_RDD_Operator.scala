package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark27_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),2)

    val rdd : RDD[Int] = dataRDD.sample(
      false,
      0.5,
      1
    )

    val rdd1 : RDD[Int] = dataRDD.sample(
      true,
      2
    )

    println(rdd.collect().mkString(","))

    //println(rdd1.collect().mkString(","))



    





    sc.stop()


  }

}
