package cn.vobile.obserble;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by lzl on 2017/9/7.
 * 新闻报纸的订阅者
 * 实现观察者的更新方法，获得更新
 */
public class NewsPaperObserver implements Observer {
    private Observable o;
    public void update(Observable o, Object arg) {
        this.o = o;
        if (o instanceof PaperObservable){
            System.out.println("新闻类，今天订阅的新内容是："+o.toString());
        }
    }
}
