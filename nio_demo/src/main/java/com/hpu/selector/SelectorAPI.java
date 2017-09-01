package com.hpu.selector;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: li_zhilei
 * @Date: create in 16:59 17/8/27.
 * @description:
 */
public class SelectorAPI {

    public static void main(String[] args) throws IOException {

        //op_read | op_write
       // interestTest(registerChannel());
        readyTest(registerChannel());

    }
    public static final SelectionKey registerChannel() throws IOException {
        //创建selector
        Selector selector = Selector.open();
        //向selector注册channel
        SocketChannel channel = SocketChannel.open();
//        channel.configureBlocking(false);
        //OP_READ 读就绪 OP_WRITE 写就绪 OP_CONNECT 连接就绪 OP_ACCEPT 接收就绪
        //通过 Selector 监听 Channel 时对什么事件感兴趣
        SelectionKey selectionKey = channel.register(selector,SelectionKey.OP_CONNECT);

        System.out.println("selectionKey = " + selectionKey);

        //获取selectorSets
        Set selectorSets = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectorSets.iterator();
        //就绪状态
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            if (key.isReadable()){
                System.out.println("is readable");
            }else if (key.isWritable()){
                System.out.println(" is writable" );
            }else if (key.isAcceptable()){
                System.out.println(" is Acceptable" );
            }else if (key.isConnectable()){
                System.out.println(" is Connectable" );
            }
        }
        return selectionKey;
    }

    //定义selector监听的事件
    public static void interestTest(SelectionKey selectionKey){

        int interestSet = selectionKey.interestOps();
        System.out.println("interestSet = " + interestSet);

        boolean interestSetInChannel = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;

        System.out.println("interestSetInChannel = " + interestSetInChannel);
    }

    //检测事件是否就绪
    public static void readyTest(SelectionKey selectionKey){
        int readyOps = selectionKey.readyOps();
        System.out.println("readyOps = " + readyOps);
        boolean isReadable = selectionKey.isReadable();
        System.out.println("isReadable = " + isReadable);
    }
}
