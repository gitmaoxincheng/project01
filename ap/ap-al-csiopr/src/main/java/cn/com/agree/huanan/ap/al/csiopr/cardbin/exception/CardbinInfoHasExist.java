package cn.com.agree.huanan.ap.al.csiopr.cardbin.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

public class CardbinInfoHasExist extends ApException{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param errMsg 错误信息
     */
    public CardbinInfoHasExist() {
        
    }
    /**
     * @param errMsg 错误信息
     */
    public CardbinInfoHasExist(String errMsg) {
        super(new Object[] {
            errMsg
        });
    }

}
