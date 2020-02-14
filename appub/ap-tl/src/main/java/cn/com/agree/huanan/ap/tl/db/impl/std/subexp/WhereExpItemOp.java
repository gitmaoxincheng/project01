package cn.com.agree.huanan.ap.tl.db.impl.std.subexp;

import java.util.List;
import java.util.Objects;

import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExpItem;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;

class WhereExpItemOp implements WhereExpItem {
    private final String key;
    private final String oper;
    private final Object value;

    public WhereExpItemOp(String key, String oper, Object value) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(oper);
        // TODO: 限制oper范围，做数据库兼容处理
        this.key = key;
        this.oper = oper;
        this.value = value;
    }

    @Override
    public String getExp(List<Object> sqlParams) {
        String valueNew = SqlUtil.formatValue(value, sqlParams);
        return String.format("%s %s %s", key, oper, valueNew);
    }
}
