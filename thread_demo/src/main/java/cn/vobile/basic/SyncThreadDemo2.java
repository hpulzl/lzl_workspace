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
     synchronized static method name name0 description dec0
     synchronized static method name name9 description dec9
     synchronized static method name name8 description dec8
     synchronized static method name name7 description dec7
     synchronized static method name name6 description dec6
     synchronized static method name name5 description dec5
     synchronized static method name name4 description dec4
     synchronized static method name name3 description dec3
     synchronized static method name name2 description dec2
     synchronized static method name name1 description dec1
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
