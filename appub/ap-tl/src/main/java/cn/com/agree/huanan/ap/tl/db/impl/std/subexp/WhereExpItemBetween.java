package cn.com.agree.huanan.ap.tl.db.impl.std.subexp;

import java.util.List;
import java.util.Objects;

import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExpItem;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;

class WhereExpItemBetween<T> implements WhereExpItem {
    private final String key;
    private final T v1;
    private final T v2;
    
    public WhereExpItemBetween(String key, T v1, T v2) {
        Objects.requireNonNull(key);
        this.key = key;
        this.v1 = v1;
        this.v2 = v2;
    }
    
    @Override
    public String getExp(List<Object> sqlParams) {
        String v1New = SqlUtil.formatValue(v1, sqlParams);
        String v2New = SqlUtil.formatValue(v2, sqlParams);
        return String.format("%s between %s and %s", key, v1New, v2New);
    }
}
