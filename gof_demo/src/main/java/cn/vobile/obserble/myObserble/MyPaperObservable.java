package cn.vobile.obserble.myObserble;


/**
 * 学习使用java的观察者模式，此类为主题，可以注册、删除、通知观察者
 */
public class MyPaperObservable extends MyObserverbleImpl{
    private String date;
    private String title;
    private String content;

    public void todayNewsChange(){
       super.notifyObserver();
    }
    public void setTodayNews(String date,String title,String content){
        this.date = date;
        this.title = title;
        this.content = content;
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