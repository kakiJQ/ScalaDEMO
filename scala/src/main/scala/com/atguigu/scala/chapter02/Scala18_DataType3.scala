package com.atguigu.scala.chapter02

/**
  * @Description
  * @Author kaki
  * @create 2020-05-19-8:01 PM
  */
object Scala18_DataType3 {
  def main(args: Array[String]): Unit = {
    val b : Byte = 10
    val c : Short = b
    val d : Int = c

    val bb : Byte = d.toByte
  }

}
