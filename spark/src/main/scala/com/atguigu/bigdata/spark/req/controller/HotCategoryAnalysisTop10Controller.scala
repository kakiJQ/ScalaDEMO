package com.atguigu.bigdata.spark.req.controller

import com.atguigu.bigdata.spark.req.service.HotCategoryAnalysisTop10Service
import com.atguigu.summerkaki.core.TController

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-9:29 PM
  */
class HotCategoryAnalysisTop10Controller extends TController{

  private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service

  override def execute(): Unit = {
    val result = hotCategoryAnalysisTop10Service.analysis()
    result.foreach(println)

  }
}
