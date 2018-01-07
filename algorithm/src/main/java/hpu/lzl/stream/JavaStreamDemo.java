package hpu.lzl.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzl on 2018/1/7.
 * java8 stream的相关API使用
 */
public class JavaStreamDemo {
    public static void main(String[] args) {
        streamList();
    }
    public static void streamList(){
        List<String> list = new ArrayList<>();

        list.add("AC");
        list.add("BC");
        list.add("FD");
        list.add("DD");
        List<String> containCList = Lists.newArrayList();
        List<String> containDList = Lists.newArrayList();
        //list.stream().filter(item -> item.contains("C")).collect(Collectors.toList());
        list.stream().forEach(item ->{
            if (item.contains("C")){
                containCList.add(item);
            }else {
                containDList.add(item);
            }
        });
        System.out.println("contain C "+containCList);
        System.out.println("contain D "+containDList);
    }
}
