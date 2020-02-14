package cn.com.agree.huanan.ap.tl.db.impl.orm;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

class OrmPoCollectors{
    public static <T> Map<String, Object> collectWhere(Class<T> poType, Consumer<T> w) {
        OrmSetterCollector<T> osc = new OrmSetterCollector<>(poType);
        w.accept(osc.getProxy());
        return osc.getSetterInfo();
    }
    
    public static <T> List<String> collectOrderBy(Class<T> poType, Consumer<T> o) {
        OrmGetterCollector<T> ogc = new OrmGetterCollector<>(poType);
        o.accept(ogc.getProxy());
        return ogc.getGetterInfo();
    }
}
