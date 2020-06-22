package com.atguigu.bigdata.spark.sparkstreamingreq.application

import com.atguigu.bigdata.spark.sparkstreamingreq.controller.BlackListController
import com.atguigu.summerkaki.core.TApplication

/**
  * @Description
  * @Author kaki
  * @create 2020-06-16-10:53 AM
  */
object BlackListApplication extends App with TApplication{

  start("sparkStreaming"){
    val blackListController = new BlackListController
    blackListController.execute()

  }



}
