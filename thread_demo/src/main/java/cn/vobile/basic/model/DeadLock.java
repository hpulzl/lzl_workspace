package cn.vobile.basic.model;

/**
 * @Author: li_zhilei
 * @Date: create in 14:44 17/9/12.
 * @description:
 * 死锁展示类
 */
public class DeadLock {
    private String did;
    public DeadLock(String did){
        this.did = did;
    }
    public synchronized void eat(DeadLock deadLock){
        System.out.println(this.toString() + " 当前对象 " + Thread.currentThread().getName() + " 排队吃饭");
        try {
            Thread.sleep(1000);
            System.out.println(this.toString() + " 当前对象 " + Thread.currentThread().getName() + " 模拟吃饭过程....");
            deadLock.toWc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void toWc(){
        System.out.println(this.toString() + " 当前对象 " + Thread.currentThread().getName() + " 排队上厕所");
        try {
            Thread.sleep(1000);
            System.out.println(this.toString() + " 当前对象 " + Thread.currentThread().getName() + " 模拟上厕所过程....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return did;
    }

    public static void main(String[] args) {
        final DeadLock deadLock1 = new DeadLock("LockA");
        final DeadLock deadLock2 = new DeadLock("LockB");

        Runnable runnableA = new Runnable() {
            public void run() {
                deadLock1.eat(deadLock2);
            }
        };

        Thread t1 = new Thread(runnableA, "runA");
        t1.start();

        Runnable runnableB = new Runnable() {
            public void run() {
                deadLock2.eat(deadLock1);
            }
        };

        Thread t2 = new Thread(runnableB, "runB");
        t2.start();
    }
}
