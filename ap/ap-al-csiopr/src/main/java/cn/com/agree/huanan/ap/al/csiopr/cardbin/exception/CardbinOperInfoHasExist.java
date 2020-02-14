package cn.com.agree.huanan.ap.al.csiopr.cardbin.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CardbinOperInfoHasExist extends ApException{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public CardbinOperInfoHasExist() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public CardbinOperInfoHasExist(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}