package cn.vobile.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author: li_zhilei
 * @Date: create in 16:51 17/9/13.
 * @description:
 * 了解Executors提供创建线程池的方法
 *
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        //newCachedThreadPool();
//        newFixedThreadPool();
//        newSingleThreadExecutor();
//        newSchduleThreadExecutor();
    }

    /**
     *创建可缓存的线程池，如果没有可用的线程，会创建一个新的，并销毁超过60m没有重用的线程
     */
    public static void newCachedThreadPool(){
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }

    /**
     * 创建固定线程数的线程池
     */
    public static void newFixedThreadPool(){
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }

    /**
     * 创建一个单线程化的Executor。
     */
    public static void newSingleThreadExecutor(){
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }

    /**
     * 创建一个定时及周期性的任务执行线程池
     */
    public static void newSchduleThreadExecutor(){
        MyRunnable myRunnable = new MyRunnable();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }
    static class MyRunnable implements Runnable{

        public void run() {
            System.out.println(Thread.currentThread().getName() + " 被调用...");
        }
    }
}
