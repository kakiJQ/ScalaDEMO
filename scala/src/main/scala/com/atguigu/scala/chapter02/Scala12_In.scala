package com.atguigu.scala.chapter02

import scala.io.StdIn

/**
  * @Description
  * @Author kaki
  * @create 2020-05-19-8:15 AM
  */
object Scala12_In {
  def main(args: Array[String]): Unit = {
    val age : Int = StdIn.readInt()
    println("The student age is " + age)
  }

}
