package com.atguigu.bigdata.spark.sparkstreamingreq.service

import com.atguigu.bigdata.spark.sparkstreamingreq.bean.Ad_Click_Log
import com.atguigu.bigdata.spark.sparkstreamingreq.dao.LastHourAdCountAnalysisDAO
import com.atguigu.summerkaki.core.TService
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.dstream.DStream

/**
  * @Description
  * @Author kaki
  * @create 2020-06-17-12:49 PM
  */
class LastHourAdCountAnalysisService extends TService{
  private val lastHourAdCountAnalysisDAO = new LastHourAdCountAnalysisDAO
  override def analysis() = {
    val messageDS : DStream[String] = lastHourAdCountAnalysisDAO.readKafka()
    val logDS : DStream[Ad_Click_Log] = messageDS.map(
      log => {
        val logs: Array[String] = log.split(" ")
        Ad_Click_Log(logs(0), logs(1), logs(2), logs(3), logs(4))
      }
    )
    //TODO ((adid,time),1)
    val tsToCountDS : DStream[((String, Long), Int)] = logDS.map(
      log => {
        val ts = log.ts.toLong
        ((log.adid, ts / 10000 * 10000), 1)
      }
    )
    val adToTimeSumDS : DStream[((String, Long), Int)] = tsToCountDS.reduceByKeyAndWindow(
      (x: Int, y: Int) => {
        x + y
      },
      Seconds(60),
      Seconds(10)
    )
    val sumTimeDS : DStream[(String, (Long, Int))] = adToTimeSumDS.map {
      case ((ts, time), sum) => {
        (ts, (time, sum))
      }
    }
    val groupDS : DStream[(String, Iterable[(Long, Int)])] = sumTimeDS.groupByKey()

    val resultDS : DStream[(String, List[(Long, Int)])] = groupDS.mapValues(
      iter => {
        iter.toList.sortWith(
          (left, right) => {
            left._1 < right._1
          }
        )
      }
    )
    resultDS.print()

  }
}
