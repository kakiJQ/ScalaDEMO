package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-8:27 PM
  */
object Scala26_Collection_Method4 {

  def main(args: Array[String]): Unit = {

    val list: List[Int] = List(3,7,8,0)

    val i: Int = list.reduce((a:Int,b:Int)=>{a+b})

    val i1: Int = list.reduceRight((a:Int,b:Int)=>{a-b})

    println(i1)

  }

}
