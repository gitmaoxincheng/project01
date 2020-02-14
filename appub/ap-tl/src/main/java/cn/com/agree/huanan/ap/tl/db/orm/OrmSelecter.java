package cn.com.agree.huanan.ap.tl.db.orm;

import cn.com.agree.huanan.ap.tl.db.po.IPage;

import java.util.List;
import java.util.function.Consumer;

public interface OrmSelecter<T> {
    public OrmSelecter<T> where(Consumer<T> w);
    public OrmSelecter<T> orderBy(Consumer<T> o);
    public List<T> fetch(int count);
    public List<T> fetchAll();
    public List<T> fetch(int start, int count);
    public long count();
    public T fetchOne();
    public IPage<T> selectPage(long curPage, long pageSize);

}
