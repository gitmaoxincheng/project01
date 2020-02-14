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
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsPerChangemegDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsPerChangemeg;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 客户信息变更申请表service层
 * 
 * @author guyulong
 */
@Service
public class MbsPerChangemegService {
	@Autowired
	private MbsPerChangemegDao mbsPerChangemegDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 客户信息变更申请信息查询
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
	public Map<String, Object> findClientChangeApplicationInformations(String idtftp, String idtfno, String app_id,
			String timeOutFlag, String gloseqNo) {
		logger.info("客户信息变更申请信息查询");
		// 明细总笔数
		int ttlNum = mbsPerChangemegDao.findClientChangeApplicationInformationsCount(idtftp, idtfno, app_id, gloseqNo);
		if (ttlNum < 1) {
			logger.info("没有对应的数据");
			throw new SelectException("没有对应的数据");
		}
		List<Map<String, Object>> list = mbsPerChangemegDao.findClientChangeApplicationInformations(idtftp, idtfno,
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
	 * 修改客户信息变更申请
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            要更新的信息
	 * @return
	 */
	public int changePerChangeInfo(String appId, Map<String, Object> updInfo) {
		// 判断记录是否存在
		logger.info("修改客户信息变更申请");
		// 判断记录是否存在
		MbsPerChangemeg perChangemeg = mbsPerChangemegDao.findByAppId(appId);
		if (perChangemeg == null) {
			throw new SelectException("修改信息失败,记录不存在");
		}
		// 更新预约信息新表信息
		int count = mbsPerChangemegDao.updPerChangeInfo(appId, updInfo);
		if (count != 1) {
			logger.error("修改客户信息变更申请失败");
			dbo.rollback();
			throw new UpdateException("修改客户信息变更申请失败");
		}
		dbo.commit();
		return count;
	}

	/**
	 * 新增客户信息变更申请表记录
	 * 
	 * @param applyInfo
	 *            申请信息
	 * @return
	 */
	public int addPerChangeInfo(Map<String, Object> applyInfo) {
		logger.info("新增客户信息变更申请表记录");
		int count = mbsPerChangemegDao.insertPerChangeInfo(applyInfo);
		if (count != 1) {
			logger.error("新增客户信息变更申请表记录");
			throw new InsertException("新增客户信息变更申请表记录");
		}
		return count;
	}
}
