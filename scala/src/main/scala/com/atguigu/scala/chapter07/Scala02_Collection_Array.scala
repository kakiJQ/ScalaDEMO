package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-9:57 PM
  */
object Scala02_Collection_Array {

  def main(args: Array[String]): Unit = {

    val array = Array(1,2,3,4)

    val ints: Array[Int] = array :+ 5

    val array1 : Array[Int] = array. +: (5)
    val array2: Array[Int] = 5 +: array

    val array4 : Array[Any] = array :+ "0"


    val array3: Array[Int] = array ++ array1

    println(array.mkString(","))
    println(array.mkString(","))
    println(array1.mkString(","))
    println(array2.mkString(","))
    println(array3.mkString(","))

  }

}
