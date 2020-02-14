package cn.com.agree.huanan.ap.tl.db.orm;

import java.util.function.Consumer;

public interface OrmUpdater<T> extends OrmBaseUpdater<T> {
    public OrmUpdater<T> set(Consumer<T> s);
    public OrmUpdater<T> where(Consumer<T> w);
}
