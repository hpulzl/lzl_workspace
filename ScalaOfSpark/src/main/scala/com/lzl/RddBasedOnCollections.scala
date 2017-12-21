package com.lzl

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by lzl on 2017/12/17.
  */
object RddBasedOnCollections {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf();
    conf.setMaster("local")
    conf.setAppName("RddBasedOnCollections")

    val sc = new SparkContext(conf)
    val numbers = 1 to 100
    val rdd = sc.parallelize(numbers) // 创建rdd
    val sum = rdd.reduce(_+_) //1-100求和
    println("1+2+3+...+99+100 = " + sum)
  }
}
