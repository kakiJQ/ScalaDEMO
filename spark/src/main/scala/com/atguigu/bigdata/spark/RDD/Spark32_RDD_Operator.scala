package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark32_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Int] = sc.makeRDD(List(4,2,1,0,3),2)

    val sortRDD : RDD[Int] = dataRDD.sortBy(num=>num,false)


    println(sortRDD.collect().mkString(","))
    

    sc.stop()


  }

}
