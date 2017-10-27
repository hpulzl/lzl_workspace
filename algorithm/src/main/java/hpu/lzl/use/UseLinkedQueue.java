package hpu.lzl.use;

import hpu.lzl.util.LinkedQueue;

/**
 * @Author: li_zhilei
 * @Date: create in 17:44 17/10/27.
 * @description:链式队列的使用
 */
public class UseLinkedQueue {
    public static void main(String[] args) {
        queueTest();
    }

    public static void queueTest(){
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.put("AAAA");
        linkedQueue.put("BBB");
        linkedQueue.put("CCC");
        System.out.println("linkedQueue add = " + linkedQueue);
        linkedQueue.poll();
        linkedQueue.poll();
        System.out.println("linkedQueue poll(删除队首操作) = " + linkedQueue);
        String e = linkedQueue.peek();
        System.out.println("linkedQueue peek（获取队首操作） " + e);
        System.out.println("linkedQueue.size() = " + linkedQueue.size() + " linkedQueue is Empty " + linkedQueue.isEmpty());

    }
}
