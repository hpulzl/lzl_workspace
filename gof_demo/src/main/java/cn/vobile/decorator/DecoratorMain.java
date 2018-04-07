package cn.vobile.decorator;

/**
 * @Author: li_zhilei
 * @Date: create in 18:15 17/9/9.
 * @description:
 */
public class DecoratorMain {

    public static void main(String[] args) {
        //来一杯摩卡深焙咖啡
        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        System.out.println("描述：" + beverage1.getDescription() + "。 价格：" + beverage1.cost());
        //来大杯的双倍摩卡综合咖啡
        Beverage beverage = new HouseBlend();
        beverage.setSize(Beverage.large);
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println("描述：" + beverage.getDescription() + "。 价格："+beverage.cost());
    }
}
