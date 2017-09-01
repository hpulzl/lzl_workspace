package com.lzl.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        StringBuffer sb = new StringBuffer();
         for(Map map : list){
            sb.append(map.get("tvIds")).append(",");
        }
        System.out.println("sb.toString() = " + sb.toString());
    }
}
