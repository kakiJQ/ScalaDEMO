package com.atguigu.bigdata.spark.sparkstreamingreq.controller

import com.atguigu.bigdata.spark.sparkstreamingreq.service.BlackListService
import com.atguigu.summerkaki.core.TController

/**
  * @Description
  * @Author kaki
  * @create 2020-06-16-11:34 AM
  */
class BlackListController extends TController{

  private val blackListService = new BlackListService

  override def execute()= {
    val result = blackListService.analysis()

  }
}
