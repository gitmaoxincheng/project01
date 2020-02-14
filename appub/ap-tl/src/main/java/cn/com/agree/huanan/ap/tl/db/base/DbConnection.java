package cn.com.agree.huanan.ap.tl.db.base;

import java.util.List;

import cn.com.agree.huanan.ap.tl.db.impl.base.ProcElement;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 数据库连接
 * 
 * @author tan.ch
 *
 */
public interface DbConnection extends AutoCloseable {
    /**
     * 获取实例
     * 
     * @return 数据库连接
     */
    public static DbConnection getInstance() {
        return SpringUtil.getBean(DbConnection.class);
    }

    /**
     * 提交
     */
    public void commit();

    /**
     * 回滚
     */
    public void rollback();

    /**
     * 查询
     * 
     * @param sql sql
     * @param sqlParams sql参数
     * @param count 最大返回记录数，0则返回所有
     * @return 结果集
     */
    public List<List<Object>> query(String sql, List<Object> sqlParams, int count);

    /**
     * 查询
     * 
     * @param sql sql
     * @param sqlParams sql参数
     * @return 结果集
     */
    default public List<List<Object>> query(String sql, List<Object> sqlParams) {
        return query(sql, sqlParams, 0);
    }

    /**
     * 查询
     * 
     * @param sql sql
     * @return 结果集
     */
    default public List<List<Object>> query(String sql) {
        return query(sql, null, 0);
    }

    /**
     * 执行
     * 
     * @param sql sql
     * @param sqlParams sql参数
     * @return 影响记录数
     */
    public int execute(String sql, List<Object> sqlParams);

    /**
     * 执行
     * 
     * @param sql sql
     * @return 影响记录数
     */
    default public int execute(String sql) {
        return execute(sql, null);
    }
    
    /**
     * @param procName 存储过程名称
     * @param params 存储过程参数
     * @return 执行是否成功
     */
    public List<ProcElement> call(String procName, List<ProcElement> params);
    
    /**
     * @param procName 存储过程名称
     * @return 执行是否成功
     */
    default public List<ProcElement> call(String procName){
        return call(procName, null);
    }
}
