package com.atguigu.scala.test

/**
  * @Description
  * @Author kaki
  * @create 2020-05-21-10:35 PM
  */

/*
* 4. 如果设计一个用于过滤的函数，你会如何做？
要求：对传递的包含多个单词的字符串参数,根据指定的规则对word进行过滤
例子："hello world scala spark" => 首写字母为s => "scala, spark"
* */
object Homework4 {

  def main(args: Array[String]): Unit = {

    val line = "hello world scala spark"
    val list = line.split(" ")

    var result = ""

    for (word <- list) {

      if (word.substring(0,1) == "s"){
        result += word + ", "
      }
    }

    println(result)

  }

}
