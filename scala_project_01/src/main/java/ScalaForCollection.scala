
/**
  * Created by lzl on 2017/11/9.
  * scala的集合
  * 包括List、Set、Map等
  */
object ScalaForCollection {
  def main(args: Array[String]): Unit = {
//    listType()
//    createTable()
//    basicList()
//    concatList()
//    fillList()
//    tabulateList()
//    reversList()

//    createSet()
//    createUnSet()
//    concatSet()


//    createMap()
//    basicMap()
    otherMap()

//    createTuple()
//    getOption()
//    optionType()
  }

  /**
    * 关于list集合的一些演示
    */
  def listType(): Unit ={
    val listl : List[String] = List("A","B","C")
    println(" list is ")
    for (l <- listl)
      print(" " + l)
    //空的list
    val empty : List[Nothing] = List()
    println(" empty list is " + empty)
    //二维列表
    val dim : List[List[String]] = List(
      List("A","B","C"),List("D","E","F"),List("G","H","I"))
    println(dim.mkString(" "))
  }

  /**
    * 使用 :: 方法创建数组
    * Nil 的概念
    *
    */
  def createTable(): Unit ={
    val site = "scala" :: ("java" :: ("spark" :: Nil))
      print("一维列表:"+site.mkString(","))
    println()
    val site2 = ("A" :: ("B" :: ("C" :: Nil))) ::
                ("D" :: ("E" :: ("F" :: Nil))) ::
                ("G" :: ("H" :: ("I" :: Nil)))
    print("二维列表:"+site2.mkString(","))
  }

  /**
    * 介绍scala的基本操作
    * head
    * tail
    * isEmpty
    */
  def basicList(): Unit ={
    val sList = "Scala" :: ("Java" :: ("Spark" :: Nil));
    val sNull = Nil
    println("返回第一个元素:" + sList.head)
    println("返回除了第一个元素外的所有元素:" + sList.tail)
    println("是否是空集合:" + sNull.isEmpty)
    println("" + sList.reverse)
  }

  /**
    * 集合的连接
    */
  def concatList(): List[String] ={
    val sList = "Scala" :: ("Java" :: ("Spark" :: Nil))
    val cList = "百度" :: ("阿里" :: ("腾讯" :: Nil))

    println("使用:::函数连接" + (sList ::: cList))
    //这种方式略有些不同
    println("使用.:::方法连接" + sList.:::(cList))
    println("使用Concat函数连接" + List.concat(sList,cList))

    sList
  }

  /**
    * 表示list重复列表
    * 第一个元素是重复的次数
    * 第二个元素是任意的重复字符
    */
  def fillList(): Unit ={
    val fList = List.fill(3)("A","B")

    println("fList:" + fList)
  }

  /**
    * 给定函数创建列表
    */
  def tabulateList(): Unit ={
    // TODO 需要搞清楚语法和计算规则
    val tList = List.tabulate(6)(b => b * b)
    println("一维数组:" + tList)
    val nList = List.tabulate(4,5)(_ * _)
    println("二维数组:" + nList)
  }

  def reversList(): Unit ={
    val tList = List.tabulate(6)(b => b * b)
    println("一维数组:" + tList)
    println("reverse 以后:" + tList.reverse)
  }

  /******************Set集合*********************/

  /**
    * 不可变的set
    *
    */
  def createSet(): Unit ={
    val sSet = Set(1,2,3,4,5)
    println("不可变set:" + sSet.mkString(","))
    println("set的name:" + sSet.getClass.getName) //

    println(sSet.exists(_ % 2 == 0)) //true
    println(sSet.drop(1)) //Set(2,3)

    println("set的name"+sSet.getClass.getName) //

  }

  /**
    * 可变的set
    * 可变集合比不可变集合多了一些操作方法例如 += -= add remove 等
    */
  def createUnSet(): Unit ={
    import scala.collection.mutable.Set
    val mutableSet = Set("A","B","C")
    println(mutableSet.getClass.getName) // 返回 scala.collection.mutable.HashSet

    mutableSet.add("D")
    mutableSet.remove("A")
    mutableSet += "F"
    mutableSet -= "C"

    println(mutableSet) // Set(B, F, D)

    val another = mutableSet.toSet
    println(another.getClass.getName) // scala.collection.immutable.Set$Set3

  }

  /**
    * set集合的连接
    */
  def concatSet(): Unit ={
    import scala.collection.mutable.Set
    val set1 = Set("A","B","C")
    val set2 = Set("AC","BC","CC")

    val s1 = set1.++(set2)
    val s2 = set1 ++ set2
    println(".++ 连接后:" + s1)
    println("++ 连接后:" + s2 + "\n")
    //寻找最大值和最小值
    println("寻找最大值和最小值")
    println("最大值：" + s1.max)
    println("最小值：" + s1.min + "\n")

    //交集和差集
    println("交集:" + s1.&(s2))
    s2 -= "AC"
    println("差集:" + s1.&~(s2))
  }

  /******************Map集合*********************/
  /**
    * map也分为可变map和不可变map，默认使用的不可变map。
    * 使用可变map时候可以导入 import scala.collection.mutable.Map。
    * 导入之后可以用mutable.Map来表示可变map
    */
  def createMap(): Unit ={
    import scala.collection.mutable
    val map = Map("A" -> 1,"B" -> 2,"c" -> 3)
    val mutableMap = mutable.Map("A" -> 1,"B" -> 2,"c" -> 3)

    mutableMap += "D" -> 4
    mutableMap += "E" -> 5
    mutableMap -= "C"
    mutableMap.put("FF",33)
    mutableMap.remove("G")
    println(map.mkString(","))
    println(mutableMap.mkString(","))
  }

  /**
    * map的基本操作
    */
  def basicMap(): Unit ={
    import scala.collection.mutable
    val map = Map("A" -> 1,"B" -> 2,"c" -> 3)
    val mutableMap = mutable.Map("A" -> 1,"B" -> 2,"c" -> 3)
    val mutableMap2 = mutable.Map("A" -> 1,"B" -> 2,"c" -> 3)

    println("keys :" + map.keys)
    println("values :" + map.values)
    println("isEmpty :" + mutableMap.isEmpty)

    //是否存再key
    println("是否存在B:" + mutableMap.contains("B") + " is " + mutableMap("B"))
    // mutableMap没有此方法
    val map2 = Map("AA" -> 1,"B" -> 2,"cC" -> 3)
    val maps = map ++ map2
    println("合并:" + maps)

    /**
      * 打印
      */
    maps.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + maps(i) )}
    //增强for循环遍历
    for((key,value) <- map) println("key = " + key + " value = " + value)

    for(keys <- map.keySet) println("key = " + keys)

    for(values <- map.values) println("values = " + values)

  }

  /**
    * 其他map的具体实现了    */
  def otherMap(): Unit ={
    /**
      * 按照key的字母顺序排序
      */
    val map = scala.collection.immutable.SortedMap("java" -> 23,"scala" -> 13,"python" -> 10)
    for((key,value) <- map) println("key = " + key + " value = " + value)
    val linkedMap = scala.collection.mutable.LinkedHashMap("HHH" -> "name","BBB" -> "age","FFF" -> "sex")
    for((key,value) <- linkedMap) println("key = " + key + " value = " + value)
  }

  /******************元组*********************/
  /**
    * 1. 元组与其他集合的区别在于，一个元组中可以存放不同类型的元素.
    * 2. 元组也是不可变的
    */
  def createTuple(): Unit ={

    /**
      * Tuple2和Tuple3...等的区别
      * tuple2可以存放两个元素
      * tuple3可以存放三个元素
      * 最多可以存放22个元素
      * Tuple1 可以是1-22个元素中的任意一个或多个
      * Tuple22 只能是22个元素
      */
    val t = (1,2.3,"hhh",10L,2.333,'f',"d","fd")
    print("元组创建方式一:" + t + "\n")

    val tuple1 = Tuple1(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22)
    val tuple1_1 = Tuple1(("A","B"),'A','b')
    print("创建方式二:"+tuple1 + "\n")
    print("创建方式二:"+tuple1_1 + "\n")
    val tuple2 = Tuple2(1,'s')
    print("创建方式三:"+tuple2 + "\n")
    val tuple6 = Tuple6(('G',"DD",1,3D,'d',30L,"S"),('F',"d",9.0F),"sss","s",1,Console)
    print("创建方式四:"+tuple6 + "\n")
    val tuple22 = Tuple22(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22)
    print("创建方式四:"+tuple6 + "\n")

    //访问元素
    print("获得元素:" + t._1 + t._2 + t._6 + tuple1._1._3 + "\n")
    tuple1.productIterator.foreach(i => print(" " + i))
    println()
    //元组转换字符串
    print("元组转换字符串：" + tuple6.toString() + "\n")
    //元组元素交换(两个元素才能交换)
    print("元组元素交换："+tuple2.swap + "\n")
  }
  /******************option选项*********************/

  /**
    * 表示返回值是可选的，如果返回值不为空，那就会返回Some，并匹配其类型。
    * 如果返回值为空，就会返回None。
    * 主要用于不确定是否有返回值的方法中
    */

  def getOption(): Unit ={
    //定义map的key和value都为string
    val map:Map[String,String] = Map("A"->"hhh","B"->"XXX","C"->"LLL")
    val a: Option[String] = map.get("A")
    val b : Option[String] = map.get("F")

    print("获取a:" + a + "\n")
    print("获取b,获取不到返回Node:" + b + "\n")
    print("使用模式匹配来获取值一:" + showType(map.get("C")) + "\n")
    print("使用模式匹配来获取值二:" + showType(map.get("F")) + "\n")
    //传入类型必须是Option类型
    print("使用模式匹配来获取值二:" + showType(Some("A")) + "\n")

  }
  def showType(i : Option[String]) = i match {
    case Some(s) => s
    case None => "Null"
  }
  def optionType(): Unit ={
    val a : Option[String] = Some("A")
    val b : Option[Int] = None

    //如果为空返回输入的默认值；如果不为空，返回值
    println("返回A: " + a.getOrElse(1) )
    println("返回1: " + b.getOrElse(1) )
    println("b.isEmpty为true: " + b.isEmpty )
    println("b.orNull为null: " + b.orNull + "\n a.orNull为A：" + a.orNull)
  }

}
