package cn.vobile.basic;

/**
 * @Author: li_zhilei
 * @Date: create in 15:22 17/9/11.
 * @description:讲解Thread的三个interrupt方法，以及各自的作用。
 */
public class ThreeInterruptThread{

    public static void main(String[] args) {
        //千万不能连在一块进行测试。
        //多线程的终止方法是t.interrupt(),这个只是设置终止线程的标志位,并没有真正的终止线程。
        System.out.println("========AAAA-----interruptTest============ ");
        interruptTest();
        //静态的interrupted()方法，获取线程的当前是否中断的状态，并将其状态职位false
        System.out.println("========BBBB-----interruptedTest============ ");
       // interruptedTest();
        //isInterrupted()方法，获取线程的中断状态，不做任何操作。
        System.out.println("========CCCC-----isInterruptTest============ ");
       // isInterruptTest();
    }

    /**
     * 直接在main线程中执行也是一样的
     * 测试目的: 这个方法测试，interrupt()只是设置中断状态，并没有中断程序。
     * 预期结果：执行中断方法之后，还能继续执行下面的方法。说明程序没有中断
     * 真是结果：确实如此
     */
    public static void interruptTest(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "当前线程的状态--0："+thread.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(thread.getName() + "当前线程的状态--1："+thread.isInterrupted());
        System.out.println(thread.getName() + "当前线程的状态--2："+thread.isInterrupted());

    }

    /**
     * 直接在main线程中执行也是一样的
     * 测试目的: 这个方法测试，isInterrupted()只是获取当前线程的是否中断的状态，并不改变其状态的结果。
     * 预期结果：
     *  main当前线程的状态--0：false
        main当前线程的状态--1：true
        main当前线程的状态--2：true
     * 真是结果：确实如此
     *  main当前线程的状态--0：false
        main当前线程的状态--1：true
        main当前线程的状态--2：true
     */
    public static void isInterruptTest(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "当前线程的状态--0："+thread.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(thread.getName() + "当前线程的状态--1："+thread.isInterrupted());
        System.out.println(thread.getName() + "当前线程的状态--2："+thread.isInterrupted());

    }

    /**
     * 直接在main线程中执行也是一样的
     * 测试目的: 这个方法测试，isInterrupted()只是获取当前线程的是否中断的状态，并且改变其状态的结果。
     * 预期结果：
     *  main当前线程的状态--0：false
     main当前线程的状态--1：true
     main当前线程的状态--2：false
     * 真是结果：确实如此
     *  main当前线程的状态--0：false
     main当前线程的状态--1：true
     main当前线程的状态--2：false
     */
    public static void interruptedTest(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " 当前线程的状态--0："+Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(thread.getName() + " 当前线程的状态--1："+Thread.interrupted());
        System.out.println(thread.getName() + " 当前线程的状态--2："+Thread.interrupted());

    }
}
