package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark18_RDD_Operator {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[Any] = sc.makeRDD(List(List(1,2),3,List(4,5)))

    val rdd : RDD[Any] = dataRDD.flatMap(
      data => {
        data match {
          case list: List[Int] => list
          case d => List(d)
        }
      }
    )
    val str: String = rdd.collect().mkString(",")

    println(str)





    sc.stop()


  }

}
