package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-7:41 PM
  */
object Scala11_Collection_Set1 {

  def main(args: Array[String]): Unit = {

    val set = mutable.Set(1,2,3,4)

    set.add(0)

    //set.update(6,true)
    //set.update(4,false)

    //println(set)

    val newSet: mutable.Set[Int] = set + 5
    val oldSet: mutable.Set[Int] = set += 7

    println(set eq newSet)
    println(set eq oldSet)


  }

}
