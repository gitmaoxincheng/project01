package cn.com.agree.huanan.ap.tl.communicate.comm.exception.error;

public interface ErrorStatus {
	
	// 获取错误类型
	public int getStatus();
	
	// 成功
	public boolean isSuccess();
	
	// 失败
	public boolean isFailed();
	
	// 异常
	public boolean isAbandon();

}
