package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-8:46 PM
  */
object Scala34_Interface2 {

  def main(args: Array[String]): Unit = {



  }

}

trait ParentTest34 {

}

trait ParentTest34_1 {

}

trait Test34 extends ParentTest34 with ParentTest34_1 with Serializable{

  def test() : Unit

  def test2() : Unit = {

  }

}

trait Test34_1 extends Exception with ParentTest34 {

}

class User34 extends Test34 {
  def test() : Unit = {

  }
}