package com.atguigu.scala.chapter08

/**
  * @Description
  * @Author kaki
  * @create 2020-05-31-4:17 PM
  */
object Scala05_Match {

  def main(args: Array[String]): Unit = {

    val map = Map("a"->("aa",1),"b"->("bb",2))

    map.foreach{
      case (k1,(k2,count)) => println(count)
    }

  }

}
