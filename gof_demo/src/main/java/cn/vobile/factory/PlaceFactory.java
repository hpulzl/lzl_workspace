package cn.vobile.factory;

import cn.vobile.factory.model.Place;

/**
 * @Author: li_zhilei
 * @Date: create in 09:10 17/9/28.
 * @description: 根据需求设计
 * 该类是为不同个性化产品创建推荐位的工厂
 * 个性化产品包括
 * 开机广告
 * 开机视频
 * 欢迎页
 * 酒店logo
 * 酒店屏幕
 */
public abstract class PlaceFactory {
    //当然这里要准备一些id，区分不同的place
    /**
     * 根据给个性化产品的类型，创建不同的推荐位对象以及素材、策略对象
     * @param object
     * @return
     */
    public abstract Place createPlace(Object object);

}
