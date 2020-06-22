package com.atguigu.scala.chapter08

/**
  * @Description
  * @Author kaki
  * @create 2020-05-31-3:29 PM
  */
object Scala03_Match {

  def main(args: Array[String]): Unit = {

    /*val user = User("pp",20)

    val result: Any = user match {
      case User("kk",20) => "yes"
      case u: User => u.name + u.age + "yes"
      case _ => "no"
    }
    println(result)*/

    val emp = Emp("kl",21)

    emp match {
      case Emp("kl",22) => println("aaa")
      case _ => println("xxx")
    }

  }

  case class Emp(name:String,age:Int)

  class User(val name : String, val age : Int)

  object User {
    def apply(name: String, age: Int): User = new User(name, age)

    def unapply(user: User): Option[(String, Int)] = {
      Option((user.name, user.age))
    }
  }

}
