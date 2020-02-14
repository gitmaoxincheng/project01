package cn.com.agree.huanan.ap.tl.db.impl.orm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.tl.db.orm.OrmUpdater;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * orm实现
 * 
 * @author tan.ch
 *
 * @param <T> 实体类型
 */
@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrmUpdaterImpl<T> implements OrmUpdater<T> {
    @Autowired
    private DbOperator dbOper;

    /** po类型 */
    private final Class<T> poType;
    
    /** set信息 */
    private Map<String, Object> setInfo = new LinkedHashMap<String, Object>();
    
    /** where信息 */
    private Map<String, Object> whereInfo = new LinkedHashMap<String, Object>();
    
    /**
     * 构造方法
     * 
     * @param poType po类型
     */
    public OrmUpdaterImpl(Class<T> poType) {
        this.poType = poType;
    }

    @Override
    public int execute() {
        // 获取表名
        Table tabAnnotation = poType.getAnnotation(Table.class);
        Class<?> tabObj = tabAnnotation.value();
        String tabName = tabObj.getSimpleName().toLowerCase();
        // 传递信息
        int count = dbOper.getUpdater()
                .update(tabName)
                .set(setInfo)
                .where(w -> {
                    whereInfo.forEach((k, v) -> w.eq(k, v));
                })
                .execute()
                ;
        return count;
    }

    @Override
    public OrmUpdater<T> set(Consumer<T> s) {
        setInfo.putAll(OrmPoCollectors.collectWhere(poType, s));
        return this;
    }

    @Override
    public OrmUpdater<T> where(Consumer<T> w) {
        whereInfo.putAll(OrmPoCollectors.collectWhere(poType, w));
        return this;
    }

}
