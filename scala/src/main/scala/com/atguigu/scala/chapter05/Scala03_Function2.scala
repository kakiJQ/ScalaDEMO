package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-9:22 PM
  */
object Scala03_Function2 {

  def main(args: Array[String]): Unit = {

    def fun1() : Unit = {
      println("fun1...")
    }

    fun1()

    def fun2() : String = {
      return "fun2..."
    }

    println(fun2())

    def fun3(s:String) : Unit = {
      println(s)
    }

    fun3("fun3...")

    def fun4(s:String) : String = {
      return "name: " + s
    }

    println(fun4("fun4..."))


    def fun5(name:String,age:Int) : Unit = {
      println(
        s"""
           |{name:$name, age:$age}
         """.stripMargin
      )
    }

    fun5("fun5...", 18)

    def fun6(name:String,age:Int) : String = {
      return s"name:$name, age$age"
    }

    println(fun6("fun6...", 666))

  }

}
