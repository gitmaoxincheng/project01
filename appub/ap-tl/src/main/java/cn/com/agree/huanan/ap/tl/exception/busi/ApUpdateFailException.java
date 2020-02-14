package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 更新失败
 */
public class ApUpdateFailException extends ApException {

    private static final long serialVersionUID = -1;
    /**
     * @param key 更新内容
     */
    public ApUpdateFailException(String key) {
        super(new Object[]{key});
    }

    /**
     * @param key 更新内容
     * @param condition 更新关键字
     */
    public ApUpdateFailException(String key, String condition) {
        super(new Object[]{key,condition});
    }


}
