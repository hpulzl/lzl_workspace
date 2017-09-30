package cn.vobile.factory;

import cn.vobile.factory.model.ScreenSaver;
import cn.vobile.factory.model.StartupAd;

/**
 * @Author: li_zhilei
 * @Date: create in 10:19 17/9/28.
 * @description:实现产品的具体逻辑，这里只需要调用工厂方法，获得Place推荐位，
 * 并执行其父类的发布或者取消的逻辑即可.
 * 父类使用的是工厂模式+模板模式来完成的。
 * 1. 使用工厂模式创建Place对象
 * 2. 使用模板模式来组织发布的规则
 */
public class ConcreteProductService extends ProductService {

    /**
     * 构造方法中引入创建工厂的实例
     *
     * @param placeFactory
     */
    public ConcreteProductService(PlaceFactory placeFactory) {
        super(placeFactory);
    }

    public void startupAdPublish(StartupAd startupAd){
        this.publishByProduct(startupAd);
    }

    public void screecSaverPublish(ScreenSaver screenSaver){
        this.publishByProduct(screenSaver);
    }

    public void screenSaverCancel(ScreenSaver screenSaver){
        this.cancelByProduct(screenSaver);
    }
    
    public void startupAdCancel(StartupAd startupAd){
        this.cancelByProduct(startupAd);
    }


    public static void main(String[] args) {
        /**
         * 创建一个startupAd，并发布和取消
         */
        PlaceFactory placeFactory = new ConcretePlaceFactory();
        StartupAd startupAd = new StartupAd();
        ConcreteProductService service = new ConcreteProductService(placeFactory);
        service.startupAdPublish(startupAd);
        service.startupAdCancel(startupAd);

    }
}
