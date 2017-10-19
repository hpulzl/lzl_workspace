package hpu.lzl.util;

import java.util.Arrays;

/**
 * @Author: li_zhilei
 * @Date: create in 16:15 17/10/18.
 * @description:
 */
public class ListContainer<E> implements Container<E> {

    Object elements[];
    int size;
    int initialCapcity;
    final int default_num = 1 << 3;

    public ListContainer(){
        elements = new Object[default_num];
    }

    /**
     * 设置初始化容器大小
     * @param size
     */
    public ListContainer(int size){
        initialCapcity = size;
        elements = new Object[size];

    }
    public boolean add(E e) {
        //如果size>容器大小，要设置一个扩容规则。
        ensureLarge(size + 1);
        elements[size++] = e;
        return true;
    }

    private void ensureLarge(int i) {
        //需要扩容操作
        if (i - initialCapcity > 0){
            dilatation();
        }
    }

    /**
     * 扩容规则
     */
    private void dilatation() {
        int newCapacity;
        if (initialCapcity - Integer.MAX_VALUE > 0){
            throw new OutOfMemoryError("超出整数类型大小");
        }
        newCapacity = initialCapcity << 1;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    /**
     * 删除元素
     * 数组补洞
     * @param e
     * @return
     */
    public boolean remove(E e) {
        if (e == null){
            for (int i=0;i<size;i++){
                if(elements[i]==null){
                    fastRemove(i);
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        int nextNum = size - index - 1;
        //将数组copy到新的数组中，这里实现的是将index后面的数组前移
        System.arraycopy(elements,index+1,elements,index,nextNum);
        elements[--size] = null;
    }

    public E remove(int index) {
        return null;
    }

    public E set(int index, E e) {
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size(); i++){
            sb.append(elements[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListContainer<String> listContainer = new ListContainer<>(2);
        listContainer.add("AAAA");
        listContainer.add("BBBB");
        listContainer.add("33333");
        listContainer.remove("33333");
        System.out.println("size = "+ listContainer.size() + " listContainer = " + listContainer);

    }
}
