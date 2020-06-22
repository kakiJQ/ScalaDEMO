package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayOps

/**
  * @Description
  * @Author kaki
  * @create 2020-06-04-10:22 PM
  */
object Test2 {

  def main(args: Array[String]): Unit = {

    //小功能：从服务器日志数据apache.log中获取每个时间段访问量。
    //83.149.9.216 - - 17/05/2015:10:05:03 +0000 GET /presentations/logstash-monitorama-2013/images/kibana-search.png
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc: SparkContext = new SparkContext(sparkConf)

    val dataRDD : RDD[String] = sc.textFile("input/apache.log")

    val durationRDD : RDD[String] = dataRDD.flatMap(
      line => {
        val strings: ArrayOps.ofRef[String] = line.split(" ")
        List(strings(3))
      }
    )


    val groupRDD : RDD[(String, Iterable[String])] = durationRDD.groupBy(key=>{key.substring(0,13)})

    val countRDD : RDD[(String, Int)] = groupRDD.map(data=>{(data._1,data._2.size)})

    val sortRDD : RDD[(String, Int)] = countRDD.sortBy(list=>{list._1})

    sortRDD.collect().foreach(println)

    sc.stop()

  }

}
