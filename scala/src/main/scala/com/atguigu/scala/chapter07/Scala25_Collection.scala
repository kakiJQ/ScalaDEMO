package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-8:05 PM
  */
object Scala25_Collection {

  def main(args: Array[String]): Unit = {

    val ints1 = List(1,2,3,4)
    val ints2 = List(7,8,3,2,9)

    //println(ints1.union(ints2))

    //println(ints1.intersect(ints2))

    //println(ints1.diff(ints2))

    //val list: List[(Int, Int)] = ints1.zip(ints2)
    //println(list)

    val list: List[String] = List("a","b","c","d","p","l","d","k")

    val index: List[(String, Int)] = list.zipWithIndex

    val iterator: Iterator[List[String]] = list.sliding(3,3)

    while (iterator.hasNext) {
      println(iterator.next())
    }



  }

}
