package com.lzl.demo.test;

/**
 * @Author: li_zhilei
 * @Date: create in 11:14 17/7/30.
 * @description:
 * java虚拟机栈和本地方法栈的栈溢出（stackOverflowError）模拟
 */
public class JavaVMStackSOF {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        this.stackLeak();
    }
    public static void main(String[] args)throws Throwable {
        JavaVMStackSOF stackSOF = new JavaVMStackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackSOF = " + stackSOF.stackLength);
            throw e;
        }
    }
}
