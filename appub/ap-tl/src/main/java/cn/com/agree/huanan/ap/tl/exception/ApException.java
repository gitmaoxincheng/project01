package cn.com.agree.huanan.ap.tl.exception;

import java.util.Objects;

import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 应用平台异常
 * 
 * @author tan.ch
 *
 */
public abstract class ApException extends RuntimeException implements ExceptionInfo {
    /** 序列化版本标识 */
    private static final long serialVersionUID = 1L;

    /** 是否已初始化 */
    private boolean isInitialized = false;
    /** 错误系统标识 */
    private final String errorAppId;
    /**序号*/
    private int index;
    /** 错误代码 */
    private String errorCode;
    /** 错误信息 */
    private String errorMsg;
    /** 错误信息参数 */
    private final Object[] errorMsgArgs;

    /**
     * 构造方法（无参）
     * 
     */
    protected ApException() {
        this((Object[]) null);
    }

    /**
     * 构造方法（有参）
     * 
     * @param errorMsgArgs 错误信息参数
     */
    protected ApException(Object[] errorMsgArgs) {
    	this.index = 1;
        this.errorAppId = "";
        this.errorMsgArgs = errorMsgArgs;
    }
    /**
     * 构造方法（有参）
     * 
     * @param errorMsgArgs 错误信息参数
     */
    protected ApException(int index, Object[] errorMsgArgs) {
    	this.index = index;
        this.errorAppId = "";
        this.errorMsgArgs = errorMsgArgs;
    }
    
    
    /**
     * 构造方法（异常链）
     * 
     * @param ex 源异常
     */
    protected ApException(Throwable ex) {
        super(ex);
        this.index = 1;
        this.errorAppId = "";
        this.errorMsgArgs = new Object[] { ex.getClass(), ex.getMessage() };
    }

    /**
     * 构造方法，本方法用于构造外部错误（如DB里面现有的错误信息，核心返回的错误信息），默认返回第一条
     * 
     * @param errorAppId 错误系统标识
     * @param errorCode 错误代码
     * @param errorMsg 错误信息
     */
    protected ApException(String errorAppId,String errorCode, String errorMsg) {
        // 校验
    	this(errorAppId,1,errorCode,errorMsg);
    }
    
    
    /**
     * 构造方法，本方法用于构造外部错误（如DB里面现有的错误信息，核心返回的错误信息）
     * 
     * @param errorAppId 错误系统标识
     * @param errorCode 错误代码
     * @param errorMsg 错误信息
     */
    protected ApException(String errorAppId,int index, String errorCode, String errorMsg) {
        // 校验
        Objects.requireNonNull(errorAppId);
        Objects.requireNonNull(errorCode);
        Objects.requireNonNull(errorMsg);
        // 初始化
        this.errorAppId = errorAppId;
        this.index = index;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorMsgArgs = null;
        // 标记
        this.isInitialized = true;
    }
    
    @Override
    public final String toString() {
        return String.format("%s: %s", this.getClass().getName(), getErrorMsg());
    }

    @Override
    public final String getErrorAppId() {
        return errorAppId;
    }

    @Override
    public final String getErrorCode() {
        mapErrorInfo();
        return errorCode;
    }

    @Override
    public final String getErrorMsg() {
        mapErrorInfo();
        return errorMsg;
    }

    private void mapErrorInfo() {
        // 判断是否已初始化
        if (isInitialized) {
            return;
        }
        // 映射
        ExceptionMapper mapper = SpringUtil.getBean(ExceptionMapper.class);
        String[] errorInfo = mapper.map(getClass().getName(),index, errorMsgArgs);
        // 检查返回
        Objects.requireNonNull(errorInfo);
        if (errorInfo.length != 2) {
            throw new IllegalArgumentException();
        }
        // 保存返回
        errorCode = errorInfo[0];
        errorMsg = errorInfo[1];
        // 标记已初始化
        isInitialized = true;
    }
}
