package cn.com.agree.huanan.ap.tl.db.orm;

public interface OrmOperator {
    public <T> OrmSelecter<T> getOrmSelecter(Class<T> poType);
    public <T> OrmUpdater<T> getOrmUpdater(Class<T> poType);
}
