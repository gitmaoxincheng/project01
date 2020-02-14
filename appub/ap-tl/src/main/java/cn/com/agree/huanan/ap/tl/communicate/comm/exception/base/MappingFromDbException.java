package cn.com.agree.huanan.ap.tl.communicate.comm.exception.base;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * 从数据库加载错误信息,数据库中配置的错误信息带格式化标识,在errorMsgArgs中放入格式化内容,自动格式化错误信息
 * 映射主键即类完整路径
 * @author xqq
 *
 */

public class MappingFromDbException extends ApException{

	public MappingFromDbException(Object[] errorMsgArgs) {
		// TODO 自动生成的构造函数存根
		super(errorMsgArgs);
	}
	
	public MappingFromDbException() {
		// TODO 自动生成的构造函数存根
	}
	/**
	 * 异常基础类
	 */
	private static final long serialVersionUID = 1L;
}
