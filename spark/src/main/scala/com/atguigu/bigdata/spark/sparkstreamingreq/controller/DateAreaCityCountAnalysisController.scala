package com.atguigu.bigdata.spark.sparkstreamingreq.controller

import com.atguigu.bigdata.spark.sparkstreamingreq.service.DateAreaCityCountAnalysisService
import com.atguigu.summerkaki.core.TController

/**
  * @Description
  * @Author kaki
  * @create 2020-06-17-10:50 AM
  */
class DateAreaCityCountAnalysisController extends TController{

  private val dateAreaCityCountAnalysisService = new DateAreaCityCountAnalysisService

  override def execute(): Unit = {
    val result : Unit = dateAreaCityCountAnalysisService.analysis()

  }
}
