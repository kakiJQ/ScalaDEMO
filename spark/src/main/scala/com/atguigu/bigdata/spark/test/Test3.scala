package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayOps

/**
  * @Description
  * @Author kaki
  * @create 2020-06-04-10:22 PM
  */
object Test3 {

  def main(args: Array[String]): Unit = {

    //练习：从服务器日志数据apache.log中获取2015年5月17日的请求路径
    //83.149.9.216 - - 17/05/2015:10:05:03 +0000 GET /presentations/logstash-monitorama-2013/images/kibana-search.png
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc: SparkContext = new SparkContext(sparkConf)

    val dataRDD : RDD[String] = sc.textFile("input/apache.log")

    val uriRDD : RDD[(String, String)] = dataRDD.map(line => {
      val strings: Array[String] = line.split(" ")
      (strings(3), strings(6))
    })

    val filterRDD : RDD[(String, String)] = uriRDD.filter(t=>{t._1.contains("17/05/2015")})

    filterRDD.collect().foreach(println)




    sc.stop()

  }

}
