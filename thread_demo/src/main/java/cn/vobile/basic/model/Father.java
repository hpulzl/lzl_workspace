package cn.vobile.basic.model;

/**
 * @Author: li_zhilei
 * @Date: create in 22:25 17/9/12.
 * @description:
 */
public class Father {

    public synchronized void doSomething(){
        System.out.println(Thread.currentThread().getName() + " 当前线程 对象" + this);
    }
}
