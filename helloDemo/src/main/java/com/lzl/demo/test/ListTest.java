package com.lzl.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 22:56 17/7/24.
 * @description:
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> Plist = new ArrayList<String>();
        Plist.add("1");
        Plist.add("23");
        Plist.add("324");
        Plist.add("43");
        Plist.add("143");
        List<String> sList = new ArrayList<String>();
        sList.add("23");
        sList.add("124");
        System.out.println("Plist.contains(sList) = " + Plist.contains(sList));
    }
}
