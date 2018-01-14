package com.spark.lzl.sort;

import com.spark.lzl.common.SparkCommonUtil;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by lzl on 2018/1/14.
 * 实现topN的分组排序
 */
public class TopNGroupSort {
    public static void main(String[] args) {
        JavaSparkContext jsc = SparkCommonUtil.getSparkContext("topNGroup","local");
        topNGroupSort(jsc);
        jsc.close();
    }

    /**
     * 分组，取前3 排序
     */
    public static void topNGroupSort(JavaSparkContext jsc){
        JavaRDD<String> javaRDD = jsc.textFile("F:\\Program Files (x86)\\lzl_workspace\\spark_demo\\src\\main\\topNGroup.txt");
        //将javaRDD进行分组
        JavaPairRDD<String,Integer> javaPairRDD = javaRDD.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                String[] splitStr = s.split(" ");
                return new Tuple2<>(splitStr[0],Integer.valueOf(splitStr[1]));
            }
        });
        JavaPairRDD<String,Iterable<Integer>> groupMapData = javaPairRDD.groupByKey(); //将数据分组
        System.out.println("==========打印分组状态============:");
        groupMapData.collect().forEach(new Consumer<Tuple2<String, Iterable<Integer>>>() {
            @Override
            public void accept(Tuple2<String, Iterable<Integer>> stringIterableTuple2) {
                System.out.println(stringIterableTuple2._1()+"==>"+stringIterableTuple2._2());
            }
        });
        System.out.println("==========打印分组排序状态============:");

        //将分组数据，每组分别排序，并取前3
        JavaPairRDD<String,Iterable<Integer>> topNGroupSort = groupMapData.mapToPair(new PairFunction<Tuple2<String,Iterable<Integer>>, String, Iterable<Integer>>() {
            @Override
            public Tuple2<String, Iterable<Integer>> call(Tuple2<String, Iterable<Integer>> stringIterableTuple2) throws Exception {
                Integer topN[] = new Integer[3]; //创建一个topN的数组
                String groupKey = stringIterableTuple2._1(); //获取分组的key
                Iterator<Integer> groupValueIt = stringIterableTuple2._2().iterator(); //获取分组的value
                while(groupValueIt.hasNext()){
                    Integer value = groupValueIt.next();
                    for(int i=0;i<topN.length;i++){
                        if (topN[i] == null){
                            topN[i] = value;
                            break;
                        }else if (value > topN[i]){
                            for (int j = 2;j>i;j--){
                                topN[j] = topN[j-1];
                            }
                            topN[i] = value;
                            break;
                        }
                    }
                }
                return new Tuple2<String,Iterable<Integer>>(groupKey, Arrays.asList(topN));
            }
        });

        topNGroupSort.foreach(new VoidFunction<Tuple2<String, Iterable<Integer>>>() {
            @Override
            public void call(Tuple2<String, Iterable<Integer>> stringIterableTuple2) throws Exception {
                System.out.println(stringIterableTuple2._1 + "==>" + stringIterableTuple2._2());
            }
        });
    }
}
