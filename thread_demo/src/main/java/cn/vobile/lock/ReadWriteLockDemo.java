package cn.vobile.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: li_zhilei
 * @Date: create in 16:36 17/9/19.
 * @description:
 * 读写锁的例子
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
//        readLockNotMutex();
//        writeLockMutex();
//        readWriteMutex();
        lockDownTest();
//        upGradeLockTest();
    }


    /**
     *读锁不互斥
     *
     * Thread-0 read start...
     Thread-1 read start...
     Thread-2 read start...
     Thread-0 read end...
     Thread-1 read end...
     Thread-2 read end...
     */
    public static void readLockNotMutex(){
        ReadRunnable readRunnable = new ReadRunnable();
        //创建3个多线程，来说明读锁不互斥
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(readRunnable);
            thread.start();
        }
    }

    /**
     * 写锁互斥
     *
     *
     * Thread-0 write start...
     Thread-0 write end...
     Thread-1 write start...
     Thread-1 write end...
     Thread-2 write start...
     Thread-2 write end...
     */
    public static void writeLockMutex(){
        WriteRunnable writeRunnable = new WriteRunnable();
        //创建3个多线程，来说明读锁不互斥
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writeRunnable);
            thread.start();
        }
    }

    /**
     * 读锁与写锁互斥
     * 线程A执行writeMethod()方法，获取到写锁，
     * 此时线程B执行readMethod()方法，因为读写锁（写读锁）互斥，所以要等待线程A释放锁，然后才能继续执行
     *
     *打印结果如下:
     * Thread-0 当前为write Lock========
     Thread-0 write lock end ========
     Thread-0 程序结束 end
     Thread-1 当前为read Lock========
     Thread-1 read lock end ========
     Thread-1 程序结束 end
     */
    public static void readWriteMutex(){
        ReadAndWriteLock readAndWriteLock = new ReadAndWriteLock();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                readAndWriteLock.writeMethod();
            }
        });
        t.start();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                readAndWriteLock.readMethod();
            }
        });
        t1.start();
    }

    /**
     * 不支持升级锁，
     * 说明：从readLock到writeLock如果readLock没有释放锁，会进入死锁状态。
     */
    public static void upGradeLockTest(){
        new LockDowngrade().upGradeLock();
    }
    /**
     * 锁降级
     * 程序先获取写锁，再获取读锁，此时写锁会降级成读锁，并先释放该写锁，再释放读锁。
     *
     * main 当前进入写锁 write...
     main 当前进入读锁 read...
     main 释放读锁...
     main 释放写锁...
     main 程序结束...
     */
    public static void lockDownTest(){
        new LockDowngrade().downGradeLock();
    }

    static class ReadRunnable implements Runnable{

        final ReentrantReadWriteLock.ReadLock readLock = new ReentrantReadWriteLock().readLock();

        public void run() {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " read start...");
            try {
                Thread.sleep(100);
//                readLock.newCondition();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + " read end...");
                readLock.unlock();
            }
        }
    }

    static class WriteRunnable implements Runnable{

        final ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();

        public void run() {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " write start...");
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + " write end...");
                writeLock.unlock();
            }
        }
    }
    static class ReadAndWriteLock{
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

        public void writeMethod(){
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " 当前为write Lock========");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + " write lock end ========");
                writeLock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " 程序结束 end");
        }

        public void readMethod(){
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " 当前为read Lock========");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + " read lock end ========");
                readLock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " 程序结束 end");
        }
    }

    static class LockDowngrade{
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

        /**
         * 锁降级，遵从线程获取写锁，再获取读锁，释放写锁，再释放读锁。此时，写锁降级为读锁。
         */
        public void downGradeLock(){
            writeLock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + " 当前进入写锁 write...");
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + " 当前进入读锁 read...");
            } finally {
                System.out.println(Thread.currentThread().getName() + " 释放读锁...");
                readLock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放写锁...");
                writeLock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " 程序结束...");
        }

        public void upGradeLock(){
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " 当前进入写锁 read...");
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " 当前进入写锁 write...");
            writeLock.unlock();
            System.out.println("程序结束....");
        }
    }
}
