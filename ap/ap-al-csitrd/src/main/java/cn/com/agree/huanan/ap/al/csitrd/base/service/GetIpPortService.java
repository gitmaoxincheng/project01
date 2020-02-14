package cn.com.agree.huanan.ap.al.csitrd.base.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.base.dao.IpPortDao;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 
 * @author maowei
 *
 */
@Service
public class GetIpPortService {
	@Autowired IpPortDao ipPortDao;
	private Logger logger = Logger.getLogger(GetIpPortService.class);
	
	public Map<String, Object> queryIpPort(String paraItem, String paraCode) {
		logger.info("-------查询Ip开始--------");
		Map<String, Object>  ipPort = ipPortDao.queryIpPortDao(paraItem,paraCode);
		return ipPort;
	}
}
