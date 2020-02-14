package cn.com.agree.huanan.ap.tl.db.impl.std.subexp;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExpItem;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;

class WhereExpItemIn<V> implements WhereExpItem {
    private final String key;
    private final List<V> valueList;

    public WhereExpItemIn(String key, List<V> valueList) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(valueList);
        this.key = key;
        this.valueList = valueList;
    }

    @Override
    public String getExp(List<Object> sqlParams) {
        String valueNew = valueList.stream()
                .map(v -> SqlUtil.formatValue(v, sqlParams))
                .collect(Collectors.joining(", "));
        return String.format("%s in (%s)", key, valueNew);
    }
}
