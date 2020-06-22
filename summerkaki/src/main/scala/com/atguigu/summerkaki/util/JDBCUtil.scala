package com.atguigu.summerkaki.util

import java.sql.Connection
import java.util

import com.alibaba.druid.pool.DruidDataSourceFactory
import javax.sql.DataSource

/**
  * @Description
  * @Author kaki
  * @create 2020-06-16-6:46 PM
  */
object JDBCUtil {

  //创建连接池对象
  var dataSource : DataSource = init()

  //连接处的初始化
  def init():DataSource ={

    val paramMap: util.HashMap[String, String] = new util.HashMap[String,String]()
    paramMap.put("driverClassName",PropertiesUtil.getvalue("jdbc.driver.name"))
    paramMap.put("url",PropertiesUtil.getvalue("jdbc.url"))
    paramMap.put("username",PropertiesUtil.getvalue("jdbc.user"))
    paramMap.put("password",PropertiesUtil.getvalue("jdbc.password"))
    paramMap.put("maxActive",PropertiesUtil.getvalue("jdbc.datasource.size"))

    //使用德鲁伊连接池对象
    DruidDataSourceFactory.createDataSource(paramMap)
  }

  //从连接池中获取连接对象
  def getConnection() : Connection ={
    dataSource.getConnection()
  }

}
