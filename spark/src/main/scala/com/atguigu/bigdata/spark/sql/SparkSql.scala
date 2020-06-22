package com.atguigu.bigdata.spark.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-06-11-5:11 PM
  */
object SparkSql {

  def main(args: Array[String]): Unit = {

    val sparkSQLConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkSQLConf).getOrCreate()
    import spark.implicits._

    val jsonDF : DataFrame = spark.read.json("input/user.json")

    jsonDF.createOrReplaceTempView("user")
    spark.sql("select * from user").show

    jsonDF.select("name","age").show
    jsonDF.select('name,'age).show

    val rdd = spark.sparkContext.makeRDD(List(
      (1, "aa", 20),
        (2, "bb", 10),
        (3, "cc", 29)
    ))
    val df : DataFrame = rdd.toDF("id","name","age")
    val rddB: RDD[Row] = df.rdd

    val userRDD : RDD[User] = rdd.map {
      case (id, name, age) => {
        User(id, name, age)
      }
    }
    val userDS : Dataset[User] = userRDD.toDS()
    val dsToRDD: RDD[User] = userDS.rdd

    val dfToDS: Dataset[User] = df.as[User]
    val dsToDF: DataFrame = dfToDS.toDF()

    spark.stop()
  }

  case class User(id:Int,name:String,age:Int)

}
