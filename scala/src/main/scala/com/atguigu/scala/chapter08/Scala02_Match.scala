package com.atguigu.scala.chapter08

/**
  * @Description
  * @Author kaki
  * @create 2020-05-31-2:53 PM
  */
object Scala02_Match {

  def main(args: Array[String]): Unit = {

    /*def describe(x:Any) = {
      val result = x match {
        case 5 => "Int Five"
        case true => "Bealoon True"
        case "hello" => "String Hello"
        case '+' => "Char +"
      }

      println(result)
    }

    describe(true)*/

    /*val s: Array[String] = Array[String]()

    def descible1(x:Any) = {
      val result = x match {
        case i : Int => "Int"
        case s : String => "String"
        case l : List[_] => "List"
        case a : Array[String] => "Array[String]"
        case something => "else: " + something
      }
      println(result)
    }

    descible1(s)*/

    val list = List(1,"2",3,List(4,5))

    val newList: List[Any] = list.flatMap((data: Any) => {
      data match {
        case a: List[_] => a
        case b: Any => List(b)
      }
    })
    println(newList)

  }

}
