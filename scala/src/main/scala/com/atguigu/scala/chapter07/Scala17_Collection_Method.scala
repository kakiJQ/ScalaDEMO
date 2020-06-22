package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-9:20 PM
  */
object Scala17_Collection_Method {

  def main(args: Array[String]): Unit = {

    val list: List[Int] = List(1,2,3,4)

    //println(list.length)

    println(list.head)
    println(list.tail)
    println(list.last)
    println(list.init)

    list.reverse
    list.contains(5)

    list.toSet
    list.distinct

    list.take(1)

  }

}
