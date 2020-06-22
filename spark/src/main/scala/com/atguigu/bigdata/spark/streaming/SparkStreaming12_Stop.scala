package com.atguigu.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-15-8:15 PM
  */
object SparkStreaming12_Stop {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    ssc.sparkContext.setCheckpointDir("cp")

    val ds : ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val wordToOneDS: DStream[(String, String)] = ds.map(num=>{("key",num)})

    wordToOneDS.print()

    new Thread(
      new Runnable {
        override def run(): Unit = {

          Thread.sleep(5000)

          val state: StreamingContextState = ssc.getState()

          if (state == StreamingContextState.ACTIVE) {
            ssc.stop(true,true)
            System.exit(0)
          }

        }
      }
    ).start()

    ssc.start()
    ssc.awaitTermination()


  }

}
