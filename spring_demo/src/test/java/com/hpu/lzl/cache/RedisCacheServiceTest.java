package com.hpu.lzl.cache;


import com.hpu.lzl.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisCacheServiceTest extends BaseTest{

    @Autowired
    private RedisCacheService redisCacheService;

    @Test
    public void cacheableTest(){
        System.out.println("第一次查询数据...");
        User user = redisCacheService.getUser("222");
        System.out.println("再次查询数据...");
        User user1 = redisCacheService.getUser("222");
        System.out.println(user1.toString());

    }
    /**
     * result
     第一次更新数据...
     from db User{uid='123', userName='awo', password='123456'}
     第二次查询数据...
     查询结束...
     */
    @Test
    public void cacheputTest(){
    }

    @Test
    public void cacheEvictTest(){
        //清空所有的key
        redisCacheService.evictAll();
    }
}