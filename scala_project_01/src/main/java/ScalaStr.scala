/**
  * @Author: li_zhilei
  * @Date: create in 10:59 17/11/9.
  * @description:scala的字符串String
  */
object ScalaStr {
  def main(args: Array[String]): Unit = {
    strDemo()
    strBufferDemo()
  }

  /**
    * string字符串 其实是直接引用java.lang.String的API，所以掌握java的String字符串就基本没有问题了
    *
    */
  def strDemo(): Unit ={
    var name = "scala"
    var name_s : String = "scala in JVM"
    print("length is " + name.length + "\n")
    var str = name_s.split(" ")
    println("split is ")
    for (s <- str){
      print(s + ",")
    }
  }

  /**
    * 创建StringBuffer
    */
  def strBufferDemo(): Unit ={
    var name = new StringBuffer()
    name.append("a" + " ")
    name.append("b")
    println("sb is " + name.toString)
  }
}
