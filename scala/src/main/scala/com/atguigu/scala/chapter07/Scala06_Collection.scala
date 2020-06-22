package com.atguigu.scala.chapter07

import scala.collection.mutable.ArrayBuffer

/**
  * @Description
  * @Author kaki
  * @create 2020-05-27-6:18 PM
  */
object Scala06_Collection {

  def main(args: Array[String]): Unit = {

    val array = Array(1,2,3,4)

    /*def fun(i:Int) : Unit = {
      println(i)
    }*/

    //array.foreach(fun)

    TestArray(1,2,3,4)

    /*TestArray.foreach((i:Int)=>{println(i)})
    TestArray.foreach((i:Int)=>println(i))
    TestArray.foreach((i)=>println(i))
    TestArray.foreach(i=>println(i))
    TestArray.foreach(println(_))*/
    //TestArray.foreach(println)


    var myMatrix = Array.ofDim[Int](3,3)
    myMatrix.foreach(_.foreach(println))

  }

  object TestArray {

    val buffer = new ArrayBuffer[Int]()

    def apply(i:Int*)  = {

      for (is <- i) {
        buffer.append(is)
      }

    }

    def foreach(f : Int => Unit) : Unit = {
      for (i <- buffer) {
        f(i)
      }
    }

  }

}
