package com.spark.lzl;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lzl on 2017/11/19.
 */
public class SparkFirst {
    private static SparkConf conf;
    private static JavaSparkContext sc;
    public static void main(String[] args) {
//        firstSparkJava();
        wordCount();
    }

    static {
        /**
         * 第一步:创建spark的配置对象SparkConf，设置spark程序运行时的配置信息，
         * setMaster设置程序要链接的spark集群的master的URL
         */
        conf = new SparkConf().setAppName("my first spark demo").setMaster("local");
        sc = new JavaSparkContext(conf);
    }
    /**
     * 统计一个串字符串中，字母出现的次数
     */
    public static void wordCount(){
        String[] strings = new String[]{"words","word","name","hello","name","word","come","on","hello"};
        JavaRDD<String> lines = sc.parallelize(Arrays.asList(strings));
//        JavaPairRDD<String,Integer> pairRDD = lines.mapToPair(s -> new Tuple2<String, Integer>(s,1));
        JavaPairRDD<String,Integer> pairRDD = lines.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s,1);
            }
        });
//        JavaPairRDD<String,Integer> counts = pairRDD.reduceByKey((a,b) -> a + b);
        JavaPairRDD<String,Integer> counts = pairRDD.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

//        counts.foreach(stringIntegerTuple2 ->System.out.println("str:" + stringIntegerTuple2._1() +
//                "=> count:" + stringIntegerTuple2._2()));
        counts.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                System.out.println("str:" + stringIntegerTuple2._1() + "=> count:" + stringIntegerTuple2._2());
            }
        });
    }
    /**
     * 1. 创建SparkConf
     * 2. 创建JavaSparkContext
     * 3. 创建JavaRDD
     */
    public static void firstSparkJava(){

        //并行集合
        List<Integer> list = Arrays.asList(1,23,4,4,5);
        JavaRDD<Integer> javaRDD = sc.parallelize(list);
        /**
         * 打印内容
         */
        javaRDD.foreach(new VoidFunction<Integer>() {
            public void call(Integer integer) throws Exception {
                System.out.println(" " + integer);
            }
        });
    }
}
