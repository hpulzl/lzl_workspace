package cn.vobile.basic;

import cn.vobile.basic.model.SyncObject;

/**
 * @Author: li_zhilei
 * @Date: create in 09:43 17/9/12.
 * @description:
 * synchronized 锁的一些总结
 */
public class SyncThreadDemo2 {

    public static void main(String[] args) {
        //staticMethodTest();
        methodTest();
    }

    /**
     * 预期结果：打印的name和dec数据不会乱。对象持有的都是类级别的锁，不同线程之间有互斥锁的现象。
     * 实际结果：按顺序输出
     *
     */
    public static void staticMethodTest(){
        MyRunnableToStatic myRunnableToStatic = new MyRunnableToStatic();
        for (int i=0;i < 10; i++){
            Thread thread = new Thread(myRunnableToStatic);
            thread.start();
        }
    }

    /**
     * 预期结果：输出的对象hashcode不一致，说明synchronized修改非静态方法，使用的锁是对象级别的锁
     * 实际结果：按顺序输出
     */
    public static void methodTest(){
        MyRunnable myRunnable = new MyRunnable();
        for (int i=0;i < 10; i++){
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }
    static class MyRunnableToStatic implements Runnable{
        public MyRunnableToStatic(){

        }
        public void run() {
            //调用静态方法，对象的实例不会改变。及内存中不会创建新的对象
            for (int i = 0; i < 10; i++) {
                SyncObject.staticMethod("name " + i, "desc " + i);
            }
        }
    }

    static class MyRunnable implements Runnable{
        public MyRunnable(){

        }
        public void run() {
            SyncObject syncObject = new SyncObject();
            //调用非静态方法
            for (int i = 0; i < 10; i++) {
                syncObject.method("name" + i, "desc" + i);
            }
        }
    }
}
