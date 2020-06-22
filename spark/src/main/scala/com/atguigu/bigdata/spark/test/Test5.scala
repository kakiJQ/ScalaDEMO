package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-04-10:22 PM
  */
object Test5 {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc: SparkContext = new SparkContext(sparkConf)

    val list = List(1,2,3,4,5,6,7,8)

    val rdd: RDD[Int] = sc.makeRDD(list,4)
    val rdd1: RDD[(Int, Iterable[Int])] = rdd.groupBy(((num :Int) => num % 2),2)
    rdd1.saveAsTextFile("output")



    sc.stop()

  }

}
