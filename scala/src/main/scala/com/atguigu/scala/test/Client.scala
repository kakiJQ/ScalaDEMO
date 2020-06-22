package com.atguigu.scala.test

import java.io.ObjectOutputStream
import java.net.Socket

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-9:51 PM
  */
object Client {

  def main(args: Array[String]): Unit = {

    //获取一个本机的客户端
    val socket : Socket = new Socket("localhost",9999)

    //函数
    def cal(x:Int) : Int = {
      x*2
    }

    //获取函数对象
    val objCal = cal _

    //输出流
    val objOutput : ObjectOutputStream = new ObjectOutputStream(socket.getOutputStream)

    //写出
    objOutput.writeObject(objCal)

    println("Object sends successfully")

    //显式的关闭输出流
    socket.shutdownOutput()

    //读取返回数据
    val backInfo = socket.getInputStream.read()
    println(backInfo)

    //流关闭
    objOutput.close()


  }



}
