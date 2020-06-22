package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-7:08 PM
  */
object Scala25_Test1 {

  def main(args: Array[String]): Unit = {

    val dep1: Dep03 = new Dep03()

    val dep0 : Dep03 = Dep03()

  }

}
class Dep03 {
  println("class")

}

class SubDep01 extends Dep03 {

}

class SubDep02 extends Dep03 {

}

object Dep03 {

  def apply(): Dep03 = {
    println("object")
    new Dep03()

  }

}