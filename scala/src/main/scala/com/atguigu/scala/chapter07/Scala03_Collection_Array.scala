package com.atguigu.scala.chapter07

import scala.collection.mutable.ArrayBuffer

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-10:17 PM
  */
object Scala03_Collection_Array {

  def main(args: Array[String]): Unit = {

    val array : ArrayBuffer[String] = new ArrayBuffer[String]()
    array.append("a")
    array.append("b")
    array.append("c")
    array.insert(2,"k","k","k")
    array.update(1,"o")
    array.remove(1)

    /*for (show <- array) {
      println(show)
    }*/
    println(array)
    println(array.mkString(","))

    Map

  }

}
