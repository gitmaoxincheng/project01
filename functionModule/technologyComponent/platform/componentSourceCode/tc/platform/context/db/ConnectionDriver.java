package tc.platform.context.db;

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

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.afa.util.StringUtils;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.impl.base.ProcElement;
import cn.com.agree.huanan.ap.tl.db.util.ProcUtil;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApDbExecuteException;
import cn.com.agree.huanan.ap.tl.util.FileUtil;
import cn.com.agree.huanan.ap.tl.util.ResUtil;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseRuntimeException;
import tc.platform.context.exception.DBException;
import tc.platform.util.db.DBUtils;
import tc.platform.util.db.SqlUtils;

public class ConnectionDriver implements DbConnection {
	
	 /**
     * 连接信息
     * 
     * @author admin
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
            this.conn = conn;
            this.containTransaction = containTransaction;
        }

        @Override
        public String toString() {
            return conn.toString();
        }
    }
    
    /** 连接信息 */
    private static final ThreadLocal<ConnInfo> threadConnInfo = new ThreadLocal<>();
    

    /** 关闭 
     * @throws DBException */
    @Override
    public void close() throws DBException {
    	// 获取连接信息
    	ConnInfo connInfo = getConnInternal(false);
        // 已关闭
        if (connInfo == null) {
        	return ;
        }
        // 包含事务
        if (connInfo.containTransaction) {
            AppLogger.error("连接包含未提交的事务，请排查程序逻辑是否存在问题，本连接事务将会被提交");
            try {
                connInfo.conn.commit();
            } catch (SQLException ex) {
            	//抛出给最外层去处理
            	throw new DBException(CommonErrorCodeEnum.COMMIT_ERROR_CODE, ex);
            }
        }
        // 关闭
        closeConnInternal(connInfo);
    }
    
    
    /** 提交 */
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
        } catch (SQLException ex) {
            rollback();
            // 抛出给最外层去处理
            throw new BaseRuntimeException(CommonErrorCodeEnum.COMMIT_ERROR_CODE,ex);
        } finally {
            // 关闭连接
            closeConnInternal(connInfo);
        }
    }
    
    /** 回滚 */
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
        } catch (SQLException ex) {
        	//抛出给最外层去处理
        	throw new BaseRuntimeException(CommonErrorCodeEnum.ROLLBACK_ERROR_CODE,ex);
        } finally {
            // 关闭连接
            closeConnInternal(connInfo);
        }
    }
    
    /**
     * 普通查询
     * 
     * @param sql sql
     * @return 结果集
     */
	@Override
	public List<List<Object>> query(String sql, List<Object> sqlParams, int count) {
		
		// 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        AppLogger.info("connInfo----------------:"+connInfo.toString());
        AppLogger.info("sql:"+sql);
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
            String sqlStr = SqlUtils.formatSql(sql, sqlParams);
            AppLogger.info(sqlStr);
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
                    rowSet.add(row);
                } while (rs.next());
                // 返回结果集
                return rowSet;
            }
        } catch (SQLException ex) {
            // 记录错误信息
            logError(connInfo, sql, sqlParams, ex);
            // 抛出给最外层处理
            throw new BaseRuntimeException(CommonErrorCodeEnum.SELECT_ERROR_DB_CODE,ex);
        } finally {
            // 无事务则关闭
            if (!connInfo.containTransaction) {
                closeConnInternal(connInfo);
            }
        }
    }

	
	/**
	 * 游标分页查询
	 * @param sql
	 * @param pageSize
	 * @param pageIndex
	 * @param sqlParams
	 * @return
	 * @throws DBException 
	 */
	public JavaList query(String sql,int pageSize,int pageIndex,JavaList sqlParams) throws DBException {
		
		AppLogger.info("方法(查询sql) --- ConnectionDriver.query--- start ---");
		DBUtils.logParams("[ConnectionDriver.query]", sql,pageSize,pageIndex,sqlParams);
		sql = SqlUtils.sqlRegular(sql, ":([A-Za-z0-9_]+)");
		//初始化
		int arraySize;
		int beginRow;
		if (sql.isEmpty()) {
			throw new RuntimeException("[ConnectionDriver.query]查询参数_sql为空");
		}
		//最大查询纪录数
		arraySize = pageSize * pageIndex;
		//起始条数
		beginRow = (pageIndex - 1)*pageSize;
		
		// 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        AppLogger.info("connInfo----------------:"+connInfo.toString());
        // 获取statement
        try (PreparedStatement stmt = getPreparedStatement(connInfo, sql, sqlParams)) {
           
            // 日志
            String sqlStr = SqlUtils.formatSql(sql, sqlParams);
            AppLogger.info(sqlStr);
            
            //最大查询到第几条记录
            stmt.setMaxRows(arraySize);
   
            // 执行查询
            try (ResultSet rs = stmt.executeQuery()) {
           
            	//游标移动到第一条记录
            	rs.relative(beginRow);
            	JavaList rowSet = new JavaList();
            	//获取结果集
            	ResultSetMetaData md = rs.getMetaData();
            	while (rs.next()) {
            		JavaList row = new JavaList();
            		for (int i = 0; i < md.getColumnCount(); i++) {
						row.add(rs.getObject(i+1));
					}
            		rowSet.add(row);
				}
                // 返回结果集
            	AppLogger.info(rowSet.toString());
            	AppLogger.info("方法(查询sql) --- ConnectionDriver.query--- end ---");
                return rowSet;
            }
        } catch (SQLException ex) {
            // 记录错误信息
            logError(connInfo, sql, sqlParams, ex);
            // 抛出给最外层处理
            throw new DBException(ex);
        } finally {
            // 无事务则关闭
            if (!connInfo.containTransaction) {
                closeConnInternal(connInfo);
            }
        }
	}
	
    public JavaList query(String sql,String arraySize,int beginRow,JavaList sqlParams) throws DBException {
		
		AppLogger.info("方法(查询sql) --- ConnectionDriver.query--- start ---");
		DBUtils.logParams("[ConnectionDriver.query]", sql,arraySize,beginRow,sqlParams);
		if (StringUtils.isNullOrEmpty(sql)) {
			throw new RuntimeException("[ConnectionDriver.query]查询参数_sql为空");
		}
		if (StringUtils.isNullOrEmpty(arraySize)) {
			//默认查出的记录为200条
			try {
				arraySize = FileUtil.readConfiguration("./workspace/cfg/", "bod.conf", "utf-8", "").get("querynum").get("max");
			} catch (Exception e) {
				AppLogger.error("最大查询记录尚未配置!");
				arraySize = "200";
			}
		}
		sql = SqlUtils.sqlRegular(sql, ":([A-Za-z0-9_]+)");
		
		// 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        AppLogger.info("connInfo----------------:"+connInfo.toString());
        // 获取statement
        try (PreparedStatement stmt = getPreparedStatement(connInfo, sql, sqlParams)) {
           
            // 日志
            String sqlStr = SqlUtils.formatSql(sql, sqlParams);
            AppLogger.info(sqlStr);
            
            //最大查询到第几条记录
            stmt.setMaxRows(Integer.parseInt(arraySize));
   
            // 执行查询
            try (ResultSet rs = stmt.executeQuery()) {
            	//游标移动到第一条记录
            	rs.relative(beginRow);
            	JavaList rowSet = new JavaList();
            	//获取结果集
            	ResultSetMetaData md = rs.getMetaData();
            	while (rs.next()) {
            		JavaList row = new JavaList();
            		for (int i = 0; i < md.getColumnCount(); i++) {
						row.add(rs.getObject(i+1));
					}
            		rowSet.add(row);
				}
            	
                // 返回结果集
            	AppLogger.info(rowSet.toString());
            	AppLogger.info("方法(查询sql) --- ConnectionDriver.query--- end ---");
                return rowSet;
            }
        } catch (SQLException ex) {
            // 记录错误信息
            logError(connInfo, sql, sqlParams, ex);
            // 抛出给外层处理
            throw new DBException(ex);
            //throw new ApDbSelectException(ex);
        } finally {
            // 无事务则关闭
            if (!connInfo.containTransaction) {
                closeConnInternal(connInfo);
            }
        }
	}
	
	public JavaList queryDict(String sql,int pageSize,int beginRow,JavaDict bindparams) throws DBException {
		
		AppLogger.info("---------------------------------into ConnectionDriver.queryDict--------------------------------");
		// 参数打印
		DBUtils.logParams("[ConnectionDriver.queryDict]", sql,pageSize,beginRow,bindparams);
		
		if (sql.isEmpty()) {
			throw new RuntimeException("[ConnectionDriver.query]查询参数_sql为空");
		}
		
		AppLogger.info("beforeRegular:"+sql);
		sql = SqlUtils.sqlRegular(sql, ":([A-Za-z0-9_]+)");
		AppLogger.info("AfterRegular:"+sql);
		JavaList sqlParams = new JavaList();
		if (bindparams!=null) {
			bindparams.getKeys().stream().forEach(s -> sqlParams.add(bindparams.getItem(s)));
		}
		
		AppLogger.info("params:"+sqlParams);
		
		//每页最多查询200条
		pageSize = pageSize < 0 ? 0 : pageSize>200 ? 200 : pageSize;
		//初始化
		int arraySize = 0;
		if (pageSize==0) {

			//从配置文件中查找最大查询纪录数
			try {
				arraySize = Integer.parseInt(FileUtil.readConfiguration("./workspace/cfg/", "bod.conf", "utf-8", "").get("querynum").get("max"));	
			} catch (Exception e) {
				AppLogger.error("[P_DbFunc.query]最大查询记录数未配置");
				arraySize = 0;
			}
		}else{
			arraySize = pageSize;
		}
		
		
		// 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        AppLogger.info("connInfo----------------:"+connInfo.toString());
        // 获取statement
        try (PreparedStatement stmt = getPreparedStatement(connInfo, sql, sqlParams)) {
           
            // 日志
            String sqlStr = SqlUtils.formatSql(sql, sqlParams);
            AppLogger.info(sqlStr);
            
            //最大查询到第几条记录
            if (arraySize!=0) {
            	stmt.setMaxRows(arraySize);
			}else {
				stmt.setMaxRows(200);
			}
            
            // 执行查询
            try (ResultSet rs = stmt.executeQuery()) {
           
            	//游标移动到第一条记录
            	rs.relative(beginRow);
            	JavaList rowSet = new JavaList();
            	//获取结果集
            	ResultSetMetaData md = rs.getMetaData();
            	while (rs.next()) {
            		JavaList row = new JavaList();
            		for (int i = 0; i < md.getColumnCount(); i++) {
						row.add(rs.getObject(i+1));
					}
            		rowSet.add(row);
				}
                // 返回结果集
            	AppLogger.info(rowSet.toString());
            	AppLogger.info("---------------------------------outof ConnectionDriver.queryDict--------------------------------");
                return rowSet;
            }
        } catch (SQLException ex) {
            // 记录错误信息
            logError(connInfo, sql, sqlParams, ex);
            throw new DBException(ex);
            // 继续抛出
            //throw new ApDbSelectException(ex);
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
        String sqlStr = SqlUtils.formatSql(sql, sqlParams);
        AppLogger.info(sqlStr);
        // 获取连接信息
        ConnInfo connInfo = getConnInternal(true);
        // 获取statement
        try (PreparedStatement stmt = getPreparedStatement(connInfo, sql, sqlParams)) {
            // 标记事务
            connInfo.containTransaction = true;
            // 执行
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            // 记录错误信息
            logError(connInfo, sql, sqlParams, ex);
            // 继续抛出
            throw new BaseRuntimeException(ex);
        }
	}


	@Override
    public List<ProcElement> call(String procName, List<ProcElement> params) {
        // TODO 自动生成的方法存根
        String procSql = SqlUtils.formatProcedure(procName, params);
        AppLogger.info(String.format("procSql: %s", procSql));
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
            throw new BaseRuntimeException(ex);
            //throw new ApDbExecuteException(ex);
        }
    }
	
	public JavaList callNew(String procName, JavaList params) {
		
		//打印参数
		DBUtils.logParams("[ConnectionDriver.callNew]",procName, params);
		
		// TODO 自动生成的方法存根
        String procSql = SqlUtils.formatProcedure(procName, params);
        AppLogger.info(String.format("procSql: %s", procSql));
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
                for (Object param : params) {
                	if (!(param instanceof ProcElement)) {
						throw new RuntimeException("params的内参类型不是ProcElement");
					}
                    switch(((ProcElement)param).getParamType()) {
                    case IN_PARAM:
                        break;
                    case OUT_PARAM:
                        ((ProcElement)param).setParamValue(cstmt.getObject(paramIndex));
                        break;
                    case IN_OUT_PARAM:
                    	((ProcElement)param).setParamValue(cstmt.getObject(paramIndex));
                        break;
                    }
                    ++paramIndex;
                }
            }
            return params;
        } catch (Exception ex) {
            // 记录错误信息
            logError(connInfo, procName, params.stream().map(i->((ProcElement)i).getParamValue()).collect(Collectors.toList()), ex);
            // 继续抛出
            throw new BaseRuntimeException(ex);
            //throw new ApDbExecuteException(ex);
        }
	}
    
	
	/** 获取连接信息 */
    private ConnInfo getConnInternal(boolean autoGetNew) {
        // 从线程上下文获取连接信息
        ConnInfo connInfo = threadConnInfo.get();
        // 检查连接是否已关闭
        if (connInfo != null) {
            try {
                // 已被关闭
                if (connInfo.conn.isClosed()) {
                    AppLogger.info("连接已被外部关闭，需要注意是否存在事务不一致风险");
                    closeConnInternal(connInfo);
                    connInfo = null;
                }
            } catch (Exception ex) {
            	AppLogger.error(String.format("检测连接是否关闭错误，丢弃该连接：%s", ex));
                //logger.exception("检测连接是否关闭错误，丢弃该连接：", ex);
                closeConnInternal(connInfo);
                connInfo = null;
            }
        }
        // 失败
        if (autoGetNew && connInfo == null) {
            // 获取新连接
            Connection conn = ConnectionSource.getConnection(null);
            // 关闭自动提交
            try {
                if (conn.getAutoCommit()) {
                    conn.setAutoCommit(false);
                }
            } catch (Exception ex) {
            	AppLogger.error(String.format("设置自动提交错误，忽略：%s", ex));
            	//logger.exception("设置自动提交错误，忽略：", ex);
            }
            // 创建信息对象
            connInfo = new ConnInfo(conn, false);
            // 保存
            threadConnInfo.set(connInfo);
        }
        //
        return connInfo;
    }
	
	/**
	 * 关闭连接
	 * @param connInfo
	 */
	private void closeConnInternal(ConnInfo connInfo) {
        try {
            // 关闭
            connInfo.conn.close();
        } catch (Exception ex) {
        	AppLogger.error(String.format("关闭连接错误，忽略：%s", connInfo));
            AppLogger.error(ex);
        }
        // 释放
        releaseConnInternal();
    }
	
	
	/**
	 * 释放
	 */
	private void releaseConnInternal() {
        // 从线程上下文获取连接
        threadConnInfo.remove();
    }
	
	private PreparedStatement getPreparedStatement(ConnInfo connInfo, String sql,
	            List<Object> sqlParams) throws DBException{
        // 获取statemen
        PreparedStatement stmt;
		try {
			stmt = connInfo.conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			throw new DBException(CommonErrorCodeEnum.GET_STATEMEN_ERROR, e);
		}
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
        } catch (SQLException ex) {
            // 关闭
            ResUtil.closeResource(stmt, ex);
            // 继续抛出
            throw new DBException(CommonErrorCodeEnum.GET_STATEMEN_ERROR,ex);
        }	
    }
	
	
	private PreparedStatement getPreparedStatement2(ConnInfo connInfo, String sql,
            JavaDict sqlParams) throws Exception {
    // 获取statemen
    PreparedStatement stmt = connInfo.conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    try {

        // 有上送参数
        if (sqlParams != null && !sqlParams.isEmpty()) {
            // 设置参数
            int index = 1;
            
            for(java.util.Map.Entry<Object, Object> entry : sqlParams.entrySet()) {
            	AppLogger.info(index+":"+entry.toString());
            	stmt.setObject(index++, entry);
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

	
	/**
	 * 获取CallableStatement对象
	 * @param connInfo
	 * @param procSql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private CallableStatement getCallableStatement(ConnInfo connInfo, String procSql,
            JavaList params) throws Exception {
        // 获取callablestatement
        CallableStatement cstmt = connInfo.conn.prepareCall(procSql);
        try {
            // 有参数
            if (params != null && !params.isEmpty()) {
                int paramIndex = 1;
                // 设置参数
                for (Object param : params) {
                	if (!(param instanceof ProcElement)) {
						throw new RuntimeException("params的内参类型不是ProcElement");
					}
                    AppLogger.info(String.format("paramIndex: %d, %s, %s", paramIndex, ((ProcElement)param).getParamName(), ((ProcElement)param).getParamValue()));
                    switch(((ProcElement)param).getParamType()) {
                    case IN_PARAM:
                        ProcUtil.setInParam(cstmt, ((ProcElement)param), paramIndex);
                        break;
                    case OUT_PARAM:
                        cstmt.registerOutParameter(paramIndex, ((ProcElement)param).getParamValueType());
                        break;
                    case IN_OUT_PARAM:
                        ProcUtil.setInParam(cstmt, ((ProcElement)param), paramIndex);
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
	                AppLogger.info(String.format("paramIndex: %d, %s, %s", paramIndex, param.getParamName(), param.getParamValue()));
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
	
    private void logError(ConnInfo connInfo, String sql, List<Object> sqlParams, Exception ex) {
        String sep = "****************************************";
        AppLogger.error(sep);
        AppLogger.error(String.format("数据库连接：%s", connInfo));
        AppLogger.error(String.format("数据库错误：%s", ExceptionUtil.getStackTrace(ex)));
        AppLogger.error(String.format("SQL语句：%s", sql));
        AppLogger.error(String.format("SQL参数：%s", sqlParams));
        AppLogger.error(sep);
    }

}
