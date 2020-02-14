package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 数据已存在
 */
public class ApDataExistException extends ApException {

    private static final long serialVersionUID = -1;
    /**
     * @param key 查询内容
     */
    public ApDataExistException(String key) {
        super(new Object[]{key});
    }

    /**
     * @param key 查询内容
     * @param condition 查询关键字
     */
    public ApDataExistException(String key, String condition) {
        super(2,new Object[]{key,condition});
    }


}
