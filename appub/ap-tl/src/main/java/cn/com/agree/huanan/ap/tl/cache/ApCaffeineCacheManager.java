package cn.com.agree.huanan.ap.tl.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Component;

import com.github.benmanes.caffeine.cache.Caffeine;

import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

@Component
public class ApCaffeineCacheManager extends CaffeineCacheManager {
    @Autowired
    private ApCacheItemConfigSource cfgSrc;
    
    @Override
    protected Cache createCaffeineCache(String name) {
        return super.createCaffeineCache(name);
        // return new ApAdaptingCache(targetCache);
    }

    @Override
    protected com.github.benmanes.caffeine.cache.Cache<Object, Object> createNativeCaffeineCache(
            String name) {
        // 获取配置
        ApCacheItemConfig cfg = cfgSrc.getCacheItemConfig(name);
        // 创建缓存
        Caffeine<Object, Object> builder = Caffeine.newBuilder();
        builder.maximumSize(cfg.getMaxSize())
            .expireAfterWrite(cfg.getExpireTime(), TimeUnit.MILLISECONDS)
            .executor(Runnable::run);
        // 处理刷新时间
        long refreshTime = cfg.getRefreshTime();
        if (refreshTime < 0) {
            refreshTime = cfg.getExpireTime() + refreshTime;
        }
        // 不需要刷新
        if (refreshTime <= 0) {
            return builder.build();
        }
        // 需要刷新（暂不支持）
        throw new ApIllegalParamException("refreshTime");
    }
}
