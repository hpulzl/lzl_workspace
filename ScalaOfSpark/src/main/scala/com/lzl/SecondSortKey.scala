package com.lzl

/**
  * Created by lzl on 2018/1/7.
  */
class SecondSortKey(val first:Int, val second:Int) extends Ordered[SecondSortKey] with Serializable{

  override def compare(that: SecondSortKey): Int = {
    if(first != that.first){
      first - that.first
    }else{
      second - that.second
    }
  }
}
