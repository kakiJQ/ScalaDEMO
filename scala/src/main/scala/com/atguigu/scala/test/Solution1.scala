package com.atguigu.scala.test

/**
  * @Description
  * @Author kaki
  * @create 2020-05-28-2:23 PM
  */
object Solution1 {

  def main(args: Array[String]): Unit = {

    //TODO 1.get the data
    val tuplesList = List(("hello",4),("hello spark",3),("hello spark scala",2),("hello spark scala hive",1))


    val strings: List[String] = tuplesList.map(t => {
      (t._1+" ") * t._2
    })

    val words: List[String] = strings.flatMap(line => {
      line.split(" ")
    })

    val groupWords: Map[String, List[String]] = words.groupBy(word => {
      word
    })

    val wordCount: Map[String, Int] = groupWords.map(kv => {
      (kv._1, kv._2.length)
    })

    val countOrder: List[(String, Int)] = wordCount.toList.sortBy(kv => {
      kv._2
    })(Ordering.Int.reverse)

    val finalResult: List[(String, Int)] = countOrder.take(3)

    println(finalResult)





  }

}
