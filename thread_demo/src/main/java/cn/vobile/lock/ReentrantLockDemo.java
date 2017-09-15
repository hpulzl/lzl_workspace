package cn.vobile.lock;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: li_zhilei
 * @Date: create in 16:22 17/9/14.
 * @description:
 * 可重入锁
 */
public class ReentrantLockDemo {

    public static void main(String[] args) throws IOException {
        reentrantLockTest();
    }

    /**
     * 模拟可重入锁的创建和取消
     */
    public static void reentrantLockTest(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }

    static class MyRunnable implements Runnable{
       private final Lock lock = new ReentrantLock();

        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 进入锁 = " + lock);
            try{
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 执行内容... " + lock);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //保证释放锁
                System.out.println(Thread.currentThread().getName() + " 释放锁... " + lock);
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "thread end ");
        }
    }
}
