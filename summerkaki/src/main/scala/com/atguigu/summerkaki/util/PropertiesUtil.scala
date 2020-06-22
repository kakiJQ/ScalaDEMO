package com.atguigu.summerkaki.util

import java.util.ResourceBundle

/**
  * @Description
  * @Author kaki
  * @create 2020-05-24-2:43 PM
  */
object PropertiesUtil {

  private val summer: ResourceBundle = ResourceBundle.getBundle("summer")

  def getvalue(key:String) : String = {
    summer.getString(key)
  }

}
