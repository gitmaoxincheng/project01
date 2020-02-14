package cn.com.agree.huanan.ap.al.csiopr.keep.exception;
		
import cn.com.agree.huanan.ap.tl.exception.ApException;

public class DeleteKeepFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7202141988466263520L;
	
	/**
     * @param errMsg 错误信息
     */
    public DeleteKeepFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public DeleteKeepFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	
	

}
