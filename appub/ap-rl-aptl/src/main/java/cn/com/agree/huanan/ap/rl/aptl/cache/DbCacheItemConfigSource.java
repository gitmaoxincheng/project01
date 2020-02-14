package cn.com.agree.huanan.ap.rl.aptl.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.aptl.dao.AptlCacheItemConfigDao;
import cn.com.agree.huanan.ap.tl.cache.ApCacheItemConfig;
import cn.com.agree.huanan.ap.tl.cache.ApCacheItemConfigSource;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class DbCacheItemConfigSource implements ApCacheItemConfigSource {
    @Autowired
    private AptlCacheItemConfigDao dao;
    @Autowired Logger logger;

    @Override
    public ApCacheItemConfig getCacheItemConfig(String cacheName) {
    	logger.debug("刷新缓存配置: "+cacheName);
        return dao.findByName(cacheName);
    }
}
