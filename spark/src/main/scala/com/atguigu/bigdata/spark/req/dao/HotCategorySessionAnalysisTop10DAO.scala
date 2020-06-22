package com.atguigu.bigdata.spark.req.dao

import com.atguigu.bigdata.spark.req.bean.UserVisitAction
import com.atguigu.summerkaki.core.TDAO
import org.apache.spark.rdd.RDD

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-11:49 PM
  */
class HotCategorySessionAnalysisTop10DAO extends TDAO{

  def getUserVisitAction(path:String)={
    val rdd : RDD[String] = readFile(path)
    rdd.map(
      line=>{
        val datas: Array[String] = line.split("_")
        UserVisitAction(
          datas(0),
          datas(1).toLong,
          datas(2),
          datas(3).toLong,
          datas(4),
          datas(5),
          datas(6).toLong,
          datas(7).toLong,
          datas(8),
          datas(9),
          datas(10),
          datas(11),
          datas(12).toLong
        )
      }
    )
  }

}
