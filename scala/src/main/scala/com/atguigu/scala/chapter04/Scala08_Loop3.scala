package com.atguigu.scala.chapter04

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-6:25 PM
  */
object Scala08_Loop3 {
  def main(args: Array[String]): Unit = {

   /* val num : Int = 9
    for (i <- 1 to 2*num by 2){
      for (j <- 1 to i){
        print("*")
      }
      println()
    }*/

    val num = 9
    for (i <- 1 to 2*num by 2;j = (2*num-i)/2){
      println(" "*j + "*"*i)
    }




  }

}
