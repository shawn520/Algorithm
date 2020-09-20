package com.github.demo.basic.java.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO
 * main线程为每一个连接创建一个线程，没有新的连接时,main线程阻塞在在accept()方法上。
 * 当前连接没有数据传输时，线程阻塞在read()方法
 *
 * cmd客户端telnet 127.0.0.1 6666
 *  'CTRL+]' 开始发送消息 send hello100
 *
 * @author Shawn
 * @date 2020/9/7
 */
public class BIOServer {
  public static void main(String[] args) throws IOException {
    //线程池机制

    //思路：
    // 1. 创建一个线程池

    ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

    // 创建ServerSocket
    ServerSocket serverSocket = new ServerSocket(6666);

    System.out.println("服务器启动了");

    while (true) {
      //监听，等待客户端连接
      System.out.println("等待连接....");
      final Socket socket = serverSocket.accept();
      System.out.println("连接到一个客户端");

      //2. 如果有客户端连接，就创建一个线程与之通讯（单独写一个方法）
      newCachedThreadPool.execute(new Runnable() {
        @Override
        public void run() { //重写
          //可以和客户端通讯
          handler(socket);
        }
      });


    }


  }

  public static void handler(Socket socket) {
    System.out.println("线程id = " + Thread.currentThread().getId() + " 名字" + Thread.currentThread().getName());

    byte[] bytes = new byte[1024];
    // 通过socket获取输入流
    try {
      InputStream inputStream = socket.getInputStream();

      //循环读取客户端发送的数据
      while (true) {
        System.out.println("线程id = " + Thread.currentThread().getId() + " 名字" + Thread.currentThread().getName());

        System.out.println("read....");
        int read = inputStream.read(bytes);
        if(read != -1) {
          System.out.println(new String(bytes, 0 , read)); //输出客户端发送的数据
        } else {
          break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("关闭和client的连接");
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }
}
