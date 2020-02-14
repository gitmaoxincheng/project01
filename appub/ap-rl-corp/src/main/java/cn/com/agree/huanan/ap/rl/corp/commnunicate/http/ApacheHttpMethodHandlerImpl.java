package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;



import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.FutureRequestExecutionService;
import org.apache.http.impl.client.HttpRequestFutureTask;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.CommAbandException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.CommFailedException;
import cn.com.agree.huanan.ap.tl.communicate.comm.msg.SendMessage;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.HttpCommParam;
import cn.com.agree.huanan.ap.tl.communicate.http.base.HttpHeaderDefine;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherHandler;
import cn.com.agree.huanan.ap.tl.communicate.http.handler.impl.HttpMethodHandlerImpl;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommConnectException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommTimeOutException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author luo.hp
 *
 */
public abstract class ApacheHttpMethodHandlerImpl extends HttpMethodHandlerImpl{

	/**
	 * 日志句柄
	 */
	public static final Logger logger =  Logger.getLogger(ApacheHttpMethodHandlerImpl.class);

	protected Map<String, String> getDefaultStringHeaderMap(){
		HttpHeaderDefine define = new  HttpHeaderDefine();
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put(define.getContentType(), ContentType.APPLICATION_JSON.getMimeType());
		return headerMap;
	}

	protected Map<String, String> getDefaultBytesHeaderMap(){
		HttpHeaderDefine define = new  HttpHeaderDefine();
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put(define.getContentType(), ContentType.APPLICATION_OCTET_STREAM.getMimeType());
		return headerMap;
	}

	@Override
	protected void setHeader(HttpRequestBase httRequst, Map<String, String> headers) {
		// TODO 自动生成的方法存根
		if ( headers != null && headers.size() > 0 ) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				logger.debug("Key: %s, Value: %s", entry.getKey(), entry.getValue());
				httRequst.addHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * @param httpRequestBase HttpRequestBase请求实体
	 * @param httpParams Http通信参数
	 * @param msg 报文信息
	 * @return 通信容器
	 */
	public CommContext syncDoing(HttpRequestBase httpRequestBase, HttpCommParam httpParams, final SendMessage msg) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpclient = null;

		HttpContext localContext = new BasicHttpContext();
		HttpClientContext context = HttpClientContext.adapt(localContext);
		try {
			httpclient = ApachePooledHttpClientAdaptor.getPooledHttpClientAdaptor().getHttpClient(httpParams.getConnTimeOut(), httpParams.getSockTimeOut());
			response = httpclient.execute(httpRequestBase, context);
			if (response == null || response.getStatusLine() == null) {
				logger.error("Http响应信息response为空");
				return CommContext.getCommAbandonContext(new CommAbandException(httpParams.getAppId()));
			}

			int statusCode = response.getStatusLine().getStatusCode();
			if ( statusCode == HttpStatus.SC_OK ) {
				logger.info("Http返回成功状态码：%d", statusCode);
				return ApacheHttpUtils.getContent(response.getEntity(), httpParams.getEncoding());
			}
			logger.info("Http返回失败状态码：%d", statusCode);
			return CommContext.getFailedCommContext(new CommFailedException(httpParams.getAppId()));
		} catch (Throwable ex) {
			logger.exception(ex);
			// 通信超时
			if (ex instanceof SocketTimeoutException || ex instanceof TimeoutException ) {
				return CommContext.getCommAbandonContext(new ApCommTimeOutException(httpParams.getAppId()));
			}
			// 通信连接错误
			else if (ex instanceof ConnectException || ex instanceof ConnectTimeoutException) {
				return CommContext.getCommAbandonContext(new ApCommConnectException(httpParams.getAppId()));
			}
			//其它异常
			return CommContext.getCommAbandonContext(new CommAbandException(httpParams.getAppId()));
		}

		/* catch(NullHttpEntityException exception){ 
            logger.error(ExceptionUtil.getStackTrace(exception));
            return CommContext.getFailedCommContext(new CommFailedException(httpParams.getAppId()));
        }
        catch (ClientProtocolException exception) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(exception));
            return CommContext.getFailedCommContext(new CommFailedException(httpParams.getAppId()));
        }
        catch (IOException exception) {
            // TODO 自动生成的 catch 块
            logger.error(ExceptionUtil.getStackTrace(exception));
            return CommContext.getCommAbandonContext(new CommAbandException(httpParams.getAppId()));
        }*/
		finally {
			if ( response != null ){
				try {
					response.close();
				} catch (IOException exception) {
					// TODO 自动生成的 catch 块
					logger.error(ExceptionUtil.getStackTrace(exception));
				}
			}
			//            if (httpclient != null){
			//                try {
			//                    httpclient.close();
			//                } catch (IOException exception) {
			//                    // TODO 自动生成的 catch 块
			//                    logger.error(ExceptionUtil.getStackTrace(exception));
			//                }
			//            }
		}
	}


	// 异步调用
	protected FurtherHandler asyncDoing(HttpRequestBase httpRequestBase, HttpCommParam httpParams, SendMessage msg, ApacheFutureCallback callback) {
		CloseableHttpClient httpclient = null;
		FutureRequestExecutionService futureRequestExecutionService = null;
		try {
			HttpContext localContext = new BasicHttpContext();
			HttpClientContext context = HttpClientContext.adapt(localContext);

			httpclient = ApachePooledHttpClientAdaptor.getPooledHttpClientAdaptor().getHttpClient(httpParams.getConnTimeOut(), httpParams.getSockTimeOut());
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			futureRequestExecutionService = new FutureRequestExecutionService(httpclient, executorService);
			HttpRequestFutureTask<CommContext> task = null;
			if (callback == null){
				task = futureRequestExecutionService.execute(httpRequestBase, context, new ApacheResponseHandler());
			}else{
				task = futureRequestExecutionService.execute(httpRequestBase, context, new ApacheResponseHandler(), callback);
			}
			return new ApacheFutureHandler(task);
		}
		finally {
			if (httpclient != null){
				try {
					httpclient.close();
				} catch (IOException exception) {
					// TODO 自动生成的 catch 块
					logger.error(ExceptionUtil.getStackTrace(exception));
				}
			}
			if (futureRequestExecutionService != null){
				try {
					futureRequestExecutionService.close();
				} catch (IOException exception) {
					// TODO 自动生成的 catch 块
					logger.error(ExceptionUtil.getStackTrace(exception));
				}
			}
		}
	}
}
