package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InserterImpl extends AbstractBaseUpdateOperator<Inserter> implements Inserter {
    private String tabName;
    private Map<String, Object> kvInfo = new LinkedHashMap<String, Object>();

    @Override
    public String getSql() {
        return getSql(null);
    }

    @Override
    public String getSql(List<Object> sqlParams) {
        StringJoiner keyJoiner = new StringJoiner(", ");
        StringJoiner valueJoiner = new StringJoiner(", ");
        for (Map.Entry<String, Object> entry : kvInfo.entrySet()) {
            keyJoiner.add(entry.getKey());
            valueJoiner.add(SqlUtil.formatValue(entry.getValue(), sqlParams));
        }
        String sql = String.format("insert into %s (%s) values (%s)", tabName,
                keyJoiner.toString(), valueJoiner);
        return sql;
    }

    @Override
    public Inserter insertInto(String tabName) {
        // TODO 检查是否重复
        this.tabName = tabName;
        return this;
    }

    @Override
    public Inserter values(String key, Object value) {
    	if (null != value) {
            kvInfo.put(key, value);
		}
        return this;
    }

    @Override
    public Inserter values(Map<String, Object> kvInfo) {
        for (Map.Entry<String, Object> entry : kvInfo.entrySet()) {
        	if (null != entry.getValue()) {
        		this.kvInfo.put(entry.getKey(), entry.getValue());		
			}
        }
        return this;
    }

}
