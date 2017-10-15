package cn.vobile.java.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 11:15 17/10/11.
 * @description:
 */
public class ArrayListDemo {
    public static void main(String[] args) {
//        arrayCopyOf();growList
//        systemCopyOf();
//        addList();
//        growList();
        syncList();
    }

    /**
     * 将list变为线程安全的方法有两种
     * 1. 使用vector
     * 2. 使用Collections.synchronizedList方法
     */
    public static void syncList(){
        List<String> list = new ArrayList();
        List<String> synchronizedList = Collections.synchronizedList(list);
        synchronizedList.add("AAA");
        System.out.println("synchronizedList = " + synchronizedList);
    }
    /**
     * 设置list初始大小，调用add(index,obj)的方法
     * 会抛出java.lang.IndexOutOfBoundsException异常
     */
    public static void growList(){
        List<String> list = new ArrayList<>(12);
        // add方法中有rangeCheckForAdd(index)判断;
        list.add(13,"A");
        System.out.println("list = " + list);
    }

    public static void addList(){
        List list = new ArrayList();
        list.add("A");
        list.add("B");

        //set方法类似于修改（替换），set的index必须小于size的大小
        list.set(1,"CC");

        list.remove(0);
    }

    /**
     * 数组的复制功能
     */
    public static void arrayCopyOf(){
        String s[] = new String[]{"A","B","C"};
        String[] ps = Arrays.copyOf(s,s.length);
        for (int i = 0; i < ps.length; i++) {
            System.out.println("ps = " + ps[i]);
        }
    }

    /**
     * 实现对象的复制功能
     */
    public static void systemCopyOf(){
        String s[] = new String[]{"A","B","C","D","E","F"};
        int size = s.length;
        int numMoved = size -1 -1;
        /**
         * src      原有的数组
         * @param      srcPos   原有数组的开始下标
         * @param      dest     目标数组
         * @param      destPos  目标数组的开始下标
         * @param      length   数组元素的copy长度.
         */
        System.arraycopy(s, 2,s, 0, numMoved);
        for (int i = 0; i < s.length; i++) {
            System.out.println(i + " == " + s[i]);
        }
        System.out.println("对本身进行复制....结束");
        String[] ps = new String[size];
        /**
         * 注意length只能复制s.size - srcPos - 1的长度
         */
        System.arraycopy(s, 4, ps, 0, size - 4);
        for (int i = 0; i < ps.length; i++) {
            System.out.println(i + " == " + ps[i]);
        }
    }
}
