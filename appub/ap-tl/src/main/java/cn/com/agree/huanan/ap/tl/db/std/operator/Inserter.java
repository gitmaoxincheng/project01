package cn.com.agree.huanan.ap.tl.db.std.operator;

import java.util.Map;

public interface Inserter extends BaseUpdateOperator<Inserter> {
    public Inserter insertInto(String tabName);
    public Inserter values(String key, Object value);
    public Inserter values(Map<String, Object> kvInfo);
}
