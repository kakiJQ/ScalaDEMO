package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-7:32 PM
  */
object Scala26_Test2 {

  def main(args: Array[String]): Unit = {

    val dep0: Dep04 = Dep04()
    val dep1: Dep04 = Dep04()

    println(dep0==dep1)

  }

}

class Dep04 private {


}

object Dep04 {
  private val dep = new Dep04()

  def apply() : Dep04 ={
    println("kkk")
    dep
  }


}