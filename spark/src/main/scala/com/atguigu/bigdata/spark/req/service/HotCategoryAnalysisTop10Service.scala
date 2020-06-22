package com.atguigu.bigdata.spark.req.service

import java.io

import com.atguigu.bigdata.spark.req.bean.HotCategory
import com.atguigu.bigdata.spark.req.dao.HotCategoryAnalysisTop10DAO
import com.atguigu.bigdata.spark.req.helper.HotCategoryAccumulator
import com.atguigu.summerkaki.core.TService
import com.atguigu.summerkaki.util.EnvUtil
import org.apache.spark.rdd.RDD

import scala.collection.mutable
import scala.collection.mutable.ArrayOps

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-9:31 PM
  */
class HotCategoryAnalysisTop10Service extends TService{

  private val hotCategoryAnalysisTop10DAO: HotCategoryAnalysisTop10DAO = new HotCategoryAnalysisTop10DAO


  override def analysis()= {

    val actionRDD : RDD[String] = hotCategoryAnalysisTop10DAO.readFile("input/user_visit_action.txt")

    val acc = new HotCategoryAccumulator
    EnvUtil.getEnv().register(acc)

    actionRDD.foreach(
      action=>{
        val datas = action.split("_")
        if ( datas(6) != "-1" ) {
          // 点击的场合
          acc.add(( datas(6), "click" ))
        } else if ( datas(8) != "null" ) {
          val ids = datas(8).split(",")
          ids.foreach(
            id => {
              acc.add((id, "order"))
            }
          )
        } else if ( datas(10) != "null" ) {
          val ids = datas(10).split(",")
          ids.foreach(
            id => {
              acc.add((id, "pay"))
            }
          )
        } else {
          Nil
        }
      }
    )

    val accValue: mutable.Map[String, HotCategory] = acc.value
    val categories: mutable.Iterable[HotCategory] = accValue.map(_._2)

    categories.toList.sortWith(
      (leftHC, rightHC) => {
        if ( leftHC.clickCount > rightHC.clickCount ) {
          true
        } else if ( leftHC.clickCount == rightHC.clickCount ) {
          if (leftHC.orderCount > rightHC.orderCount) {
            true
          } else if (leftHC.orderCount == rightHC.orderCount) {
            leftHC.payCount > rightHC.payCount
          } else {
            false
          }
        } else {
          false
        }
      }
    ).take(10)


  }

  /*override def analysis()= {
    val actionRDD : RDD[String] = hotCategoryAnalysisTop10DAO.readFile("input/user_visit_action.txt")

    actionRDD.map(
      line => {
        val strings = line.split("_")
        if (strings(6) != "-1") {
          List( (strings(6), HotCategory(strings(6), 1, 0, 0)) )
        }
        else if (strings(8) != "null") {
          val ids: Array[String] = strings(8).split(",")
          ids.map(id=>(id, HotCategory(id, 0,1,0)))
        }
        else if (strings(10) != "null") {
          val ids = strings(10).split(",")
          ids.map(id=>(id, HotCategory(id, 0,0,1)))
        }
        else {
          Nil
        }
      }
    )

    val flatmapRDD: RDD[(String, HotCategory)] = actionRDD.flatMap(
      action => {
        val datas = action.split("_")
        if (datas(6) != "-1") {
          // 点击的场合
          List((datas(6), HotCategory(datas(6), 1, 0, 0)))
        } else if (datas(8) != "null") {
          // 下单的场合
          val ids = datas(8).split(",")
          ids.map(id => (id, HotCategory(id, 0, 1, 0)))
        } else if (datas(10) != "null") {
          // 支付的场合
          val ids = datas(10).split(",")
          ids.map(id => (id, HotCategory(id, 0, 0, 1)))
        } else {
          Nil
        }
      }
    )

    val reduceRDD : RDD[(String, HotCategory)] = flatmapRDD.reduceByKey(
      (t1, t2) => {
        t1.clickCount = t1.clickCount + t2.clickCount
        t1.orderCount = t1.orderCount + t2.orderCount
        t1.payCount = t1.payCount + t2.payCount
        t1
      }
    )
    reduceRDD.collect().sortWith(
      (left, right) => {
        val leftHC: HotCategory = left._2
        val rightHC: HotCategory = right._2
        if (leftHC.clickCount > rightHC.clickCount) {
          true
        } else if (leftHC.clickCount == rightHC.clickCount) {
          if (leftHC.orderCount > rightHC.orderCount) {
            true
          } else if (leftHC.orderCount == rightHC.orderCount) {
            leftHC.payCount > rightHC.payCount
          } else {
            false
          }
        } else {
          false
        }
      }
    ).take(10)


  }*/


  /*override def analysis()= {

    val actionRDD : RDD[String] = hotCategoryAnalysisTop10DAO.readFile("input/user_visit_action.txt")

    actionRDD.cache()

    val clickRDD = actionRDD.map(
      line => {
        val strings: Array[String] = line.split("_")
        (strings(6), 1)
      }
    ).filter(t=>{t._1 != -1})
    .reduceByKey(_+_)
    .map{
      case(k,v)=>{(k,(v,0,0))}
    }

    val orderRDD = actionRDD.map(
      line => {
        val strings: Array[String] = line.split("_")
        strings(8)
      }
    ).filter(t=>{t != "null"})
    .flatMap(id=>{
      val strings: ArrayOps.ofRef[String] = id.split(",")
      strings.map(id=>(id,1))
    })
    .reduceByKey(_+_)
    .map{
      case(k,v)=>{(k,(0,v,0))}
    }

    val payRDD = actionRDD.map(
      line => {
        val strings: Array[String] = line.split("_")
        strings(10)
      }
    ).filter(t=>{t != "null"})
      .flatMap(id=>{
        val strings: ArrayOps.ofRef[String] = id.split(",")
        strings.map(id=>(id,1))
      })
      .reduceByKey(_+_)
    .map{
      case(k,v)=>{(k,(0,0,v))}
    }

    val countRDD : RDD[(String, (Int, Int, Int))] = clickRDD.union(orderRDD).union(payRDD).reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )





    val sortRDD : RDD[(String, (Int, Int, Int))] = countRDD.sortBy(_._2,false)

    val result : Array[(String, (Int, Int, Int))] = sortRDD.take(10)

    result


  }*/
  /*override def analysis()= {

    val actionRDD : RDD[String] = hotCategoryAnalysisTop10DAO.readFile("input/user_visit_action.txt")

    val clickRDD = actionRDD.map(
      line => {
        val strings: Array[String] = line.split("_")
        (strings(6), 1)
      }
    ).filter(t=>{t._1 != -1})
    .reduceByKey(_+_)

    val orderRDD = actionRDD.map(
      line => {
        val strings: Array[String] = line.split("_")
        strings(8)
      }
    ).filter(t=>{t != "null"})
    .flatMap(id=>{
      val strings: ArrayOps.ofRef[String] = id.split(",")
      strings.map(id=>(id,1))
    })
    .reduceByKey(_+_)

    val payRDD = actionRDD.map(
      line => {
        val strings: Array[String] = line.split("_")
        strings(10)
      }
    ).filter(t=>{t != "null"})
      .flatMap(id=>{
        val strings: ArrayOps.ofRef[String] = id.split(",")
        strings.map(id=>(id,1))
      })
      .reduceByKey(_+_)

    val joinRDD : RDD[(String, (Int, Int))] = clickRDD.join(orderRDD)
    val joinRDD1 : RDD[(String, ((Int, Int), Int))] = joinRDD.join(payRDD)
    val mapRDD : RDD[(String, (Int, Int, Int))] = joinRDD1.mapValues {
      case ((clickCount, orderCount), payCount) => {
        (clickCount, orderCount, payCount)
      }
    }
    val sortRDD : RDD[(String, (Int, Int, Int))] = mapRDD.sortBy(_._2,false)

    val result : Array[(String, (Int, Int, Int))] = sortRDD.take(10)

    result


  }*/

}
