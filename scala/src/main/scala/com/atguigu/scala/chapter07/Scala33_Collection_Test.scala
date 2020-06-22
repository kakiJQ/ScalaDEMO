package com.atguigu.scala.chapter07

import scala.collection.immutable
import scala.collection.mutable.ArrayOps

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-10:34 PM
  */
object Scala33_Collection_Test {


  def main(args: Array[String]): Unit = {

    val dataList: List[(String, String, String)] = List(
      ("zhangsan", "河北", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "鞋"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "鞋"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "鞋"),
      ("zhangsan", "河北", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "帽子"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "电脑"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "电脑"),
      ("zhangsan", "河南", "电脑"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子")
    )

    val list: List[String] = dataList.map((t:(String,String,String))=>{(t._2+"-"+t._3)})

    val groupData: Map[String, List[String]] = list.groupBy(s=>{s})

    val countList: Map[String, Int] = groupData.map((t: (String, List[String])) => {
      (t._1, t._2.length)
    })

    //val countList: Map[String, Int] = groupData.mapValues(_.size)

    val standList: List[(String, (String, Int))] = countList.toList.map(kv => {
      val strings: Array[String] = kv._1.split("-")
      (strings(0), (strings(1), kv._2))
    })

    val groupP: Map[String, List[(String, (String, Int))]] = standList.groupBy(t=>{t._1})

    val finalResult: Map[String, List[(String, Int)]] = groupP.mapValues((list: List[(String, (String, Int))]) => {
      val ll: List[(String, Int)] = list.map((t:(String,(String,Int)))=>{t._2})

      ll.sortWith((left, right) => {
        left._2 > right._2
      })

    })
    println(finalResult)


  }

}
