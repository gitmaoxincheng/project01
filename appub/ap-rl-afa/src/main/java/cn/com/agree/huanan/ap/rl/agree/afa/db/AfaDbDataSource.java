package cn.com.agree.huanan.ap.rl.agree.afa.db;

import java.sql.Connection;

import org.springframework.stereotype.Component;

import cn.com.agree.afa.jcomponent.DBConnProvider;
import cn.com.agree.huanan.ap.tl.db.base.DbDataSource;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbConnectionException;

@Component
public class AfaDbDataSource implements DbDataSource {
    @Override
    public Connection getConnection(String connName) {
        try {
            if (connName == null || connName.isEmpty()) {
                return DBConnProvider.getConnection();
            } else {
                return DBConnProvider.getConnection(connName);
            }
        } catch (Exception ex) {
            throw new ApDbConnectionException(ex);
        }
    }
}
