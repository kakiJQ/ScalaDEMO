package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-3:41 PM
  */
object Scala08_Function7 {

  def main(args: Array[String]): Unit = {

    def test() ={
      "kaki"
    }

    val result = test

    val f = test _

    //println(result)
    //println(f1())

    def test1() : String = {
      return "kaki"
    }

    val f1 : () => String = test1

    def test2(s:String) : String = {
      return s
    }

    val f2 : (String) => String = test2



  }

}
