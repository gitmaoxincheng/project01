package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 查询无数据
 */
public class ApSelectNotFoundException extends ApException {

    private static final long serialVersionUID = -1;
    
    /**
     * @param key 查询内容
     */
    public ApSelectNotFoundException() {
        super(new Object[]{});
    }
    
    /**
     * @param desc 查询内容
     */
    public ApSelectNotFoundException(String desc) {
        super(2,new Object[]{desc});
    }

    /**
     * @param desc 查询内容
     * @param key 查询关键字
     */
    public ApSelectNotFoundException(String desc,String key) {
        super(3,new Object[]{desc,key});
    }


}
