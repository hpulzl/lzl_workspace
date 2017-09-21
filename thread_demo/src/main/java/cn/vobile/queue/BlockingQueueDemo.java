package cn.vobile.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: li_zhilei
 * @Date: create in 09:47 17/9/20.
 * @description:
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        putAndRemoveQueueTest();
    }

    /**
     * add方法和put方法
     * 都是向队列中添加元素，add方法如果添加的元素超出容器的大小，会抛出throw new IllegalStateException("Queue full");
     *                  put方法如果超出容器大小，会一直等待，知道有元素移出才会添加新的元素。
     * @throws InterruptedException
     */
    public static void blockingQueueTest() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(20);
        for (int i = 0; i < 30; i++) {
            blockingQueue.add("向阻塞队列中添加：" + i + " 个元素");
            System.out.println("向阻塞队列中添加：" + i + " 个元素");
//            blockingQueue.put("向阻塞队列中添加：" + i + " 个元素");
        }
        System.out.println("添加队列结束 = " + blockingQueue.size());
     }

     public static void putAndRemoveQueueTest(){
        final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(20);
         PutAndRemoveQueueRunnable putAndRemoveQueueRunnable = new PutAndRemoveQueueRunnable(blockingQueue);
        Thread thread = new Thread(putAndRemoveQueueRunnable);
         thread.start();
     }

    static class PutAndRemoveQueueRunnable implements Runnable{
        BlockingQueue<String> blockingQueue;
        public PutAndRemoveQueueRunnable(BlockingQueue<String> blockingQueue){
            this.blockingQueue = blockingQueue;
        }

        public void run() {
            //一直进行put元素的操作
            int i = 1;
            while(i < 30){
                int count = putItem(i);
                if (count >= blockingQueue.size()){
                    System.out.println("blockingQueue remove before size is " + blockingQueue.size());
                    removeItem();
                    System.out.println("blockingQueue remove after size is " + blockingQueue.size());
                }
                i++;
            }
            System.out.println("programming end...");
        }
        private int putItem(int i){
            try {
                blockingQueue.put("向阻塞队列中添加元素：" + i);
                System.out.println("向阻塞队列中添加元素：" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return blockingQueue.size();
        }

        private void removeItem(){
            //一次性put10条元素
            try {
                System.out.println("移除-->" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
