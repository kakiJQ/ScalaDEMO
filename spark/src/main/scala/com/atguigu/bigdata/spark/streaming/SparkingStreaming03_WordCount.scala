package com.atguigu.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-06-14-11:37 PM
  */
object SparkingStreaming03_WordCount {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
    val ssc = new StreamingContext(sparkConf,Seconds(3))


    val queue = new mutable.Queue[RDD[String]]()
    val queueDS: InputDStream[String] = ssc.queueStream(queue)



    
    queueDS.print()

    ssc.start()

    for (i <- 1 to 5) {
      val rdd: RDD[String] = ssc.sparkContext.makeRDD(List(i.toString))
      queue.enqueue(rdd)
      Thread.sleep(1000)
    }

    ssc.awaitTermination()


  }

}
