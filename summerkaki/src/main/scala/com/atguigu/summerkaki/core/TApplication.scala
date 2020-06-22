package com.atguigu.summerkaki.core

import java.net.{ServerSocket, Socket}

import com.atguigu.summerkaki.util.{EnvUtil, PropertiesUtil}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Description
  * @Author kaki
  * @create 2020-05-22-8:23 PM
  */
trait TApplication {

  var envData : Any = null

  def start(s:String = "jdbc")( op: =>Unit ) : Unit = {

    //TODO initial enverinment...

    if (s == "socket") {
      envData = new Socket(PropertiesUtil.getvalue("server.host"),
        PropertiesUtil.getvalue("server.port").toInt)
    }
    else if (s == "serverSocket") {
      envData = new ServerSocket(PropertiesUtil.getvalue("server.port").toInt)
    }
    else if (s == "spark") {
     EnvUtil.getEnv()
    }
    else if (s == "sparkStreaming") {
      envData = EnvUtil.getStreamingEnv()
    }




    //TODO : op
    try {
      op
    } catch {
      case ex: Exception => println("failed..." + ex.getMessage)
    }




    //TODO: close the source...
    if (s == "socket") {
      val socket : Socket = envData.asInstanceOf[Socket]

      if (!socket.isClosed) {
        socket.close()
      }

    }
    else if (s == "serverSocket") {
      val server : ServerSocket = envData.asInstanceOf[ServerSocket]

      if (!server.isClosed){
        server.close()
      }

    }
    else if (s == "spark") {
      EnvUtil.clear()

    }
    else if (s == "sparkStreaming") {
      val ssc : StreamingContext = envData.asInstanceOf[StreamingContext]
      ssc.start()
      ssc.awaitTermination()

    }



  }

  /*def start( t:String = "jdbc" )( op : =>Unit ) : Unit = {

    // TODO 1. 初始化环境
    if ( t == "socket" ) {
      envData = new Socket(
        PropertiesUtil.getvalue("server.host"),
        PropertiesUtil.getvalue("server.port").toInt)
    } else if ( t == "serverSocket" ) {
      envData = new ServerSocket(
        PropertiesUtil.getvalue("server.port").toInt
      )
    } else if ( t == "spark" ) {
      envData = EnvUtil.getEnv()
    } else if ( t == "sparkStreaming" ) {
      envData = EnvUtil.getStreamingEnv()
    }

    // TODO 2. 业务逻辑
    try {
      op
    } catch {
      case ex: Exception => println("业务执行失败 ：" + ex.getMessage)
    }

    // TODO 3. 环境关闭
    if ( t == "socket" ) {
      val socket: Socket = envData.asInstanceOf[Socket]
      if ( !socket.isClosed ) {
        socket.close()
      }
    } else if ( t == "serverSocket" ) {
      val server: ServerSocket = envData.asInstanceOf[ServerSocket]
      if ( !server.isClosed ) {
        server.close()
      }
    } else if ( t == "spark" ) {
      EnvUtil.clear()
    } else if ( t == "sparkStreaming" ) {
      val ssc: StreamingContext = envData.asInstanceOf[StreamingContext]
      ssc.start()
      ssc.awaitTermination()
    }
  }*/

}
