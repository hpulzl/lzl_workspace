package hpu.lzl.util;

/**
 * Created by lzl on 2017/10/23.
 * 定义栈的一些接口方法
 */
public interface Stack<E> {
    /**
     * 栈元素是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 栈元素大小
     * @return
     */
    int size();

    /**
     * 栈顶添加一个元素
     * @param e
     * @return
     */
    void push(E e);

    /**
     * 从栈顶移除一个元素
     * @return
     */
    E pop();

    /**
     * 从栈顶查找一个元素
     * @return
     */
    E peek();
}
