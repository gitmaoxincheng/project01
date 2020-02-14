package cn.com.agree.huanan.ap.tl.db.impl.orm;

import java.util.LinkedHashMap;
import java.util.Map;

class OrmSetterCollector<T> extends AbstractOrmPoCollector<T> {
    // setter信息：字段名->字段值
    private final Map<String, Object> setterInfo = new LinkedHashMap<String, Object>();
    
    /**
     * 构造方法
     * @param type 类型
     */
    public OrmSetterCollector(Class<T> type) {
        super(type);
    }

    @Override
    protected void procSetterCall(Class<?> fieldType, String fieldName, Object fieldValue) throws Throwable {
        setterInfo.put(fieldName, fieldValue);
    }
    
    public Map<String, Object> getSetterInfo() {
        return setterInfo;
    }
}
