/**
  * @Author: li_zhilei
  * @Date: create in 13:59 17/11/14.
  * @description:scala的类和对象
  */
class ScalaForOOP {
  /**
    * 1. 一个scala源文件中可以有多个class修饰的类。
    * 2. 可以使用new关键字实例化对象
    * 3. 与java不同的是，class中可以传递参数，叫做类参数；它作用于整个类
    */
}

class Person(name : String , age : Int){
  var pName = name;
  private var pAge = age;

  def printP(): Unit ={
    print("pName:" + pName + " pAge:" + pAge + "\n")
  }
  def sayHello: Unit ={
    println("say Hello !")
  }
}

object Test{
  def main(args: Array[String]): Unit = {
    usePersonPrint()
        useWorkerPrint()
  }

  def usePersonPrint(): Unit ={
    var person = new Person("lzl",24)
    person.printP
  }

  def useWorkerPrint(): Unit ={
    var worker = new Worker("ll",22,false)
    worker.printP()
    worker.printByWorker()
    worker.sayHello
    println("pName = " + worker.pName)
  }
}

/**
  * 类的继承
  * 1. 子类复写父类的方法必须使用override
  * 2. scala只支持单继承
  * 3. 子类继承父类，可以拥有所有private修饰除外的属性和方法
  */
class Worker(val name: String, val age : Int,sex : Boolean) extends Person(name,age){

  override def printP(): Unit = super.printP()

  def printByWorker(): Unit ={
    val str = if(sex == false){
      "女"
    }else{
      "男"
    }
    print("pName:" + pName + " pAge:" + age + " 性别:" + str)
  }
}
