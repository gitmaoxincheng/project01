package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 参数不存在
 * 
 *@author HCP
 *
 *
 */
public class ApParamNotExistException extends ApException {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /**
     * @param key 字段名
     * 如 telrno
     */
    public ApParamNotExistException(String key) {
        super(new Object[] { key });
    }
    /**XXX 错误码咋暂时未配置
     * @param key 字段名
     * @param key 字段描述
     * 如 telrno ，柜员号
     */    
    public ApParamNotExistException(String key,String desc) {
        super(new Object[] { key,desc });
    }
}
