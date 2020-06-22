package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-7:50 PM
  */
object Scala15_Function {

  def main(args: Array[String]): Unit = {

    def test(i:Int)(j:Int)(f:(Int,Int)=>Int) = {
      f(i,j)
    }

    println(test(1)(1)(_ + _))

  }

}
