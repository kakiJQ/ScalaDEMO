package com.atguigu.scala.chapter05

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.{ServerSocket, Socket}

import com.atguigu.summerkaki.bean.Task
import com.atguigu.summerkaki.core.Application

/**
  * @Description
  * @Author kaki
  * @create 2020-05-24-2:26 PM
  */
object Scala21_Function_Server extends Application{

  def main(args: Array[String]): Unit = {

    start("serverSocket"){

      val server : ServerSocket = envData.asInstanceOf[ServerSocket]

      while (true) {
        var client : Socket = server.accept()
        new Thread(
          new Runnable {
            override def run(): Unit = {

              val inObject : ObjectInputStream = new ObjectInputStream(client.getInputStream)
              val task = inObject.readObject().asInstanceOf[Task]
              client.shutdownInput()

              val outObject : ObjectOutputStream = new ObjectOutputStream(client.getOutputStream)
              val result = task.compute()
              outObject.writeObject(result)
              outObject.flush()
              client.shutdownOutput()

              if (!client.isClosed){
                client.close()
              }

              client = null

            }
          }
        ).start()
      }

    }

  }

}
