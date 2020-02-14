package cn.com.agree.huanan.ap.tl.cache;

import java.util.concurrent.Callable;

import org.springframework.cache.Cache;

public class ApAdaptingCache implements Cache {
    private final Cache targetCache;
    
    public ApAdaptingCache(Cache targetCache) {
        this.targetCache = targetCache;
    }
    
    @Override
    public String getName() {
        return targetCache.getName();
    }

    @Override
    public Object getNativeCache() {
        return targetCache.getNativeCache();
    }

    @Override
    public ValueWrapper get(Object key) {
        return targetCache.get(key);
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return targetCache.get(key, type);
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        ApKey apKey = new ApKey(key, valueLoader);
        return targetCache.get(apKey, valueLoader);
    }

    @Override
    public void put(Object key, Object value) {
        targetCache.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return targetCache.putIfAbsent(key, value);
    }

    @Override
    public void evict(Object key) {
        targetCache.evict(key);
    }

    @Override
    public void clear() {
        targetCache.clear();
    }
}
