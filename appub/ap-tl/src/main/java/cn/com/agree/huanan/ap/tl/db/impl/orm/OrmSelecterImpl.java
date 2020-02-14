package cn.com.agree.huanan.ap.tl.db.impl.orm;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.po.Page;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.util.DbUtil;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.PojoUtil;
import cn.com.agree.huanan.ap.tl.util.PojoUtil.PojoFieldInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.function.Consumer;

/**
 * orm实现
 * 
 * @author tan.ch
 *
 * @param <T> 实体类型
 */
@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrmSelecterImpl<T> implements OrmSelecter<T> {
    @Autowired
    private DbOperator dbOper;
    /** po类型 */
    private final Class<T> poType;
    @Autowired Logger logger;

    /** where信息 */
    private Map<String, Object> whereInfo = new LinkedHashMap<String, Object>();

    /** orderBy信息 */
    private List<String> orderList = new ArrayList<String>();

    /**
     * 构造方法
     * 
     * @param poType po类型
     */
    public OrmSelecterImpl(Class<T> poType) {
        this.poType = poType;
    }

    @Override
    public OrmSelecter<T> where(Consumer<T> w) {
        whereInfo.putAll(OrmPoCollectors.collectWhere(poType, w));
        return this;
    }

    @Override
    public OrmSelecter<T> orderBy(Consumer<T> o) {
        orderList.addAll(OrmPoCollectors.collectOrderBy(poType, o));
        return this;
    }

    @Override
    public List<T> fetch(int count) {
        // 获取表名
        Table tabAnnotation = poType.getAnnotation(Table.class);
        Class<?> tabObj = tabAnnotation.value();
        String tabName = tabObj.getSimpleName().toLowerCase();
        // 获取字段信息
        Map<String, PojoFieldInfo> poFieldInfo = PojoUtil.getPojoFieldInfo(poType);
        // 传递信息
        List<Map<String, Object>> rowSet = dbOper.getSelecter()
            .select(poFieldInfo.keySet().toArray(new String[0]))
            .from(tabName)
            .where(w -> {
                whereInfo.forEach((k, v) -> w.eq(k, v));
            })
            .orderBy(orderList)
            .fetch(count);
        if (rowSet.isEmpty()) {
            return Collections.emptyList();
        }
        // 转换为po
        List<T> poList = new ArrayList<T>(rowSet.size());
        for (Map<String, Object> row : rowSet) {
            // 创建po
            T poInstance = PojoUtil.createInstance(poType);
            // 转换
            row.entrySet().stream().forEach(entry -> {
                PojoFieldInfo info = poFieldInfo.get(entry.getKey());
                Object value = entry.getValue();

                // 处理Number
                    if (value instanceof Number) {
                        Number num = (Number) value;
                        if (info.fieldType == int.class || info.fieldType == Integer.class) {
                            value = num.intValue();
                        } else if (info.fieldType == long.class || info.fieldType == Long.class) {
                            value = num.longValue();
                        }
                    }
                    // 调用setter
                    try {
                        info.setMethod.invoke(poInstance, value);
                    } catch (ReflectiveOperationException ex) {
                        throw ExceptionUtil.convert(ex);
                    }catch (IllegalArgumentException e) {
                    	if (value != null) {
                    		logger.error("定义字段名：%s,类型: %s,实际值类型：%s",info.fieldName,info.fieldType,value.getClass().getName());	
						}else {
							logger.error("定义字段名：%s,类型: %s,请核查返回内容类型",info.fieldName,info.fieldType);
						}
		            	throw ExceptionUtil.convert(e);
					}
                });
            // 保存
            poList.add(poInstance);
        }
        // 
        return poList;
    }

    public long count() {
        // 获取表名
        Table tabAnnotation = poType.getAnnotation(Table.class);
        Class<?> tabObj = tabAnnotation.value();
        String tabName = tabObj.getSimpleName().toLowerCase();
        // 获取字段信息
        Map<String, PojoFieldInfo> poFieldInfo = PojoUtil.getPojoFieldInfo(poType);
        // 传递信息
        long count = dbOper.getSelecter()
                .select(poFieldInfo.keySet().toArray(new String[0]))
                .from(tabName)
                .where(w -> {
                    whereInfo.forEach((k, v) -> w.eq(k, v));
                }).count();
        return count;

    }


    public List<T> fetch(int start, int count) {
        // 获取表名
        Table tabAnnotation = poType.getAnnotation(Table.class);
        Class<?> tabObj = tabAnnotation.value();
        String tabName = tabObj.getSimpleName().toLowerCase();
        // 获取字段信息
        Map<String, PojoFieldInfo> poFieldInfo = PojoUtil.getPojoFieldInfo(poType);
        // 传递信息
        List<Map<String, Object>> rowSet = dbOper.getSelecter()
                .select(poFieldInfo.keySet().toArray(new String[0]))
                .from(tabName)
                .where(w -> {
                    whereInfo.forEach((k, v) -> w.eq(k, v));
                })
                .orderBy(orderList)
                .fetch(start,count);
        if (rowSet.isEmpty()) {
            return Collections.emptyList();
        }
        // 转换为po
        List<T> poList = new ArrayList<T>(rowSet.size());
        for (Map<String, Object> row : rowSet) {
            // 创建po
            T poInstance = PojoUtil.createInstance(poType);
            // 转换
            row.entrySet().stream().forEach(entry -> {
                PojoFieldInfo info = poFieldInfo.get(entry.getKey());
                Object value = entry.getValue();
                // 处理Number
                if (value instanceof Number) {
                    Number num = (Number) value;
                    if (info.fieldType == int.class) {
                        value = num.intValue();
                    } else if (info.fieldType == long.class) {
                        value = num.longValue();
                    }
                }
                // 调用setter
                try {
                    info.setMethod.invoke(poInstance, value);
                } catch (ReflectiveOperationException ex) {
                    throw ExceptionUtil.convert(ex);
                }
            });
            // 保存
            poList.add(poInstance);
        }
        //
        return poList;
    }

    @Override
    public List<T> fetchAll() {
        return fetch(0);
    }

    @Override
    public T fetchOne() {
        List<T> retList = fetch(1);
        if (retList.isEmpty()) {
            return null;
        } else {
            return retList.get(0);
        }
    }

    /**
     * 分页查询
     * @param curPage 当前页码
     * @param pageSize 记录数
     * @return 分页封装Bean
     */
    public IPage<T> selectPage(long curPage, long pageSize) {
        // 获取表名
        Table tabAnnotation = poType.getAnnotation(Table.class);
        Class<?> tabObj = tabAnnotation.value();
        String tabName = tabObj.getSimpleName().toLowerCase();
        // 获取字段信息
        Map<String, PojoFieldInfo> poFieldInfo = PojoUtil.getPojoFieldInfo(poType);
        // 传递信息
        IPage<Map<String, Object>> iPage = dbOper.getSelecter()
                .select(poFieldInfo.keySet().toArray(new String[0]))
                .from(tabName)
                .where(w -> {
                    whereInfo.forEach((k, v) -> w.eq(k, v));
                })
                .orderBy(orderList).selectMapsPage(curPage,pageSize);

        IPage<T> pagePos = new Page<>(iPage.getCurrent(),iPage.getSize());
        pagePos.setTotal(iPage.getTotal());

        if (iPage.getSize() < 1) {
            return pagePos.setRecords(null);
        }
        List<T> records = DbUtil.transferDbPos(poType, iPage.getRecords());
        pagePos.setRecords(records);
        return pagePos;
    }



}
