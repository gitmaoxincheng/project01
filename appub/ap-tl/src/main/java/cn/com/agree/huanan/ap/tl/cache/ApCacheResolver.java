package cn.com.agree.huanan.ap.tl.cache;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.AbstractCacheResolver;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ApCacheResolver extends AbstractCacheResolver {
    @Autowired Logger logger;
    public ApCacheResolver(CacheManager cacheManager) {
        super(cacheManager);
    }
    
    @Override
    protected Collection<String> getCacheNames(CacheOperationInvocationContext<?> context) {
        // 使用类名作为缓存名称
    
    	String className = context.getTarget().getClass().getCanonicalName();
        return Arrays.asList(className);
    }

}
