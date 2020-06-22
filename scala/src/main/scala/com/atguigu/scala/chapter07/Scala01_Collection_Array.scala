package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-9:46 PM
  */
object Scala01_Collection_Array {

  def main(args: Array[String]): Unit = {

    val array = new Array[String](5)

    //println(array)

    array(0) = "kaki"
    array(1) = "kaki"
    array(2) = "kaki"
    array(3) = "kaki"
    array(4) = "kaki"

    /*for (show <- array) {
      println(show)
    }*/
    println(array.mkString(","))

  }

}
