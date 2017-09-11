package cn.vobile.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: li_zhilei
 * @Date: create in 16:36 17/9/11.
 * @description:
 * 守护线程(后台线程)
 * 概念与用户线程相比较。它是一个优先级很低的进程，只有用户线程在操作时候，
 * 守护线程才会去执行操作。
 * 如果不存在用户线程，jvm可能将其回收掉。例如GC的线程。
 * 守护线程的创建
 * 与线程创建类似，在调用thread.start()之前调用thread.setDaemon(true)
 */
public class DaemonThread {
    public static void main(String[] args) {
        //如果主线程中断，就执行守护线程
        Thread thread = new DaemonThreadTest();
        thread.setDaemon(true);
        thread.start();
        System.out.println("thread.isDaemon() = " + thread.isDaemon());
        System.out.println("main over");
    }
    //一个实例，来验证守护线程的说法
    public static void daemonTest(){
        Thread thread = new DaemonThreadTest();
        thread.setDaemon(true);
        thread.start();

    }
    static class DaemonThreadTest extends Thread{
        @Override
        public void run() {
            //直接打印，出来结果
            System.out.println(" daemon thread is running.... ");
            try {
                //让守护线程睡1m，等待主线程（唯一的用户线程）执行完毕。
                Thread.sleep(1000);
                FileOutputStream fileOutputStream = new FileOutputStream("/Users/vobile_lzl/HSS-0814.sql");
                fileOutputStream.write("gfdsgsd".getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("daemon write over ");
        }
    }
}
