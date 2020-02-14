package cn.com.agree.huanan.ap.tl.db.std.subexp;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * where表达式
 * 
 * @author tan.ch
 *
 */
public interface WhereExp {
    /**
     * 获取表达式数量
     * 
     * @return 表达式数量
     */
    public int getExpItemCount();

    /**
     * 获取表达式
     * 
     * @param sqlParams sql参数，null则不使用参数化
     * @return 表达式
     */
    public String getExp(List<Object> sqlParams);

    public WhereExp op(String key, String oper, Object value);

    public WhereExp eq(String key, Object value);

    public <V> WhereExp between(String key, V v1, V v2);

    public <V> WhereExp in(String key, V... values);

    public <V> WhereExp in(String key, List<V> values);

    public WhereExp eqAll(Map<String, Object> kvInfo);

    //public WhereExp and(Consumer<WhereExp> w);

    //public WhereExp or(Consumer<WhereExp> w);

    //public WhereExp not(Consumer<WhereExp> w);
}
