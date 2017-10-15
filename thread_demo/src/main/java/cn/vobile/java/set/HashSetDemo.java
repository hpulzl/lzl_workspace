package cn.vobile.java.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: li_zhilei
 * @Date: create in 16:08 17/10/12.
 * @description:
 */
public class HashSetDemo {

    public static void main(String[] args) {

    }

    public static void setHash(){
        Set<String> set = new HashSet();
        set.add("AAA");
        set.remove("AAA");
    }
}
