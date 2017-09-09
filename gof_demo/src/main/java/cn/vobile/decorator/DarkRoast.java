package cn.vobile.decorator;

/**
 * @Author: li_zhilei
 * @Date: create in 17:57 17/9/9.
 * @description:深焙咖啡，是一款咖啡类型
 */
public class DarkRoast extends Beverage{

    public DarkRoast(){
        description = "深焙咖啡";
    }

    public Double cost() {
        return 0.89;
    }
}
