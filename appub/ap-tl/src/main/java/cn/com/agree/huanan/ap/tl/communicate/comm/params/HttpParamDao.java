package cn.com.agree.huanan.ap.tl.communicate.comm.params;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.NoCommParamException;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author HCP
 *
 */
@Component
public class HttpParamDao{
	/**
	 * 通信配置参数
	 */
	public static Logger logger =  Logger.getLogger(HttpParamDao.class);
	@Autowired private ParamQuery paramQuery;
	
	/**
	 * @param appId 应用ID
	 * @param commItem 通信配置项
	 * @param nodeName 节点名称
	 */
    @ApCacheable
	public Map<String, Object> initParams(String appId, String commItem, String nodeName) {
		 Selecter selecter = paramQuery.getQueryOper().getSelecter();
		 Map<String, Object> paramMap = selecter.select("serverUrl", "operator", "msgType", "httpVersion", "mc", "tc", "remark")
	                .from("t_comm_http_param").where(w->{
	                    w.eq("nodeName", nodeName);
	                    w.eq("appId",appId);
	                    w.eq("commItem", commItem);
	                }).fetchOne();		 
		if (paramMap.isEmpty()){
			logger.error("未配置通信参数");
			throw NoCommParamException.getException();
		}
//		logger.debug("通讯参数："+paramMap);
		return paramMap;
	}

}
