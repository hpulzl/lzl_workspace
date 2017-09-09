package cn.vobile.decorator;

/**
 * @Author: li_zhilei
 * @Date: create in 17:57 17/9/9.
 * @description:综合咖啡，是一款咖啡类型
 */
public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "综合咖啡";
    }

    public Double cost() {
        return super.getSize() + 0.89;
    }
}
