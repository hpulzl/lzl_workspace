package com.lzl.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 11:48 17/7/30.
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @description:jvm堆内存的oom
 * 不断创建对象。
 */
public class JavaVmHeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args)throws Throwable {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
