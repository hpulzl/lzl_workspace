package cn.vobile.basic.model;

/**
 * @Author: li_zhilei
 * @Date: create in 13:22 17/9/11.
 * @description: 主要介绍synchronized修饰的方法，以及所起到的作用
 */
public class SyncObject {

    private String aname;
    private String adescription;

    private static String aaaa = "aaaa";
    private static String bbbb = "bbbb";

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAdescription() {
        return adescription;
    }

    public void setAdescription(String adescription) {
        this.adescription = adescription;
    }

    /**
 * 需要去证明3件事情
 * 1. synchronize修饰静态方法，锁的类型是类级别锁。
 * 2. synchronize修饰非静态方法，锁的类型是对象级别锁。
 *
 * ===昨天已经证明
 * 3.
 *  3.1 类级别锁和对象级别锁是不同的，
 *  3.2 不同的锁之间没有阻塞作用
 */

    /**
     * 修饰静态方法，属于类级别锁，类似于SyncObject.class
     */
    public synchronized static void staticMethod(String name,String description){
        try {
            aaaa = name;
            Thread.sleep(2000);
            bbbb = description;
            //模拟耗时过程
            System.out.println("synchronized static method name " + aaaa + " description " + bbbb);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修饰非静态方法，属于对象锁，类似于this
     */
    public synchronized void method(String name,String description){
        try {
            //模拟耗时过程
            setAname(name);
            Thread.sleep(2000);
            setAdescription(description);
            System.out.println("当前对象 = " + this + " synchronized method name " + getAname() + " description " + getAdescription());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 修饰代码块，可以设置代码块锁的类型--（类级别锁和对象级别锁）
     */
    public void methodToBlock(){
        Object o = new Object();
        synchronized (o){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " synchronized Block method AAAA " + o);
            synchronized (Object.class){
                System.out.println(Thread.currentThread().getName() + " synchronized Block method BBBB " + o);
            }
        }
        System.out.println(Thread.currentThread().getName() + "非锁代码块的输出...");
    }

    public static void main(String[] args) {
        for (int i=0;i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    new SyncObject().methodToBlock();
                }
            });
            thread.start();
        }
    }
}
