package com.atguigu.scala.chapter08

/**
  * @Description
  * @Author kaki
  * @create 2020-05-31-2:37 PM
  */
object Scala01_Match {

  def main(args: Array[String]): Unit = {

    val a: Int = 10
    val b: Int = 20
    val operator: Char = '-'

    val result : Any = operator match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => "illegle"
    }

    println(result)

  }

}
