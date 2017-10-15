package cn.vobile.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: li_zhilei
 * @Date: create in 10:07 17/10/15.
 * @description:主要介绍单例模式的三种线程安全性的创建方式
 * 以及它们使用的场景
 * 1. 加synchronized锁
 * 2. 静态的全局变量创建对象（急切模式也就是饿汉模式）
 * 3. 双重验证的单例模式
 *
 * Step1: 先来看一下线程不安全的单例模式吧
 */
public class DoubleSingletonClass {
    private static CountDownLatch countDownLatch = null;
    //用volatile修饰，保证变量多线程中可见性
    private static volatile DoubleSingletonClass uniqueClass = null;

    private DoubleSingletonClass(){}
    //这个类说明第一种创建方式
    public static DoubleSingletonClass getInstance(){
        if (uniqueClass == null){
            //模拟耗时操作
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DoubleSingletonClass.class){
                if (uniqueClass == null){
                    uniqueClass = new DoubleSingletonClass();
                }
            }
        }
        return uniqueClass;
    }

    public static void statisticDouble(int count) {
        countDownLatch = new CountDownLatch(count);
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
        long end = System.currentTimeMillis();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("double use time is :" + (end - start));
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            DoubleSingletonClass unsafeSingletonClass = DoubleSingletonClass.getInstance();
//            System.out.println(Thread.currentThread().getName() + " unsafeSingletonClass = " + unsafeSingletonClass);
            countDownLatch.countDown();
        }
    }
}
