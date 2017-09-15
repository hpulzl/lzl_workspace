package cn.vobile.basic.model;

/**
 * @Author: li_zhilei
 * @Date: create in 13:24 17/9/13.
 * @description:
 * 资源类类定义生产者消费者的方法
 */
public class Resource {

    //定义资源数量
    private int resourceCount = 1;
    //定义当前状态，false 生产状态；true 消费状态
    private boolean status = false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**

     * 生产方法
     */
    public synchronized void product(){
        while (status){ //消费状态的话，就等待
            System.out.println(Thread.currentThread().getName() + " 生产者等待唤醒...");
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resourceCount++;
        System.out.println(Thread.currentThread().getName() + " 生产者生产产品 " + resourceCount);
        //唤醒等待线程
        super.notifyAll();
        //允许消费者消费
        status = true;
        System.out.println(Thread.currentThread().getName() + " 生产者生产结束... ");
    }

    /**
     * 消费方法
     */
    public synchronized void consume(){
        while (status == false){ //生产状态的话，就等待
            System.out.println(Thread.currentThread().getName() + " 消费者等待唤醒...");
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resourceCount--;
        System.out.println(Thread.currentThread().getName() + " 消费者消费产品，当前剩余量 " + resourceCount);
        //唤醒等待线程
        super.notifyAll();
        //允许生产者生产
        status = false;
        System.out.println(Thread.currentThread().getName() + " 消费者消费结束... ");
    }

    /**
     * 生产者多线程类
     */
    static class Productor implements Runnable{
        private Resource produceWorker;
        public Productor(Resource resource){
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
        private Resource consumeWorker;

        public Consumer(Resource resource){
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
        Resource resource = new Resource();
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
