package com.hpu.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;

/**
 * @Author: li_zhilei
 * @Date: create in 13:53 17/8/30.
 * @description:socket服务端
 */
public class NioServerSocket {
    private Selector selector;
    private ByteBuffer byteBuffer;
    private CharsetDecoder decoder;
    private CharBuffer charBuffer;
    public NioServerSocket(){
    }
    public void listenDefault() throws IOException {
        listen(9999);
    }
    public void listen(int port) throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定监听端口
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //注册接入事件
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        //初始化字节缓冲流
        byteBuffer = ByteBuffer.allocate(1024);
        Charset charset = Charset.forName("GBK");
        decoder = charset.newDecoder();
        charBuffer = CharBuffer.allocate(1024);

        while (true){
            int keys = selector.select();
            if (keys > 0){
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey selectionKey = it.next();
                    it.remove();
                    //
                    handleSelectionKey(selectionKey);
                }
            }
        }
    }

    private void handleSelectionKey(SelectionKey selectionKey) {
        //serverSocketChannel支持accept、read、write是那种key
        Channel channel = selectionKey.channel();
        if (selectionKey.isAcceptable()){
            //接受就绪
            handleAccept(channel);
        }else if (selectionKey.isReadable()){
            //读就绪
            handleRead(channel);
        }else if (selectionKey.isWritable()){
            //写就绪
            handleWrite(channel);
        }
    }

    private void handleAccept(Channel channel) {
        try {
            SocketChannel socketChannel = ((ServerSocketChannel)channel).accept();
            if (socketChannel != null){
                System.out.println("服务端，监听地址 = " + socketChannel.getLocalAddress());
                socketChannel.configureBlocking(false);
                //接收到客户端后，为其注册读事件
                socketChannel.register(selector,SelectionKey.OP_READ);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleWrite(Channel channel) {

    }

    private void handleRead(Channel channel) {
        try {
            System.out.println("服务端，正在读取数据...");
            SocketChannel socketChannel = ((SocketChannel)channel);
            int byteRead = socketChannel.read(byteBuffer);
//            byteBuffer.clear();
            StringBuffer sb = new StringBuffer();
            if (byteRead == -1){
                socketChannel.close();
                return;
            }
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                charBuffer = decoder.decode(byteBuffer);
                sb.append(charBuffer.array());
            }
            System.out.println("sb.to = " + sb.toString());
            System.out.println("服务端，读结束...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
