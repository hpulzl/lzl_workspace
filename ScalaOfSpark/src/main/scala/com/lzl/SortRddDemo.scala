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
    //secondarySort(sc)
    getTopN(sc)
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

  /**
    * 按照数组排序，获取前n个数据
    * @param sc
    */
  def getTopN(sc:SparkContext): Unit ={
    val arr = Array(4,3,2,10,5,30,40,3,2,80,80,80)
    val arrRDD = sc.parallelize(arr)
    val arrMap = arrRDD.map(line => (line,line)) //将数组转换成Map集合
    val sortMap = arrMap.sortByKey(false) //按照key值降序排序
    val sortedData = sortMap.map(pair => pair._2) //过滤出排序的内容
    val top5 = sortedData.take(5) //获取前五个元素
    top5.foreach(println)
  }
}
