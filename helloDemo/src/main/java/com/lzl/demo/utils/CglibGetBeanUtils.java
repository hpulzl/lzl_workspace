package com.lzl.demo.utils;

import com.lzl.demo.bean.Person;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * @Author: li_zhilei
 * @Date: create in 16:40 17/6/25.
 * @description:
 */
public class CglibGetBeanUtils {
    public static Object instantiate(String classForName){
        try {
            Class beanClass = Class.forName(classForName);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallbackFilter(new CallbackFilter() {
                public int accept(Method method) {
                    return 0;
                }
            });
            enhancer.setCallback(NoOp.INSTANCE);
            return enhancer.create();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Person p = (Person) CglibGetBeanUtils.instantiate("com.lzl.demo.bean.Person");
        System.out.println("p = " + p);
    }
}
