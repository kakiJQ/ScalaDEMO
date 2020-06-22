package com.atguigu.bigdata.spark.sparkstreamingreq.application

import com.atguigu.bigdata.spark.sparkstreamingreq.controller.MockDataController
import com.atguigu.summerkaki.core.TApplication

/**
  * @Description
  * @Author kaki
  * @create 2020-06-15-10:38 PM
  */
object MockDataApplication extends App with TApplication{

  start("sparkStreaming"){

    val mockDataController = new MockDataController
    mockDataController.execute()

  }



}
