package com.atguigu.scala.chapter04

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-7:03 PM
  */
object Scala10_Loop5 {

  def main(args: Array[String]): Unit = {

    val result = for (i <- 1 to 5) yield {
      i
    }

    println(result)
  }

}
