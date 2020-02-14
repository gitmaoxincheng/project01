package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP
 *  删除失败
 */
public class ApDeleteFailException extends ApException {

    private static final long serialVersionUID = -1;
    /**
     * @param desc 删除内容
     *  示例：desc 柜员信息  - 柜员信息删除失败
     */
    public ApDeleteFailException(String desc) {
        super(new Object[]{desc});
    }

    /**
     * @param desc 删除内容
     * @param condition 删除关键字/要素
     * 示例：desc 柜员信息 condition 柜员号XXX  - 柜员信息删除失败，要素：柜员号XXX
     */
    public ApDeleteFailException(String desc, String condition) {
        super(new Object[]{desc,condition});
    }


}
