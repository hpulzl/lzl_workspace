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
//        reentrantLockTest();
//        reentrantTest();
        reentrantTest2();
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

    /**
     * 可重入性的测试
     */
    public static void reentrantTest(){
        ReentrantDemoRunnable reentrantDemoRunnable = new ReentrantDemoRunnable(false);
        Thread thread = new Thread(reentrantDemoRunnable);
        thread.start();

        reentrantDemoRunnable.setFlag(true);
        Thread thread1 = new Thread(reentrantDemoRunnable);

        thread1.start();
    }

    public static void reentrantTest2(){
        SubClass subClass = new SubClass();
        subClass.method();
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

    static class ReentrantDemoRunnable implements Runnable{
        final ReentrantLock reentrantLock = new ReentrantLock();
        private boolean flag = false;

        public ReentrantDemoRunnable(boolean flag){
            this.flag = flag;
        }

        public synchronized boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            System.out.println("flag = " + flag);
            if (flag){
                this.methodA();
            }else {
                this.methodB();
            }
        }

        public void methodA() {
            System.out.println(" lock before methodAAAAAA ========" );
            reentrantLock.lock();

            try {
                System.out.println(" run methodA and lock..." );
                Thread.sleep(1000);
                this.methodB();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println(" run methodA end unlock..." );
                reentrantLock.unlock();
            }
            System.out.println(" methodAAAAAA ======== end =====" );
        }

        public void methodB() {
            System.out.println(" lock before methodBBBBBB ========" );
            ReentrantLock l = new ReentrantLock();
                    l.lock();

            try {
                System.out.println(" run methodB and lock..." );

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println(" run methodB end unlock..." );
                l.unlock();
            }
            System.out.println(" methodBBBBBB ======== end =====" );
        }
    }

    static class Father{
        final ReentrantLock lock = new ReentrantLock();
        public void method(){
            lock.lock();
            try {
                System.out.println("father do something ");
            } finally {
                lock.unlock();
            }
        }
    }

    static class SubClass extends Father{

        @Override
        public void method(){
            lock.lock();
            try {
                System.out.println("subClass do something ");
                super.method();
            } finally {
                lock.unlock();
            }
        }
    }
}
