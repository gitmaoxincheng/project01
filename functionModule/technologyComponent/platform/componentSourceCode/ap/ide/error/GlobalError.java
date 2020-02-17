package ap.ide.error;

import cn.com.agree.afa.svc.context.IContext;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIllegalArgumentException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 * @category 全局错误信息
 *
 */
public class GlobalError {
    
    // 错误类型
    private static final String ERROR_TYPE_KEY = "errorType";
    
    // 错误代码
    private static final String ERROR_CODE_KEY = "errorCode";
    
    // 错误信息
    private static final String ERROR_MSG_KEY = "errorMsg";
    
    // 全局错误对象
    private static GlobalError gError = null;
    
    
    /**
     * 日志句柄
     */
    public static final Logger logger = Logger.getLogger(GlobalError.class);
    
    /**
     * @param dict 错误信息容器
     * @param errorTypeKey 错误类型Key值
     * @param errorCodeKey 错误代码Key值
     * @param errorMsgKey 错误信息Key值
     */
    public void putGlobalErrorToDict(JavaDict dict, String errorTypeKey, String errorCodeKey, String errorMsgKey)
    {
      if (dict == null){
          logger.error("错误容器为null");
          throw new ApIllegalArgumentException(new NullPointerException());
      }
      IContext context = EnvContextHolder.getHolder().getContext();
      errorTypeKey = errorTypeKey==null ? ERROR_TYPE_KEY : errorTypeKey;
      errorCodeKey = errorCodeKey==null ? ERROR_CODE_KEY : errorCodeKey;
      errorMsgKey  = errorMsgKey ==null ? ERROR_MSG_KEY  : errorMsgKey;
      
      if (!dict.containsKey(errorTypeKey)){dict.setItem(errorTypeKey, context.getProperty("ERR_TYPE"));}
      if (!dict.containsKey(errorCodeKey)){dict.setItem(errorCodeKey, context.getProperty("ERR_CODE"));}
      if (!dict.containsKey(errorMsgKey)) {dict.setItem(errorMsgKey,  context.getProperty("ERR_MSG"));}
    }
    
    /**
     * 私有无参构造
     */
    public GlobalError(){
        
    }
    
    /**
     * @return 获取全局错误单体对象
     */
    public static GlobalError getGlobalError(){
        if (gError == null){
            gError = new GlobalError();
        }
        return gError;
    }
}