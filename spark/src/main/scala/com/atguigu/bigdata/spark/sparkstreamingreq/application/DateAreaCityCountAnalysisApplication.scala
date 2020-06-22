package com.atguigu.bigdata.spark.sparkstreamingreq.application

import com.atguigu.bigdata.spark.sparkstreamingreq.controller.DateAreaCityCountAnalysisController
import com.atguigu.summerkaki.core.TApplication

/**
  * @Description
  * @Author kaki
  * @create 2020-06-17-10:49 AM
  */
object DateAreaCityCountAnalysisApplication extends App with TApplication{
  start("sparkStreaming"){
    val dateAreaCityCountAnalysisController = new DateAreaCityCountAnalysisController
    dateAreaCityCountAnalysisController.execute()

  }
}
