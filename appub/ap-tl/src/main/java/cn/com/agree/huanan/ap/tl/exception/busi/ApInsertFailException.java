package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 * 插入失败
 */
public class ApInsertFailException extends ApException {

    private static final long serialVersionUID = -1;
    /**
     * @param key 新增内容
     * 示例：desc: 柜员  - 柜员新增失败
     */
    public ApInsertFailException(String desc) {
        super(new Object[]{desc});
    }

    /**
     * @param desc 新增内容
     * @param key 关键字
     * 示例：desc: 柜员  key: 01000 - 柜员[01000]新增失败
     */
    public ApInsertFailException(String desc, String key) {
        super(2,new Object[]{desc,key});
    }


}
