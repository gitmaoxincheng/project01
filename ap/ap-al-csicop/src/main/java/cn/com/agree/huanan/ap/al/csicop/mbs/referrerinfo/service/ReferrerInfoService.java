package cn.com.agree.huanan.ap.al.csicop.mbs.referrerinfo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.dao.QRCodeInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.referrerinfo.dao.ReferrerInfoDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 推荐人信息表service
 * 
 * @author guyulong
 */
@Service
public class ReferrerInfoService {
	@Autowired
	private ReferrerInfoDao referrerInfoDao;
	@Autowired
	private QRCodeInfoDao qRCodeInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 新增推荐人信息
	 * 
	 * @param referrerInfo
	 *            推荐人信息
	 * @return
	 */
	public Map<String, Object> addNacInfo(Map<String, Object> refMap) {
		logger.info("查询推荐人信息");
		String reftype = (String) refMap.get("reftype");
		String refname = (String) refMap.get("refname");
		String persno = (String) refMap.get("persno");
		String brno = (String) refMap.get("brno");
		String refphone = (String) refMap.get("refphone");
		String stagductcode = (String) refMap.get("stagductcode");
		String instjectcode = (String) refMap.get("instjectcode");
		String rebankno = (String) refMap.get("rebankno");
		String reaccount = (String) refMap.get("reaccount");
		String reaccount_name = (String) refMap.get("reaccount_name");
		String projno = (String) refMap.get("projno");
		String entename = (String) refMap.get("entename");
		String cardbranch = (String) refMap.get("cardbranch");
		Map<String, Object> nacInfo = referrerInfoDao.findReferrerInfo(reftype, refname, persno, brno, refphone,
				stagductcode, instjectcode, rebankno, reaccount, reaccount_name, projno, entename, cardbranch);
		if (nacInfo.size() < 1) {
			// 没有推荐人信息, 可新增推荐人信息
			logger.info("新增推荐人信息");
			int count = referrerInfoDao.insertInfo(refMap);
			if (count != 1) {
				logger.info("新增推荐人信息失败");
				dbo.rollback();
				throw new InsertException("新增推荐人信息失败");
			}
			dbo.commit();
			nacInfo = refMap;
		}
		return nacInfo;
	}

	/**
	 * 推荐人信息查询
	 * 
	 * @param reftype
	 *            推荐人类型
	 * @param refname
	 *            推荐人名字
	 * @param refphone
	 *            推荐人手机
	 * @param certnumber
	 *            推荐人证件号
	 * @param persno
	 *            人事编号
	 * @param projno
	 *            项目编号
	 * @param refid
	 *            推荐人id
	 * @param stagductcode
	 *            分期产品代码
	 * @param instjectcode
	 *            分期项目代码
	 * @return
	 */
	public Map<String, Object> findReferrerInfo(String reftype, String refname, String refphone, String certnumber,
			String persno, String projno, String refid, String stagductcode, String instjectcode) {
		logger.info("推荐人信息查询");
		List<Map<String, Object>> referrerInfoList = referrerInfoDao.findReferrerInfo(reftype, refname, refphone,
				certnumber, persno, projno, refid, stagductcode, instjectcode);
		int sql_listnm = referrerInfoList.size();
		if (sql_listnm < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data_list", referrerInfoList);
		map.put("sql_listnm", sql_listnm);
		return map;
	}

	/**
	 * 推荐人信息查询(aweb)
	 * 
	 * @param refid
	 *            推荐人id
	 * @return
	 */
	public Map<String, Object> findReferrerInfo(String refid) {
		logger.info("推荐人信息查询(aweb)");
		Map<String, Object> referrerInfoMap = referrerInfoDao.findReferrerInfo(refid);
		Map<String, Object> qRCodeInfoMap = qRCodeInfoDao.findQRCodeInfo(refid);
		if (referrerInfoMap.size() < 1) {
			logger.info("查询无记录");
			throw new SelectException("无对应的推荐人信息");
		}
		if (qRCodeInfoMap.size() < 1) {
			logger.info("查询无记录");
			throw new SelectException("无对应的二维码信息");
		}
		Map<String, Object> map = new HashMap<>();
		map.putAll(qRCodeInfoMap);
		map.putAll(referrerInfoMap);
		return map;
	}

	/**
	 * 查询身份类型
	 * 
	 * @param refid
	 *            推荐人id
	 * @return
	 */
	public Map<String, Object> findReftype(String refid) {
		logger.info("查询身份类型");
		Map<String, Object> map = referrerInfoDao.findReftype(refid);
		return map;
	}

}
