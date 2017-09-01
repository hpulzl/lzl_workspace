package com.hpu.channel;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @Author: li_zhilei
 * @Date: create in 15:06 17/8/27.
 * @description:通道
 */
public class FileChannelAPI {
    public static void main(String[] args) throws IOException {
        fileChannelRead();
        //fileChannelWrite();
    }

    //FileChannel 无法设置为非阻塞模式，它总是运行在阻塞模式下
    public static void fileChannelRead() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("/Users/vobile_lzl/HSS-0814.sql","rw");
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        int byteRead = fileChannel.read(byteBuffer);
        StringBuffer sb = new StringBuffer();
        while (byteRead != -1){

            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                decoder.decode(byteBuffer, charBuffer, false);
                //读之前要反转。
                charBuffer.flip();
                //获取读取的数据
                sb.append(charBuffer.array());
//                while (charBuffer.hasRemaining()){
//                    sb.append(charBuffer.get());
//                }
            }

            byteBuffer.clear();
            charBuffer.clear();
            // 保证写入到 FileChannel 里的数据一定会即时写到磁盘上，这里不必使用
//            fileChannel.force(true);
            byteRead = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
        System.out.println("sb.toString() = " + sb.toString());
    }

    public static void fileChannelWrite() throws IOException {
        String newData = "你好，我是李志磊";
        RandomAccessFile accessFile = new RandomAccessFile("/Users/vobile_lzl/HSS-0814.sql","rw");
        FileChannel fileChannel = accessFile.getChannel();
        //创建一个buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(newData.getBytes());
        //buffer反转
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            fileChannel.write(byteBuffer);
        }
        System.out.println(" write over !");
        fileChannel.close();
    }
}

