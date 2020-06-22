package com.atguigu.scala.chapter07

import scala.collection.mutable.ArrayOps

/**
  * @Description
  * @Author kaki
  * @create 2020-05-29-5:43 PM
  */
object Scala21_Collection_WordCount {

  def main(args: Array[String]): Unit = {

    val tuplesList = List(
      ("hello",4),
      ("hello spark",3),
      ("hello spark scala",2),
      ("hello spark scala hive",1)
    )

    val wordTuples: List[(String, Int)] = tuplesList.flatMap((kv: (String, Int)) => {

      val words: ArrayOps.ofRef[String] = kv._1.split(" ")

      words.map((word: String) => {
        (word, kv._2)
      })

    })

    val groupWords: Map[String, List[(String, Int)]] = wordTuples.groupBy((kv:(String,Int))=>{kv._1})

    val countGroup: Map[String, Int] = groupWords.map((kv: (String, List[(String, Int)])) => {
      val countList: List[Int] = kv._2.map((t: (String, Int)) => {
        t._2
      })
      val sumCount: Int = countList.sum
      (kv._1, sumCount)
    })

    val orderWords: List[(String, Int)] = countGroup.toList.sortBy((kv:(String,Int))=>{kv._2})(Ordering.Int.reverse)

    val finalResult: List[(String, Int)] = orderWords.take(3)

    println(finalResult)






  }

}
