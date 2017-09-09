package cn.vobile.obserble.myObserble;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 19:36 17/9/9.
 * @description:
 */
public class MyObserverbleImpl implements MyObserverble {
    private List<MyObserver> observers = null;

    public MyObserverbleImpl(){
        observers = new ArrayList<MyObserver>();
    }
    public void removeObserver(MyObserver myObserver) {
        observers.remove(myObserver);
    }

    public void addObserver(MyObserver myObserver) {
        observers.add(myObserver);
    }

    public void notifyObserver(MyObserver myObserver) {
        observers.get(observers.indexOf(myObserver)).update(this, myObserver);
    }

    public void notifyObserver() {
        for (MyObserver myObserver : observers){
            myObserver.update(this, myObserver);
        }
    }
}
