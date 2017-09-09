package cn.vobile.decorator;

/**
 * @Author: li_zhilei
 * @Date: create in 17:51 17/9/9.
 * @description:星巴兹咖啡店是以饮料为主，因此有各式的饮料和不同的价格
 */
public abstract class Beverage {

    //星巴兹咖啡店新增了小杯、中杯、大杯的咖啡规格。
    public static final int small = 1;
    public static final int middle = 2;
    public static final int large = 3;

    String description;
    private double sizeCost = 0D;
    private String sizeDescription;

    public void setSize(int size){
        if (size == small){
            sizeCost = 0.1;
            sizeDescription = "小杯";
        }else if (size == middle){
            sizeCost = 0.2;
            sizeDescription = "中杯";
        }else if (size == large){
            sizeCost = 0.3;
            sizeDescription = "大杯";
        }
    }

    public double getSize(){
        return sizeCost;
    }

    public String getDescription(){
        return sizeDescription + this.description;
    }

    //不同的价格，由子类来说明
    public abstract Double cost();
}
