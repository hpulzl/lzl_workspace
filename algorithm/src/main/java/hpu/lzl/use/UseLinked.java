package hpu.lzl.use;


import hpu.lzl.util.Container;
import hpu.lzl.util.Linked;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: li_zhilei
 * @Date: create in 14:54 17/10/27.
 * @description:
 */
public class UseLinked {
    public static void main(String[] args) {
        linkedTest();
//        linkedQueueTest();
    }

    public static void linkedQueueTest(){
        java.util.Queue<String> queue = new LinkedBlockingQueue<String>();
        queue.add("AAAA");
        queue.add("BBB");
        queue.add("CCC");
        System.out.println("queue = " + queue);
    }

    public static void linkedTest(){
        Container<String> queue = new Linked<String>();
        queue.add("AAA");
        queue.add("BBB");
        queue.add("CCC");
        System.out.println("add over = " + queue.size() + " queue = " + queue);

        queue.add(0,"xxx");
        System.out.println("add index over = " + queue.size() + " queue = " + queue);

        queue.remove("AAA");
        queue.remove("BBBB");
        System.out.println("remove index over = " + queue.size() + " queue = " + queue);

        queue.remove(0);
        System.out.println("remove index = " + queue.size() + " queue = " + queue);
        queue.set(1,"jfk");
        System.out.println("set index = " + queue.size() + " queue = " + queue);
        queue.clear();
        System.out.println("cleat linked = " + queue.size() + " queue = " + queue);
        queue.isEmpty();
        System.out.println("isEmpty linked = " + queue.size() + " queue = " + queue + " is empty " + queue.isEmpty());
    }
}
