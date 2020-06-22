package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-25-6:43 PM
  */
object Scala13_Field4_Access {

  def main(args: Array[String]): Unit = {

    val user : User = new User()
    user.test()
    //user.name = "lisi"

    val emp : Emp = new Emp()
    emp.test()

  }

}

class User {
  private var name : String = "kaki"
  private[chapter06] var age : Int = 20
  protected var tel : Int = 12121212


  def test() : Unit = {
    println("Name: " + name)
    println("Tel: " + tel)
  }
}

class SubUser extends User {

  def test1() : Unit = {

    println(tel)
  }

}

class Emp {

  def test() : Unit = {
    val user : User = new User()
    println("Age: " + user.age)
    //println("Tel: " + user.tel)
  }

}