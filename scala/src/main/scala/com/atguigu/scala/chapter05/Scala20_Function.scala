package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-9:22 PM
  */
object Scala20_Function {

  def main(args: Array[String]): Unit = {

    def test() : String = {
      println("xxxx")
      "KAKI"
    }

    lazy val a = test()

    println("***********")
    println(a)

  }

}
