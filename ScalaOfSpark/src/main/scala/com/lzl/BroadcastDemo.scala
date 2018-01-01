package com.lzl

import org.apache.spark.SparkContext

/**
  * Created by lzl on 2018/1/1.
  * spark的广播机制
  * 1. 减少网络传输
  * 2. 运用于大字段的变量，避免每个task的拷贝来带来OOM
  *spark的累加器
  * 1. 累加器是集群内部全局共享的变量
  * 2. 记录全局唯一的状态，只增不减
  */
object BroadcastDemo {

  def main(args: Array[String]): Unit = {
    val sc = Transformations.createSc("broadcast","local")
    //创建一个广播变量的实例
    //createBroadCast(sc)
    createAccumulator(sc)
    sc.stop()
  }

  def createBroadCast(sc:SparkContext): Unit ={
    val broadcastNum = sc.broadcast(10) //创建一个广播变量
    val numbers = 1 to 100 //创建一个数组
    val rdd = sc.parallelize(numbers) //创建一个rdd
    val numResult = rdd.map(_ * broadcastNum.value) //数组中的变量* 广播变量的值 ==> broadcastNum.value获取广播变量的值
    numResult.collect.foreach(println)
  }

  def createAccumulator(sc:SparkContext): Unit ={
    val sum = sc.accumulator(0,"accu")
    val data = sc.parallelize(1 to 10)
    data.foreach(item => sum += item) //sum是累加器标志的值，累加第一次
    data.foreach(item => sum += item) //累加第二次
    println(sum)
  }
}
