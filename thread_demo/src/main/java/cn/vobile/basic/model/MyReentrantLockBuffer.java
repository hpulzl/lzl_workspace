package cn.vobile.basic.model;



import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: li_zhilei
 * @Date: create in 16:49 17/9/14.
 * @description:
 * 用Lock来修饰
 */
public class MyReentrantLockBuffer {

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void read(){
        reentrantLock.lock();
        try {
            long start = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " 进行读操作...");
            //模拟十分耗时的读操作
            while (true){
                if (System.currentTimeMillis() % 10000 == 3){
                    System.out.println("start = " + start);
                }
                if (System.currentTimeMillis() - start >= Integer.MAX_VALUE){
                    break;
                }
            }
        } finally {
           reentrantLock.unlock();
        }
    }

    public synchronized void write() throws InterruptedException {
        //允许中断锁
        reentrantLock.lockInterruptibly();
        System.out.println(Thread.currentThread().getName() + " 进行写操作...");

    }
}
