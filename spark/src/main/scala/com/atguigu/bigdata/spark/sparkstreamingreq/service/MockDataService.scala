package com.atguigu.bigdata.spark.sparkstreamingreq.service

import com.atguigu.bigdata.spark.sparkstreamingreq.dao.MockDataDAO
import com.atguigu.summerkaki.core.TService

/**
  * @Description
  * @Author kaki
  * @create 2020-06-15-10:57 PM
  */
class MockDataService extends TService{

  private val mockDataDAO = new MockDataDAO

  override def analysis() = {

    //TODO 生成数据
    // import mockDataDAO._
    val datas  = mockDataDAO.genMockData()

    //TODO 发送数据
    mockDataDAO.writeToKakfa(datas)


  }

}
