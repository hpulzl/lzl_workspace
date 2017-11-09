/**
  * Created by lzl on 2017/11/9.
  * scala的集合
  * 包括List、Set、Map等
  */
object ScalaForCollection {
  def main(args: Array[String]): Unit = {
//    listType()
    createTable()
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
    val site = "scala" :: ("java" :: ("spark" :: Nil)) ::
                "A" :: ("B" :: ("C" :: Nil))
      print(site.mkString(","))
    val empty = List
    print(empty)
  }
}
