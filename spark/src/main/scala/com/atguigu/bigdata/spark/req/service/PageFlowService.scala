package com.atguigu.bigdata.spark.req.service

import java.text.SimpleDateFormat

import com.atguigu.bigdata.spark.req.bean
import com.atguigu.bigdata.spark.req.dao.PageFlowDAO
import com.atguigu.summerkaki.core.TService
import org.apache.spark.rdd.RDD

/**
  * @Description
  * @Author kaki
  * @create 2020-06-10-11:50 AM
  */
class PageFlowService extends TService{

  private val pageFlowDAO = new PageFlowDAO


  override def analysis() = {
    /*统计每个页面id的停留时间，
    按照一个会话进行分组，
    然后按照行为时间进行排序，
    然后将后一个页面id行为时间减去当前页面id的行为时间，就是当前页面id的停留时间，
    但是一个会话中最后一个页面id只有行为时间，就没有停留时间了，
    那计算平均停留时间，要对最后一个页面id进行计数*/

    val actionRDD : RDD[bean.UserVisitAction] = pageFlowDAO.getUserVisitAction("input/user_visit_action.txt")

    //1. 按照一个会话进行分组，
    val sessionRDD : RDD[(String, Iterable[bean.UserVisitAction])] = actionRDD.groupBy(_.session_id)


    //2. 对组内集合进行操作
    val pageTimeRDD : RDD[(String, List[(Long, Long)])] = sessionRDD.mapValues(iter => {

      val dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

      //3. 按照行为时间进行排序
      val actions: List[bean.UserVisitAction] = iter.toList.sortWith(
        (left, right) => {
          left.action_time < right.action_time
        }
      )

      //4. 转化时间格式
      val tuples: List[(Long, Long)] = actions.map(bean => {
        val acTime = bean.action_time
        val time: Long = dataFormat.parse(acTime).getTime
        (bean.page_id, time)
      })


      //5. 将后一个页面id行为时间减去当前页面id的行为时间，就是当前页面id的停留时间，
      val tt: List[((Long, Long), (Long, Long))] = tuples.zip(tuples.tail)
      tt.map {
        case ((k1, v1), (k2, v2)) => {
          (k1, v2 - v1)
        }
      }


    })

    //6. 扁平化
    val pageIdTimeRDD : RDD[(Long, Long)] = pageTimeRDD.map(_._2).flatMap(list=>list)

    //7. 将页面ID分组
    val groupRDD : RDD[(Long, Iterable[Long])] = pageIdTimeRDD.groupByKey()

    groupRDD.foreach{
      case(id,iter)=>{
        println("page ID: " + id + ", times: "+ iter.size + ", average time: " + (iter.sum/iter.size))
      }
    }






  }


  /*override def analysis() = {
    val actionRDD : RDD[bean.UserVisitAction] = pageFlowDAO.getUserVisitAction("input/user_visit_action.txt")

    val flowids = List(1,2,3,4,5,6,7)
    val okFlowids: List[String] = flowids.zip(flowids.tail).map(t=>{(t._1+"-"+t._2)})

    //TODO: fen mu

    val filterRDD : RDD[bean.UserVisitAction] = actionRDD.filter(action => {
      flowids.init.contains(action.page_id.toInt)
    })


    val pageToOneRDD : RDD[(Long, Int)] = filterRDD.map(
      action => {
        (action.page_id, 1)
      }
    )

    val pageToSumRDD : RDD[(Long, Int)] = pageToOneRDD.reduceByKey(_+_)

    val pageCount : Array[(Long, Int)] = pageToSumRDD.collect()

    //TODO: fen zi
    val sessionRDD : RDD[(String, Iterable[bean.UserVisitAction])] = actionRDD.groupBy(_.session_id)

    val pageFlowRDD : RDD[(String, List[(String, Int)])] = sessionRDD.mapValues(iter => {
      val actions: List[bean.UserVisitAction] = iter.toList.sortWith(
        (left, right) => {
          left.action_time < right.action_time
        }
      )
      val pageIDs: List[Long] = actions.map(_.page_id)



      val zipIDs: List[(Long, Long)] = pageIDs.zip(pageIDs.tail)

      zipIDs.map {
        case (pg1, pg2) => {
          (pg1 + "-" + pg2, 1)
        }
      }.filter{
        case (ids,one)=>{
          okFlowids.contains(ids)
        }
      }

    })

    val pageidSumRDD : RDD[List[(String, Int)]] = pageFlowRDD.map(_._2)

    val pageFlowRDD1 : RDD[(String, Int)] = pageidSumRDD.flatMap(list=>list)

    val pageFlowToSumRDD : RDD[(String, Int)] = pageFlowRDD1.reduceByKey(_+_)

    pageFlowToSumRDD.foreach{
      case (pageflow, sum) =>{
        val pageid : String = pageflow.split("-")(0)
        val value : Int = pageCount.toMap.getOrElse(pageid.toLong,1)
        println("page flow:"+ pageflow + " the rate: " + (sum.toDouble/value))
      }
    }

  }*/

  /*override def analysis() = {
    val actionRDD : RDD[bean.UserVisitAction] = pageFlowDAO.getUserVisitAction("input/user_visit_action.txt")

    //TODO: fen zi
    val pageToOneRDD : RDD[(Long, Int)] = actionRDD.map(
      action => {
        (action.page_id, 1)
      }
    )
    
    val pageToSumRDD : RDD[(Long, Int)] = pageToOneRDD.reduceByKey(_+_)

    val pageCount : Array[(Long, Int)] = pageToSumRDD.collect()

    //TODO: fen mu
    val sessionRDD : RDD[(String, Iterable[bean.UserVisitAction])] = actionRDD.groupBy(_.session_id)

    val pageFlowRDD : RDD[(String, List[(String, Int)])] = sessionRDD.mapValues(iter => {
      val actions: List[bean.UserVisitAction] = iter.toList.sortWith(
        (left, right) => {
          left.action_time < right.action_time
        }
      )
      val pageIDs: List[Long] = actions.map(_.page_id)

      val zipIDs: List[(Long, Long)] = pageIDs.zip(pageIDs.tail)

      zipIDs.map {
        case (pg1, pg2) => {
          (pg1 + "-" + pg2, 1)
        }
      }

    })

    val pageidSumRDD : RDD[List[(String, Int)]] = pageFlowRDD.map(_._2)

    val pageFlowRDD1 : RDD[(String, Int)] = pageidSumRDD.flatMap(list=>list)
    
    val pageFlowToSumRDD : RDD[(String, Int)] = pageFlowRDD1.reduceByKey(_+_)

    pageFlowToSumRDD.foreach{
      case (pageflow, sum) =>{
        val pageid : String = pageflow.split("-")(0)
        val value : Int = pageCount.toMap.getOrElse(pageid.toLong,1)
        println("page flow:"+ pageflow + " the rate: " + (sum.toDouble/value))
      }
    }

  }*/

}
