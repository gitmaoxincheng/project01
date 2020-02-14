package cn.com.agree.huanan.ap.al.csiopr.mutitable.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.mutitable.dao.AtnAuthOperMutiDao;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class AtnAuthMutiService {

	@Autowired AtnAuthOperMutiDao atnAuthOperMutiDao;
	@Autowired Logger logger;
	
	/**
	 * 
	 * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param chnlCode 渠道代码
	 * @param authType 认证方式
	 * @return
	 */
	public Map<String, Object> getAtnAuthOperPageList(int pageFlag, int maxNum, String chnlCode, String authType)  {
		if (pageFlag < 1) {
			logger.error("页码不可小于1");
			throw new ApIllegalParamException("pageFlag");
		}
		
		if (maxNum < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("maxNum");
		}
		return atnAuthOperMutiDao.getAtnAuthOperPageList(pageFlag, maxNum, chnlCode, authType);
	}
}
