
/**
  * Created by lzl on 2017/11/14.
  * scala函数编程进阶
  * 1. scala的函数可以赋值给一个变量
  * 2. 函数常用的是匿名函数。
  * 3. 函数可以作为参数进行传递，这样极大的简化编程的语法
  * 4. 函数式编程的返回值可以是函数，当scala的返回值是函数的时候，说明scala实现了函数的闭包
  *
  * 5. currying函数写法
  * scala的闭包理解如下：
  * scala中是类和对象，scala的参数都作为函数的成员，所以在scala的后续方法中可以继续访问。
  */
object ScalaForFunction {
  def main(args: Array[String]): Unit = {
    functionMethod_1()
    functionMethod_2()

    val say = (func:String)=>sayFun(func)
    getSay(say,"lzl")

    /**
      * 函数的闭包
      * currying函数写法
      */
    def getFunction(fu : String) = (fun : String) => sayFun(fu + " " + fun)
    getFunction("aaa")("bbbb")

    val result = getFunction("xxx ")
    result("MMM")
  }

  /**
    * 函数赋值给变量
    */
  def functionMethod_1(): Unit ={
    val hi = toPrint _
    hi("lzl")
  }

  /**
    * 匿名函数
    */
  def functionMethod_2(): Unit ={
    val f = (name:String) => toPrint(name)
    f("hh")
  }

  def toPrint(name : String): Unit ={
    println(" hello " + name)
  }

  def sayFun(fun : String): Unit ={
    println("sayFun:" + fun)
  }

  /**
    * 函数中传入一个参数
    * @param func
    * @param name
    */
  def getSay(func:String => Unit,name : String){
    func(name)
  }

}

