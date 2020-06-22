package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-7:39 PM
  */
object Scala22_Collection_SortWith {

  def main(args: Array[String]): Unit = {

    val tuples: List[(Int, String)] = List((10,"kaki"),(20,"kiko"),(10,"pp"))

    println(tuples.sortWith(
      (left, right) => {
        if (right._1 > left._1) {
          false
        }
        else if (right._1 == left._1) {
          right._2 < left._2
        }
        else {
          true
        }
      }
    ))

  }

}
