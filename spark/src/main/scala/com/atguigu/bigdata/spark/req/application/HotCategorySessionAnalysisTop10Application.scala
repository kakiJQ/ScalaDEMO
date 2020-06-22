package com.atguigu.bigdata.spark.req.application

import com.atguigu.bigdata.spark.req.controller.HotCategorySessionAnalysisTop10Controller
import com.atguigu.summerkaki.core.TApplication

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-11:47 PM
  */
object HotCategorySessionAnalysisTop10Application extends App with TApplication{


  start("spark") {
    val controller = new HotCategorySessionAnalysisTop10Controller
    controller.execute()

  }

}
