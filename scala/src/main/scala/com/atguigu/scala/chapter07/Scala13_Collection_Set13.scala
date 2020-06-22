package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-8:15 PM
  */
object Scala13_Collection_Set13 {

  def main(args: Array[String]): Unit = {

    val map: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->2,"c"->3)

    map.put("d",1)
    map.update("d",5)
    map("d") = 9

    val maybeInt: Option[Int] = map.get("p")
    val i: Int = map.getOrElse("a",-1)

    println(maybeInt)
    println(maybeInt.getOrElse(-1))
    println(i)

  }

}
