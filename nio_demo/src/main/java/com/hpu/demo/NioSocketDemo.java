package com.hpu.demo;

import java.io.IOException;

/**
 * @Author: li_zhilei
 * @Date: create in 12:59 17/8/30.
 * @description:用serverSocketChannel来实现一个socket实例
 */
public class NioSocketDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                NioServerSocket serverSocket = new NioServerSocket();
                try {
                    System.out.println("服务端启动中... ");
                    serverSocket.listenDefault();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("客户端请求连接中...");
                    NioClientSocket clientSocket = new NioClientSocket();
                    clientSocket.connectDefault();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
