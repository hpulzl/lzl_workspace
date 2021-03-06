package cn.vobile.basic;

import cn.vobile.basic.model.MySyncBuffer;

/**
 * @Author: li_zhilei
 * @Date: create in 16:54 17/9/14.
 * @description:
 * 中断锁，比较ReentrantLock与synchronized的区别
 */
public class SyncInterruptDemo {

    public static void main(String[] args) {
        syncReaderWriterTest();
    }

    /**
     * 设计两个线程，一个read线程，一个write线程。
     * 当read线程正在read的时候，write线程处于等待状态、
     * 然后中断write线程，看会有什么情况发生
     *
     * 正常情况下，如果write中断，会打印 write end...
     * 但是因为synchronized没有对中断锁做出响应，所以不会打印这个数据
     */
    public static void syncReaderWriterTest(){
        MySyncBuffer mySyncBuffer = new MySyncBuffer();
        final Thread reader = new Thread(new SyncReader(mySyncBuffer));
        final Thread writer = new Thread(new SyncWriter(mySyncBuffer));
        reader.start();
        writer.start();

        System.out.println(Thread.currentThread().getName() +  " writer 不在等待了...");
        writer.interrupt();
        System.out.println(Thread.currentThread().getName() +  " writer 已经中断, " + writer.isInterrupted());
    }

    /**
     * 写操作,传入MySyncBuffer的构造方法，保证两个对象持有相同的对象锁
     */
    static class SyncWriter implements Runnable{

        private MySyncBuffer mySyncBuffer;

        public SyncWriter(MySyncBuffer mySyncBuffer){
            this.mySyncBuffer = mySyncBuffer;
        }
        public void run() {
//            if (Thread.currentThread().isInterrupted()){
//                System.out.println(Thread.currentThread().getName() + " write end.");
//                return;
//            }
            mySyncBuffer.write();
            System.out.println(Thread.currentThread().getName() + " write end.");
        }
    }

    /**
     * 写操作,传入MySyncBuffer的构造方法，保证两个对象持有相同的对象锁
     */
    static class SyncReader implements Runnable{

        private MySyncBuffer mySyncBuffer;

        public SyncReader(MySyncBuffer mySyncBuffer){
            this.mySyncBuffer = mySyncBuffer;
        }
        public void run() {

            mySyncBuffer.read();

        }
    }

}
