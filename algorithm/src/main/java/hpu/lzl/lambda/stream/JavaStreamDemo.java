package hpu.lzl.lambda.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import hpu.lzl.lambda.client.LambdaClient;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by lzl on 2018/1/7.
 * java8 stream的相关API使用
 * 1. 集合流计算方式分为串行流（sequential）和并行流(parallel)
 * 2. 集合流计算过程分为中间操作和终止操作
 * 2.1 中间操作返回的对象还是stream，例如filter，sorted，map,group等
 * 2.3 返回非stream对象，例如foreach(),sum(),toArray()等
 */
public class JavaStreamDemo {
    public static void main(String[] args) {
//        streamList();
//        sequentialStreamDemo();
//        parallelStreamDemo();
        streamListDemo();
    }
    public static void streamList(){
        List<String> list = new ArrayList<>();

        list.add("AC");
        list.add("BC");
        list.add("FD");
        list.add("DD");
        List<String> containCList = Lists.newArrayList();
        List<String> containDList = Lists.newArrayList();
        //list.stream().filter(item -> item.contains("C")).collect(Collectors.toList());
        list.stream().forEach(item ->{
            if (item.contains("C")){
                containCList.add(item);
            }else {
                containDList.add(item);
            }
        });
        System.out.println("contain C "+containCList);
        System.out.println("contain D "+containDList);
    }

    public static List<Integer> getIntegerList(){
        List<Integer> list = Lists.newArrayList();
        for (int i=1;i<=10000000;i++){
            Integer count = new Random().nextInt(i);
            list.add(count);
        }
        return list;
    }
    /**
     * 串行流
     */
    public static void sequentialStreamDemo(){
        List<Integer> list = getIntegerList();
        //串行排序，并计算时间
        long start = System.nanoTime();
        long count = ((Stream)list.stream().sequential()).sorted().count();
        long end = System.nanoTime();
        long useTime = TimeUnit.NANOSECONDS.toMillis(end - start);
        System.out.println("sequential sort count : use time is ms" + useTime);
    }

    /**
     * 并行流
     */
    public static void parallelStreamDemo(){
        List<Integer> list = getIntegerList();
        //串行排序，并计算时间
        long start = System.nanoTime();
        long count = ((Stream)list.stream().parallel()).sorted().count();
        long end = System.nanoTime();
        long useTime = TimeUnit.NANOSECONDS.toMillis(end - start);
        System.out.println("parallell sort count : use time is ms" + useTime);
    }

    public static void streamListDemo(){
        List<LambdaClient.Person> personList = Lists.newArrayList();
        for (int i=0;i<50;i++){
            personList.add(new LambdaClient.Person("name_"+i,15+i));
        }
        //过滤30岁以上的person
        /**
         * filter 传入的参数是Predicate<T>函数式。
         * forEachOrdered 传入的参数是Consumer<T> 函数式
         */
        personList.stream().filter(person -> person.getAge()>30).forEachOrdered(
                person -> System.out.println("person age 30+ " + person)
        );

    }

    /**
     *
     */
    public static void streamMapDemo(){
//        List<Integer> transactionsIds = transactions.parallelStream().
//                filter(t -> t.getType() == Transaction.GROCERY).
//                sorted(comparing(Transaction::getValue).reversed()).
//                map(Transaction::getId).
//                collect(toList());
    }
}
