package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-8:57 PM
  */
object Scala16_Collection_Tuple2 {

  def main(args: Array[String]): Unit = {

    val tuple: (Int, String) = (1,"Q")

    val stringToInt: mutable.Map[String, Int] = mutable.Map(("k",1),("p",0),("q",3))

    for (kv <- stringToInt) {
      println(kv._1 + "=" + kv._2)
    }


  }

}
