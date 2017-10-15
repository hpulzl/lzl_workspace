package cn.vobile.java.map;

import java.util.*;

/**
 * @Author: li_zhilei
 * @Date: create in 13:41 17/10/13.
 * @description:
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        putLinked();
    }


    /**
     * linkedHashMap保证插入数据的顺序
     */
    public static void putLinked(){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("A","AA");
        map.put("B","BB");
        map.put("C","CC");
        for(Map.Entry m : map.entrySet()){
            System.out.println("key : " + m.getKey() + " value : " + m.getValue());
        }
        System.out.println("========================map = " + map);
        Map<String,String> hashMap = new HashMap<>();

        hashMap.put("HHH","AA");
        hashMap.put("MMM","BB");
        hashMap.put("AAA","CC");
//        for(Map.Entry m : hashMap.entrySet()){
//            System.out.println("key : " + m.getKey() + " value : " + m.getValue());
//        }
        System.out.println("========================hashMap = " + hashMap);
    }

    public static void itetraLinked(){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("A","AA");
        map.put("B","BB");
        map.put("C","CC");
       Set<Map.Entry<String,String>> set = map.entrySet();
       Iterator<Map.Entry<String,String>> iterator = set.iterator();
       while (iterator.hasNext()){
           Map.Entry m = iterator.next();
           System.out.println(m);
       }
    }
}
