package cn.com.agree.huanan.ap.rl.aptl.exception;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.aptl.dao.AptlExceptMapperInfoDao;
import cn.com.agree.huanan.ap.rl.aptl.po.AptlExceptMapperInfo;
import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.exception.ExceptionMapper;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class DbExceptionMapper implements ExceptionMapper {
    @Autowired
    Logger logger;
    
    @Autowired
    AptlExceptMapperInfoDao dao;

    @Override
//    @ApCacheable
    public String[] map(String exceptionId,int index, Object[] errorMsgArgs) {
        AptlExceptMapperInfo po = dao.findException(exceptionId,index);
        if (po == null) {
            if (errorMsgArgs != null && errorMsgArgs.length > 0) {
                logger.error("%s", formatArgs(errorMsgArgs));
            }
            return new String[] { "0310E99999", "错误码没配置" };//东莞银行标准错误码
        }
        String errorMsg = po.getErrorMsg();
        if (errorMsgArgs != null && errorMsg.length() > 0) {
            errorMsg = String.format(errorMsg, errorMsgArgs);
        }
        return new String[] {
                po.getErrorCode(),
                errorMsg
        };
    }



    private static String formatArgs(Object[] errorMsgArgs) {
        for (int i = 0; i < errorMsgArgs.length; i++) {
            Object arg = errorMsgArgs[i];
            if (arg != null && arg.getClass().isArray()) {
                errorMsgArgs[i] = Arrays.asList((Object[])arg);
            }
        }
        return Arrays.toString(errorMsgArgs);
    }



	public String[] map(String string, String[] errorMsgArgs) {
		// TODO 自动生成的方法存根
		return null;
	}
}
