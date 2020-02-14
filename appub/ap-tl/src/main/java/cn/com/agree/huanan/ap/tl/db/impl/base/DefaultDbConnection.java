package cn.com.agree.huanan.ap.tl.db.impl.base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.base.DbDataSource;
import cn.com.agree.huanan.ap.tl.db.util.ProcUtil;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbCommitException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbExecuteException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbSelectException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.ResUtil;

/**
 * 默认数据库连接
 * 
 * @author tan.ch
 *
 */
@Component
public class DefaultDbConnection implements DbConnection {
    /**
     * 连接信息
     * 
     * @author tan.ch
     *
     */
    private static class ConnInfo {
        /** JDBC连接 */
        public final Connection conn;
        /** 是否包含事务 */
        public boolean containTransaction;

        /**
         * 构造方法
         * 
         * @param conn DBC连接
         * @param containTransaction 是否包含事务
         */
        public ConnInfo(Connection conn, boolean containTransaction) {
            // 保存
            this.conn = conn;
            this.containTransaction = containTransaction;
        }

        @Override
        public String toString() {
            return conn.toString();
        }
    }

    /** 日志 */
    @Autowired
    private Logger logger;

    /** 数据源 */
    @Autowired
    private DbDataSource dataSrc;

    /** 连接信息 */
    private static final ThreadLocal<ConnInfo> threadConnInfo = new ThreadLocal<>();

    @Override
    public void close() {
        // 获取连接信息
        ConnInfo connInfo = getConnInternal(false);
        // 已关闭
        if (connInfo == null) {
            return;
        }
        // 包含事务
        if (connInfo.containTransaction) {
            logger.error("连接包含未提交的事务，请排查程序逻辑是否存在问题，本连接事务将会被提交");
            try {
                connInfo.conn.commit();
            } catch (Exception ex) {
                logger.exception("提交事务异常，忽略：", ex);
            }
        }
        // 关闭
        closeConnInternal(connInfo);
    }

    @Override
    public void commit() {
        // 获取连接信息
        ConnInfo connInfo = getConnInternal(false);
        // 已关闭/无事务，直接返回
        if (connInfo == null || !connInfo.containTransaction) {
            return;
        }
        // 提交
        try {
            connInfo.conn.commit();
        } catch (Exception ex) {
            logger.error("提交事务异常：%s", connInfo);
            // 回滚
            rollback();
            // 继续抛出
            throw new ApDbCommitException(ex);
        } finally {
            // 关闭连接
            closeConnInternal(connInfo);
        }
    }

    @Override
    public void rollback() {
        // 获取连接信息
        ConnInfo connInfo = getConnInternal(false);
        // 已关闭/无事务，直接返回
        if (connInfo == null || !connInfo.containTransaction) {
            return;
        }
        // 回滚
        try {
            connInfo.conn.rollback();
        } catch (Exception ex) {
            logger.exception("回滚事务异常，忽略：", ex);
        } finally {
            // 关闭连接
            closeConnInternal(connInfo);
        }
    }

    @Override
    public List<List<Object>> query(String sql, List<Object> sqlParams, int count) {
        // 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        // 获取statement
        try (PreparedStatement stmt = getPreparedStatement(connInfo, sql, sqlParams)) {
            // 设置返回最大结果数
            if (count == 0) {
                // 返回所有
            }
            else if (count > 0) {
                // 返回N
                stmt.setMaxRows(count);
            }
            else if (count < 0) {
                // 超出范围
                throw new ApValueOutOfRangeException(count);
            }
            // 日志
            String sqlStr = SqlUtil.formatSql(sql, sqlParams);
            logger.info(sqlStr);
            // 执行查询
            try (ResultSet rs = stmt.executeQuery()) {
                // 空则直接返回
                boolean hasNext = rs.next();
                if (!hasNext) {
                    return Collections.emptyList();
                }
                // 结果集描述信息
                ResultSetMetaData rsmd = rs.getMetaData();
                // 列数
                int colsCount = rsmd.getColumnCount();
                // 初始化结果集容器（优化只查1条的情况）
                int initialCapacity = (count == 1) ? 1 : 0;
                List<List<Object>> rowSet = new ArrayList<List<Object>>(initialCapacity);
                // 循环解析
                do {
                    // 初始化行容器
                    List<Object> row = new ArrayList<Object>(colsCount);
                    // 逐列获取值
                    for (int i = 0; i < colsCount; i++) {
                        Object value = rs.getObject(i + 1);
                        // null
                        if (value == null) {
                            int colType = rsmd.getColumnType(i + 1);
                            if (colType == Types.VARCHAR) {
                                value = "";
                            }
                        }
                        row.add(value);
                    }
                    // 保存到结果集 
                    rowSet.add(Collections.unmodifiableList(row));
                } while (rs.next());
                // 返回结果集
                return Collections.unmodifiableList(rowSet);
            }
        } catch (Exception ex) {
            // 记录错误信息
            logError(connInfo, sql, sqlParams, ex);
            // 继续抛出
            throw new ApDbSelectException(ex);
        } finally {
            // 无事务则关闭
            if (!connInfo.containTransaction) {
                closeConnInternal(connInfo);
            }
        }
    }

    @Override
    public int execute(String sql, List<Object> sqlParams) {
        // 日志
        String sqlStr = SqlUtil.formatSql(sql, sqlParams);
        logger.info(sqlStr);
        // 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        // 获取statement
        try (PreparedStatement stmt = getPreparedStatement(connInfo, sql, sqlParams)) {
            // 标记事务
            connInfo.containTransaction = true;
            // 执行
            return stmt.executeUpdate();
        } catch (Exception ex) {
            // 记录错误信息
            logError(connInfo, sql, sqlParams, ex);
            // 继续抛出
            throw new ApDbExecuteException(ex);
        }
    }

    private ConnInfo getConnInternal(boolean autoGetNew) {
        // 从线程上下文获取连接信息
        ConnInfo connInfo = threadConnInfo.get();
        // 检查连接是否已关闭
        if (connInfo != null) {
            try {
                // 已被关闭
                if (connInfo.conn.isClosed()) {
                    logger.info("连接已被外部关闭，需要注意是否存在事务不一致风险");
                    closeConnInternal(connInfo);
                    connInfo = null;
                }
            } catch (Exception ex) {
                logger.exception("检测连接是否关闭错误，丢弃该连接：", ex);
                closeConnInternal(connInfo);
                connInfo = null;
            }
        }
        // 失败
        if (autoGetNew && connInfo == null) {
            // 获取新连接
            Connection conn = dataSrc.getConnection(null);
            // 关闭自动提交
            try {
                if (conn.getAutoCommit()) {
                    conn.setAutoCommit(false);
                }
            } catch (Exception ex) {
                logger.exception("设置自动提交错误，忽略：", ex);
            }
            // 创建信息对象
            connInfo = new ConnInfo(conn, false);
            // 保存
            threadConnInfo.set(connInfo);
        }
        //
        return connInfo;
    }

    private void closeConnInternal(ConnInfo connInfo) {
//        try {
//            // 关闭
//            connInfo.conn.close();
//        } catch (Exception ex) {
//            logger.error("关闭连接错误，忽略：%s", connInfo);
//            logger.exception(ex);
//        }
        // 释放
        releaseConnInternal();
    }

    private void releaseConnInternal() {
        // 从线程上下文获取连接
        threadConnInfo.remove();
    }

    private PreparedStatement getPreparedStatement(ConnInfo connInfo, String sql,
            List<Object> sqlParams) throws Exception {
        // 获取statement
        PreparedStatement stmt = connInfo.conn.prepareStatement(sql);
        try {
            // 有上送参数
            if (sqlParams != null && !sqlParams.isEmpty()) {
                // 设置参数
                int index = 1;
                for (Object param : sqlParams) {
                    stmt.setObject(index++, param);
                }
            }
            // 返回
            return stmt;
        } catch (Exception ex) {
            // 关闭
            ResUtil.closeResource(stmt, ex);
            // 继续抛出
            throw new ApDbExecuteException(ex);
        }
    }

    private void logError(ConnInfo connInfo, String sql, List<Object> sqlParams, Exception ex) {
        String sep = "****************************************";
        logger.error(sep);
        logger.error("数据库连接：%s", connInfo);
        logger.error("数据库错误：%s", ExceptionUtil.getStackTrace(ex));
        logger.error("SQL语句：%s", sql);
        logger.error("SQL参数：%s", sqlParams);
        logger.error(sep);
    }

    private CallableStatement getCallableStatement(ConnInfo connInfo, String procSql,
            List<ProcElement> params) throws Exception {
        // 获取callablestatement
        CallableStatement cstmt = connInfo.conn.prepareCall(procSql);
        try {
            // 有参数
            if (params != null && !params.isEmpty()) {
                int paramIndex = 1;
                // 设置参数
                for (ProcElement param : params) {
                    logger.info("paramIndex: %d, %s, %s", paramIndex, param.getParamName(), param.getParamValue());
                    switch(param.getParamType()) {
                    case IN_PARAM:
                        ProcUtil.setInParam(cstmt, param, paramIndex);
                        break;
                    case OUT_PARAM:
                        cstmt.registerOutParameter(paramIndex, param.getParamValueType());
                        break;
                    case IN_OUT_PARAM:
                        ProcUtil.setInParam(cstmt, param, paramIndex);
                        break;
                    }
                    ++paramIndex;
                }
            }
            
            // 返回
            return cstmt;
        } catch (Exception ex) {
            // 关闭
            ResUtil.closeResource(cstmt, ex);
            // 继续抛出
            throw new ApDbExecuteException(ex);
        }
    }
    
    @Override
    public List<ProcElement> call(String procName, List<ProcElement> params) {
        // TODO 自动生成的方法存根
        String procSql = SqlUtil.formatProcedure(procName, params);
        logger.info("procSql: %s", procSql);
        // 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        // 获取cstatement
        try (CallableStatement cstmt = getCallableStatement(connInfo, procSql, params)) {
            // 标记事务
            connInfo.containTransaction = true;
            // 执行
            cstmt.execute();
            if (params != null && !params.isEmpty()) {
                int paramIndex = 1;
                // 设置参数
                for (ProcElement param : params) {
                    switch(param.getParamType()) {
                    case IN_PARAM:
                        break;
                    case OUT_PARAM:
                        param.setParamValue(cstmt.getObject(paramIndex));
                        break;
                    case IN_OUT_PARAM:
                        param.setParamValue(cstmt.getObject(paramIndex));
                        break;
                    }
                    ++paramIndex;
                }
            }
            return params;
        } catch (Exception ex) {
            // 记录错误信息
            logError(connInfo, procName, params.stream().map(i->i.getParamValue()).collect(Collectors.toList()), ex);
            // 继续抛出
            throw new ApDbExecuteException(ex);
        }
    }
}
