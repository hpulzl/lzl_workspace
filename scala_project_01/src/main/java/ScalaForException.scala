
/**
  * @Author: li_zhilei
  * @Date: create in 11:13 17/11/16.
  * @description:scala的异常处理
  * 1. scala的异常处理与java中是类似的，当抛出异常后，会终止程序的执行
  * 2. scala中的异常处理使用模式匹配的思想来匹配异常类型的
  */
object ScalaForException {
  def main(args: Array[String]): Unit = {
//    throwException
    getFile("in.txt")
  }

  /**
    * 直接抛出异常
    * @return
    */
  def throwException = throw new IllegalArgumentException

  /**
    * 捕获异常
    * 执行finally方法
    * @param path
    */
  def getFile(path : String): Unit ={
    import java.io._
    try{
      val file = new FileReader(path)
    }catch {
      case ex: FileNotFoundException =>{
        println("抛出FileNotFoundException异常 " + ex)
      }
      case ex : IOException =>{
        println("抛出IOException异常" + ex)
      }
    }finally {
      println("exit...")
    }

  }
}
