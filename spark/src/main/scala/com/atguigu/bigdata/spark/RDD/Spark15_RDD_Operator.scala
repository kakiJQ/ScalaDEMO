package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark15_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Int] = sc.makeRDD(List(1,4,3,2,5,6),2)

    val rdd : RDD[(Int, Int)] = dataRDD.mapPartitionsWithIndex(
      (index, iter) => {
        List((index, iter.max)).iterator
      }
    )
    println(rdd.collect().mkString(","))

    sc.stop()


  }

}
