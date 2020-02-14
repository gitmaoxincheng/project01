package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.impl.std.subexp.WhereExpImpl;
import cn.com.agree.huanan.ap.tl.db.std.operator.Deleter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DeleterImpl extends AbstractBaseUpdateOperator<Deleter> implements Deleter {
    private String tabName;
    private List<WhereExp> whereList = new ArrayList<WhereExp>();

    @Override
    public String getSql() {
        return getSql(null);
    }

    @Override
    public String getSql(List<Object> sqlParams) {
        StringJoiner joiner = new StringJoiner(" ");
        // delete
        joiner.add("delete from");
        joiner.add(tabName);
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
    public Deleter deleteFrom(String tabName) {
        // TODO 校验表名重复
        this.tabName = tabName;
        return this;
    }

    @Override
    public Deleter where(Consumer<WhereExp> w) {
        WhereExp we = new WhereExpImpl();
        w.accept(we);
        if (we.getExpItemCount() > 0) {
            whereList.add(we);
        }
        return this;
    }

}
