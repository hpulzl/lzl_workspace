package cn.vobile.decorator;

/**
 * @Author: li_zhilei
 * @Date: create in 17:59 17/9/9.
 * @description:摩卡装饰者，创建这个类的饮料都加了摩卡
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    private Mocha(){}
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription() {
        return this.beverage.getDescription() + ", 摩卡";
    }



    public Double cost() {
        return this.beverage.cost() + 0.2;
    }

}
