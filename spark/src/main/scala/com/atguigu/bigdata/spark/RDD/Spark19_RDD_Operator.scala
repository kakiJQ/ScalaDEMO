package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark19_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Any] = sc.makeRDD(List(1,2,3,4),2)

    val rdd : RDD[Array[Any]] = dataRDD.glom()

    rdd.collect().foreach(
      (array:Array[Any])=>{println(array.mkString(","))}
    )
    





    sc.stop()


  }

}
