package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-8:50 PM
  */
object Scala28_Collection_Method6 {

  def main(args: Array[String]): Unit = {

    val list : List[Int] = List(7,3,1,0,6)
    val i: Int = list.fold(1)((a: Int, b: Int) => {
      a + b
    })

    val str: String = list.foldLeft("a")((a:String,b:Int)=>{a+b})



    println(str)

  }

}
