package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.dao.FunctionInfoDao;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class FunctionInfoService {
	@Autowired
	private FunctionInfoDao functionInfoDao;
	@Autowired
	private Logger logger;

	/**
	 * 根据funcid查询url
	 * 
	 * @param funcid
	 *            功能id
	 * @return
	 */
	public Map<String, Object> findUrl(String funcid) {
		Map<String, Object> urlMap = functionInfoDao.findUrl(funcid);
		if (urlMap == null || urlMap.size() < 1) {
			logger.error("根据funcid查询url失败");
			throw new SelectException("根据funcid查询url失败");
		}
		return urlMap;
	}
}
