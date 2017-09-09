package cn.vobile.decorator;

/**
 * @Author: li_zhilei
 * @Date: create in 18:00 17/9/9.
 * @description:装饰者，是为了满足不同顾客对饮料的需求，
 * 例如用户想要拿铁奶泡综合咖啡，这个就需要装饰着来修饰了
 */
public abstract class CondimentDecorator extends Beverage{
    //对被装饰的了饮料的描述
    public abstract String getDescription();
}
