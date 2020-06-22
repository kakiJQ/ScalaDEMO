package com.atguigu.bigdata.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-07-2:37 PM
  */
object WordCount00 {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc : SparkContext = new SparkContext(sparkConf)

    val dataRDD : RDD[String] = sc.makeRDD(List("hello scala","hello spark"),2)

    val fmRDD : RDD[String] = dataRDD.flatMap(line=>{line.split(" ")})

    //val mapRDD : RDD[Map[String, Int]] = fmRDD.map(word=>{Map[String,Int]((word,1))})

    fmRDD.aggregate(Map[String,Int]())(
      (map,k)=>{map.updated(k,map.getOrElse(k,0)+1)},
      (map1,map2)=>{
        map1.foldLeft(map2)(
          (map,kv)=>{
            map.updated(kv._1,map.getOrElse(kv._1,0)+kv._2)
          }
        )
      }
    )

    sc.stop()

  }

}
