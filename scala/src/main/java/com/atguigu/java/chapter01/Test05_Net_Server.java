package com.atguigu.java.chapter01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author kaki
 * @create 2020-05-19-8:57 AM
 */
public class Test05_Net_Server {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(9999);

        /*while (true){
            Socket client = server.accept();

            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            int data = 0;
                            try {
                                data = client.getInputStream().read();
                                System.out.println("服务器读取的数据为： " + data);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
            ).start();
            }*/
        Socket client = server.accept();

        ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());

        User05 user = (User05)objectInputStream.readObject();
        System.out.println("服务器读取的数据为： " + user.name);



    }
}
