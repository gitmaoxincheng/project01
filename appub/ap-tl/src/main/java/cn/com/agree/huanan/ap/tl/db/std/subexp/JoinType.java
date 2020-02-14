package cn.com.agree.huanan.ap.tl.db.std.subexp;

/**
 * join类型
 * 
 * @author tan.ch
 *
 */
public enum JoinType {
    InnerJoin("inner join"), 
    FullJoin("full join"), 
    LeftJoin("left join"), 
    RightJoin("right join");

    /** 表达式 */
    private final String repr;

    /**
     * 构造方法
     * 
     * @param repr 表达式
     */
    private JoinType(String repr) {
        this.repr = repr;
    }

    /**
     * 转换为字符串
     */
    public String toString() {
        return repr;
    }
}
