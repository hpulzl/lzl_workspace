package cn.vobile.singleton;

/**
 * @Author: li_zhilei
 * @Date: create in 10:42 17/10/15.
 * @description:统计三种单例模式的耗时操作
 */
public class StatisticsSingleton {

    public static void main(String[] args) {
        //1. 统一控制多线程数量
        int count = 10000;
        //2. 各自打印耗时时间
        UnsafeSingletonClass.statisticUnSafe(count);
        SingletonClass.statisticsSync(count);
        StaticSingletonClass.statisticStatic(count);
        DoubleSingletonClass.statisticDouble(count);
    }
}
