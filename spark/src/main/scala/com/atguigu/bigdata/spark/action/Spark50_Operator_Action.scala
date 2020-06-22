package com.atguigu.bigdata.spark.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-06-1:49 PM
  */
object Spark50_Operator_Action {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val rdd : RDD[Int] = sc.makeRDD(List(1,2,3,4))

    // 保存成Text文件
    rdd.saveAsTextFile("output")

    // 序列化成对象保存到文件
    rdd.saveAsObjectFile("output1")

    // 保存成Sequencefile文件
    rdd.map((_,1)).saveAsSequenceFile("output2")

    sc.stop()

  }

}
