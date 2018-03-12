package cn.vobile.akka.service;

/**
 * 技术的service类
 *
 * @author awo
 * @create 2018-03-09 下午1:55
 **/
public class CountService {

    private int count;

    public int increaseCount(){
       return  count++;
    }
}
