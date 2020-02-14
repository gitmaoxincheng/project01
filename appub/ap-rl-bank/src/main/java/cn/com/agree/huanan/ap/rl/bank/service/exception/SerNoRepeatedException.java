package cn.com.agree.huanan.ap.rl.bank.service.exception;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author acz
 * 流水号重复
 */
public class SerNoRepeatedException extends ApException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param SerNo 流水号
     */
    public SerNoRepeatedException(String sysId,String SerNo){
        super(new String[]{sysId,SerNo});
    }

}
