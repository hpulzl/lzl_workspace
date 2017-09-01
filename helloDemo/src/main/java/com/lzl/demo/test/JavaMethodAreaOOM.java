package com.lzl.demo.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: li_zhilei
 * @Date: create in 12:18 17/7/30.
 * @description:java方法区栈溢出
 * 1.8没有permSize(永久代)使用metaspace（元空间）来取代
 * -XX:MaxMetaspaceSize=2m
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{

    }
}
