package cn.vobile.basic.model;

/**
 * @Author: li_zhilei
 * @Date: create in 22:25 17/9/12.
 * @description:
 */
public class Child extends Father{

    public synchronized void methodA(){
        System.out.println(Thread.currentThread().getName() + " child methodA 当前线程 对象" + this);
        this.doSome();
    }

    public void doSome(){
        synchronized (this){
            super.doSomething();
            System.out.println(Thread.currentThread().getName() + " child doSomething当前线程 对象" + this);
        }
    }
    @Override
    public synchronized void doSomething() {
        super.doSomething();
        System.out.println(Thread.currentThread().getName() + " child doSomething当前线程 对象" + this);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    new Child().methodA();
                }
            });
            thread.start();
        }
    }
}
