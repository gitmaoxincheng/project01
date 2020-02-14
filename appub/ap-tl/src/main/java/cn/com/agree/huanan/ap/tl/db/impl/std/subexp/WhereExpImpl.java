package cn.com.agree.huanan.ap.tl.db.impl.std.subexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExpItem;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTooShortException;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WhereExpImpl implements WhereExp {
    
    private List<WhereExpItem> whereExpItemList = new ArrayList<WhereExpItem>();

    @Override
    public int getExpItemCount() {
        return whereExpItemList.size();
    }

    @Override
    public String getExp(List<Object> sqlParams) {
        String exp = whereExpItemList.stream()
                .map(i -> i.getExp(sqlParams))
                .collect(Collectors.joining(" and "));
        return exp;
    }

    @Override
    public WhereExp op(String key, String oper, Object value) {
        whereExpItemList.add(new WhereExpItemOp(key, oper, value));
        return this;
    }

    @Override
    public WhereExp eq(String key, Object value) {
        return op(key, "=", value);
    }

    @Override
    public <V> WhereExp between(String key, V v1, V v2) {
        // v1 == v2
        if (Objects.equals(v1, v2)) {
            return eq(key, v1);
        }
        // between
        whereExpItemList.add(new WhereExpItemBetween<V>(key, v1, v2));
        return this;
    }

    @Override
    public <V> WhereExp in(String key, V... values) {
        return in(key, Arrays.asList(values));
    }

    @Override
    public <V> WhereExp in(String key, List<V> values) {
        // empty
        if (values.isEmpty()) {
            throw new ApValueTooShortException(0, 1);
        }
        // name in ('china') -> name = 'a'
        else if (values.size() == 1) {
            return eq(key, values.get(0));
        }
        // in
        whereExpItemList.add(new WhereExpItemIn<V>(key, values));
        return this;
    }

    @Override
    public WhereExp eqAll(Map<String, Object> kvInfo) {
        for (Map.Entry<String, Object> entry : kvInfo.entrySet()) {
            eq(entry.getKey(), entry.getValue());
        }
        return this;
    }

}
