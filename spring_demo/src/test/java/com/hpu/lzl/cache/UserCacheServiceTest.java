package com.hpu.lzl.cache;


import com.hpu.lzl.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCacheServiceTest extends BaseTest{

    @Autowired
    private UserCacheService userCacheService;

    @Test
    public void cacheableTest(){
        System.out.println("第一次查询数据...");
        userCacheService.getUser("123");
        System.out.println("第二次查询数据...");
        userCacheService.getUser("123");
        System.out.println("...换一个uid进行查询,第一次...");
        userCacheService.getUser("456");
        System.out.println("...换一个uid进行查询,第二次...");
        userCacheService.getUser("456");
        System.out.println("查询结束...");
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
        System.out.println("第一次更新数据...");
        User user = new User();
        user.setUid("123");
        user.setUserName("awo");
        user.setPassword("123456");
        User user1 = null;
        try {
            user1 = userCacheService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("更新结果展示,"+ user1);
        System.out.println("第二次查询数据...");
        userCacheService.getUser("123");

        System.out.println("查询结束...");
    }

    @Test
    public void cacheEvictTest(){
        //缓存两个user
        userCacheService.getUser("123");
        userCacheService.getUser("456");
        User user = new User();
        user.setUid("123");
        try {
            System.out.println("调用evictUpdateUser，清空key=" + user.getUid());
            //清空uId=123的缓存
            userCacheService.evictUpdateUser(user);
            userCacheService.getUser("123");
            System.out.println("调用updateUser，更新key=" + user.getUid());
            //缓存uId=123
            userCacheService.updateUser(user);
            System.out.println("调用evictAll，清空所有key ");
            //清空所有的key
            userCacheService.evictAll();
            //验证
            userCacheService.getUser("123");
            userCacheService.getUser("456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}