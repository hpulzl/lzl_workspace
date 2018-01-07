package com.spark.lzl.sort;

import scala.Serializable;
import scala.math.Ordered;

/**
 * Created by lzl on 2018/1/7.
 * 实现二次排序
 */
public class SecondarySort implements Ordered<SecondarySort>, Serializable{

    private int first;
    private int second;

    public SecondarySort(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compare(SecondarySort that) {
        if (this.first != that.getFirst()){
            return this.first - that.getFirst();
        }else{
            return this.second - that.getSecond();
        }
    }

    @Override
    public boolean $less(SecondarySort that) {
        return this.compare(that) < 0;
    }

    @Override
    public boolean $greater(SecondarySort that) {
        return this.compare(that) > 0;
    }

    @Override
    public boolean $less$eq(SecondarySort that) {
        return this.compare(that) <= 0;
    }

    @Override
    public boolean $greater$eq(SecondarySort that) {
        return this.compare(that) >= 0;
    }

    @Override
    public int compareTo(SecondarySort that) {
        return this.compare(that);
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
