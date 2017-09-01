package com.hpu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: li_zhilei
 * @Date: create in 18:54 17/8/27.
 * @description: 非阻塞式
 */
public class ServerSocketChannelAPI {

    public static void main(String[] args) throws IOException {
       serverSocketTest();
    }

    public static void serverSocketTest() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9998));
        serverSocketChannel.configureBlocking(false);
        while (true){
            SocketChannel channel = serverSocketChannel.accept();
//            System.out.println("first return "+ channel);
            if (channel != null){ //非阻塞式，就算没有接收也会返回空，所以要有个判断
                System.out.println("address = " + channel.getLocalAddress());
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int byteRead = channel.read(byteBuffer);
                byteBuffer.clear();
                StringBuffer sb = new StringBuffer();
                if (byteRead == -1){
                   channel.close();
                   return;
                }
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.println("sb.toString() = " + sb.toString());
                    sb.append(byteBuffer.array());
                }
            }
        }
    }
}
