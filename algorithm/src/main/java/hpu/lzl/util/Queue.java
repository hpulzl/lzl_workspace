package hpu.lzl.util;

/**
 * Created by lzl on 2017/10/25.
 * 定义队列接口方法
 */
public interface Queue<E> {
    /**
     * 删除队首操作
     */
    E poll();

    /**
     * 返回队首数据
     * @return
     */
    E peek();

    /**
     * 从队尾添加元素
     * @param e
     * @return
     */
    boolean put(E e);

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列中的元素
     * @return
     */
    int size();
}
