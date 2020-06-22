package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-8:46 PM
  */
object Scala15_Collection_Tuple {

  def main(args: Array[String]): Unit = {

    val data = ("kaki", 1, true)

    /*println(data._1)
    println(data._2)
    println(data._3)*/

    val iterator: Iterator[Any] = data.productIterator

    while (iterator.hasNext) {
      println(iterator.next())
    }

    println(data.productElement(0))

  }

}
