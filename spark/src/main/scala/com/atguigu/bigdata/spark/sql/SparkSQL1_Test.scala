package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-12-7:55 PM
  */
object SparkSQL1_Test {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark : SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import spark.implicits._

    val rdd : RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List(
      (1, "zhangsan", 30),
      (2, "lisi", 20),
      (3, "wangwu", 40)
    ))

    /*val userRDD : RDD[User] = rdd.map {
      case (id, name, age) => {
        User(id, name, age)
      }
    }

    val userDS : Dataset[User] = userRDD.toDS()

    val newDS: Dataset[User] = userDS.map(user => {
      User(user.id, "name: " + user.name, user.age)
    })

    newDS.show()*/

    /*val df : DataFrame = rdd.toDF("id","name","age")

    val ds: Dataset[Row] = df.map(row => {
      val id = row(0)
      val name = row(1)
      val age = row(2)
      Row(id, "name" + name, age)
    })
    ds.show()*/

    // TODO 使用 自定义函数在SQL中完成数据的转换操作
    val df : DataFrame = rdd.toDF("id","name","age")
    df.createOrReplaceTempView("user")
    spark.udf.register("addName",(x:String)=>"Name: "+ x)
    spark.udf.register("changeAge",(x:Int)=>18)

    spark.sql("select addName(name),changeAge(age) from user").show()

    spark.stop()

  }

  case class User(id:Int, name:String, age:Int)

}
