package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-9:10 PM
  */
object Scala02_Function1 {

  def main(args: Array[String]): Unit = {

    def test() : Unit = {
      println("xxx")
    }

    test()
    test()
    test()

    test1("ss")
  }

  def test1() : Unit = {
    println("user1...")
  }

  def test1(s:String) : Unit = {
    println(s)
  }

}
