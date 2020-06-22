package com.atguigu.bigdata.spark.serial

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-06-2:35 PM
  */
object Spark52_Serial {

  def main(args: Array[String]): Unit = {

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRDD")
    val sc = new SparkContext(sparkConf)

    /*//TODO Spark
    val rdd : RDD[Int] = sc.makeRDD(List(1,2,3,4))
    rdd.foreach(
      num => {
        val user = new User()
        println("age=" + (user.age + num))
      }
    )*/

    //TODO Exception: Task not serializable
    //算子里的在executor端， 外面在driver端
    //算子中使用了算子外的对象， 那么在执行时，需要保证整个对象序列化
    /*val user = new User()
    val rdd : RDD[Int] = sc.makeRDD(List(1,2,3,4))
    rdd.foreach(
      num => {
        println("age=" + (user.age + num))
      }
    )*/

    //TODO Scala闭包
    val user = new User()
    val rdd : RDD[Int] = sc.makeRDD(List())

    //Spark的算子的操作都是闭包（匿名函数），所以闭包有可能包含外部的变量
    //如果包含外部的变量， 那么就一定要保证这个外部变量的可序列化
    //所以Spark在提交作业之前，就应该对闭包的变量就行检测，检测是否能够序列化
    //将这个称之为闭包检测
    rdd.foreach(
      num => {
        println("age=" + (user.age + num))
      }
    )

    sc.stop()

  }

  class User {
    val age:Int =30
  }

  //样例类自动混入可序列化特质
  //case class User(age:Int =20) {}

}
