package com.atguigu.scala.chapter05

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.Socket

import com.atguigu.scala.chapter05.Scala21_Function_Server.start
import com.atguigu.summerkaki.bean.Task
import com.atguigu.summerkaki.core.Application

/**
  * @Description
  * @Author kaki
  * @create 2020-05-24-2:26 PM
  */
object Scala22_Function_Client extends Application{

  def main(args: Array[String]): Unit = {

    start("socket"){

      val client : Socket = envData.asInstanceOf[Socket]
      
      val outObject : ObjectOutputStream = new ObjectOutputStream(client.getOutputStream)

      val task : Task = new Task()
      task.data = 10
      //task.logic = (x:Int)=>{x*2}
      task.logic = _ * 2


      outObject.writeObject(task)
      outObject.flush()
      client.shutdownOutput()


      val inObject : ObjectInputStream = new ObjectInputStream(client.getInputStream)
      val result = inObject.readObject().asInstanceOf[Int]
      println("Get the result: " + result)
      client.shutdownInput()

    }

  }

}
