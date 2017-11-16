/**
  * @Author: li_zhilei
  * @Date: create in 11:46 17/11/16.
  * @description:scala的提取器
  * 1. apply类似于java类的构造方法，在伴生对象中可以创建不同的apply
  * 2. unapply接收一个对象，在对象中提取相应的值。
  */
object ScalaForExtractor {
  def main(args: Array[String]): Unit = {
    println("调用apply:" + apply("824","abc"))
    println("调用unapply:" + unapply("824__aaa"))
    println("调用unapply:" + unapply("824,aaa"))
  }
  def apply(prefix : String,suffix : String): String ={
    prefix + "__" + suffix
  }

  def unapply(arg: String): Option[(String,String)] ={
    val split = arg.split("__")
    if (split.length == 2){
      Some(split(0),split(1))
    }else{
      None
    }
  }
}

object MyExtractor{
  def main(args: Array[String]): Unit = {
    val x = MyExtractor(8)
    x match {
      case MyExtractor(x) => println("x = " + x)
      case _ => println("返回为空")
    }
  }

  def apply(x : Int) = x * 3

  def unapply(arg: Int): Option[Int] = {
    if (arg % 2 == 0){
      Some(arg)
    }else{
      None
    }
  }

  def unapply(str: String,arg:Int): Option[(String,Int)] ={
    if (arg % 2 == 0){
      Some(str,arg)
    }else{
      None
    }
  }
}
