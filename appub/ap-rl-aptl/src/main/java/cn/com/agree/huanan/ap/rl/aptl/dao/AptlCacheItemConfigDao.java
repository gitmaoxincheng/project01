package cn.com.agree.huanan.ap.rl.aptl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.cache.ApCacheItemConfig;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApConfigMissException;

@Component
public class AptlCacheItemConfigDao {
    @Autowired
    private DbOperator dbOper;

    public ApCacheItemConfig findByName(String cacheName) {
        // 查询
        String tabName = "Aptl_Cache_ItemConfig";
        Map<String, Object> ret = dbOper.getSelecter()
            .select("maxSize", "expireTime", "refreshTime")
            .from(tabName)
            .where(w -> w.eq("cacheName", cacheName))
            .fetchOne()
            ;
        // 记录不存在
        if (ret.isEmpty()) {
            throw new ApConfigMissException(tabName, cacheName);
        }
        // ORM
        long maxSize = Long.parseLong((String) ret.get("maxSize"));
        long expireTime = Long.parseLong((String) ret.get("expireTime"));
        long refreshTime = Long.parseLong((String) ret.get("refreshTime"));
        return new ApCacheItemConfig(cacheName, maxSize, expireTime, refreshTime);
    }
}
