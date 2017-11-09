
/**
  * Created by lzl on 2017/11/8.
  * scala支持的数组的一些操作
  */
object ScalaForArray {
  def main(args: Array[String]): Unit = {
//    println("====创建数组====")
//    createArray()
//    arrayFirst()
//    println("====多维数组演示====")
//    manyArray()
//    println("====range数组演示====")
//    rangeArray()
    println("====fill数组演示====")
    fillArray()
  }

  /**
    * 多维数组
    */
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
    println()
    var arrayThree = ofDim[Int](3,3,4)
    for (x <- 0 to 2){
      for (y <- 0 to 2){
        for (z <- 0 to 3){
          arrayThree(x)(y)(z) = value
          value += 1
        }
      }
    }
    println("打印三维数组:")
    for (arrx <- arrayThree){
      for (arry <- arrx){
        for (arrz <- arry){
          print(" " + arrz)
        }
      }
    }
    println()
    println("concat 组合数组：")
    var arry1 = Array(1,2,3)
    var arry2 = Array(4,5,6)
    var arry3 = concat(arry1,arry2)
    for (arr <- arry3)
      print(" " + arr)
  }

  def rangeArray(): Unit ={
    import Array._
    val array1 = range(10,19,2)
    val array2 = range(200,10)

    println("range step = 2 打印:")
    for (arr <- array1)
      print(" " + arr)

    println()
    println("range step = 1 打印:")
    for (arr <- array2)
      print(" " + arr)
  }
  def fillArray(): Unit ={
    /**
      * 返回一个数组长度为10的数组，数组每个值为2
      */
    val array = Array.fill(10)(3)
    for (arr <- array)
      print(" " + arr)
  }
  /**
    * 1. 数组必须用val来修饰，表示不可变的数组
    * 2. `new Array[String](10)` 是用来创建一个String类型的数组，并开辟长度为10的空间
    */
  def createArray(): Unit ={
    var arrays = new Array[String](10)
    for (a <- arrays)
      print(a+" ")
    var array2 = Array


  }

  def arrayFirst(): Unit ={
    println("打印一串数组，声明其类型，方式一:")
    //@1 创建方式一
    val arrays = new Array[String](10)
    arrays(0) = "A"
    arrays(1) = "B"
    for (item <- arrays) print(" " + item)

    println("打印一串数组，自动推到类型，方式二:" + "\n")
    val arrays2 = Array(1,2,3,4,5)
    for (item <- arrays2) print(" " + item)
    println("\nlength is " + arrays2.length)

    println("打印一串数组，使用apply创建数组，方式二:" + "\n")
    val arrays3 = Array.apply("scala","Spark","kafka")
    for (item <- arrays3) print(" " + item)
//    print("iterator 遍历：" + arrays3.toIterator)

//    apply(1)
    println("使用ArrayBuffer类创建数组:")
    arrayToBuffer()
  }

 //TODO 需要弄明白这种返回是什么意思?
  def apply(i: Int): Int = throw new Error()
  /**
    * 创建一个可变数组的方法
    */
  def arrayToBuffer(): Unit ={
    //导入ArrayBuffer的包
    import scala.collection.mutable.ArrayBuffer
    //这里写new 不写new 都可以吗?
    var arrayBuffers = ArrayBuffer[Int]()
    //var arrayBuffers = new  ArrayBuffer[Int]()
    arrayBuffers += 1
    arrayBuffers += 2
    arrayBuffers += 3
    println(arrayBuffers.toString)

  }
}
