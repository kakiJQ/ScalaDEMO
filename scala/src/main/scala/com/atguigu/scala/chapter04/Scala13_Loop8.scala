package com.atguigu.scala.chapter04

import scala.util.control.Breaks

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-8:23 PM
  */
object Scala13_Loop8 {

  def main(args: Array[String]): Unit = {

    Breaks.breakable{

      for (i <- 1 to 5){

        if (i == 3){
          Breaks.break()
        }

        println(i)

      }

    }

    println("sssss")



  }

}
