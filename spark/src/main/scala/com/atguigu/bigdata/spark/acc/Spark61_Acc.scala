package com.atguigu.bigdata.spark.acc

import org.apache.spark.rdd.RDD
import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-06-08-2:03 PM
  */
object Spark61_Acc {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")

    val sc : SparkContext = new SparkContext(sparkConf)

    val rdd : RDD[Int] = sc.makeRDD(List(1,2,3,4))

    val sum: LongAccumulator = sc.longAccumulator("sum")

    rdd.foreach(
      num=>{
        sum.add(num)
      }
    )

    println(sum.value)

    sc.stop()

  }


}
