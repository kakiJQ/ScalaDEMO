package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-25-8:23 PM
  */
object Scala16_Method1 {

  def main(args: Array[String]): Unit = {
    val user = new User16()
    //val user1 = User16.apply()
    val user1 = User16()
    val user2 = User16("kaki")
  }

}

class User16 {

}

object User16 {

  def apply() : User16 = {
    new User16
  }

  def apply(name:String): User16 = {
    println("name: " + name)
    new User16()
  }
}