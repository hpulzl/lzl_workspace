package cn.vobile.decorator;

/**
 * @Author: li_zhilei
 * @Date: create in 17:59 17/9/9.
 * @description:奶泡装饰者，创建这个类的饮料都加了摩卡
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    private Whip(){}
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription() {
        return this.beverage.getDescription() + ", 奶泡";
    }

    public Double cost() {
        return this.beverage.cost() + this.beverage.getSize() + 0.1;
    }

}
