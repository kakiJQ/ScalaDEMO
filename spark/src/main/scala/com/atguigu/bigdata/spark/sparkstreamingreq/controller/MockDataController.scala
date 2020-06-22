package com.atguigu.bigdata.spark.sparkstreamingreq.controller

import com.atguigu.bigdata.spark.sparkstreamingreq.service.MockDataService
import com.atguigu.summerkaki.core.TController

/**
  * @Description
  * @Author kaki
  * @create 2020-06-15-10:55 PM
  */
class MockDataController extends TController{

  private val mockDataService = new MockDataService

  override def execute(): Unit = {
    val result : Any = mockDataService.analysis()

  }
}
