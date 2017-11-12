#集合

##集合的创建

* 指定泛型的创建

通过`List[String]`方式来指定是`String`类型

	```
	def listType(): Unit ={
	    val listl : List[String] = List("A","B","C")
	    println(" list is ")
	    for (l <- listl)
	      print(" " + l)
	    //空的list
	    val empty : List[Nothing] = List()
	    println(" empty list is " + empty)
	    //二维列表
	    val dim : List[List[String]] = List(
	      List("A","B","C"),List("D","E","F"),List("G","H","I"))
	    println(dim.mkString(" "))
	  }
	```

* 使用`::`和`Nil`创建

以下是创建一维数组和二维数组的方式

	```
	def createTable(): Unit ={
	    val site = "scala" :: ("java" :: ("spark" :: Nil))
	      print("一维列表:"+site.mkString(","))
	    println()
	    val site2 = ("A" :: ("B" :: ("C" :: Nil))) ::
	                ("D" :: ("E" :: ("F" :: Nil))) ::
	                ("G" :: ("H" :: ("I" :: Nil)))
	    print("二维列表:"+site2.mkString(","))
	  }
	```

* 看看`::`的源码（只分析结构）

>  `(x: B)` 表示传入的类型是个泛型`B`

>  `[B >: A]` 表示传入一个泛型是继承自A的

>  `: List[B]` 表示返回值是`List[B]`的类型

	```
	def ::[B >: A] (x: B): List[B] =
	    new scala.collection.immutable.::(x, this)
	```

##集合的常用操作

* 输出

> `head` 输出集合的第一个元素

> `tail` 输出集合中除了第一个元素外的其他元素


> `isEmpty` 判断集合是否为空

	```
	 def basicList(): Unit ={
	    val sList = "Scala" :: ("Java" :: ("Spark" :: Nil));
	    val sNull = Nil
	    println("返回第一个元素:" + sList.head)
	    println("返回除了第一个元素外的所有元素:" + sList.tail)
	    println("是否是空集合:" + sNull.isEmpty)
	  }
	```

* 连接
 
这三个操作都是将两个集合拼接在一起。
> `:::`

> `.:::` 

> `concat` 


	```
	def concatList(): Unit ={
	    val sList = "Scala" :: ("Java" :: ("Spark" :: Nil))
	    val cList = "百度" :: ("阿里" :: ("腾讯" :: Nil))
	
	    println("使用:::函数连接" + (sList ::: cList))
	    //这种方式略有些不同
	    println("使用.:::方法连接" + sList.:::(cList))
	    println("使用Concat函数连接" + List.concat(sList,cList))
	
	  }
	```

* fill()

> 表示list重复列表
  第一个元素是重复的次数
  第二个元素是任意的重复字符

	```
	def fillList(): Unit ={
	    val fList = List.fill(3)("A","B")
	    println("fList:" + fList)
	  }
	```

* tabulate()

> TODO : 需要搞清楚语法和计算规则
	
	```
	def tabulateList(): Unit ={
	    // TODO 需要搞清楚语法和计算规则
	    val tList = List.tabulate(6)(b => b * b)
	    println("一维数组:" + tList)
	    val nList = List.tabulate(4,5)(_ * _)
	    println("二维数组:" + nList)
	  }
	```
* reverse()

> 将列表反转

	```
	def reversList(): Unit ={
	    val tList = List.tabulate(6)(b => b * b)
	    println("一维数组:" + tList)
	    println("reverse 以后:" + tList.reverse)
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
#Set集合

* set集合

> Set集合有可变集合和不可变集合，默认是用的是不可变集合。如果要使用可变集合需要导入`import scala.collection.mutable.Set`包。
> 不可变集合比可变集合多了一些(add,remove,+,-)操作。

* 可变set和不可变Set

	
	```
	def createSet(): Unit ={
	    val sSet = Set(1,2,3,4,5)
	    println("不可变set:" + sSet.mkString(","))
	    println("set的name:" + sSet.getClass.getName) //
	
	    println(sSet.exists(_ % 2 == 0)) //true
	    println(sSet.drop(1)) //Set(2,3)
	
	    println("set的name"+sSet.getClass.getName) //
	
	  }
	
	  /**
	    * 可变的set
	    */
	  def createUnSet(): Unit ={
	    import scala.collection.mutable.Set
	    val mutableSet = Set("A","B","C")
	    println(mutableSet.getClass.getName) // 返回 scala.collection.mutable.HashSet
	
	    mutableSet.add("D")
	    mutableSet.remove("A")
	    mutableSet += "F"
	    mutableSet -= "C"
	
	    println(mutableSet) // Set(B, F, D)
	
	    val another = mutableSet.toSet
	    println(another.getClass.getName) // scala.collection.immutable.Set$Set3
	
	  }
	```

* set集合常见的操作

> 主要包括set结合的连接、最大值最小值筛选、交集、差等

	```
	 def concatSet(): Unit ={
	    import scala.collection.mutable.Set
	    val set1 = Set("A","B","C")
	    val set2 = Set("AC","BC","CC")
	
	    val s1 = set1.++(set2)
	    val s2 = set1 ++ set2
	    println(".++ 连接后:" + s1)
	    println("++ 连接后:" + s2 + "\n")
	    //寻找最大值和最小值
	    println("寻找最大值和最小值")
	    println("最大值：" + s1.max)
	    println("最小值：" + s1.min + "\n")
	
	    //交集和差集
	    println("交集:" + s1.&(s2))
	    s2 -= "AC"
	    println("差集:" + s1.&~(s2))
	  }
	```