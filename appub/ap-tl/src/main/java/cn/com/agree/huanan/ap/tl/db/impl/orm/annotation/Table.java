package cn.com.agree.huanan.ap.tl.db.impl.orm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据表
 * 
 * @author tan.ch
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    /**
     * 关联表对象类
     * 
     * @return 表对象类
     */
    public Class<?> value();
}
