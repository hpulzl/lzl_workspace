package cn.vobile.java.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: li_zhilei
 * @Date: create in 17:20 17/10/13.
 * @description:
 * 继承LinkedHashMap并将accessOrder设置为true就可以实现LRU(最近最少使用)算法
 * LinkedHashMap实现LRU的思路
 * 设计一个双向链表，在每次put或者get的时候，将元素放到链表的末尾。
 */
public class LruHashMap<K,V> extends LinkedHashMap<K,V> {

    public LruHashMap(){
        super(16,.75f,true);
    }

    public static void main(String[] args) {
        Map<Integer,Integer> lruMap = new LruHashMap<>();
        for (int i = 0; i < 10; i++) {
            lruMap.put(i,i);
        }
        System.out.println("before lruMap = " + lruMap);
        lruMap.put(3,90);
        System.out.println("after lruMap = " + lruMap);
    }
}
