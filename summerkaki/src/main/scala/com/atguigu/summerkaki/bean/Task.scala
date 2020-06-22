package com.atguigu.summerkaki.bean

/**
  * @Description
  * @Author kaki
  * @create 2020-05-24-3:28 PM
  */
class Task extends Serializable {

  var data : Int = 0
  var logic : (Int)=>Int = null

  def compute() = {
    logic(data)
  }

}
