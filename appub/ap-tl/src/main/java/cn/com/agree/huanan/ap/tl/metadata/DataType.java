package cn.com.agree.huanan.ap.tl.metadata;

/**
 * 数据类型
 * 
 * @author tan.ch
 *
 */
public interface DataType {
    /**
     * 获取原始类型
     * 
     * @return 原始类型
     */
    public Class<?> getRawType();
    
    /**
     * 校验数据
     * 
     * @param input 输入
     * @param minLen 最小长度
     * @param maxLen 最大长度
     */
    public void validate(String input, int minLen, int maxLen);
}
