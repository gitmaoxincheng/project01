package cn.com.agree.huanan.ap.tl.communicate.comm.context;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.AbandonException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.FailedException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.SuccessException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.error.ErrorStatus;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.RecvMessage;

/**
 * @author luo.hp
 * @category 通信结果容器
 */
public class CommContext implements ErrorStatus{
	
	private RecvMessage   msg;
	private int       	  status;
	private BaseException exception;
	 
	/**
	 * @return 获取通信结果消息
	 */
	public RecvMessage getMessage() {
	    if (!this.isSuccess()){
	        throw getException();
	    }
	    return msg;
	}
	
	/**
	 * @return 获取通信异常信息
	 */
	public BaseException getException(){
		return exception;
	}
	
	private CommContext(int status, BaseException exception, RecvMessage msg){
		this.status = status;
		this.exception = exception;
		this.msg =msg;
	}
	
    /**
     * @return 通信成功容器（无需返回值）
     */
	public static CommContext getCommContext(){
		return getCommContext(null);
	}
	
	/**
	 * @param msg 通信返回信息
	 * @return 通信成功容器
	 */
	public static CommContext getCommContext(RecvMessage msg){
		return new CommContext(Const.ERROR_TYPE_SUCCESS, SuccessException.getException(), msg);
	}
	
    /**
     * @return 失败通信结果
     */
	public static CommContext getFailedCommContext(){
		return getFailedCommContext(null);
	}
	
    /**
     * @param exception 失败
     * @return 失败通信结果
     */
	public static CommContext getFailedCommContext(BaseException exception){
		if (exception == null){
			exception = FailedException.getFailed();
		}
		return new CommContext(Const.ERROR_TYPE_FAILED, exception, null);
	}
	
    /**
     * @return 异常通信结果（默认）
     */
	public static CommContext getCommAbandonContext(){
		return getCommAbandonContext(null);
	}
	
	/**
	 * @param exception 异常
	 * @return 异常通信结果
	 */
	public static CommContext getCommAbandonContext(BaseException exception){
		if (exception == null){
			exception = AbandonException.getAbandon();
		}
		return new CommContext(Const.ERROR_TYPE_ABAND, exception, null);
	}
	
	@Override
	public int getStatus() {
		// TODO 自动生成的方法存根
		return status;
	}

	@Override
	public boolean isSuccess() {
		// TODO 自动生成的方法存根
		return status == Const.ERROR_TYPE_SUCCESS;
	}

	@Override
	public boolean isFailed() {
		// TODO 自动生成的方法存根
		return status == Const.ERROR_TYPE_FAILED;
	}

	@Override
	public boolean isAbandon() {
		// TODO 自动生成的方法存根
		return status == Const.ERROR_TYPE_ABAND;
	}
}
