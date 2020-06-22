package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark29_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Int] = sc.makeRDD(List(1,1,1,3,3,3),2)

    val filterRDD : RDD[Int] = dataRDD.filter(_%2==0)

    val coalesceRDD : RDD[Int] = filterRDD.coalesce(1)



    sc.stop()


  }

}
