package com.atguigu.bigdata.spark.sparkstreamingreq.application

import com.atguigu.bigdata.spark.sparkstreamingreq.controller.LastHourAdCountAnalysisController
import com.atguigu.summerkaki.core.TApplication

/**
  * @Description
  * @Author kaki
  * @create 2020-06-17-12:46 PM
  */
object LastHourAdCountAnalysisApplication extends App with TApplication{

  start("sparkStreaming"){
    val lastHourAdCountAnalysisController = new LastHourAdCountAnalysisController
    lastHourAdCountAnalysisController.execute()
  }

}
