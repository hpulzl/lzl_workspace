package cn.vobile.basic;

/**
 * @Author: li_zhilei
 * @Date: create in 09:43 17/9/12.
 * @description:
 * synchronized 锁的一些总结
 */
public class SyncThreadDemo {

    public static void main(String[] args) {
        syncThreadTest();
    }
    public static void syncThreadTest(){
        for (int i=0; i < 10; i++){
            SyncThread syncThread = new SyncThread();
            syncThread.start();
        }
    }

    /**
     * 该例子说明 object锁和SyncThread.class作用的对象是不一样的。
     * 1. 访问同一个类的不同实例对象中的同步代码块，不存在阻塞等待获取对象锁的问题，因为它们获取的是各自实例的对象级别锁，相互之间没有影响。
     * object作用于当前对象
     * class作用于所有创建SyncThread的地方
     */
    static class SyncThread extends Thread{
        private static Object blockerLock = new Object();
        public SyncThread(){

        }
        @Override
        public void run() {
            synchronized (blockerLock){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 当前等待的线程object " + blockerLock);
                synchronized (SyncThread.class){
                    System.out.println(Thread.currentThread().getName() + " 当前等待的线程 " + SyncThread.class);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 当前锁 SyncThread.class= " + SyncThread.class);
                }
                System.out.println(Thread.currentThread().getName() + "over = ");
            }
        }
    }
}
