package cn.vobile.volatiledemo;

/**
 * @Author: li_zhilei
 * @Date: create in 17:44 17/9/27.
 * @description:
 */
public class VolatileModel {
    boolean isEat = false;
    volatile boolean isVolatileEat = false;

    private String eat="还没有吃饭";

    public void setEat(){
        eat = "已经吃饭了...";
    }

    public String getEat(){
        return eat;
    }

    public void sleep(boolean flag){
        System.out.println("flag = " + flag + " sleep");
    }
}
