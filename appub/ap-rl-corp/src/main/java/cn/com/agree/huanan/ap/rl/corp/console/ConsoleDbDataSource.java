package cn.com.agree.huanan.ap.rl.corp.console;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.base.DbDataSource;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbConnectionException;
import cn.com.agree.huanan.ap.tl.util.ReflectionUtil;

@Component
public class ConsoleDbDataSource implements DbDataSource {
    @Autowired
    private Environment env;

    private Connection dbConn;

    @Override
    public Connection getConnection(String connName) {
        try {
            if (dbConn == null) {
                /** 获取数据源 */
                DataSource ds = getDataSource();
                /** 创建代理 */
                ConnectionProxy proxy = new ConnectionProxy(ds.getConnection());
                dbConn = ReflectionUtil.getProxy(Connection.class, proxy);
            }
            return dbConn;
        } catch (Exception ex) {
            throw new ApDbConnectionException(ex);
        }
    }

    private DataSource getDataSource() {
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName(env.getProperty("ap.rl.console.datasource.driver-class-name"));
        dmds.setUrl(env.getProperty("ap.rl.console.datasource.url"));
        dmds.setUsername(env.getProperty("ap.rl.console.datasource.username"));
        dmds.setPassword(env.getProperty("ap.rl.console.datasource.password"));
        return dmds;
    }

    /**
     * 连接代理
     * 
     * @author tan.ch
     *
     */
    private static class ConnectionProxy implements InvocationHandler {
        /** 真实连接 */
        private final Connection dbConn;

        /**
         * 构造方法
         * 
         * @param dbConn 真实连接
         */
        public ConnectionProxy(Connection dbConn) {
            this.dbConn = dbConn;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 拦截close()
            if (method.getName().equals("close") && method.getParameterCount() == 0) {
                return null;
            }
            // 调用原始方法
            return method.invoke(dbConn, args);
        }

    }
}
