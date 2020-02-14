package cn.com.agree.huanan.ap.tl.db.std.operator;

import java.util.Map;

/**
 * @author luo.hp
 * @category 存储过程接口
 *
 */
public interface Procedurer {
    /**
     * @param procName 存储过程名称
     * @return 存储过程对象
     */
    public Procedurer procName(String procName);
    /**
     * @param name 输入参数名称
     * @param value 输入参数值
     * @return 存储过程对象
     */
    public Procedurer setInParam(String name, Object value);
    /**
     * @param name 输出参数名称
     * @param cls 参数值类型
     * @return 存储过程对象
     */
    public Procedurer setOutParam(String name, Class<?> cls);
    /**
     * @param name 输入参数名称
     * @param value 输入参数值
     * @return 存储过程对象
     */
    public Procedurer setInOutParam(String name, Object value);
    
    /**
     * 存储过程调用
     * @return 输出参数
     */
    public Map<String, Object> call();
}
