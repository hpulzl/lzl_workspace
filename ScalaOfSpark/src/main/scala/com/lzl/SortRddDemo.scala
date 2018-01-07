package com.lzl

import org.apache.spark.SparkContext

/**
  * Created by lzl on 2018/1/7.
  * rdd排序算法实例
  */
object SortRddDemo {
  def main(args: Array[String]): Unit = {
    val sc = Transformations.createSc("sortRdd","local")
//    sortByCountDesc(sc)
    secondarySort(sc)
    sc.stop()
  }

  /**
    * 根据单词出现的次数来进行从高到低的排序
    */
  def sortByCountDesc(sc:SparkContext): Unit ={
    val fileRdd = sc.textFile("F:\\Program Files (x86)\\lzl_workspace\\spark_demo\\src\\main\\helloSpark.txt")
    val map = fileRdd.flatMap(_.split(" ")).map(word=>(word,1)) //将文件系统中的单词封装成map，并给其value初始化为1
    val reduceMap = map.reduceByKey(_+_,1)
    val pairMap = reduceMap.map(pair =>(pair._2,pair._1))
    val sortResult = pairMap.sortByKey(false).map(pair=>(pair._2,pair._1))
    sortResult.collect.foreach(println)
  }

  def secondarySort(sc:SparkContext): Unit ={
    val secondSortRdd = sc.textFile("F:\\Program Files (x86)\\lzl_workspace\\ScalaOfSpark\\src\\main\\scala\\com\\lzl\\secondSort.txt")
    //将其封装成SecondSortKey的结构
    val secondSortKey = secondSortRdd.map(line =>(
    new SecondSortKey(line.split(" ")(0).toInt,line.split(" ")(1).toInt),line
    ))
    //设置为降序排序
    val sortedByKey = secondSortKey.sortByKey(false)
    //去掉sortedByKey中的key值
    val sortedResult = sortedByKey.map(sortedLine => sortedLine._2)
    sortedResult.collect().foreach(println)
  }
}
