package com.atguigu.summerkaki.util

import org.apache.spark.streaming.{Duration, Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-9:05 PM
  */
object EnvUtil {

  private val scLocal : ThreadLocal[SparkContext] = new ThreadLocal[SparkContext]
  private val sscLocal : ThreadLocal[StreamingContext] = new ThreadLocal[StreamingContext]


  def getStreamingEnv(time:Duration = Seconds(5))={
    var ssc : StreamingContext = sscLocal.get()

    if (ssc == null) {
      val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkApplication")
      ssc = new StreamingContext(sparkConf,time)
      sscLocal.set(ssc)
    }

    ssc
  }

  def getEnv()={
    var sc : SparkContext = scLocal.get()

    if (sc == null) {
      val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkApplication")
      sc = new SparkContext(sparkConf)
      scLocal.set(sc)
    }

    sc
  }

  def clear()={
    scLocal.remove()
  }

  /*private val scLocal = new ThreadLocal[SparkContext]
  private val sscLocal = new ThreadLocal[StreamingContext]

  def getStreamingEnv( time : Duration = Seconds(3) ) = {
    var ssc: StreamingContext = sscLocal.get()
    if ( ssc == null ) {
      // 如果获取不到环境对象
      val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkApplication")
      // 创建新的环境对象
      ssc = new StreamingContext(sparkConf, time)
      // 保存到共享内存中
      sscLocal.set(ssc)
    }

    ssc
  }

  def getEnv()  = {
    // 从当前线程的共享内存空间中获取环境对象
    var sc: SparkContext = scLocal.get()
    if ( sc == null ) {
      // 如果获取不到环境对象
      val sparkConf = new SparkConf().setMaster("local").setAppName("sparkApplication")
      // 创建新的环境对象
      sc = new SparkContext(sparkConf)
      // 保存到共享内存中
      scLocal.set(sc)
    }

    sc
  }

  def clear(): Unit = {
    getEnv.stop()
    // 将共享内存中的数据清除掉
    scLocal.remove()
  }*/

}
