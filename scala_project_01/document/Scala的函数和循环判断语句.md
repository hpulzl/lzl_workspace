#Scala的函数和循环判断语句
#前言
学习了scala和idea的整合，那么以后就用idea来练习scala的基本用法了。并且还可以通过idea的反编译来读取scala一些方法的内部实现，十分方便!
在了解scala的语言时，也十分有必要去学习scala的命名规则习惯、scala支持的类型、scala的运算符等操作，我是通过http://www.yiibai.com/scala/scala_functions.html来学习的。练习的代码在githubhttps://github.com/hpulzl/lzl_workspace/tree/master/scala_project_01上面。
那么接下来详细介绍一下scala的函数表达式和循环判断语句
#scala的函数表达式
* 一个main函数的表达
`def` 表示声明一个函数
`main(args: Array[String])` 函数的名称
`: Unit =` 表示返回值类型是 Unit（也就是空类型）
我们可以把这个理解为无返回值的方法,在Scala中不返回任何东西的函数称为过程。
```
def main(args: Array[String]): Unit = {
    println("A")
  }
```
* 无返回值的函数
`Unit=` 表示返回值是Unit，即没有返回值！
```
 def dataType(): Unit ={
    println("AnyRef is = " + AnyRef)
  }
  /**也可以这么表示。
  不用写Unit，scala会自动识别返回类型
  **/
   def dataType(){
    println("AnyRef is = " + AnyRef)
  }
```
* 带参数的无返回值函数（比较有意思的地方）
主要是调用方式有两种
第一种很好理解，`noReturn(1,"b")` 按照参数类型顺序来调用就可以了。
第二种，scala可以根据参数的名称来匹配参数类型，进行调用 。 例如`noReturn(b = "b",a = 1)` 传入参数按照函数的参数名称来匹配的。

```
//调用的地方
def main(args: Array[String]): Unit = {
   print(noReturn(b = "b",a = 1))
   print(noReturn(1,"b"))
  }
def hasReturn(a : Int,b : String):Unit = {
    println("带参数的Unit返回值类型函数: a = " + a + " b =" + b)
  }
```
* 传入多个相同类型参数的函数
用`*` 来标记多个相同类型的参数
```
def noReturn(strs : String*): Unit ={
    for (str <- strs){
      print(str)
    }
    println("传入相同类型数据的集合")
  }
```
* 有返回值类型的函数（不使用return）
不使用`return`，scala语法会根据最后的数据类型来返回数据。
```
def main(args: Array[String]): Unit = {
 /**
      * 调用的方式
      */
    print(hasReturn(age = 12,name = "a"))
    println(hasReturn("lzl",24))
}
def hasReturn(name: String, age: Int):String = {
    print("name is " + name + " age is " + age +"\n")
    //不用return
    name
  }
```
* 有返回值类型的函数（使用return）
可以不写返回值类型，scala语法会自动识别返回值类型。
```
 def returnString(a : String){
    return a
  }
```
* 匿名函数
以下是一个匿名函数，一个变量参数是`i`,返回值是一个隐式匹配，其实是一个`Int类型的数字`。
我们可以调用`println(multi(10))`方法来打印输出

```
var multiplier = (i :Int) => i * 10
```

以上是scala函数奇妙的语法表达式，当然在开发过程中，我们不可能使用那么多种神奇的表达方式，我们需要写的是按照规范，写清晰易懂的代码。但是以上的语法内容还是需要花费一点时间来领会的认识!

##scala的闭包
* 闭包简单的表示方式

使用的是匿名函数 + 外部变量。其中`factor `引用了外部`var factor = 3`的值。
闭包相当于就是函数引用外部变量的过程。

```
var factor = 3
  var multi = (i : Int) => i * factor
```

调用方式

```
println(multi(10))
结果打印 :30
```

* 再看一种表达

```
def closure(more : Int) = (i : Int)   => i + more

/**
调用部分
**/
var a = closure(10)
    println("a = " + a)
    println( " b = " + a(2))
```

**解释**

> 第一步: 调用`closure(10)`给more赋值，然后匿名函数中的more函数值为10，

> 第二步: 调用`a(2)`,i的值为2

> 最后: 打印结果

```
======scala的闭包=====
a = <function1>
 b = 12
```

#scala的循环判断语句
循环判断语句包括for、do While、while、if。下面是详细的代码展示

* if语句

可以看出if中的数据可以返回并赋值给b。
说明if也是一个函数式。
```
def ifType(): Unit ={
    var a = 10
    var b = if (a > 0){
      a
    }
    println("b =" +b)
  }
```
* for循环

顺序打印数据
```
    print("顺序打印:")
    for (num <- 1 to 10){
      print(num + " ")
    }
```
条件打印语句
```
    print("\n打印偶数:")
    for (num <- 1 to 10 if(num % 2 == 0)){
      print(num + " ")
    }
```
* while语句
包括简单的循环体，循环终止条件。
```
def whileType(): Unit ={
    var flag = true
    var num : Int = 0
    println("while 循环打印：")
    while (flag){
      num += 1
      print(" " + num)
      if (num == 10)
        flag = false
    }
  }
```
* break函数

终止循环。
通过`var loop = Breaks`方式获取loop对象，在循环体中调用`loop.break()`来跳出循环
```
def breakType(): Unit ={
    var loop = Breaks
    loop.breakable{
      for (num <- 1 to 10 if (num % 2 == 0)){
        print(" " + num)
        if(num == 10)
          loop.break()
      }
    }
  }
```
另一种表示方式，`var loop = Breaks`创建Breaks对象，在`loop.breakable{}`中，调用`loop.break()`方法。

```
def breakType(): Unit ={
var loop = Breaks
var num = 10
    while (num > 0){
      num -= 1
      print(" " + num)
      if (num == 4){
        loop.break()
      }
    }
}
```
> 两种调用break的方法有一些不同，直接调用`loop.break()`会抛出`Exception in thread "main" scala.util.control.BreakControl` 的异常
> 在`breakables`中调用`loop.break`方法不会抛出异常终止

从scala的源码中也可以看出这个端倪
```
def break(): Nothing = { throw breakException }
```
```
def breakable(op: => Unit) {
    try {
      op
    } catch {
      case ex: BreakControl =>
        if (ex ne breakException) throw ex
    }
  }
```