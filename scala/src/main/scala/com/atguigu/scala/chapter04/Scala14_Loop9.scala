package com.atguigu.scala.chapter04

import scala.util.control.Breaks._

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-8:34 PM
  */
object Scala14_Loop9 {


  def main(args: Array[String]): Unit = {

    breakable{

      for (i <- 1 to 5){

        if (i == 3){
          break
        }

        println(i)

      }

    }

    println("xxxx")


  }



}
