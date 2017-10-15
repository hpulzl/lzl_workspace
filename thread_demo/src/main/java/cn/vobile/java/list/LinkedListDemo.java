package cn.vobile.java.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 10:44 17/10/12.
 * @description:
 */
public class LinkedListDemo {

    public static void main(String[] args) {
//        addLinked();
//        removeLinked();
//        addAllLinked();
        threadList();
    }

    /**
     * 默认是从后插入，
     * 还有从前插入
     */
    public static void addLinked(){
        List<String> list = new LinkedList<>();
//        list.add("AAA");
//        list.add("BBB");
//
//        list.add(1,"CCC");

        System.out.println("list = " + list);

        //从前面插入
        if (list instanceof LinkedList){
            LinkedList l = (LinkedList)list;
            l.addFirst("TTT");
            l.addFirst("XXX");
            System.out.println("list = " + l);
        }
    }

    public static void removeLinked(){
        List<String> list = new LinkedList<>();
        list.add("AAA");
        list.add("CCC");
        list.remove(0);
        list.remove(0);
    }

    public static void addAllLinked(){
        List<String> list = new LinkedList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        List<String> stringList = new LinkedList<>();
        stringList.add("VVVVVVV");
        stringList.addAll(list);
        System.out.println("stringList = " + stringList);
    }

    /**
     * 一个进行迭代，一个进行删除
     * 会出现异常
     Exception in thread "Thread-1" java.util.ConcurrentModificationException
     */
    public static void threadList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < 10000; i++){
            list.add(i);
        }
        T1 t1  = new T1(list);
        T2 t2  = new T2(list);
        t1.start();
        t2.start();
    }

    static class T1 extends Thread{

        List<Integer> list = null;
        public T1(List<Integer> list){
            this.list = list;
        }
        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++)
            {
                list.remove(i);
            }
        }
    }
    static class T2 extends Thread{

        List<Integer> list = null;
        public T2(List<Integer> list){
            this.list = list;
        }
        @Override
        public void run() {
            for (Integer i : list){
                System.out.println("i = " + i);
            }
        }
    }
}
