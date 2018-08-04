package com.hpu.lzl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.cache.interceptor.CacheOperation;
import org.springframework.cache.interceptor.SimpleKeyGenerator;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;

/**
*   
* @author:awo  
* @time:2018/7/18  下午2:13 
* @Description: info
**/  
public class TripCarKeyGenerator extends SimpleKeyGenerator{

    @Autowired
    private CacheInterceptor cacheInterceptor;
    private String prefixKey;

    public String getPrefixKey() {
        return prefixKey;
    }

    public void setPrefixKey(String prefixKey) {
        this.prefixKey = prefixKey;
    }

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefixKey());
        sb.append(o.getClass().getSimpleName()).append("_");

        Collection<CacheOperation> cacheOperations = cacheInterceptor.getCacheOperationSource()
                .getCacheOperations(method,o.getClass());
        if (!cacheOperations.isEmpty()){
            cacheOperations.stream().forEach(cacheOperation -> {
                Set<String> cacheNames = cacheOperation.getCacheNames();
                if (!cacheNames.isEmpty()){
                    cacheNames.stream().forEach(cacheName->{
                        sb.append(cacheName).append("_");
                    });
                }
            });
        }

        for (Object obj : objects) {
            sb.append(obj.toString()).append("_");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
