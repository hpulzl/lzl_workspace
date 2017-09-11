package cn.vobile.obserble;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        PaperObservable paperObservable = new PaperObservable();
        //更新今天的主题内容
        paperObservable.setTodayNews("2017-09-07","lzl修复100+bug","程序员一天内努力修复100+bug");
        //添加订阅者
        NewsPaperObserver newsPaperObserver = new NewsPaperObserver();
        ConsumerPaperObserver consumerPaperObserver = new ConsumerPaperObserver();
        paperObservable.addObserver(newsPaperObserver);
        paperObservable.addObserver(consumerPaperObserver);
        paperObservable.todayNewsChange();

    }
}
