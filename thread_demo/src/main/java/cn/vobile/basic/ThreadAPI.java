package cn.vobile.basic;

/**
 * @Author: li_zhilei
 * @Date: create in 10:54 17/9/11.
 * @description:
 */
public class ThreadAPI {
    public static void main(String[] args) {
        Thread thread = new ThreadAPI().new MyThread();
        thread.start();
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("thread name " + Thread.currentThread().getName());
        }
    }
}
