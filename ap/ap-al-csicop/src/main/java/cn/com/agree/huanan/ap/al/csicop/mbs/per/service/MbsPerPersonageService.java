package cn.com.agree.huanan.ap.al.csicop.mbs.per.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsApplyInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsPerPersonageDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 个人开卡申请service层
 * 
 * @author guyulong
 */
@Service
public class MbsPerPersonageService {
	@Autowired
	private MbsPerPersonageDao mbsPerPersonageDao;
	@Autowired
	private MbsApplyInfoDao mbsApplyInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 个人开卡申请信息查询
	 * 
	 * @param idtftp
	 *            证件类型
	 * @param idtfno
	 *            证件号码
	 * @param app_id
	 *            申请编号
	 * @param timeOutFlag
	 *            是否超时查询 0-否/1-是
	 * @param gloseqno
	 *            交易流水号
	 * @return
	 */
	public Map<String, Object> findPersonalCardApplicationInformations(String idtftp, String idtfno, String app_id,
			String timeOutFlag, String gloseqNo) {
		logger.info("个人开卡申请信息查询");
		// 明细总笔数
		int ttlNum = mbsPerPersonageDao.findPersonalCardApplicationInformationsCount(idtftp, idtfno, app_id, gloseqNo);
		if (ttlNum < 1) {
			logger.info("没有对应的数据");
			throw new SelectException("没有对应的数据");
		}
		List<Map<String, Object>> list = mbsPerPersonageDao.findPersonalCardApplicationInformations(idtftp, idtfno,
				app_id, gloseqNo);
		// 本次查询记录数
		int listNum = list.size();
		if (listNum < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		List<Map<String, Object>> applyInfo = new ArrayList<>();
		for (Map<String, Object> map : list) {
			Map<String, Object> newMap = new HashMap<>(map);
			newMap.put("ispubl", "2");
			applyInfo.add(newMap);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("applyinfo_list", applyInfo);
		resultMap.put("listnum", listNum);
		resultMap.put("ttlnum", ttlNum);
		return resultMap;
	}

	/**
	 * 个人开卡申请
	 * 
	 * @param informationMap1
	 *            个人开卡申请信息集
	 * @param informationMap2
	 *            个人开卡申请记录信息集
	 * @return
	 */
	public Map<String, Object> insertPersonalCardApplicationInformation(Map<String, Object> informationMap1,
			Map<String, Object> informationMap2) {
		logger.info("向个人开卡申请表中插入数据");
		int count = mbsPerPersonageDao.insertPersonalCardApplicationInformation(informationMap1);
		if (count < 1) {
			logger.error("个人开卡申请信息插入失败");
			dbo.rollback();
			throw new InsertException("个人开卡申请信息插入失败");
		}
		count = mbsApplyInfoDao.insertApplyInfo(informationMap2);
		if (count < 1) {
			logger.error("个人开卡申请记录插入失败");
			dbo.rollback();
			throw new InsertException("个人开卡申请记录插入失败");
		}
		dbo.commit();
		// 返回数据结果集
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("appnumber", informationMap1.get("app_id"));
		resultMap.put("serialno", informationMap1.get("serialno"));
		return resultMap;
	}

	/**
	 * 个人开卡信息表信息修改
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            要更新的信息
	 * @return
	 */
	public int changePerSonaInfo(String appId, Map<String, Object> updInfo) {
		logger.info("个人开卡信息表信息修改");
		// 判断记录是否存在
		int count = mbsPerPersonageDao.findPersonageInfo(appId);
		if (count < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		count = mbsPerPersonageDao.updPersonalInfo(appId, updInfo);
		if (count != 1) {
			logger.error("个人开卡信息表信息修改失败");
			dbo.rollback();
			throw new UpdateException("个人开卡信息表信息修改失败");
		}
		dbo.commit();
		return count;
	}

	/**
	 * 个人开卡信息修改
	 * 
	 * @param appId
	 *            申请编号
	 * @param updateInfo1
	 *            个人开卡修改信息集
	 * @param updateInfo2
	 *            个人开卡申请记录修改信息集
	 * @return
	 */
	public int updatePersonalCardInformation(String appId, String status, Map<String, Object> updateInfo1,
			Map<String, Object> updateInfo2) {
		logger.info("个人开卡信息表信息修改");
		int count = mbsPerPersonageDao.findPersonageInfo(appId);
		if (count < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		if ("01".equals(status)) {
			logger.error("个人开卡信息表信息修改失败");
			throw new UpdateException("该状态不允许修改信息");
		}
		if ("03".equals(status) || "04".equals(status)) {
			updateInfo1.put("tradedate", updateInfo1.get("upddate"));
			updateInfo1.put("tradetime", updateInfo1.get("updtime"));
			updateInfo2.put("tradedate", updateInfo2.get("updatedate"));
			updateInfo2.put("tradetime", updateInfo2.get("updatetime"));
		}
		count = mbsPerPersonageDao.updPersonalInfo(appId, updateInfo1);
		if (count != 1) {
			logger.error("个人开卡信息表信息修改失败");
			dbo.rollback();
			throw new UpdateException("个人开卡信息表信息修改失败");
		}
		count = mbsApplyInfoDao.updApplyInfo(appId, updateInfo2);
		if (count < 1) {
			logger.error("个人开卡申请记录修改失败");
			dbo.rollback();
			throw new InsertException("个人开卡申请记录修改失败");
		}
		dbo.commit();
		return count;
	}

	/**
	 * 处理客户信息查询返回数据
	 */
	public Map<String, Object> custnoInfo(List<Map<String, Object>> list) {
		if (list == null || list.size() == 0) {
			logger.error("客户信息查询失败");
			throw new SelectException("客户信息查询失败");
		}
		String pres_address = null;
		String postcode = null;
		String unitaddrss = null;
		for (int i = 0; i < list.size(); i++) {
			if ("114".equals(list.get(i).get("addrtype"))) {
				pres_address = (String) list.get(i).get("addr");
				postcode = (String) list.get(i).get("zipcode");
			}
			if ("115".equals(list.get(i).get("addrtype"))) {
				unitaddrss = (String) list.get(i).get("addr");
			}
		}
		Map<String, Object> info = new HashMap<>();
		info.put("pres_address", pres_address);
		info.put("postcode", postcode);
		info.put("unitaddrss", unitaddrss);
		return info;
	}
}
