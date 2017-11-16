/**
  * @Author: li_zhilei
  * @Date: create in 10:45 17/11/16.
  * @description:scala的正则表达式
  */
object ScalaForRegex {
  def main(args: Array[String]): Unit = {
    patternStr()
  }

  def patternStr(): Unit ={
    //创建一个Regex类
    val pattern = "scala".r
    val str = "scala is ok,scala to spark"
    println("正则表达式一:" + (pattern findFirstIn  str))
    println("正则表达式二:" + pattern.findFirstIn(str))
    println("正则表达式三:" + pattern.findAllIn(str).mkString(","))

    //匹配大小写开头的`java`
    val pt = "(J|j)ava".r
    val s = "Java is ok,java to spark"
    println("正则表达式四:" + pt.replaceAllIn(s,"scala"))
  }
}
