package com.atguigu.bigdata.spark.req.application

import com.atguigu.bigdata.spark.req.controller.PageFlowController
import com.atguigu.summerkaki.core.TApplication

/**
  * @Description
  * @Author kaki
  * @create 2020-06-10-11:48 AM
  */
object PageFlowApplication extends App with TApplication {


  start("spark") {
      val controller = new PageFlowController
      controller.execute()

  }

}
