package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz
 * 必输字段为空异常
 */
public class ApNullArgsException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param key 字段名
     * @param desc 中文描述
     * 序号2
     */
    public ApNullArgsException(String key,String desc){
        super(2,new String[]{key,desc});
    }

    /**
     * @param key 字段名
     * 序号1
     */
    public ApNullArgsException(String key){
        super(1,new String[]{key});
    }

}
