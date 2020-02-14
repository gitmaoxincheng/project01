package cn.com.agree.huanan.ap.tl.db.std.operator;

import java.util.function.Consumer;

import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;

public interface Deleter extends BaseUpdateOperator<Deleter> {
    public Deleter deleteFrom(String tabName);
    public Deleter where(Consumer<WhereExp> w);
}
