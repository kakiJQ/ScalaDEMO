package com.atguigu.scala.chapter04

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-5:55 PM
  */
object Scala07_Loop2 {
  def main(args: Array[String]): Unit = {

    /*for (i <- 1 to 5) {
      for (j <- 1 to 5) {
        println("i= " + i + " j= " + j)
      }

    }*/

    /*for (i <- Range(1,5); j <- Range(1,5)){
      println("i= " + i + " j= " + j)
    }
    */

    for (i <- Range(1,5); j = i-1){
      println("i= " + i + " j= " + j)
    }
  }

}
