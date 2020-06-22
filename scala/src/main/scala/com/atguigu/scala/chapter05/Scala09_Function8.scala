package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-6:34 PM
  */
object Scala09_Function8 {

  def main(args: Array[String]): Unit = {

    def test1(i:Int) : Int = {
      return i*2
    }

    def test2(f2:(Int)=>Int) : Int = {
      f2(10)
    }

    val f : (Int) => Int  = test1

    //println(test2(f))

    val result = test2( (i:Int)=> {i*i} )

    //println(result)




  }

}
