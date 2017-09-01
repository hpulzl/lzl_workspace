package com.lzl.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: li_zhilei
 * @Date: create in 09:01 17/5/23.
 * @description:
 */
public class TvidTest {
    public static void main(String[] args) {
        TvidTest.test();
    }
    public static void test(){
        String tvid = "";
       List<Map<String,Object>> maps = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("tv_id","348UFJJS");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("tv_id","qCode");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("tv_id","43235qcode");
        Map<String,Object> map4 = new HashMap<>();
        map4.put("tv_id","23234_UPM_TV_ID");
        Map<String,Object> map6 = new HashMap<>();
        map6.put("tv_id","23234_upm_tv_id");
        Map<String,Object> map5 = new HashMap<>();
        map5.put("tv_id","PC00PCWEB293204320");
       maps.add(map1);
       maps.add(map2);
       maps.add(map3);
       maps.add(map4);
       maps.add(map5);
       maps.add(map6);
        for(int x=0;x<maps.size();x++){
            try {
                Map<String,Object> map = maps.get(x);
                String tvidStr = (String) map.get("tv_id");
                if(tvidStr.equalsIgnoreCase("qCode")||tvidStr.contains("_UPM_TV_ID")){
                    continue;
                }
                String str56 =  tvidStr.substring(4,6);
                System.out.println("str56 = " + str56);
                if("PC".equals(str56)){
                    continue;
                }
                tvid += tvidStr+",";
            } catch ( NumberFormatException e) {
                e.printStackTrace();
            }
        }
        tvid = tvid.substring(0, tvid.length()-1);
        tvid = tvid.replaceAll(",", "\r\n");
        System.out.println("tvid = " + tvid);
    }
}
