package com.atguigu.bigdata.spark.req.application

import com.atguigu.bigdata.spark.req.controller.HotCategoryAnalysisTop10Controller
import com.atguigu.summerkaki.core.TApplication

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-9:28 PM
  */
object HotCategoryAnalysisTop10Application extends App with TApplication{

  start("spark"){
    val hotCategoryAnalysisTop10Controller = new HotCategoryAnalysisTop10Controller
    hotCategoryAnalysisTop10Controller.execute()
  }


}
