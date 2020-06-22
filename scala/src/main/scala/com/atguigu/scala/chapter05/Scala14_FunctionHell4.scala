package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-7:02 PM
  */
object Scala14_FunctionHell4 {

  def main(args: Array[String]): Unit = {

    def test(i:Int) = {

      def sum(j:Int) : Int = {
        i+j
      }

      sum _

    }

    println(test(10)(90))

  }

}
