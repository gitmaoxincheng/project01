package cn.com.agree.huanan.ap.al.csiusr.branch.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author HCP 机构不存在
 */
public class BranchNotFoundException extends ApException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public BranchNotFoundException() {
    }
    /**
     * @param brno 机构名
     */
    public BranchNotFoundException(String brno) {
        super(new Object[] {
            brno
        });
    }
}
