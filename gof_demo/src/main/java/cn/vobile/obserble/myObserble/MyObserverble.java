package cn.vobile.obserble.myObserble;

/**
 * @Author: li_zhilei
 * @Date: create in 19:31 17/9/9.
 * @description:
 */
public interface MyObserverble {
    /**
     * 删除观察者
     */
    void removeObserver(MyObserver myObserver);

    /**
     * 添加观察者
     * @param myObserver
     */
    void addObserver(MyObserver myObserver);

    /**
     * 通知观察者，某个
     * @param myObserver
     */
    void notifyObserver(MyObserver myObserver);

    /**
     * 通知所有的观察者
     */
    void notifyObserver();
}
