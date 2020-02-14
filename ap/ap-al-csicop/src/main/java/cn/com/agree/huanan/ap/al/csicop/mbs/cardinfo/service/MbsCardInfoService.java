package cn.com.agree.huanan.ap.al.csicop.mbs.cardinfo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.cardinfo.dao.MbsCardInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class MbsCardInfoService {
	@Autowired
	private MbsCardInfoDao mbsCardInfoDao;
	@Autowired
	private Logger logger;

	/**
	 * 卡产品信息查询
	 * 
	 * @param product_type
	 *            分类标识
	 * @param findDate
	 *            查询日期
	 * @return
	 */
	public Map<String, Object> findCardInformations(String product_type, String findDate) {
		logger.info("卡产品信息查询");
		// 查询总记录数
		int totalnum = mbsCardInfoDao.findCardInformationsCount(product_type, findDate);
		List<Map<String, Object>> data = mbsCardInfoDao.findCardInformations(product_type, findDate);
		// 本次查询记录数
		int listnm = data.size();
		if (listnm < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data_list", data);
		resultMap.put("listnm", listnm);
		resultMap.put("totalnum", totalnum);
		return resultMap;
	}
}
