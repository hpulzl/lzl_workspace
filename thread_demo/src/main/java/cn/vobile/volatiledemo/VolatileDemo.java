package cn.vobile.volatiledemo;

/**
 * @Author: li_zhilei
 * @Date: create in 15:39 17/9/27.
 * @description:
 * 参考http://www.cnblogs.com/dolphin0520/p/3920373.html博客
 * 线程安全的程序具有一下特性
 * 1. 原子性
 *    也就是数据一致性的操作，对数据进行更新操作，要么成功数据得到更新；要么失败数据不更新。
 * 2. 有序性
     * * 有序性的理解，不是单纯的代码执行的顺序。在jvm中存在重排序的概念，重排序是在不影响操作结果的情况下，对程序顺序重新排列。
     * 例如
     * int x = 0  //序号1
     * int b = 2  //序号2
     * int c = x + b //序号3
     * System.out.println(c) //序号4
     * 正常我们以为的执行流程1-->2-->3-->4
     * 我们可以知道c的结果为2，那么jvm在不影响结果的情况下，执行顺序可能是2-->1-->3-->4。换句话说，如果两个类间没有数据依赖，
     * jvm就可以根据性能来进行优化重排序执行顺序。
 * 3. 可见性
 *    多线程操作中，线程A对改变数据X，那么线程B读取的X应该是线程A改变后的值。

 * 再次刷新对volatile的理解
 * volatile具有的特性
 * 1. 保证程序的可见性
 * 2. 保证程序的有序性（特殊）
 *    可以这样理解，如果某字段volatile修饰例如A，那么程序在顺序执行的时候，遇到A，jvm会保证A之前的程序都执行完毕。
 *    然后才会往下执行。入
 *
 * 3. 不保证程序的原子性
 */
public class VolatileDemo{

    public int volCount = 0;
    public volatile int incVolCount = 0;

    public static void main(String[] args) {
        volatileNoAtomic();
//        syncAtomic();
    }
    public static void syncAtomic(){
        VolatileDemo volatileDemo = new VolatileDemo();
        SyncRunnable myRunnable = new SyncRunnable(volatileDemo);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }
    /**
     * 验证volatile的非原子性
     */
    public static void volatileNoAtomic(){
        VolatileDemo volatileDemo = new VolatileDemo();
        VolatileRunnable myRunnable = new VolatileRunnable(volatileDemo);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }

    /**
     * 加锁的自增方法
     * synchronized具有原子性、可见性、有序性
     */
    public synchronized void incSynchronizedVolCount(){
        volCount++;
        System.out.println(Thread.currentThread().getName() + " incSynchronizedVolCount = " + volCount);
    }

    /**
     * 使用volatile字段修饰的自增方法
     * volatile不具有原子性
     * 过程叙述：
     * 当incVolCount进行自增虚拟机需要进行如下操作
     * 1. 取出local的incVolCount值
     * 2. 进行加1操作
     * 3. 将incVolCount写回到local。
     * 这三个步骤是线程不安全的，所以不能保证数据原子性。
     */
    public void incVolCount(){
        incVolCount++;
        System.out.println(Thread.currentThread().getName() + " volCount = " + incVolCount);
    }

    static class VolatileRunnable implements Runnable{
        VolatileDemo volatileDemo = null;

        public VolatileRunnable(VolatileDemo volatileDemo){
            this.volatileDemo = volatileDemo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
               volatileDemo.incVolCount();
            }
            System.out.println(Thread.currentThread().getName() + " volCount = " + volatileDemo.volCount);
        }
    }

    static class SyncRunnable implements Runnable{
        VolatileDemo volatileDemo = null;

        public SyncRunnable(VolatileDemo volatileDemo){
            this.volatileDemo = volatileDemo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                volatileDemo.incSynchronizedVolCount();
            }
            System.out.println(Thread.currentThread().getName() + " incSynchronizedVolCount = " + volatileDemo.volCount);
        }
    }
}