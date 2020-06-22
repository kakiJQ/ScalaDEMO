package com.atguigu.scala.test

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-05-28-7:12 PM
  */
object Test1 {

  def main(args: Array[String]): Unit = {

    val arrays: Array[Int] = Array(30, 1, 34, 21, 89)

    val arr : Array[Int] = map(arrays, x => x * x)

    println(arr.toList)

  }

  def map(array: Array[Int],op: Int=>Int)  = {
    for (ele <- array) yield op(ele)
  }

}
