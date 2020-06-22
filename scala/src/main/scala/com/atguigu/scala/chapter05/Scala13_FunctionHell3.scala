package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-6:47 PM
  */
object Scala13_FunctionHell3 {

  def main(args: Array[String]): Unit = {

    /*def test(i:Int) : Int = {
      i
    }

    def fun() = {

      test _

    }*/

    //val a = fun()

    //println(a(10))

    //println(fun()(10))

    def fun() = {

      def test(i:Int) : Int = {
        i*2
      }

      test _

    }

    def fun1(): Int=>Int = {

      def test(i:Int) : Int = {
        i*2
      }

      test

    }

    println(fun()(9))

  }

}
