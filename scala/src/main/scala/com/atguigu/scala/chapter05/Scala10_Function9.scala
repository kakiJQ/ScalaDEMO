package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-7:46 PM
  */
object Scala10_Function9 {

  def main(args: Array[String]): Unit = {

    def sum(x:Int,y:Int) : Int = {
      x+y
    }

    def cal(f:(Int,Int)=>Int) = {
      val boy = 20
      val girl = 25

      f(boy,girl)

    }

    //val s = sum _
    //println(cal(s))

    //val rse = cal( (x, y)=> x+y )
    val rse = cal( _ + _ )

    println(rse)

  }

}
