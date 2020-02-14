package cn.com.agree.huanan.ap.al.csiopr.keeppara.exception;
		
import cn.com.agree.huanan.ap.tl.exception.ApException;

public class DeleteKeepParaFailException extends ApException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7202141988466263520L;
	
	/**
     * @param errMsg 错误信息
     */
    public DeleteKeepParaFailException() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public DeleteKeepParaFailException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }
	
	
	

}
