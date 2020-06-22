package com.atguigu.scala.chapter07

import scala.beans.BeanProperty
import scala.io.{BufferedSource, Source}

/**
  * @Description
  * @Author kaki
  * @create 2020-05-28-12:50 PM
  */
object Scala20_Collection_WordCount {

  def main(args: Array[String]): Unit = {

    //TODO 1. 传入文件，装入集合
    val source: BufferedSource = Source.fromFile("input/word")
    val lineList: List[String] = source.getLines().toList
    source.close()

    //TODO 2. spilit, 分组
    val words: List[String] = lineList.flatMap((line: String) => {
      line.split(" ")
    })

    val groupWords: Map[String, List[String]] = words.groupBy((word: String) => {
      word
    })


    //TODO 3. 计数
    val wordCount: Map[String, Int] = groupWords.map((kv: (String, List[String])) => {
      (kv._1, kv._2.length)
    })


    //TODO 4. 排序
    val orderWordCounts: List[(String, Int)] = wordCount.toList.sortBy((kv:(String,Int))=>{kv._2})(Ordering.Int.reverse)

    //TODO 5. 取值
    val finalResult: List[(String, Int)] = orderWordCounts.take(3)
    println(finalResult)

  }

}
