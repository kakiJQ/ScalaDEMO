package com.atguigu.bigdata.spark.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-06-1:49 PM
  */
object Spark51_Operator_Action {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val rdd : RDD[Int] = sc.makeRDD(List(1,2,3,4))

    //TODO foreach方法
    //集合的方法中的代码是在当前节点中执行的
    //foreach方法是在当前节点的内存中完成数据循环的
    rdd.collect().foreach(println)
    println("**************************")

    //TODO 算子
    //rdd的方法称之为算子
    //算子的逻辑代码是在分布式计算节点EXECUTOR执行的
    //foreach算子可以将循环在不同的计算节点完成
    //算子之外的代码是在Driver端执行
    rdd.foreach(println)


    sc.stop()

  }

}
