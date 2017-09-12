package cn.vobile.basic;



/**
 * @Author: li_zhilei
 * @Date: create in 14:10 17/9/11.
 * @description:终止线程的demo
 */
public class InterruptThread {
    public static void main(String[] args) {
        //isInterruptedTest();
        //interruptedTest();
        //interruptedThreadMethod1();
        interruptedThreadMethod2();
    }

    public static void isInterruptedTest(){
        InterruptThreadt interruptThreadt = new InterruptThread().new InterruptThreadt();
        interruptThreadt.start();
        //主线程睡2m，让子线程有执行的机会
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--0：" + interruptThreadt.isInterrupted());
        //终止线程
        interruptThreadt.interrupt();
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--1：" + interruptThreadt.isInterrupted());
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--2：" + interruptThreadt.isInterrupted());
    }

    //静态的interrupted(),必须用Thread.currentThread().interrupt()方式中断线程，才能获取终端的状态。
    public static void interruptedTest(){
        InterruptThreadt interruptThreadt = new InterruptThread().new InterruptThreadt();
        interruptThreadt.start();
        //主线程睡2m，让子线程有执行的机会
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--0：" + Thread.currentThread().interrupted());
        //终止线程
        Thread.currentThread().interrupt();
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--1：" + Thread.currentThread().interrupted());
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--2：" + Thread.currentThread().interrupted());
    }

    /**
     * 中断线程执行的方法一
     */
    public static void interruptedThreadMethod1(){
        InterruptThreadt interruptThreadt = new InterruptThread().new InterruptThreadt();
        interruptThreadt.start();
        //主线程睡2m，让子线程有执行的机会
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--0：" + interruptThreadt.isInterrupted());
        //终止线程
        interruptThreadt.interrupt();
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--1：" + interruptThreadt.isInterrupted());
        System.out.println(interruptThreadt.getName() + " 当前线程的状态--2：" + interruptThreadt.isInterrupted());
    }

    /**
     * 中断线程执行的方法二
     */
    public static void interruptedThreadMethod2(){
        InterruptThreadtx interruptThreadtx = new InterruptThread().new InterruptThreadtx();
        interruptThreadtx.start();
        //主线程睡2m，让子线程有执行的机会
        System.out.println(interruptThreadtx.getName() + " 当前线程的状态--0：" + interruptThreadtx.isInterrupted());
        //终止线程
        interruptThreadtx.interrupt();
        System.out.println(interruptThreadtx.getName() + " 当前线程的状态--1：" + interruptThreadtx.isInterrupted());
        System.out.println(interruptThreadtx.getName() + " 当前线程的状态--2：" + interruptThreadtx.isInterrupted());
    }
    /**
     * 中断线程的执行方法一
     * interrupt()+sleep()+return;
     */
    class InterruptThreadt extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i=0; i < 100; i++){
                System.out.println("i = " + i);
            }
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " thread not interrupted ");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " thread was interrupted ");
                e.printStackTrace();
                //中断线程 interrupt()方法，线程还可以继续执行，所以需要在catch中使用return。
                return;
            }
            System.out.println("线程中断了，还是执行了...");
        }
    }

    /**
     * interrupt+isInterrupted+return
     */
    class InterruptThreadtx extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i=0; i < 100; i++){
                System.out.println("i = " + i);
            }
            System.out.println(Thread.currentThread().getName() + " thread not interrupted ");
            if (this.isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " thread was interrupted ");
                return;
            }
            System.out.println("线程中断了，还是执行了...");
        }
    }
}
