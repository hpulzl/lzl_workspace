package cn.vobile.obserble.myObserble;

/**
 * Hello world!
 *
 */
public class ObserverbleMain
{
    public static void main( String[] args ) {
        MyPaperObservable paperObservable =  new MyPaperObservable();
        //更新今天的主题内容
        paperObservable.setTodayNews("2017-09-0909","lzl修复100+bug","程序员一天内努力修复100+bug");
        //添加订阅者
        MyNewsPaperObserver newsPaperObserver = new MyNewsPaperObserver();
        ConsumerPaperObserver consumerPaperObserver = new ConsumerPaperObserver();
        paperObservable.addObserver(newsPaperObserver);
        paperObservable.addObserver(consumerPaperObserver);
        paperObservable.todayNewsChange();

    }
}
