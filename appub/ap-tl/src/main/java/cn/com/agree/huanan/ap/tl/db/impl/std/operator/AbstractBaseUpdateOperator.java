package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.std.operator.BaseUpdateOperator;

abstract class AbstractBaseUpdateOperator<T> extends AbstractBaseOperator<T> implements BaseUpdateOperator<T> {
    @Autowired
    private DbConnection dbConn;
    
    @Override
    public int execute() {
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = getSql(sqlParams);
        return dbConn.execute(sql, sqlParams);
    }
}
