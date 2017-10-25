package hpu.lzl.util;

/**
 * Created by lzl on 2017/10/25.
 * 链式队列
 * 有以下特征
 * 1. 链式队列没有队满的情况，可以无限制的增加。
 * 2. 链式队列的底层实现的单向链表
 */
public class LinkedQueue<E> implements Queue<E>{

    public Linked linked;
    public LinkedQueue(){
        linked = new Linked();
    }
    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean put(E e) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
