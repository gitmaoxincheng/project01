package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Deleter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Procedurer;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;


@Component
public class DbOperatorImpl implements DbOperator {
    @Autowired
    private DbConnection dbConn;
    
    @Override
    public Selecter getSelecter() {
        return SpringUtil.getBean(Selecter.class);
    }

    @Override
    public Inserter getInserter() {
        return SpringUtil.getBean(Inserter.class);
    }

    @Override
    public Updater getUpdater() {
        return SpringUtil.getBean(Updater.class);
    }

    @Override
    public Deleter getDeleter() {
        return SpringUtil.getBean(Deleter.class);
    }

    @Override
    public void commit() {
        dbConn.commit();
    }

    @Override
    public void rollback() {
        dbConn.rollback();
    }

    @Override
    public Procedurer getProcedurer() {
        // TODO 自动生成的方法存根
        return SpringUtil.getBean(Procedurer.class);
    }
}
