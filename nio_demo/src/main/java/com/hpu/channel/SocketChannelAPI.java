package com.hpu.channel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author: li_zhilei
 * @Date: create in 20:01 17/8/27.
 * @description:
 */
public class SocketChannelAPI {
    public static void main(String[] args) throws IOException {
        socketTest();
    }
    public static void socketTest() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //false 非阻塞式，true 阻塞式；默认是false
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",9998));
        while (!socketChannel.finishConnect()){
            System.out.println("socket is connecting... " );
        }
        System.out.println("socket is connected !" );
        while (socketChannel.isOpen()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("你好，我是小红".getBytes());
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                socketChannel.write(byteBuffer);
            }
            System.out.println("write over ");
            break;
        }
        socketChannel.close();
    }
}
