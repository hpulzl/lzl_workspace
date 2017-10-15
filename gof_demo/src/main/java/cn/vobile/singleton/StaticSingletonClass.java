package cn.vobile.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: li_zhilei
 * @Date: create in 10:33 17/10/15.
 * @description:
 */
public class StaticSingletonClass {
    private static CountDownLatch countDownLatch = null;
    private static final StaticSingletonClass uniqueClass = new StaticSingletonClass();

    private StaticSingletonClass(){}
    //这个类说明第一种创建方式
    public static StaticSingletonClass getInstance(){
        return uniqueClass;
    }

    public static void statisticStatic(int count) {
        countDownLatch = new CountDownLatch(count);
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
        long end = System.currentTimeMillis();
        try {
            //程序计数器，阻塞主线程执行，所有子线程执行完，才会往下执行。
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static use time is :" + (end - start));
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            StaticSingletonClass unsafeSingletonClass = StaticSingletonClass.getInstance();
//            System.out.println(Thread.currentThread().getName() + " unsafeSingletonClass = " + unsafeSingletonClass);
            //程序计数器，多线程执行完之后，需要执行该方法。
            countDownLatch.countDown();
        }
    }
}
