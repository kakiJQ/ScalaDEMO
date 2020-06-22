package com.atguigu.scala.test

import scala.collection.mutable.ListBuffer

/**
  * @Description
  * @Author kaki
  * @create 2020-05-28-3:36 PM
  */

object Solution2 {

  def main(args: Array[String]): Unit = {


    val tuplesList = List(
      ("hello",4),
      ("hello spark",3),
      ("hello spark scala",2),
      ("hello spark scala hive",1)
    )



    val buffer: ListBuffer[String] = ListBuffer()


    for (t <- tuplesList) {

      val str: String = (t._1+" ") * t._2

      val strings: Array[String] = str.split(" ")
      for (s<-strings){
        buffer.append(s)
      }

    }

    val groupWord: Map[String, ListBuffer[String]] = buffer.groupBy(word => {
      word
    })

    val wordCount: Map[String, Int] = groupWord.map(kv => {
      (kv._1, kv._2.length)
    })

    val orderCount: List[(String, Int)] = wordCount.toList.sortBy(kv => {
      kv._2
    })(Ordering.Int.reverse)

    println(orderCount.take(3))




  }



}
