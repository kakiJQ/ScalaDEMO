package com.atguigu.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-14-11:37 PM
  */
object SparkingStreaming01_WordCount {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
    val ssc = new StreamingContext(sparkConf,Seconds(3))

    val socketDS: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val wordDS: DStream[String] = socketDS.flatMap(_.split(" "))
    val wordToOneDS: DStream[(String, Int)] = wordDS.map(word=>(word,1))
    val wordToSumDS: DStream[(String, Int)] = wordToOneDS.reduceByKey(_+_)

    wordToSumDS.print()

    ssc.start()
    ssc.awaitTermination()


  }

}
