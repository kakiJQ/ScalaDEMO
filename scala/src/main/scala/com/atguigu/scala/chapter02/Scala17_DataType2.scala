package com.atguigu.scala.chapter02

/**
  * @Description
  * @Author kaki
  * @create 2020-05-19-7:41 PM
  */
object Scala17_DataType2 {
  def main(args: Array[String]): Unit = {
    // Unit(没有返回值)（void） => Nothing（无值）(exception)
    val s : String = null
    val ss = null

    val a : Any = "aaa"
    val b : AnyRef = "ddd"
    val c : AnyVal = 12
  }

  def test() : Nothing ={
    throw new Exception
  }
}
