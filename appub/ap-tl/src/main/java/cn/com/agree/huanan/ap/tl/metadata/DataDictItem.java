package cn.com.agree.huanan.ap.tl.metadata;

import java.util.Optional;

/**
 * 数据字典项
 * 
 * @author tan.ch
 *
 */
public interface DataDictItem {
    /**
     * 获取名称
     * 
     * @return 名称
     */
    public String getName();

    /**
     * 获取中文名称
     * 
     * @return 中文名称
     */
    public String getCnName();

    /**
     * 获取数据类型
     * 
     * @return 数据类型
     */
    public DataType getDataType();

    /**
     * 获取数据枚举
     * 
     * @return 数据枚举
     */
    public Optional<Class<? extends DataEnum>> getDataEnum();

    /**
     * 获取最小长度
     * 
     * @return 最小长度
     */
    public int getMinLen();

    /**
     * 获取最大长度
     * 
     * @return 最大长度
     */
    public int getMaxLen();

    /**
     * 校验
     * 
     * @param input 输入
     */
    public void validate(String input);
}
