package com.atguigu.scala.test

import scala.io.StdIn

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-10:25 PM
  */

/*
* 3. 如果函数调用：  test(10,20,c)的计算结果由参数c来决定，这个参数c你会如何声明
* */
object Homework3 {

  def main(args: Array[String]): Unit = {


    def cal(a:Int=10,b:Int=20,c:Int)={
      10+20+c
    }

    println("Please input the number")
    val num = StdIn.readInt()
    val result = cal(c=num)
    println(result)

  }

}
