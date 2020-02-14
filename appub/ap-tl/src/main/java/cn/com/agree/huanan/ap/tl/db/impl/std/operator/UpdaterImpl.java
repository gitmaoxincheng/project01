package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.impl.std.subexp.WhereExpImpl;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UpdaterImpl extends AbstractBaseUpdateOperator<Updater> implements Updater {
    private String tabName;
    private Map<String, Object> setInfo = new LinkedHashMap<String, Object>();
    private List<WhereExp> whereList = new ArrayList<WhereExp>();

    @Override
    public String getSql() {
        return getSql(null);
    }

    @Override
    public String getSql(List<Object> sqlParams) {
        StringJoiner joiner = new StringJoiner(" ");
        // update
        joiner.add("update");
        joiner.add(tabName);
        // set
        joiner.add("set");
        String setExp = setInfo.entrySet().stream().map(entry -> {
            String value = SqlUtil.formatValue(entry.getValue(), sqlParams);
            return String.format("%s = %s", entry.getKey(), value);
        }).collect(Collectors.joining(", "));
        joiner.add(setExp);
        // where
        if (!whereList.isEmpty()) {
            joiner.add("where");
            joiner.add(whereList.stream()
                .map(w -> w.getExp(sqlParams))
                .collect(Collectors.joining(" and ")));
        }
        return joiner.toString();
    }

    @Override
    public Updater update(String tabName) {
        // TODO 校验表名重复
        this.tabName = tabName;
        return this;
    }

    @Override
    public Updater set(String key, Object value) {
    	if (null != value) {
    		setInfo.put(key, value);
		}
        return this;
    }

    @Override
    public Updater set(Map<String, Object> kvInfo) {
        for (Map.Entry<String, Object> entry : kvInfo.entrySet()) {
        	if (null != entry.getValue()) {
        		this.setInfo.put(entry.getKey(), entry.getValue());		
			}
        }
        return this;
    }

    @Override
    public Updater where(Consumer<WhereExp> w) {
        WhereExp we = new WhereExpImpl();
        w.accept(we);
        if (we.getExpItemCount() > 0) {
            whereList.add(we);
        }
        return this;
    }

}
