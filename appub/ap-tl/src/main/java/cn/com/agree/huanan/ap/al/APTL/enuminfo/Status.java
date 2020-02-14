package cn.com.agree.huanan.ap.al.APTL.enuminfo;

import cn.com.agree.huanan.ap.tl.metadata.DataEnum;

/**
 * 状态
 * 
 * @author MetaDataGenerator
 *
 */
public enum Status implements DataEnum {
    /** 成功 */
    SUCCESS("S"),
    /** 失败 */
    FAILURE("F"),
    /** 异常 */
    ABEND("A"),
    ;
    
    /** 代码 */
    private final String code;
    
    /**
     * 构造方法
     * 
     * @param code 代码
     */
    private Status(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}

