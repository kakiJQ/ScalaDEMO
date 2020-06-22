package com.atguigu.bigdata.spark.sparkstreamingreq.controller

import com.atguigu.bigdata.spark.sparkstreamingreq.service.LastHourAdCountAnalysisService
import com.atguigu.summerkaki.core.TController

/**
  * @Description
  * @Author kaki
  * @create 2020-06-17-12:49 PM
  */
class LastHourAdCountAnalysisController extends TController{
  private val lastHourAdCountAnalysisService = new LastHourAdCountAnalysisService
  override def execute(): Unit = {
    val result: Unit = lastHourAdCountAnalysisService.analysis()
  }
}
