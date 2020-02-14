package cn.com.agree.huanan.ap.tl.db.base;

import java.sql.Connection;

public interface DbDataSource {
    public Connection getConnection(String connName);
}
