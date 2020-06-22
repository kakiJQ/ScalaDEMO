package com.atguigu.bigdata.spark.req.service

import com.atguigu.bigdata.spark.req.bean
import com.atguigu.bigdata.spark.req.bean.HotCategory
import com.atguigu.bigdata.spark.req.dao.HotCategorySessionAnalysisTop10DAO
import com.atguigu.summerkaki.core.TService
import com.atguigu.summerkaki.util.EnvUtil
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-11:49 PM
  */
class HotCategorySessionAnalysisTop10Service extends TService{

  private val hotCategorySessionAnalysisTop10DAO = new HotCategorySessionAnalysisTop10DAO

  override def analysis(data:Any) = {
    val top10 : List[HotCategory] = data.asInstanceOf[List[HotCategory]]

    val top10ID: List[String] = top10.map(_.categoryId)

    val bcList: Broadcast[List[String]] = EnvUtil.getEnv().broadcast(top10ID)

    val actionRDD : RDD[bean.UserVisitAction] = hotCategorySessionAnalysisTop10DAO.getUserVisitAction("input/user_visit_action.txt")

    val filterRDD : RDD[bean.UserVisitAction] = actionRDD.filter(
      action => {
        if (action.click_category_id != -1) {

          bcList.value.contains(action.click_category_id.toString)
          /*var flag = false

          top10.foreach(
            hc => {
              if (hc.categoryId.toLong == action.click_category_id) {
                flag = true
              }
            }
          )

          flag*/
        }
        else {
          false
        }
      }
    )

    val rdd : RDD[(String, Int)] = filterRDD.map(
      action => {
        (action.click_category_id + "_" + action.session_id, 1)
      }
    )
    val reduceRDD : RDD[(String, Int)] = rdd.reduceByKey(_+_)

    val mapRDD : RDD[(String, (String, Int))] = reduceRDD.map {
      case (k, v) => {
        val strings: Array[String] = k.split("_")
        (strings(0), (strings(1), v))
      }
    }

    val groupRDD : RDD[(String, Iterable[(String, Int)])] = mapRDD.groupByKey()

    val resultRDD : RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      iter => {
        iter.toList.sortWith(
          (left, right) => {
            left._2 > right._2
          }
        ).take(10)
      }
    )
    resultRDD.collect()

  }
}
