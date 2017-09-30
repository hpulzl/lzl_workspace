package cn.vobile.factory;

import cn.vobile.factory.model.Place;
import cn.vobile.factory.model.ScreenSaver;
import cn.vobile.factory.model.StartupAd;

/**
 * @Author: li_zhilei
 * @Date: create in 09:21 17/9/28.
 * @description: 创建推荐位的具体工厂实现类
 */
public class ConcretePlaceFactory extends PlaceFactory{

    public Place createPlace(Object object) {
        Place place = null;
        if (object instanceof StartupAd){
            StartupAd startupAd = (StartupAd) object;
            place = new Place();
            place.setCode("startupAd");
        }else if (object instanceof ScreenSaver){
            ScreenSaver screenSaver = (ScreenSaver) object;
            place = new Place();
            place.setCode("screenSaver");
        }
        System.out.println(" creatre factory new object is " + place.getCode() );
        return place;
    }

}
