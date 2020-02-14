package cn.com.agree.huanan.ap.tl.db.impl.orm;

import java.util.ArrayList;
import java.util.List;

class OrmGetterCollector<T> extends AbstractOrmPoCollector<T> {
    // setter信息：字段名->字段类型
    private final List<String> getterInfo = new ArrayList<String>();
    
    /**
     * 构造方法
     * @param type 类型
     */
    public OrmGetterCollector(Class<T> type) {
        super(type);
    }

    @Override
    protected void procGetterCall(Class<?> fieldType, String fieldName) throws Throwable {
        getterInfo.add(fieldName);
    }
    
    public List<String> getGetterInfo() {
        return getterInfo;
    }
}
