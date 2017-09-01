package com.lzl.demo.thread;


/**
 * @Author: li_zhilei
 * @Date: create in 13:40 17/3/21.
 * @description:
 */
public class Holder {
    private int n;
    public Holder(int i){
        this.n = i;
    }
    public void assertSanity(){
        if(n!=n)
            throw new AssertionError("当前状态不一致");
    }
}
