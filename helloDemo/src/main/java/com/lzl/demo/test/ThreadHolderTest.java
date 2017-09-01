package com.lzl.demo.test;


import java.util.Calendar;
import java.util.Date;

/**
 * @Author: li_zhilei
 * @Date: create in 13:49 17/3/21.
 * @description: 测试发布线程安全的对象
 */
public class ThreadHolderTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int hours = c.get(Calendar.HOUR_OF_DAY) + 1;
        for (int i = 0; i < hours; i++) {
            c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - 1);
            System.out.println("c.toString() = " + c.toString());
        }
    }
}
