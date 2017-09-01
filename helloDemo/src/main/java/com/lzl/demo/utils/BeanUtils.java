package com.lzl.demo.utils;

import com.lzl.demo.bean.Person;

/**
 * @Author: li_zhilei
 * @Date: create in 16:16 17/6/25.
 * @description:通过反射实例化bean
 */
public class BeanUtils {
    public static <T> T instantiate(String classForName){
        try {
            Class tClass = Class.forName(classForName);
            return (T) tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Person person = BeanUtils.instantiate("com.lzl.demo.bean.Person");
        System.out.println("person = " + person);
    }
}
