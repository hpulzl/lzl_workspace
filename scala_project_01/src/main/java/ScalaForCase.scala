/**
  * @Author: li_zhilei
  * @Date: create in 17:13 17/11/15.
  * @description:
  *
  * scala的模式匹配
  * 1）模式匹配可以匹配固定类型的参数
  * 2）模式匹配也可以匹配任意类型的参数(Any)
  * 3）模式匹配可以匹配样例类
  * 1. 模式匹配作用于方法或函数上
  * 2. 模式匹配作用于类上-->样例类
  *
  */
object ScalaForCase {
  def main(args: Array[String]): Unit = {
    println("匹配字符串:" + matchStr(1))
    println("匹配字符串:" + matchStr(4))
    println("匹配任意类型:" + matchAny("A"))
    matchSample()
  }

  /**
    * match和case之间联合使用
    * `case 1 => "one"` 表示匹配为1，就返回one
    * @param x
    * @return
    */
  def matchStr(x : Int):String = x match {
    case 1 => "one"
    case 2 => "TWO"
    case _ => "more"
  }

  /**
    * 匹配任意类型的数据
    * @param x
    * @return
    */
  def matchAny(x : Any):Any = x match {
    case "A" => "A"
    case 'F' => 'F'
    case false => false
    case 4L => 4L
    case 3D => 3D
    case _ => None
  }

  /**
    * 匹配类对象
    */
  def matchSample(): Unit ={
    val pList = List(new Person("lzl","男"),new Person("hhh","男"),new Person("ggg","女"),new Person("mmm","女"))
    for (p <- pList){
      p match {
        case Person("lzl","男") => println("hi lzl!")
        case Person("hhh","男") => println("hi hhh!")
        case Person("ggg","女") => println("hi ggg!")
        case Person("mmm","女") => println("hi mmm!")
        case _ => print("hi None!")
      }
    }
  }

  /**
    * 样例类
    * @param name
    * @param sex
    */
  case class Person(name:String,sex:String)
}
