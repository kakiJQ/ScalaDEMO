package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-7:44 PM
  */
object Scala27_Abstract {

  def main(args: Array[String]): Unit = {

    val user : User27 = new SubUser27()
    println(user)

  }

}

abstract class User27 {

  var name : String
  val age : Int = 10

  def test() : Unit

  def test2() : Unit = {

  }

}

class SubUser27 extends User27 {

  var name : String = "kaki"
  override val age : Int = 20

  def test() : Unit = {

  }

  override def test2() : Unit = {

  }

}