import java.text.SimpleDateFormat

/**
  * @Author: li_zhilei
  * @Date: create in 14:32 17/11/15.
  * @description:
  */
trait Logging{
  def log(log : String): Unit ={
    print("logging is:" + log + "\n")
  }
}

trait SystemLogging extends Logging{
  override def log(log: String): Unit = {
    print("system loggin is:" + log + "\n")
  }
}

/**
  * 使用extends...with表示
  * @param name
  * @param date
  */
class userOperation(name : String,date : String) extends Logging with SystemLogging{
  def sysUserSave(name : String): Unit ={
    val str = name + " 用户保存成功! 时间:" + date
    //写入log,默认使用的是SystemLogging.log方法
    log(str)
  }
}

object userOperation{

  def apply(): userOperation = {
    apply("")
  }

  def apply(name: String): userOperation = {
    import java.util.Date
    val date : Date = new Date()
    var simpleDate : SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd mm:ss")
    val dateStr = simpleDate.format(date)
    apply(name,dateStr)
  }

  def apply(name: String, date: String): userOperation = new userOperation(name, date)

  def main(args: Array[String]): Unit = {
    var useroperation = apply()
    useroperation.sysUserSave("lzl")
  }
}

