#Scala数组和集合
#数组
## 数组的创建和赋值
* 声明类型

> 1. 数组必须用val来修饰，表示不可变的数组
> 2. `new Array[String](10)` 是用来创建一个String类型的数组，并开辟长度为10的空间
> 3. arrays(0)给第0个元素赋值

```
 println("打印一串数组，声明其类型，方式一:")
    //@1 创建方式一
    val arrays = new Array[String](10)
    arrays(0) = "A"
    arrays(1) = "B"
    for (item <- arrays) print(" " + item)
```
* 不声明类型

> 1. scala会根据赋值类型自动推倒类型。
> 2. `Array(1,2,3,4,5)`来直接给数组赋值

```
println("打印一串数组，自动推到类型，方式二:" + "\n")
    val arrays2 = Array(1,2,3,4,5)
    for (item <- arrays2) print(" " + item)
```
* 直接用applay赋值

```
println("打印一串数组，使用apply创建数组，方式二:" + "\n")
    val arrays3 = Array.apply("scala","Spark","kafka")
    for (item <- arrays3) print(" " + item)
```

##多维数组

* 创建二维数组

1. `Array._`是导入Array下面的所有包
2. 使用`ofDim[Int](3,3)`创建二维数组

```
def manyArray(): Unit ={
    /**
      * 导入包
      */
    import Array._
    var array = ofDim[Int](3,3)
    var value=0
    for (i <- 0 to 2){
      for (j <- 0 to 2){
        array(i)(j) = value;
        value += 1
      }
    }

    println("二维数组打印:")
    for (arr <- array){
      for (a <- arr){
        print(" " + a)
      }
    }
  }
```
* 查看`ofDim`源码

> 1. 仔细阅读以下源码，实现多维数组也就是数组里面套数组。
例如二维数组用`new Array[Array[T]]`表示，三维数组用`Array[Array[Array[T]]]`表示。
> 2. 五维数组的实现是调用`tabulate(n1)(_ => ofDim[T](n2, n3, n4, n5))`方法来获取四维数组，四维数组同样调用`tabulate(n1)(_ => ofDim[T](n2, n3, n4))`获取三维数组，这里使用了一个递归的思想。最后二维数组返回`arr`

```
//二维数组
def ofDim[T: ClassTag](n1: Int, n2: Int): Array[Array[T]] = {
    val arr: Array[Array[T]] = (new Array[Array[T]](n1): Array[Array[T]])
    for (i <- 0 until n1) arr(i) = new Array[T](n2)
    arr
    // tabulate(n1)(_ => ofDim[T](n2))
  }
 //三维数组
   def ofDim[T: ClassTag](n1: Int, n2: Int, n3: Int): Array[Array[Array[T]]] =
    tabulate(n1)(_ => ofDim[T](n2, n3))
 //四维数组
  def ofDim[T: ClassTag](n1: Int, n2: Int, n3: Int, n4: Int): Array[Array[Array[Array[T]]]] =
    tabulate(n1)(_ => ofDim[T](n2, n3, n4))
  //五维数组
  def ofDim[T: ClassTag](n1: Int, n2: Int, n3: Int, n4: Int, n5: Int): Array[Array[Array[Array[Array[T]]]]] =
    tabulate(n1)(_ => ofDim[T](n2, n3, n4, n5))
```
## 数组其他使用

* concat函数

可以将两个数组合并在一起。

```
println("concat 组合数组：")
    var arry1 = Array(1,2,3)
    var arry2 = Array(4,5,6)
    var arry3 = concat(arry1,arry2)
    for (arr <- arry3)
      print(" " + arr)
```

* range函数

> 1. 可以设置数组的开始大小和结束大小，并设置数组的步长。
> 例如`range(10,20,2)`: 打印一个数组开始为10，结束为20，步长为2的数组。
> 2. 步长不能为0。

```
def rangeArray(): Unit ={
    import Array._
    val array1 = range(10,20,2)
    val array2 = range(200,10)

    println("range step = 2 打印:")
    for (arr <- array1)
      print(" " + arr)

    println()
    println("range step = 1 打印:")
    for (arr <- array2)
      print(" " + arr)
  }
```
* fill函数

返回一个数组长度为10的数组，数组每个值为2

```
def fillArray(): Unit ={
    val array = Array.fill(10)(3)
    for (arr <- array)
      print(" " + arr)
  }
```
#集合



