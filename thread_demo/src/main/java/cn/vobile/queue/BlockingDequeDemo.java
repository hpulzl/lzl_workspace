package cn.vobile.queue;

import java.util.concurrent.*;

/**
 * @Author: li_zhilei
 * @Date: create in 09:47 17/9/20.
 * @description:阻塞栈实例
 */
public class BlockingDequeDemo {

    public static void main(String[] args) {
//        blockDequeTest();
        PutAndRemoveDequeTest();
    }

    public static void blockDequeTest(){
       BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>(20);
        for (int i = 0; i < 30; i++) {
            try {
                //相当于 putLast()
                blockingDeque.put("栈内元素：" + i);
                System.out.println("向阻塞栈中添加元素:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序执行结束...");
    }

    /**
     * 阻塞栈
     * 调用put()
     * take()的方法
     */
    public static void PutAndRemoveDequeTest(){
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(20);
        Thread t = new Thread(new PutAndRemoveDequeRunnable(blockingDeque));
        t.start();
    }
    static class PutAndRemoveDequeRunnable implements Runnable{
        BlockingDeque<String> blockingDeque;
        public PutAndRemoveDequeRunnable(BlockingDeque<String> blockingDeque){
            this.blockingDeque = blockingDeque;
        }

        public void run() {
            //一直进行put元素的操作
            int i = 1;
            while(i < 30){
                int count = putItem(i);
                if (count >= 15){
                    while(removeItem() > 0){
                        System.out.println("blockingDeque remove before size is " + blockingDeque.size());
                        removeItem();
                        System.out.println("blockingDeque remove after size is " + blockingDeque.size());
                    }
                }
                i++;
            }
            System.out.println("programming end...");
        }
        private int putItem(int i){
            try {
                blockingDeque.put("向阻塞栈中添加元素：" + i);
                System.out.println("向阻塞栈中添加元素：" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return blockingDeque.size();
        }

        private int removeItem(){
            //一次性put10条元素
            try {
                System.out.println("移除-->" + blockingDeque.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return blockingDeque.size();
        }
    }
}
