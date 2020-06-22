package com.atguigu.scala.chapter02

/**
  * @Description
  * @Author kaki
  * @create 2020-05-19-6:48 AM
  */
object Scala11_String {
  def main(args: Array[String]): Unit = {
    val name : String = "kaki"
    val age : Int = 20

    val json =
      s"""
        |{username:$name, age:$age}
      """.stripMargin
    print(json)
  }

}
