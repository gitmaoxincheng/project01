package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import cn.com.agree.huanan.ap.tl.config.ApTlBaseConfig;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.base.DbType;
import cn.com.agree.huanan.ap.tl.db.impl.std.subexp.WhereExpImpl;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.po.Page;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SelecterImpl extends AbstractBaseOperator<Selecter> implements Selecter {
    @Autowired
    private DbConnection dbConn;
    @Autowired
    private ApTlBaseConfig apTlBaseConfig;
    @Autowired Logger logger;
    
    private List<String> selectList = new ArrayList<String>();
    private List<String> fromList = new ArrayList<String>();
    private List<JoinInfo> joinList = new ArrayList<JoinInfo>();
    private List<WhereExp> whereList = new ArrayList<WhereExp>();
    private List<String> groupList = new ArrayList<String>();
    private List<WhereExp> havingList = new ArrayList<WhereExp>();
    private List<String> orderList = new ArrayList<String>();

    /**
     * join信息
     * 
     * @author tan.ch
     *
     */
    private static class JoinInfo {
        /** join类型 */
        public final JoinType joinType;
        /** 表名 */
        public final String tab;
        /** on列表 */
        public final List<WhereExp> onList;

        /**
         * 构造方法
         * 
         * @param joinType join类型
         * @param tab 表名
         * @param onList on列表
         */
        public JoinInfo(JoinType joinType, String tab, List<WhereExp> onList) {
            this.joinType = joinType;
            this.tab = tab;
            this.onList = onList;
        }
    }

    @Override
    public String getSql() {
        return getSql(null);
    }

    @Override
    public String getSql(List<Object> sqlParams) {
        StringJoiner joiner = new StringJoiner(" ");
        // select
        joiner.add("select");
        joiner.add(String.join(", ", selectList));
        // from
        joiner.add("from");
        joiner.add(String.join(", ", fromList));
        // join
        if (!joinList.isEmpty()) {
            joinList.forEach(joinInfo -> {
                String onExp = joinWhere(joinInfo.onList, sqlParams);
                joiner.add(String.format("%s %s on %s", joinInfo.joinType, joinInfo.tab, onExp));
            });
        }
        // where
        if (!whereList.isEmpty()) {
            joiner.add("where");
            joiner.add(joinWhere(whereList, sqlParams));
        }
        // group by
        if (!groupList.isEmpty()) {
            joiner.add("group by");
            joiner.add(String.join(", ", groupList));
        }
        // having
        if (!havingList.isEmpty()) {
            joiner.add("having");
            joiner.add(joinWhere(havingList, sqlParams));
        }
        // order by
        if (!orderList.isEmpty()) {
            joiner.add("order by");
            joiner.add(String.join(", ", orderList));
        }
        return joiner.toString();
    }

    @Override
    public Selecter select(String... fields) {
        return select(Arrays.asList(fields));
    }

    @Override
    public Selecter select(List<String> fields) {
        selectList.addAll(fields);
        return this;
    }

    @Override
    public Selecter from(String... tabs) {
        fromList.addAll(Arrays.asList(tabs));
        return this;
    }

    @Override
    public Selecter join(JoinType joinType, String tab, Consumer<WhereExp> w) {
        List<WhereExp> onList = new ArrayList<WhereExp>();
        addWhere(onList, w);
        joinList.add(new JoinInfo(joinType, tab, onList));
        return this;
    }

    @Override
    public Selecter where(Consumer<WhereExp> w) {
        addWhere(whereList, w);
        return this;
    }

    @Override
    public Selecter groupBy(String... fields) {
        return groupBy(Arrays.asList(fields));
    }

    @Override
    public Selecter groupBy(List<String> fields) {
        groupList.addAll(fields);
        return this;
    }

    @Override
    public Selecter having(Consumer<WhereExp> w) {
        addWhere(havingList, w);
        return this;
    }

    @Override
    public Selecter orderBy(String... fields) {
        return orderBy(Arrays.asList(fields));
    }

    @Override
    public Selecter orderBy(List<String> fields) {
        orderList.addAll(fields);
        return this;
    }

    @Override
    public List<Map<String, Object>> fetch(int count) {
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = getSql(sqlParams);
        return fetchInternal(sql, sqlParams, count);
    }
    
    private List<Map<String, Object>> fetchInternal(String sql, List<Object> sqlParams, int count) {
        List<List<Object>> rowSet = dbConn.query(sql, sqlParams, count);
        //
        if (rowSet.isEmpty()) {
            return Collections.emptyList();
        }
        //
        List<Map<String, Object>> dataMapList = new ArrayList<Map<String, Object>>(rowSet.size());
        for (List<Object> row : rowSet) {
            Map<String, Object> dataMap = new LinkedHashMap<String, Object>(row.size());
            for (int i = 0; i < selectList.size(); i++) {
                String key = selectList.get(i);
                int n = key.lastIndexOf(' ');
                if (n >= 0) {
                    key = key.substring(n + 1);
                }
                Object value = row.get(i);
                dataMap.put(key, value);
            }
            dataMapList.add(Collections.unmodifiableMap(dataMap));
        }
        //
        return Collections.unmodifiableList(dataMapList);
    }

    @Override
    public List<Map<String, Object>> fetch(int start, int count) {
        if (apTlBaseConfig.getDbType() == DbType.ORACLE) {
            return fetchWithOracle(start, count);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public List<Map<String, Object>> fetchAll() {
        return fetch(0);
    }

    @Override
    public Map<String, Object> fetchOne() {
        List<Map<String, Object>> rowSet = fetch(1);
        if (rowSet.isEmpty()) {
            return Collections.emptyMap();
        }
        return rowSet.get(0);
    }

    @Override
    public long count() {
        // 查询
        Map<String, Object> row;
        try (SelecterBackup bak = getSelecterBackup(1)) {
            select("count(*) ap_cnt");
            row = fetchOne();
        } 
        // 解析
        Object cnt = row.get("ap_cnt");
        if (cnt instanceof Number) {
            return ((Number) cnt).longValue();
        } else {
            throw new IllegalArgumentException(cnt.getClass().getName());
        }
    }

    private static String joinWhere(List<WhereExp> whereList, List<Object> sqlParams) {
        return whereList.stream().map(w -> w.getExp(sqlParams)).collect(
                Collectors.joining(" and "));
    }

    private static void addWhere(List<WhereExp> whereList, Consumer<WhereExp> w) {
        WhereExp we = new WhereExpImpl();
        w.accept(we);
        if (we.getExpItemCount() > 0) {
            whereList.add(we);
        }
    }
    
    private class SelecterBackup implements AutoCloseable {
        // 备份
        private List<String> oldSelectList;
        
        public SelecterBackup(List<String> newSelectList) {
            // 备份
            oldSelectList = selectList;
            // 替换
            selectList = newSelectList;
        }

        @Override
        public void close() {
            // 还原
            selectList = oldSelectList;
        }
    }
    
    public SelecterBackup getSelecterBackup(int capacity) {
        return getSelecterBackup(new ArrayList<>(capacity));
    }
    
    public SelecterBackup getSelecterBackup(List<String> newSelectList) {
        return new SelecterBackup(new ArrayList<>(newSelectList));
    }
    
    private List<Map<String, Object>> fetchWithOracle(int start, int count) {
        // 获取原始sql
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = getSql(sqlParams);
        // 转换
        String fmt = "select * from (select ap_tab.*, rownum ap_rn from (\n    %s\n) ap_tab) where ap_rn > %s and rownum <= %s";
        String pageSql = String.format(fmt, 
                sql, 
                SqlUtil.formatValue(start, sqlParams),
                SqlUtil.formatValue(count, sqlParams));
        return fetchInternal(pageSql, sqlParams, count);
    }

                              
    /**
     * 分页查询
     * @param curPage 当前页码
     * @param pageSize 记录数
     * @return 分页封装Bean
     */
    @Override
    public IPage<Map<String, Object>> selectMapsPage(long curPage, long pageSize) {
        List<Map<String,Object>> dataList = null;
        long total = count();
        logger.debug("分页查询总数："+total);

        IPage<Map<String,Object>> iPage = new Page<Map<String, Object>>(curPage,pageSize);
        long offset = iPage.offset();
        if (total <= pageSize){
            logger.debug("总记录数少于查询记录数，返回所有数据");
            dataList = fetchAll();
            iPage.setCurrent(0); 
            iPage.setSize(dataList.size());
//            iPage.setPages((long) Math.ceil(dataList.size()/pageSize));
            iPage.setTotal(dataList.size());
        }else if (total <= offset){
            logger.debug("当前所查的记录范围超出总记录数，返回最后一页");
//            iPage.setPages((long) Math.ceil(total/pageSize));
            iPage.setTotal(total);
            iPage.setCurrent(iPage.getPages());
            logger.debug(iPage.getCurrent()+":"+iPage.offset()+":"+iPage.getSize()+":"+iPage.getTotal()+":"+iPage.getPages());
            dataList = fetch((int)(iPage.offset()),(int)iPage.getSize()); //XXX long int统一一下
            if (dataList.size()< pageSize) {
				logger.debug("最后一页数据不足所查询的记录数");
				iPage.setSize(dataList.size());
			}
            
        }else {
            logger.debug("查询范围："+offset+"至"+(offset+pageSize));
            iPage.setTotal(total);
            dataList = fetch((int) offset,(int)iPage.getSize());
            if (dataList.size()< pageSize) {
				logger.debug("该页数据不足所查询的记录数");
				iPage.setSize(dataList.size());
			}
//            iPage.setCurrent(curPage);
//            iPage.setPages((long) Math.ceil(total/pageSize));
//            iPage.setSize(pageSize);
            
        }
        iPage.setRecords(dataList);
        return iPage;
    }

}
