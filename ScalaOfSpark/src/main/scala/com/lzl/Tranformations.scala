package com.lzl

import org.apache.spark.{SparkConf, SparkContext}

/**spark transformation的案例实战
  * Created by lzl on 2017/12/24.
  */
object Transformations {
  def main(args: Array[String]): Unit = {
    val sc = createSc("transformation","local") //创建sparkContext
//    mapped(sc) //打印mapped信息
//    flatMapTransformation(sc) //打印数组信息
//    groupByKeyTransformation(sc) //分组计算
//    reduceByKeyTransformation(sc) //单词统计
//    joinTransformation(sc) //join操作
    cogroupTransformation(sc) //cogroup操作
    sc.stop()
  }

  def createSc(name:String,master:String): SparkContext ={
    val conf = new SparkConf().setAppName(name).setMaster(master) //设置sparkConf的配置信息
    val sc = new SparkContext(conf) //创建SparkContext，这是创建RDD的通道，是Driver的灵魂，是通往集群的唯一通道
    sc
  }

  def mapped(sc: SparkContext): Unit ={
    val nums = sc.parallelize(1 to 10) //创建基于数组的RDD
    val mapped = nums.map(item => 2 * item) //对数组进行map操作。这里的意思是每个元素扩大2倍
    mapped.collect.foreach(println) //打印mapped中的元素，collect可以适用于集群中
    val filter = nums.filter(line => line%2==0) //过滤出x%2==0的数据
    filter.collect.foreach(println)
  }

  def flatMapTransformation(sc:SparkContext): Unit ={
    val arrays = Array("hello 2017","bye 2017","hi 2018","hope 2018")
    val bigDataString = sc.parallelize(arrays) //创建基于数组的RDD
    val words = bigDataString.flatMap(line => line.split(" "))
    words.collect.foreach(println)
  }
  def groupByKeyTransformation(sc:SparkContext): Unit ={
    val arrays = Array(Tuple2(100,"Spark"),Tuple2(90,"Tachyon"),Tuple2(73,"hadoop"),Tuple2(90,"HBase"),Tuple2(73,"Java"))
    val rdd = sc.parallelize(arrays) //创建RDD
//    val sortMap = rdd.sortBy(key => key._1) //通过tuple_1的值来进行升序排序
//    sortMap.collect.foreach(println)
    val groupMap = rdd.groupByKey() //按照key来分组
    val sortGroupMap = groupMap.sortByKey() //按照key排序
    sortGroupMap.collect.foreach(println)
  }
  def reduceByKeyTransformation(sc:SparkContext): Unit ={
    val textFile = sc.textFile("F:\\Program Files (x86)\\lzl_workspace\\ScalaOfSpark\\src\\main\\scala\\com\\lzl\\helloSpark.txt") //从磁盘中取出文件
    val words = textFile.flatMap(line => line.split(" ")) //对单词进行划分
    val pairs = words.map(word => (word,1)) //对每个基础划分的单词设置初始值为1
    val wordCount = pairs.reduceByKey(_+_) //对单词进行统计
    wordCount.collect.foreach(wordCountPair => println(wordCountPair._1 + ":" + wordCountPair._2))
  }

  /**
    * join会将相同的数据id进行合并
    * @param sc
    */
  def joinTransformation(sc:SparkContext): Unit ={
    val studentName = Array(Tuple2(1,"lzl"),Tuple2(2,"zdh"),Tuple2(3,"mlj"),Tuple2(4,"ht"))
    val studentScore = Array(Tuple2(1,89.2),Tuple2(2,34.2),Tuple2(3,100),Tuple2(4,50)
    ,Tuple2(1,50.2),Tuple2(2,60.2),Tuple2(3,70),Tuple2(4,80))
    val studentNameRDD = sc.parallelize(studentName)
    val studentScoreRDD = sc.parallelize(studentScore)
    val studentNameAndScore = studentNameRDD.join(studentScoreRDD)
    for (elem <- studentNameAndScore.collect) {
      println(elem)
    }
  }

  /**
    * 合并并且组合
    * @param sc
    */
  def cogroupTransformation(sc:SparkContext): Unit ={
    val studentName = Array(Tuple2(1,"lzl"),Tuple2(2,"zdh"),Tuple2(3,"mlj"),Tuple2(4,"ht"))
    val studentScore = Array(Tuple2(1,89.2),Tuple2(2,34.2),Tuple2(3,100),Tuple2(4,50)
      ,Tuple2(1,50.2),Tuple2(2,60.2),Tuple2(3,70),Tuple2(4,80))
    val studentNameRDD = sc.parallelize(studentName)
    val studentScoreRDD = sc.parallelize(studentScore)
    val studentNameAndScore = studentNameRDD.cogroup(studentScoreRDD)
    for (elem <- studentNameAndScore.collect) {
      println(elem)
    }
  }
}
