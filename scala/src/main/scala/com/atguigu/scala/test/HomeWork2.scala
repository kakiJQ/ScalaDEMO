package com.atguigu.scala.test

import scala.io.StdIn

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-10:20 PM
  */

/*
* 2. 如果上一题想将数字A转换为任意数据B（不局限为数字），转换规则自己定义，该如何声明
* */
object HomeWork2 {

  def main(args: Array[String]): Unit = {

    println("Please input the number A: ")
    val inputNum = StdIn.readInt()

    def getHello(numA:Int) : String = {
      "*"*numA
    }

    val result = getHello(inputNum)

    println(result)

  }

}
