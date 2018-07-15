package com.hpu.lzl.cache;

import com.hpu.lzl.common.Constans;
import com.hpu.lzl.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
*   
* @author:awo  
* @time:2018/6/27  下午8:13 
* @Description: info
**/
@Service
public class UserCacheService {

    /**
     * Cacheable
     * value 指定选择的缓存管理器名称，即spring配置文件中设置的accountCache
     * key 缓存的key值,可以使用SpEL设置key值。默认是入参拼接
     * @param uid
     * @return
     */
    @Cacheable(value = Constans.CACHE_MANAGER)
    public User getUser(String uid){
        return getFromDB(uid);
    }

    private User getFromDB(String uid){
        System.out.println("get from db " + uid);
        User user = new User();
        user.setUid(uid);
        user.setPassword("123456");
        user.setUserName("dead fish");
        return user;
    }

    /**
     * CachePut
     * 通过key值更新缓存中的数据，并返回更新的结果。
     * 如果更新失败，再次查询是从数据库中查询。
     * @param user
     * @return
     */
    @CachePut(value = Constans.CACHE_MANAGER,key = "#user.getUid()")
    public User updateUser(User user) throws Exception {
        return updateFromDB(user);
    }

    private User updateFromDB(User user)throws Exception {
        System.out.println("update from db " + user.toString());
//        throw new RuntimeException();
        return user;
    }

    /**
     * CacheEvict 清空指定的key的缓存。
     * allEntries 清空缓存器中的所有的缓存，默认false
     * beforeInvocation 是否在方法执行前就清空，默认false
     * 清空前抛出异常，缓存不会清空
     * @param user
     * @return
     * @throws Exception
     */
    @CacheEvict(value = Constans.CACHE_MANAGER,key = "#user.getUid()")
    public User evictUpdateUser(User user) throws Exception {
        return updateFromDB(user);
    }

    @CacheEvict(value = Constans.CACHE_MANAGER,allEntries = true)
    public void evictAll(){}
}
