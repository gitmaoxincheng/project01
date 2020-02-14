package cn.com.agree.huanan.ap.tl.db.std.subexp;

/**
 * 逻辑连接词
 * 
 * @author tan.ch
 *
 */
public enum LogicConnector {
    And("and"), Or("or");

    /** 表达式 */
    private final String repr;

    /**
     * 构造方法
     * 
     * @param repr 表达式
     */
    private LogicConnector(String repr) {
        this.repr = repr;
    }

    /**
     * 转换为字符串
     */
    public String toString() {
        return repr;
    }
}
