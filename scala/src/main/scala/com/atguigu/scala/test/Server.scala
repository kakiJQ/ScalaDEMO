package com.atguigu.scala.test

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.{ServerSocket, Socket}

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-9:52 PM
  */
object Server {

  def main(args: Array[String]): Unit = {
    //创建一个服务器，并指定端口号
    val server : ServerSocket = new ServerSocket(9999)

    //获取客户端
    val client : Socket = server.accept()

    //获取一个输入流
    val objInput : ObjectInputStream = new ObjectInputStream(client.getInputStream)

    //读取并反序列化
    val getObjCal : Any = objInput.readObject()
    val objCal : (Int)=>Int = getObjCal.asInstanceOf[(Int)=>Int]

    println("Receive Successfully!")

    //运算
    val result : Int = objCal(2)


    //写出
    client.getOutputStream.write(result)

    println("Sends Back")

    //流关闭
    objInput.close()




  }

}
