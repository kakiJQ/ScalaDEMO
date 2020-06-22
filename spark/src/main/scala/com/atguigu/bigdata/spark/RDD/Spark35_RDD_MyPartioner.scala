package com.atguigu.bigdata.spark.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-02-8:25 PM
  */
object Spark35_RDD_MyPartioner {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    val dataRDD : RDD[(String, String)] = sc.makeRDD(
      List(("cba", "消息1"), ("cba", "消息2"), ("cba", "消息3"),
        ("nba", "消息4"), ("wnba", "消息5"), ("nba", "消息6")),
      1)

    val pRDD : RDD[(String, String)] = dataRDD.partitionBy(new MyPartitioner(3))

    val indexPRDD : RDD[(Int, (String, String))] = pRDD.mapPartitionsWithIndex {
      (index, data) => {
        data.map(
          d => {
            (index, d)
          }
        )
      }
    }

    indexPRDD.collect().foreach(println)

    

    sc.stop()


  }

  class MyPartitioner(i:Int) extends Partitioner {
    override def numPartitions: Int = {
      i
    }

    override def getPartition(key: Any): Int = {
      key match {
        case "nba" => 0
        case _ => 1
      }
    }
  }

}
