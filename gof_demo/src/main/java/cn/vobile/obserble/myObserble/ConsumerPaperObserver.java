package cn.vobile.obserble.myObserble;


/**
 * Created by lzl on 2017/9/7.
 * 民生类报纸的订阅者
 * 实现观察者的更新方法，获得更新
 */
public class ConsumerPaperObserver implements MyObserver {
    private MyObserverble o;

    public void update(MyObserverble myObserverble, Object object) {
        this.o = myObserverble;
        if (o instanceof MyPaperObservable){
            System.out.println("民生类，今天订阅的新内容是："+o.toString());
        }
    }
}
