package cn.com.agree.huanan.ap.tl.communicate.comm.exception.validator;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.MappingFromDbException;


public class VaildateFailureException  extends MappingFromDbException{
	/**
	 * 字段校验不通过
	 */
	private static final long serialVersionUID = 1L;
	public VaildateFailureException(Object [] messagePara){
		super(messagePara);
	}
	

}
