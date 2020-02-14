package cn.com.agree.huanan.ap.tl.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cache.annotation.Cacheable;

/**
 * 缓存
 * 
 * @author tan.ch
 *
 */
@Target({
        ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Cacheable(cacheResolver = "cn.com.agree.huanan.ap.tl.cache.ApCacheResolver", sync=true)
public @interface ApCacheable {
    /**
     * 缓存key，使用SpEL表达式，未设置则使用所有参数
     */
    String key() default "";
}
