package com.atguigu.bigdata.spark.req.controller

import com.atguigu.bigdata.spark.req.bean
import com.atguigu.bigdata.spark.req.service.{HotCategoryAnalysisTop10Service, HotCategorySessionAnalysisTop10Service}
import com.atguigu.summerkaki.core.TController

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-11:48 PM
  */
class HotCategorySessionAnalysisTop10Controller extends TController {

  private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service
  private val hotCategorySessionAnalysisTop10Service = new HotCategorySessionAnalysisTop10Service

  override def execute()= {
    val categories: List[bean.HotCategory] = hotCategoryAnalysisTop10Service.analysis()
    val result = hotCategorySessionAnalysisTop10Service.analysis(categories)

    result.foreach(println)
  }
}
