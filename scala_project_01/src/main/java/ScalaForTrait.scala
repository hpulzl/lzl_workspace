/**
  * Created by lzl on 2017/11/14.
  * scala的面向接口编程
  * 1. trait 支持多重继承,使用extends和with的方式
  * 2. 可以定义属性和方法的实现
  * 3. scala的类支持单继承，trait可以继承多个。
  * 3. trait可和with混入到类中
  */
trait ScalaForTrait {
  /**
    * 抽象的方法，返回字符串是否相等
    * @param name
    * @return
    */
  def isStr(name: Any) : Boolean

  /**
    * 具体方法。
    * @param name
    * @return
    */
  def isNotStr(name: Any): Boolean = !isStr(name)
}

class InstanceScalaTrait(str : String) extends ScalaForTrait{
  override def isStr(obj: Any): Boolean = {
    obj.equals(str)
  }
}

object TraitTest{
  def main(args: Array[String]): Unit = {
    var ins = new InstanceScalaTrait("hhh")
    print("isStr result:" + ins.isStr("hhh"))
    print("isNotStr result:" + ins.isNotStr("hhh"))
  }
}
