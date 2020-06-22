package com.atguigu.bigdata.spark.req.controller

import com.atguigu.bigdata.spark.req.application.WordCountApplication.envData
import com.atguigu.bigdata.spark.req.service.WordCountService
import com.atguigu.summerkaki.core.TController
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * @Description
  * @Author kaki
  * @create 2020-06-08-11:43 PM
  */
class WordCountController extends TController{

  private val wordCountService = new WordCountService

  override def execute(): Unit = {

    val finalResult : Array[(String, Int)] = wordCountService.analysis()
    println(finalResult.mkString(","))





  }

}
