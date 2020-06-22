package com.atguigu.scala.chapter07

import scala.collection.mutable

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-9:08 PM
  */
object Scala29_Collection_Method7 {

  def main(args: Array[String]): Unit = {

    val map1: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->2,"c"->3)
    val map2: mutable.Map[String, Int] = mutable.Map("a"->4,"d"->5,"c"->6)

    val finalResult: mutable.Map[String, Int] = map1.foldLeft(map2: mutable.Map[String, Int])(
      (map: mutable.Map[String, Int], kv: (String, Int)) => {

        //map.update(kv._1, map.getOrElse(kv._1, 0) + kv._2)
        val k : String = kv._1
        val v : Int = kv._2
        val newV : Int = map.getOrElse(k,0) + v
        map.update(k,newV)
        map
    })
    println(finalResult)


  }

}
