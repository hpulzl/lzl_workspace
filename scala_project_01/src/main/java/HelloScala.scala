import scala.util.control.Breaks
import scala.xml.Null

/**
  * @Author: li_zhilei
  * @Date: create in 18:13 17/11/7.
  * @description:
  */
object HelloScala {
  def main(args: Array[String]): Unit = {
    println("有返回值的函数")
    /**
      * 调用的方式
      */
    print(hasReturn(age = 12,name = "a"))
    println(hasReturn("lzl",24))
    print(noReturn(b = "b",a = 1))
    print(noReturn(1,"b"))
    print(noReturn("a","b","c"))
    print("===========" + returnString("aaaab"))
    println("======scala数据类型====")
    dataType()
    println("======scala变量声明====")
    varStatement()
    println("======scala运算符=====")
    relationOperator()
    println("======scala循环语句=======")
    loopType()
  }

  def noReturn(strs : String*): Unit ={
    for (str <- strs){
      print(str)
    }
    println("传入相同类型数据的集合")
  }
  def noReturn(a : Int,b : String):Unit = {
    println("带参数的Unit返回值类型函数: a = " + a + " b =" + b)
  }

  def returnString(a : String){
    return a
  }
  /**
    * 有返回值的函数
    * @param name
    * @param age
    * @return
    */
  def hasReturn(name: String, age: Int):String = {
    print("name is " + name + " age is " + age +"\n")
    //不用return
    name
  }

  /**
    * 数据类型
    * scala中没有基本数据类型，它是纯面向对象的语言。
    * 可以对应的数据类型包括
    * 这里介绍一下java中没有而scala中有的并说明
    * Unit 类似于java中的void
    * Null 空引用
    * Nothing
    * Any 任何类型的超类型; 任何对象的类型为Any
    * AnyRef 	任何引用类型的超类型
    *
    */
  // TODO: 这里暂时证明不了，后期了解
  def dataType(): Unit ={
    println("Null is =" +Null.toString())
//    println("Any is = " + Any)
//    println("Nothing is = " + new Nothing())
    println("AnyRef is = " + AnyRef)
  }

  /**
    * 变量声明
    * var 可变变量
    * val 不可变变量
    */
  def varStatement(): Unit ={
    var name : String = "lzl"
    val sex : Int = 1
    var hl = "fjdks"

    println(" name is " + name)
    println(" sex is " + sex)
    println(" hl is " + hl)
    //多个赋值
    val (myVar1: Int, myVar2: String) = Pair(40, "Foo")
    println("myVar1 is " + myVar1 + " myVar2 is " + myVar2 )
    //这种表达方式会出错
//    println(" sex is " + (sex = sex + 1))
  }
  /**
    * scala支持的运算符
    * def 表示函数的开始
    * relationOperator() 函数名
    * Unit 表示返回的参数为空
    * 算数运算符
    * + - * / %
    * 关系运算符
    * >= <= > != ==
    * 逻辑运算符
    * && || !
    * 位运算符
    * ~ 取反 （计算方式讲解:http://www.cnblogs.com/shy1766IT/p/6184874.html）
    * & 按位与
    * | 按位或
    * ^ 异或
    * << 左移操作符
    * >> 右移操作符
    * 赋值运算符
    * = += -= *= /= %=
    * <<= >>= &= ^= |=
    */
  def relationOperator(): Unit ={
    var a = false
    var b = true
    var x = 5
    var y = -10
    println("====逻辑运算符=====")
    println("a && b = " + (a && b))
    println("a || b = " + (a || b))
    println("!a = " + !a)
    println("====位运算符=====")
    println("~x(1000)" + (~x))
    println("x(1000) & y(0010)" + (x & y))
    println("x(1000) | y(0010)" + (x | y))
    println("x(1000) ^ y(0010)" + (x ^ y))
    println("x << 2 = " + (x << 2))
    println("y >> 5 = " + (y >> 5))
    //无符号右移
    println("y >>> 5 = " + (y >>> 5))
    println("====赋值运算符====")
    x <<= 2
    println("x <<= 2 = " + x)
    x >>= 2
    println("x >>= 2 = " + x)
    x &= 2
    println("x &= 2 = " + x)
    x |= 2
    println("x |= 2 = " + x)
    x ^= 2
    println("x ^= 2 = " + x)
  }

  /**
    * 循环语句
    * for while do{}while
    * 循环终止
    * break
    */
  def loopType(): Unit ={
    print("顺序打印:")
    for (num <- 1 to 10){
      print(num + " ")
    }
    print("\n打印偶数:")
    /**
      * for循环中可以判断循环条件
      */
    for (num <- 1 to 10 if(num % 2 == 0)){
      print(num + " ")
    }
    println("\nwhile 循环:")
    /**
      * break不是一个关键字了，需要创建出对象才行
      */
    var loop = new Breaks
    var num = 1
    while(num < 10){
      num += 1
      print(num + " ")
      if (num == 5)
        loop.break()
    }

  }
}
