package cn.com.agree.huanan.ap.al.csiusr.branch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HWW 机构不存在
 */
public class BranchInitException extends ApException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public BranchInitException() {
    }
    /**
     * @param brno 机构名
     */
    public BranchInitException(String brno) {
        super(new Object[] {
            brno
        });
    }
}
