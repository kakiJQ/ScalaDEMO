package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-7:26 PM
  */
object Scala10_Collection_Set {

  def main(args: Array[String]): Unit = {

    val set : Set[Int] = Set(1,2,3,4)
    val set1: Set[Int] = set + 5

    println(set eq set1)
    println(set)
    println(set1)

  }

}
