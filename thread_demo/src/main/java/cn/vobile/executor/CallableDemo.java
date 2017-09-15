package cn.vobile.executor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: li_zhilei
 * @Date: create in 16:51 17/9/13.
 * @description:
 * 比较Executors的execute方法、submit(Runnable runnable)、submit(Callable callable)
 *
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        newCachedThreadPool();
//        newFixedThreadPool();
//        newSingleThreadExecutor();
//        newSchduleThreadExecutor();
//        callableSubmitTest();
        myNewThreadPoolTest();
    }

    /**
     * 自定义线程池
     */
    public static void myNewThreadPoolTest(){
        //创建等待队列
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, blockingQueue);

        for (int i = 0; i <10 ; i++) {
            threadPoolExecutor.submit(new MyCallable<String>());
        }
        threadPoolExecutor.shutdown();
    }
    public static void callableSubmitTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 0; i <10 ; i++) {
            Future<String> future = executorService.submit(new MyCallable<String>());
            list.add(future);
        }
        for (int i = 0; i < list.size(); i++){
            Future<String> future = list.get(i);
            System.out.println("future.get() = " + future.get() + " is canceled :" + future.isDone());
        }
        executorService.shutdown();
    }
    static class MyCallable<String> implements Callable<String>{
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " 线程名...");
            return (String) Thread.currentThread().getName();
        }
    }
}
