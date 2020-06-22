package com.atguigu.bigdata.spark.req.controller

import com.atguigu.bigdata.spark.req.service.PageFlowService
import com.atguigu.summerkaki.core.TController

/**
  * @Description
  * @Author kaki
  * @create 2020-06-10-11:49 AM
  */
class PageFlowController extends TController{

  private val pageFlowService = new PageFlowService

  override def execute(): Unit = {
    val result : Unit = pageFlowService.analysis()

  }
}
