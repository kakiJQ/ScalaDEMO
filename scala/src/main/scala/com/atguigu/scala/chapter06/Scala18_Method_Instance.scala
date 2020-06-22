package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-25-9:48 PM
  */
object Scala18_Method_Instance {

  def main(args: Array[String]): Unit = {

    val user = new User()
    user.User()

  }

  class User() {

    def User() = {
      println("init...")
    }

  }

}
