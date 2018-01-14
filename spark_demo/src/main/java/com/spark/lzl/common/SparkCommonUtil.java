package com.spark.lzl.common;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by lzl on 2018/1/14.
 */
public class SparkCommonUtil {

    public static JavaSparkContext getSparkContext(String name, String master){
        /**
         * 第一步:创建spark的配置对象SparkConf，设置spark程序运行时的配置信息，
         * setMaster设置程序要链接的spark集群的master的URL
         */
        SparkConf conf = new SparkConf().setAppName(name).setMaster(master);
        JavaSparkContext sc = new JavaSparkContext(conf);
        return sc;
    }
}
