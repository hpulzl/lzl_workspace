package cn.vobile.factory;

import cn.vobile.factory.model.Place;

/**
 * @Author: li_zhilei
 * @Date: create in 09:39 17/9/28.
 * @description: 产品的调用者，根据业务需求生产不同的产品，并实现不同的逻辑.
 * 个性化产品的逻辑描述如下
 * 1. 创建Place
 * 2. 提交publish请求
 *      或者提交cancel请求
 */
public abstract class ProductService {
    private final CmsService cmsService = new CmsService();

    private PlaceFactory placeFactory;

    /**
     * 构造方法中引入创建工厂的实例
     * @param placeFactory
     */
    public ProductService(PlaceFactory placeFactory){
        this.placeFactory = placeFactory;
    }

    public Place getPlaceByObj(Object object) {
        return placeFactory.createPlace(object);
    }

    public void publishByProduct(Object object){
        Place place = getPlaceByObj(object);
        cmsService.publish(place);
    }

    public void cancelByProduct(Object object){
        Place place = getPlaceByObj(object);
        cmsService.cancel(place);
    }

}
