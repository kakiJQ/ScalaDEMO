package com.atguigu.bigdata.spark.acc

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-06-08-2:03 PM
  */
object Spark63_BC {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")

    val sc : SparkContext = new SparkContext(sparkConf)


    val rdd : RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3)))

    val list = List(("a",1),("b",2),("c",3))

    val rdd2 : RDD[(String, (Int, Int))] = rdd.map {
      case (k, v1) => {
        var v2 = 0

        for (i <- list) {
          if (i._1 == k) {
            v2 = i._2
          }
        }

        (k, (v1, v2))
      }
    }
    println(rdd2.collect().mkString(","))

    sc.stop()

  }


}
