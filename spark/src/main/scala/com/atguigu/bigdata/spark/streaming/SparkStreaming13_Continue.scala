package com.atguigu.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-15-8:15 PM
  */
object SparkStreaming13_Continue {

  def main(args: Array[String]): Unit = {



    val ssc : StreamingContext = StreamingContext.getActiveOrCreate("cp",getStreamingContext)


    ssc.start()
    ssc.awaitTermination()


  }

  def getStreamingContext() : StreamingContext ={
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    ssc.checkpoint("cp")

    val ds : ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)
    ds.print()
    ssc
  }

}
