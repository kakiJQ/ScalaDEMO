package com.atguigu.scala.chapter04

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-5:55 PM
  */
object Scala06_Loop1 {
  def main(args: Array[String]): Unit = {

    for (i <- 1 to 10 by 2 if i != 3) {
      println(i)
    }
  }

}
