package cn.com.agree.huanan.ap.tl.db.std.operator;

import java.util.Map;
import java.util.function.Consumer;

import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;

public interface Updater extends BaseUpdateOperator<Updater> {
    public Updater update(String tabName);
    public Updater set(String key, Object value);
    public Updater set(Map<String, Object> kvInfo);
    public Updater where(Consumer<WhereExp> w);
}
