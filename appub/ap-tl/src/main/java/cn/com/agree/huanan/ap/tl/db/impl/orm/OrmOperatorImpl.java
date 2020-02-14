package cn.com.agree.huanan.ap.tl.db.impl.orm;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.orm.OrmUpdater;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

@Component
public class OrmOperatorImpl implements OrmOperator {
    @Override
    public <T> OrmSelecter<T> getOrmSelecter(Class<T> poType) {
        return SpringUtil.getBean(OrmSelecter.class, poType);
    }

    @Override
    public <T> OrmUpdater<T> getOrmUpdater(Class<T> poType) {
        return SpringUtil.getBean(OrmUpdater.class, poType);
    }
}
