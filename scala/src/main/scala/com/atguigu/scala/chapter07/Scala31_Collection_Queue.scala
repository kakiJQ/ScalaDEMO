package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-9:54 PM
  */
object Scala31_Collection_Queue {

  def main(args: Array[String]): Unit = {

    val queue: mutable.Queue[String] = mutable.Queue[String]()
    queue.enqueue("a")
    queue.enqueue("b")
    queue.enqueue("c")

    val q1: mutable.Queue[String] = queue += "d"
    
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

  }

}
