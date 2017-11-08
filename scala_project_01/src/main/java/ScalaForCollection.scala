
/**
  * Created by lzl on 2017/11/8.
  * scala支持的集合操作
  */
object ScalaForCollection {
  def main(args: Array[String]): Unit = {
    arrayFirst()
  }

  /**
    * 1. 数组必须用val来修饰，表示不可变的数组
    * 2. `new Array[String](10)` 是用来创建一个String类型的数组，并开辟长度为10的空间
    */
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
    val arrays3 = Array("scala","Spark","kafka")
    for (item <- arrays3) print(" " + item)

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
