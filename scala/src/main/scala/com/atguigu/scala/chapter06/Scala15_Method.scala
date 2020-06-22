package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-25-8:03 PM
  */
object Scala15_Method {

  def main(args: Array[String]): Unit = {

    val user = new User()

  }



  class User {


    override def equals(obj: Any): Boolean = {

      if (obj.isInstanceOf[User]) {
        val otherUser = obj.asInstanceOf[User]
        this == otherUser
      }
      else {
        false
      }

    }
  }

}

