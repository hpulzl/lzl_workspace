/**
  * @Author: li_zhilei
  * @Date: create in 15:13 17/11/14.
  * @description:伴生对象
  * 1. class ScalaForCompanion 和 object ScalaForCompanion名必须一致
  * 2. object ScalaForCompanion叫做class ScalaForCompanion的伴生对象
  * 3. class ScalaForCompanion叫做object ScalaForCompanion的伴生类
  * 4. 伴生对象可以访问类的私有属性和方法
  * 5. 伴生对象中的apply用来创建出类的实例，可以设置不同的构造函数
  */
class ScalaForCompanion private(name : String) {
  private val sex : Boolean = false
  private val age : Int = 2

  private def convertBySex(boolean: Boolean): String ={
    var sexStr = "女"
    if (boolean == true){
      sexStr = "男"
    }
    sexStr
  }

  override def toString: String = {
    val str = "name: " + name + " age:" + age + " sex:" + convertBySex(sex)
    str
  }
}
object ScalaForCompanion{
  val forCompanion = ScalaForCompanion
  /**
    *
    * @param name
    * @return
    */
  def apply(name: String): ScalaForCompanion = new ScalaForCompanion(name)
  def apply(name: String,age:Int): ScalaForCompanion ={
    val scalaForCom = new ScalaForCompanion(name)
    //可以访问到私有的变量
    val scalaForCom.age = age
    scalaForCom
  }

  def getInfo(name:String ,sex:Boolean): String ={
    val scalaForCom = apply(name)
    //可以访问私有方法
    val sexs = scalaForCom.convertBySex(sex)
    val info = "name = " + name + " sex = " + sexs
    info
  }

  def main(args: Array[String]): Unit = {
    //使用伴生对象
    print(getInfo("lll",true) + "\n")
    val scalaForCompanion = ScalaForCompanion.apply("lzl")
    print(scalaForCompanion)
  }
}
