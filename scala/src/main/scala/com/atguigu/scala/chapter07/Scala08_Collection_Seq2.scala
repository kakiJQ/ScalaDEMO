package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-7:11 PM
  */
object Scala08_Collection_Seq2 {

  def main(args: Array[String]): Unit = {

    //val nil : List[Nothing] = Nil
    //println(Nil)
    val list: List[Int] = 1::7::8::Nil
    //println(list)

    val list1: List[Any] = 8::6::6::list:::Nil
    println(list1)

  }

}
