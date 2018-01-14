package com.spark.lzl;

import com.spark.lzl.common.SparkCommonUtil;
import com.spark.lzl.sort.SecondarySort;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lzl on 2017/11/19.
 */
public class SparkFirst {
    public static void main(String[] args) {
        JavaSparkContext sc = SparkCommonUtil.getSparkContext("sparkDemo","local");
////        firstSparkJava();
////        wordCount();
////        wordCountByTextFile();
//        cogroupSparkJava(sc); //聚合
        secondSort(sc);
        sc.close();
    }


    /**
     * 统计一个串字符串中，字母出现的次数
     */
    public static void wordCount(JavaSparkContext sc){
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

    public static void wordCountByTextFile(JavaSparkContext sc){
       JavaRDD<String> javaRDD = sc.textFile("F:\\Program Files (x86)\\lzl_workspace\\spark_demo\\src\\main\\helloSpark.txt");
        JavaPairRDD<String,Integer> pairRDD = javaRDD.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s,1);
            }
        });
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
    public static void firstSparkJava(JavaSparkContext sc){

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

    public static void cogroupSparkJava(JavaSparkContext sc){
        List<Tuple2<Integer,String>> stuNames = Arrays.asList(new Tuple2<Integer,String>(1,"lzl"),
                new Tuple2<Integer,String>(2,"ht"),new Tuple2<Integer,String>(3,"mlj"),
                new Tuple2<Integer,String>(4,"zdh"));
        List<Tuple2<Integer,Float>> stuScores = Arrays.asList(new Tuple2<Integer,Float>(1,99.9f),
                new Tuple2<Integer,Float>(2,88.8f),new Tuple2<Integer,Float>(3,79.8f),
                new Tuple2<Integer,Float>(4,100f),new Tuple2<Integer,Float>(1,39f),
                new Tuple2<Integer,Float>(2,40.8f),new Tuple2<Integer,Float>(3,99.8f),
                new Tuple2<Integer,Float>(4,100f));
        JavaPairRDD<Integer,String> stuNamesRddPair = sc.parallelizePairs(stuNames);
        JavaPairRDD<Integer,Float> stuScoreRddPair = sc.parallelizePairs(stuScores);
        JavaPairRDD<Integer,Tuple2<Iterable<String>,Iterable<Float>>> nameScores = stuNamesRddPair.cogroup(stuScoreRddPair);

        nameScores.foreach(new VoidFunction<Tuple2<Integer, Tuple2<Iterable<String>, Iterable<Float>>>>() {
            @Override
            public void call(Tuple2<Integer, Tuple2<Iterable<String>, Iterable<Float>>> integerTuple2Tuple2) throws Exception {
                System.out.println("id:" + integerTuple2Tuple2._1());
                System.out.println("name:" + integerTuple2Tuple2._2._1());
                System.out.println("score:" + integerTuple2Tuple2._2._2());
            }
        });
    }

    public static void secondSort(JavaSparkContext sc){
        JavaRDD<String> javaRdd = sc.textFile("F:\\Program Files (x86)\\lzl_workspace\\spark_demo\\src\\main\\secondSort.txt");
        JavaPairRDD<SecondarySort,String> javaPairRDD = javaRdd.mapToPair(new PairFunction<String, SecondarySort, String>() {
            private static final long serialVersion = 1L;

            /**
             * 将文件中的每一行封装成一个Tuple2的对象
             * @param line
             * @return
             * @throws Exception
             */
            @Override
            public Tuple2<SecondarySort, String> call(String line) throws Exception {
                String split[] = line.split(" ");
                SecondarySort sort = new SecondarySort(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
                return new Tuple2<>(sort,line);
            }
        });
        JavaPairRDD<SecondarySort,String> sorted = javaPairRDD.sortByKey(); // 完成二次排序
        /**
         * 过滤排序后自定的key，保留排序的结果
         */
        JavaRDD<String> javaSorted = sorted.map(new Function<Tuple2<SecondarySort, String>, String>() {
            private static final long serialVersion = 1L;
            @Override
            public String call(Tuple2<SecondarySort, String> secondarySortStringTuple2) throws Exception {
                return secondarySortStringTuple2._2();
            }
        });
        javaSorted.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });
    }
}
