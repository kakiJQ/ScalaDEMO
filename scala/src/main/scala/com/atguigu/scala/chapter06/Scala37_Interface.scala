package com.atguigu.scala.chapter06

/**
  * @Description
  * @Author kaki
  * @create 2020-05-26-9:10 PM
  */
object Scala37_Interface {

  def main(args: Array[String]): Unit = {

    new MySQL37().operateData()

  }

}
trait Operate37 {

  def operateData() : Unit  = {
    println("Operating data...")
  }

}

trait DB37 extends Operate37 {
  override def operateData(): Unit = {
    println("To Database...")
    super.operateData()
  }
}

trait Log37 extends Operate37 {
  override def operateData(): Unit = {
    println("To Log...")
    super.operateData()
  }
}

class MySQL37 extends DB37 with Log37 {


}