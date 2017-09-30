package cn.vobile.volatiledemo;

/**
 * @Author: li_zhilei
 * @Date: create in 17:40 17/9/27.
 * @description:
 * volatile的有序性验证。
 */
public class VolatileOrderDemo {

    public static void main(String[] args) {
        noOrder();
//        volatileOrder();
    }

    /**
     * 写一个没有volatile修饰的例子，
     * 证明开始是程序开始并没有volatile的特性。
     * 没有volatile修饰的boolean类型，可能会导致多次运行结果不一致。
     */
    public static void noOrder(){

        VolatileModel volatileModel = new VolatileModel();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "在执行....");
                volatileModel.setEat();
                //吃完饭设为true
                volatileModel.isEat = true;
            }
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "在执行....");
                //如果吃过饭，就睡觉了
               if (volatileModel.isEat){
                   volatileModel.sleep(volatileModel.isEat);
               }
               //并打印出eat的值
                System.out.println("thread = " + volatileModel.getEat());
            }
        });
        thread2.start();
    }

    /**
     *
     */
    public static void volatileOrder(){

        VolatileModel volatileModel = new VolatileModel();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "在执行....");
                volatileModel.setEat();
                //吃完饭设为true
                volatileModel.isVolatileEat = true;
            }
        });
        thread.start();

        //保证线程1先执行
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "在执行....");
                //如果吃过饭，就睡觉了
                if (volatileModel.isVolatileEat){
                    volatileModel.sleep(volatileModel.isVolatileEat);
                }
                //并打印出eat的值
                System.out.println("thread = " + volatileModel.getEat());
            }
        });
        thread2.start();
    }
}
