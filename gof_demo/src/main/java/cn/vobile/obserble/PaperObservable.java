package cn.vobile.obserble;

import java.util.Observable;

/**
 * 学习使用java的观察者模式，此类为主题，可以注册、删除、通知观察者
 */
public class PaperObservable extends Observable{
    private String date;
    private String title;
    private String content;

    public void todayNewsChange(){
        setChanged();
        notifyObservers();
    }
    public void setTodayNews(String date,String title,String content){
        this.date = date;
        this.title = title;
        this.content = content;
    }
    public void getObserversCount(){
        int count = super.countObservers();
        System.out.println("当前订阅者："+count);
    }

    @Override
    public String toString() {
        return "PaperObservable{" +
                "date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}