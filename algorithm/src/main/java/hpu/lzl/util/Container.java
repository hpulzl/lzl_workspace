package hpu.lzl.util;

/**
 * @Author: li_zhilei
 * @Date: create in 15:41 17/10/18.
 * @description:定义容器的一些基本操作
 */
public interface Container<E> {

    /**
     * 添加一个元素
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 在某个位置添加元素
     * @param index
     * @param e
     * @return
     */
    void add(int index,E e);

    /**
     * 根据元素内容，
     * 删除一个元素
     * @param e
     * @return
     */
    boolean remove(E e);

    /**
     *根据元素位置，
     * 删除一个元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 在容器某个位置添加一个元素
     * 如果位置有数据则替换
     * @param index
     * @param e
     * @return
     */
    E set(int index, E e);

    /**
     * 当前元素的大小
     * @return
     */
    int size();

    /**
     * 判断集合是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 清空集合
     */
    void clear();

    /**
     * 获取元素
     * @param index
     * @return
     */
    E get(int index);

}
