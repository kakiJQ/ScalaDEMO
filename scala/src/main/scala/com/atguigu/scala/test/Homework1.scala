package com.atguigu.scala.test

import scala.io.StdIn

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-10:13 PM
  */

/*
* 1. 如果想把一个任意的数字A通过转换后得到它的2倍，那么这个转换的函数应该如何声明和使用
* */
object Homework1 {

  def main(args: Array[String]): Unit = {

    println("Please Input the Number: ")
    val inputNum : Int = StdIn.readInt()

    def doubleNum(num:Int) : Int = {
      num*2
    }

    val result = doubleNum(inputNum)

    println(result)

  }

}
