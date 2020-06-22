package com.atguigu.bigdata.spark.req.application

import com.atguigu.bigdata.spark.req.controller.WordCountController
import com.atguigu.summerkaki.core.TApplication
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * @Description
  * @Author kaki
  * @create 2020-06-08-11:18 PM
  */
object WordCountApplication extends App with TApplication{

  start("spark") {

    val controller = new WordCountController
    controller.execute()


  }


}
