package com.lzl.demo.test;

/**
 * @Author: li_zhilei
 * @Date: create in 11:14 17/7/30.
 * @description:
 * java虚拟机栈和本地方法栈的内存溢出（OutOfMemoryError）模拟
 * 不停的创建线程（申请线程的内存空间）
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    //这里要抛Throwable
    public static void main(String[] args)throws Throwable {
        JavaVMStackOOM stackOOM = new JavaVMStackOOM();
        stackOOM.stackLeakByThread();
    }
}
