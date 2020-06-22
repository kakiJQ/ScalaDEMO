package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-6:58 PM
  */
object Scala07_Collection {


  def main(args: Array[String]): Unit = {

    val list: List[Int] = List(1,2,3,4)
    val newlist: List[Int] = list :+ 5

    println(list eq newlist)
    println(newlist)

    println(list.mkString(","))
    list.foreach(println)

  }

}
