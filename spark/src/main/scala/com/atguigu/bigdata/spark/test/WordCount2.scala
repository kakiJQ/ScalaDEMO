package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayOps

/**
  * @Description
  * @Author kaki
  * @create 2020-06-07-2:37 PM
  */
object WordCount2 {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc : SparkContext = new SparkContext(sparkConf)

    val dataRDD : RDD[String] = sc.makeRDD(List("hello scala","hello spark"))

    val fmRDD : RDD[String] = dataRDD.flatMap(line => {
      line.split(" ")
    })

    val tupleRDD : RDD[(String, Int)] = fmRDD.map(word => {
      (word, 1)
    })

    //TODO: groupByKey
    val groupRDD : RDD[(String, Iterable[Int])] = tupleRDD.groupByKey()

    val countRDD : RDD[(String, Int)] = groupRDD.map {
      case (key, count) => {
        (key, count.sum)
      }
    }


    countRDD.collect().foreach(println)

    sc.stop()

  }

}
