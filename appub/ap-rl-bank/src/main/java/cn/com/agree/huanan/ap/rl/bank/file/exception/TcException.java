package cn.com.agree.huanan.ap.rl.bank.file.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * TC文件传输异常类
 * @author YYX
 */
public class TcException extends ApException {

	private static final long serialVersionUID = 1L;

	public TcException() {
		
	}

    /**
     * @param errMsg 错误信息
     */
    public TcException(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
