package cn.vobile.basic.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: li_zhilei
 * @Date: create in 13:24 17/9/13.
 * @description:
 * 用concurrent包中的数据写一个生产者消费者的方法
 */
public class SignalResource {

    //定义资源数量
    private int resourceCount = 1;
    //定义当前状态，false 生产状态；true 消费状态
    private boolean status = false;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**

     * 生产方法
     */
    public void product(){
        lock.lock();
        try {
            while (status){ //消费状态的话，就等待
                System.out.println(Thread.currentThread().getName() + " 生产者等待唤醒...");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            resourceCount++;
            System.out.println(Thread.currentThread().getName() + " 生产者生产产品 " + resourceCount);
            //唤醒等待线程
            condition.signalAll();
            //允许消费者消费
            status = true;
            System.out.println(Thread.currentThread().getName() + " 生产者生产结束... ");
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费方法
     */
    public void consume(){
        lock.lock();

        try {
            while (status == false){ //生产状态的话，就等待
                System.out.println(Thread.currentThread().getName() + " 消费者等待唤醒...");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            resourceCount--;
            System.out.println(Thread.currentThread().getName() + " 消费者消费产品，当前剩余量 " + resourceCount);
            //唤醒等待线程
            condition.signalAll();
            //允许生产者生产
            status = false;
            System.out.println(Thread.currentThread().getName() + " 消费者消费结束... ");
        } finally {
            lock.unlock();
        }
    }

    /**
     * 生产者多线程类
     */
    static class Productor implements Runnable{
        private SignalResource produceWorker;
        public Productor(SignalResource resource){
            produceWorker = resource;
        }
        public void run() {
            for (int i = 0; i < 10; i++) {
                produceWorker.setStatus(false);
                produceWorker.product();
            }
        }
    }

    static class Consumer implements Runnable{
        private SignalResource consumeWorker;

        public Consumer(SignalResource resource){
            consumeWorker = resource;
        }
        public void run() {
            for (int i = 0; i < 10; i++) {
                consumeWorker.setStatus(true);
                consumeWorker.consume();
            }
        }
    }

    public static void main(String[] args) {
        SignalResource resource = new SignalResource();
        //创建10个生产者
        Productor productor = new Productor(resource);
        Thread thread = new Thread(productor);
        thread.start();

        //创建10个消费者
        Consumer consumer = new Consumer(resource);
        Thread thread1 = new Thread(consumer);
        thread1.start();
    }
}
