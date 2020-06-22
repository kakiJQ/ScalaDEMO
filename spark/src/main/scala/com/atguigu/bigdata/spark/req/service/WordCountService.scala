package com.atguigu.bigdata.spark.req.service

import com.atguigu.bigdata.spark.req.dao.WordCountDAO
import com.atguigu.summerkaki.core.TService
import com.atguigu.summerkaki.util.EnvUtil
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * @Description
  * @Author kaki
  * @create 2020-06-08-11:47 PM
  */
class WordCountService extends TService {

  private val wordCountDAO = new WordCountDAO

  override def analysis() = {
    val dataRDD : RDD[String] = wordCountDAO.readFile("input/word.txt")
    val fmRDD : RDD[String] = dataRDD.flatMap(line => {line.split(" ")})
    val groupRDD : RDD[(String, Iterable[String])] = fmRDD.groupBy(word=>word)
    val countRDD : RDD[(String, Int)] = groupRDD.map { case (key, data) => {(key, data.size)}}
    val finalResult : Array[(String, Int)] = countRDD.collect()
    finalResult
  }

}
