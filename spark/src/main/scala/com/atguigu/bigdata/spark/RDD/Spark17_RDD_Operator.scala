package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark17_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[List[Int]] = sc.makeRDD(List(List(1,2),List(3,4)))

    val rdd: RDD[Int] = dataRDD.flatMap((list:List[Int])=>{list})

    println(rdd.collect().mkString(","))



    sc.stop()


  }

}
