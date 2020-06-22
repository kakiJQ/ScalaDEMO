package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-8:18 PM
  */
object Scala31_Interface {

  def main(args: Array[String]): Unit = {

    val oper = new MySQL() with Operate2
    oper.oper()
    oper.insert()

  }

}
trait Operate {

  def oper() : Unit

}

trait Operate2 {

  def insert() : Unit = {
    println("Insert...")
  }

}

class MySQL extends Operate {

  override def oper(): Unit = {
    println("Operation MySQL...")
  }

}