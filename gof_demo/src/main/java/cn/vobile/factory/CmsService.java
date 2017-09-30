package cn.vobile.factory;

import cn.vobile.factory.model.Place;

/**
 * @Author: li_zhilei
 * @Date: create in 09:58 17/9/28.
 * @description:
 * 与cms系统对接的服务，拥有取消和发布的方法
 */
public class CmsService {

    public void cancel(Place place){
        System.out.println("取消推荐位信息 " + place.toString());
    }

    public void publish(Place place){
        System.out.println("发布推荐位信息 " + place.toString());
    }
}
