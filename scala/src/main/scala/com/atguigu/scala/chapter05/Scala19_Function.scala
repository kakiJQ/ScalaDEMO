package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-8:54 PM
  */
object Scala19_Function {

  def main(args: Array[String]): Unit = {

    println(factorial(5))

    println(factorial2(5,1))
  }

  def factorial2(i:Int, result:Int) : Int = {
    if (i < 1) {
      result
    }
    else {
      factorial2(i-1,i+result)
    }
  }

  def factorial(num:Int) : Int ={
    if (num < 1) {
      1
    }

    else {
      num * factorial(num-1)
    }
  }

}
