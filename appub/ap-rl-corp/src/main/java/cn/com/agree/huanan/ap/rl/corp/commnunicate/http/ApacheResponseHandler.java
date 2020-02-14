package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.CommFailedException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.http.HttpFutrueResponseException;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherHandler;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 *
 */
public class ApacheResponseHandler implements ResponseHandler<CommContext>{
    public static Logger logger =  Logger.getLogger(FurtherHandler.class);

    // 默认编码
    private String encoding = cn.com.agree.huanan.ap.tl.communicate.comm.base.Const.DEFAULT_ENCODING; 
    
    @Override
    public CommContext handleResponse(final HttpResponse response) throws IOException {
        if (response == null || response.getStatusLine() == null) {
            logger.error("Http响应信息response为空");
            return CommContext.getCommAbandonContext(HttpFutrueResponseException.getException());
        }

        logger.debug("解析Http返回");
        int statusCode = response.getStatusLine().getStatusCode();
        if ( statusCode == HttpStatus.SC_OK ) {
            logger.debug("Http返回成功状态码：%d", statusCode);
            return ApacheHttpUtils.getContent(response.getEntity(), encoding);
        }
        logger.debug("Http返回失败状态码：%d", statusCode);
        return CommContext.getFailedCommContext(new CommFailedException(""));
    }
    
    /**
     * @param encoding 结果编码
     */
    public void setEncoding(String encoding){
        this.encoding = encoding;
    }
}
