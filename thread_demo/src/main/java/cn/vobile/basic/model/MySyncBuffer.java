package cn.vobile.basic.model;


/**
 * @Author: li_zhilei
 * @Date: create in 16:49 17/9/14.
 * @description:
 * 用synchronized修饰的锁
 */
public class MySyncBuffer {
    public synchronized void read(){
        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " 进行读操作...");
        //模拟十分耗时的读操作
        while (true){
            if (System.currentTimeMillis() % 10000 == 3){
                System.out.println("start = " + start);
            }
            if (System.currentTimeMillis() - start >= Integer.MAX_VALUE){
                break;
            }
        }
    }

    public synchronized void write(){

        System.out.println(Thread.currentThread().getName() + " 进行写操作...");

    }
}
