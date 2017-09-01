package com.lzl.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 11:58 17/7/30.
 * @description:方法区与运行时oom
 * 这个方式在1.7之后就不会出现oom了
 *
 *
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(true){
            //intern方法如果常量池中有该常量，就返回；否则把该变量加入到常量池中
            list.add(String.valueOf(i++).intern());
        }
    }
}
