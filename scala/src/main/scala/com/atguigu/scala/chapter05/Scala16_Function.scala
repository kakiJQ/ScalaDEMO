package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-8:04 PM
  */
object Scala16_Function {

  def main(args: Array[String]): Unit = {



    //test(println("kkjkkk"))

    def fun : String = {
      "lloooollll"
    }

    test(fun)

  }

  def test(f: =>String) : Unit = {
    println(f)
  }

}
