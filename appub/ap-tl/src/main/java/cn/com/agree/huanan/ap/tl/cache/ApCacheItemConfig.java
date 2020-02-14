package cn.com.agree.huanan.ap.tl.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApCacheItemConfig {
    private String cacheName;
    private long maxSize;
    private long expireTime;
    private long refreshTime;
}
