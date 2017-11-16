package other

/**
  * Created by lzl on 2017/11/16.
   scala中implicit的关键字讲解
  * 1. implicit叫做隐式转换
  * 1) 可以作用于函数中，可以隐式调用其他类中的方法
  * 2) 可以作用于参数上，相当于一个默认值
  */
class Study(val subject:String)

//object Study{
//  implicit def study2Scala(stu : Study) = new ScalaStudy(stu.subject)
//}

object implicitObj{
  implicit def study2Scala(stu : Study) = new ScalaStudy(stu.subject)
}
class ScalaStudy(sub:String){
  def study{
    println("I am learning " + sub)
  }
}

object ScalaForImplicit {
  def main(args: Array[String]): Unit = {
//    val study = new Study("scala")
    //可以调用ScalaStudy中的方法
//    study.study

    //导入implicit中的内容
    import other.implicitObj._
    val study = new Study("java")
    study.study

    implicit val aaa = "hhhh"
    blog("http:csdn.com")
  }

  def blog(path:String)(implicit author:String) = println("path is " + path + " author is " + author)
}
