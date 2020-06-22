package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-2:34 PM
  */
object Scala06_Function5 {

  def main(args: Array[String]): Unit = {

    def test(name:String) : String = {
      return "Name = " + name
    }

    def test1(name:String) : String = {
      "Name = " + name
    }

    def test2(i:Int) =

      if(i > 10){
        "kaki"
      }
      else {
        25

    }

    def test3(name:String) = "Name = " + name


    def test4 = "test4"

    def test5() {

    }

    val a = () => println("Hello ~   No Name")

    a()

    //println(test4)

  }

}
