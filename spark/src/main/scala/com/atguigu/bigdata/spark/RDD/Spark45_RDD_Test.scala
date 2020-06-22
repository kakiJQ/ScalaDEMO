package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark45_RDD_Test {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[String] = sc.textFile("input/agent.log")

    val cleanData : RDD[(String, Int)] = dataRDD.map(line => {
      val strings: Array[String] = line.split(" ")
      (strings(1) + "-" + strings(4), 1)
    })

    val sumData : RDD[(String, Int)] = cleanData.reduceByKey(_+_)

    val formatData : RDD[(String, (String, Int))] = sumData.map {
      case (key, sum) => {
        val strings: Array[String] = key.split("-")
        (strings(0), (strings(1), sum))
      }
    }


    val groupData : RDD[(String, Iterable[(String, Int)])] = formatData.groupByKey()

    val sortData : RDD[(String, List[(String, Int)])] = groupData.mapValues(iter => {
      iter.toList.sortWith {
        (left, right) => {
          left._2 > right._2
        }
      }.take(3)
    })

    sortData.collect().foreach(println)








    sc.stop()


  }


}
