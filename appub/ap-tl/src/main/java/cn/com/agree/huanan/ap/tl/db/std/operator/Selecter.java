package cn.com.agree.huanan.ap.tl.db.std.operator;

import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface Selecter extends BaseOperator<Selecter> {
    public Selecter select(String... fields);
    public Selecter select(List<String> fields);
    public Selecter from(String... tabNames);
    //public Selecter from(Selecter selecter, String alias);
    public Selecter join(JoinType joinType, String tab, Consumer<WhereExp> w);
    public Selecter where(Consumer<WhereExp> w);
    public Selecter groupBy(String... fields);
    public Selecter groupBy(List<String> fields);
    public Selecter having(Consumer<WhereExp> w);
    public Selecter orderBy(String... fields);
    public Selecter orderBy(List<String> fields);
    public List<Map<String, Object>> fetch(int count);
    public List<Map<String, Object>> fetch(int start, int count);
    public List<Map<String, Object>> fetchAll();
    public Map<String, Object> fetchOne();
    public long count();
    /**
     * 分页查询
     * @param curPage 当前页码
     * @param pageSize 记录数
     * @return 分页封装数据
     */
    public IPage<Map<String, Object>> selectMapsPage(long curPage, long pageSize);
}
