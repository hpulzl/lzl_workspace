package com.hpu.demo;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * @Author: li_zhilei
 * @Date: create in 13:53 17/8/30.
 * @description:socket客户端
 */
public class NioClientSocket {
    private Selector selector;
    private ByteBuffer byteBuffer;
    private CharsetDecoder decoder;
    private CharBuffer charBuffer;
    private CharsetEncoder charsetEncoder;
    public NioClientSocket(){
    }

    public void connectDefault() throws IOException {
        connect("127.0.0.1", 9999);
    }
    public void connect(String ipAddress, int port) throws IOException {
         selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //注册连接事件
        socketChannel.register(selector,SelectionKey.OP_CONNECT);

        //初始化字节缓冲流
        byteBuffer = ByteBuffer.allocate(1024);
        Charset charset = Charset.forName("GBK");
        decoder = charset.newDecoder();
        charBuffer = CharBuffer.allocate(1024);
        charsetEncoder = charset.newEncoder();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(ipAddress, port);
        //请求连接
        socketChannel.connect(inetSocketAddress);
        this.write();
    }
    public void write() throws IOException {
        while (true){
            int keys = selector.select();
            if (keys > 0){
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey selectionKey = it.next();
                    it.remove();
                    handelSelectorKeys(selectionKey);
                }
            }
        }
    }

    private void handelSelectorKeys(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if (selectionKey.isConnectable()){
            System.out.println("连接就绪...");
            try {
                if (socketChannel.isConnectionPending()){
                    socketChannel.finishConnect();
                }
                System.out.println("客户端，准备写入...");
                //客户端写入
                socketChannel.write(charsetEncoder.encode(charBuffer.wrap("你好")));
                //注册读事件
                socketChannel.register(selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (selectionKey.isReadable()){
            try {
                int readBuffer = socketChannel.read(byteBuffer);
                byteBuffer.clear();
                StringBuffer sb = new StringBuffer();
                while (readBuffer != -1){
                    while (byteBuffer.hasRemaining()){
                        sb.append(byteBuffer.array());
                    }
                }
                System.out.println("sb = " + sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
