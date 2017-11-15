package cn.vobile.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @Author: li_zhilei
 * @Date: create in 09:56 17/11/14.
 * @description:实现一个适配器的设计模式
 * 适配器模式可以使得客户端调用一个接口，并转接到另一个接口的实现的效果。
 * 使得客户端和被调用接口之间解耦
 */
public class EnumerationAdapter<E> implements Enumeration<E>{

    private Iterator it;
    public EnumerationAdapter(Iterator<String> it){
        this.it = it;
    }
    public boolean hasMoreElements() {
        return it.hasNext();
    }

    public E nextElement() {
        return (E) it.next();
    }
}
