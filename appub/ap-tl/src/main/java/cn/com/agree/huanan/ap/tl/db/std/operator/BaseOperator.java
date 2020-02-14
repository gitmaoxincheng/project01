package cn.com.agree.huanan.ap.tl.db.std.operator;

import java.util.List;

public interface BaseOperator<T> {
    //public T limit(int count);
    //public T offset(int offset);
    //public T setBatchMode(boolean batchMode);
    public String getSql();
    public String getSql(List<Object> sqlParams);
}
