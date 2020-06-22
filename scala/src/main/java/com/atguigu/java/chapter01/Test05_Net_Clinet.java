package com.atguigu.java.chapter01;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Description
 * @Author kaki
 * @create 2020-05-19-8:58 AM
 */
public class Test05_Net_Clinet {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",9999);


        User05 user = new User05();
        user.name = "kkk";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);

        socket.getOutputStream().write(10);

        System.out.println("客户端发送的数据为10");

        socket.close();
    }
}
