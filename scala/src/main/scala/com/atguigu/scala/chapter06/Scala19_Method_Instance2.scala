package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-25-10:02 PM
  */
object Scala19_Method_Instance2 {

  def main(args: Array[String]): Unit = {

    val user = new User()
    val user2 = new User("kaki")
    val user3 = new User("jayme",24)

    println(user)
    println(user2)
    println(user3)

  }

  class User() {

    println("xxxxxxx")

    def this(name:String) = {
      this()
    }

    def this(name:String,age:Int) = {
      this(name)
    }

  }

}
