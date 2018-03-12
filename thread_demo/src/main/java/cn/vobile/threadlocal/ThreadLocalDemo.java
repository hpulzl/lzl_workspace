package cn.vobile.threadlocal;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: li_zhilei
 * @Date: create in 11:07 17/9/28.
 * @description:线程局部变量
 * ThreadLocal提供了set()、get()、remove()方法
 *
 */
public class ThreadLocalDemo {
    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    private static final InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        hashOpenAddress();
    }

    public static void threadLocalDemo(){
        //main thread set threadLocal
        stringThreadLocal.set("hello");
        stringThreadLocal.set("aaaaa");
        stringThreadLocal.set("bbbbb");
        System.out.println(Thread.currentThread().getName()+" get " + stringThreadLocal.get());
        //t1 thread set threadLocal
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("hhhh");
                System.out.println(Thread.currentThread().getName()+" get " + stringThreadLocal.get());
            }
        });
        t1.start();
    }


    /**
     * 一个有趣的hash散列值算法
     * 0-32散列不重复
     */
    public static void hashOpenAddress(){
        AtomicInteger atomicInteger = new AtomicInteger();
        int hash = 0x61c88647;
        int size = 32;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++){
            //每次累加0x61c88647
            int add  = atomicInteger.getAndAdd(hash);
            System.out.println("add = " + add);
            list.add(add & (size -1 ));
        }
        System.out.println("list = " + list);
    }
}
