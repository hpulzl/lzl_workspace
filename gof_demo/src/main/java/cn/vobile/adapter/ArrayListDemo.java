package cn.vobile.adapter;

import java.util.*;

/**
 * @Author: li_zhilei
 * @Date: create in 10:00 17/11/14.
 * @description:
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        arrayListUseEnumerations();
    }

    public static void arrayListUseEnumerations(){
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        /**
         * 我们发现arrayList实现了Iterator接口，但是没有实现Enumeration接口，
         * 如果要兼容Enumeration接口需要写一个EnumerationAdapter
         * 的适配器，并能够实现兼容。
         */
        Enumeration<String> enumerationAdapter = new EnumerationAdapter<String>(arrayList.iterator());

        while (enumerationAdapter.hasMoreElements()){
            String str = enumerationAdapter.nextElement();
            System.out.println("str = " + str);
        }
    }
}
