
/**
  * @Author: li_zhilei
  * @Date: create in 15:21 17/11/16.
  * @description:scala的IO操作
  * 1. scala可以直接使用javaIO的API来操作
  * 2.
  */
object ScalaForIO {
  def main(args: Array[String]): Unit = {
    printWriter()
    inputByConsole()
    readSource()
  }

  def printWriter(): Unit ={
    import java.io._
    val pw = new PrintWriter(new File("lzl.text"))
    pw.write("I am sorry,I will go")
//    println("你输入的内容是:" + line)

  }

  def inputByConsole(): Unit ={
    val line = Console.readLine()
    println("你输入的内容是:" + line)
  }

  def readSource(): Unit ={
    import scala.io.Source
    Source.fromFile("/Users/vobile_lzl/lzl_workspace/scala_project_01/src/main/java/111.txt").foreach{
      print
    }
  }
}
