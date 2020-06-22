package com.atguigu.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-15-8:15 PM
  */
object SparkStreaming10_Window1 {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    ssc.sparkContext.setCheckpointDir("cp")

    val ds : ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val wordToOneDS: DStream[(String, Int)] = ds.map(num=>{("key",num.toInt)})



    val result: DStream[(String, Int)] = wordToOneDS.reduceByKeyAndWindow(
      (x, y) => {
        x + y
      },
      (x, y) => {
        x - y
      },
      Seconds(9)
    )
    result.foreachRDD(rdd=>{rdd.foreach(println)})
    
    
    ssc.start()
    ssc.awaitTermination()


  }

}
