package com.atguigu.bigdata.spark.sparkstreamingreq.service

import java.sql.Connection
import java.text.SimpleDateFormat

import com.atguigu.bigdata.spark.sparkstreamingreq.bean.Ad_Click_Log
import com.atguigu.bigdata.spark.sparkstreamingreq.dao.DateAreaCityCountAnalysisDAO
import com.atguigu.summerkaki.core.TService
import com.atguigu.summerkaki.util.JDBCUtil
import org.apache.spark.streaming.dstream.DStream

/**
  * @Description
  * @Author kaki
  * @create 2020-06-17-10:50 AM
  */
class DateAreaCityCountAnalysisService extends TService{

  private val dateAreaCityCountAnalysisDAO = new DateAreaCityCountAnalysisDAO

  override def analysis()= {
    val messageDS : DStream[String] = dateAreaCityCountAnalysisDAO.readKafka()
    val logDS : DStream[Ad_Click_Log] = messageDS.map(
      data => {
        val datas: Array[String] = data.split(" ")
        Ad_Click_Log(datas(0), datas(1), datas(2), datas(3), datas(4))
      }
    )
    val sdf = new SimpleDateFormat()
    val dayDS : DStream[((String, String, String, String), Int)] = logDS.map(
      log => {
        val date = new java.util.Date(log.ts.toLong)
        val day: String = sdf.format(date)
        ((day, log.area, log.city, log.adid), 1)
      }
    )
    val resultDS : DStream[((String, String, String, String), Int)] = dayDS.reduceByKey(_+_)

    resultDS.foreachRDD(
      rdd=>{
        rdd.foreachPartition(
          datas=>{
            val conn : Connection = JDBCUtil.getConnection()
            val pstat = conn.prepareStatement(
              """
                |insert into area_city_ad_count ( dt, area, city, adid, count )
                |values ( ?, ?, ?, ? ,? )
                |on duplicate key
                |update count = count + ?
              """.stripMargin
            )

            datas.foreach{
              case((dt, area ,city, adid),count) =>{
                pstat.setString(1,dt)
                pstat.setString(2,area)
                pstat.setString(3,city)
                pstat.setString(4,adid)
                pstat.setLong(5,count)
                pstat.setLong(6,count)
                pstat.executeUpdate()

              }
            }
            // TODO 关闭资源
            pstat.close()
            conn.close()
          }
        )
      }
    )

  }
}
