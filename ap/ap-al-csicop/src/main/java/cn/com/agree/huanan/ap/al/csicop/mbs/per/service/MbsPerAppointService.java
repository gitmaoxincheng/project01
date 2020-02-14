package cn.com.agree.huanan.ap.al.csicop.mbs.per.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.BankCardCheckException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.IdentityCheckException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsPerAppointDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 政采贷预约信息表service层
 * 
 * @author guyulong
 */
@Service
public class MbsPerAppointService {
	@Autowired
	private MbsPerAppointDao mbsPerAppointDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 统一签约/维护申请信息查询
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
	public Map<String, Object> findPersonalUnifySignApplicationInformations(String idtftp, String idtfno, String app_id,
			String timeOutFlag, String gloseqNo) {
		logger.info("统一签约/维护申请信息查询");
		// 明细总笔数
		int ttlNum = mbsPerAppointDao.findPersonalUnifySignApplicationInformationsCount(idtftp, idtfno, app_id,
				gloseqNo);
		if (ttlNum < 1) {
			logger.info("没有对应的数据");
			throw new SelectException("没有对应的数据");
		}
		List<Map<String, Object>> list = mbsPerAppointDao.findPersonalUnifySignApplicationInformations(idtftp, idtfno,
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
			newMap.put("cardno", "");
			applyInfo.add(newMap);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("applyinfo_list", applyInfo);
		resultMap.put("listnum", listNum);
		resultMap.put("ttlnum", ttlNum);
		return resultMap;
	}

	/**
	 * 更新统一签约/维护申请信息
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            要更新的信息
	 * @return
	 */
	public int changePerAppoInfo(String appId, Map<String, Object> updInfo) {
		logger.info("更新统一签约/维护申请信息");
		// 判断记录是否存在
		int count = mbsPerAppointDao.findAppoInfoByAppId(appId);
		if (count == 0) {
			throw new SelectException("更新信息失败,记录不存在");
		}
		// 更新预约信息新表信息
		count = mbsPerAppointDao.updPerAppoInfo(appId, updInfo);
		if (count != 1) {
			logger.error("更新统一签约/维护申请信息");
			dbo.rollback();
			throw new UpdateException("更新统一签约/维护申请信息");
		}
		dbo.commit();
		return count;
	}

	/**
	 * 统一申请录入
	 * 
	 * @param appointInfo
	 *            申请信息
	 * @return
	 */
	public int register(Map<String, Object> appointInfo) {
		logger.info("统一签约/维护申请录入");
		int count = mbsPerAppointDao.insertInfo(appointInfo);
		if (count != 1) {
			logger.error("新增统一签约/维护申请失败");
			throw new InsertException("新增统一签约/维护申请失败");
		}
		dbo.commit();
		return count;
	}

	/**
	 * 验证银行卡状态
	 * 
	 * @param idtftp
	 *            输入证件类型
	 * @param idtfno
	 *            输入证件号码
	 * @param docs_catg
	 *            银行卡开户证件类型
	 * @param docs_num
	 *            银行卡开户证件号码
	 * @param acctst
	 *            银行卡账户状态
	 * @param vchrst
	 *            银行卡凭证状态
	 * @param acct_ctrl_ste
	 *            银行卡止付状态
	 */
	public void checkAcctInfo(String idtftp, String idtfno, String docs_catg, String docs_num, String acctst,
			String vchrst, String acct_ctrl_ste) {
		// 判断账户预约证件与录入证件是否一致
		if (!idtftp.equals(docs_catg) || !idtfno.equals(docs_num)) {
			logger.error("您提供的证件与开卡证件不一致，请重新提供证件");
			throw new IdentityCheckException("您提供的证件与开卡证件不一致，请重新提供证件");
		}
		// 判断账户状态
		if (!"A".equals(acctst)) {
			logger.error("账户状态异常");
			throw new BankCardCheckException("账户状态异常");
		}
		// 判断凭证状态
		if (!"0".equals(vchrst)) {
			logger.error("凭证状态异常");
			throw new BankCardCheckException("凭证状态异常");
		}
		// 判断止付状态
		if (!"0".equals(acct_ctrl_ste)) {
			logger.error("支付状态异常");
			throw new BankCardCheckException("支付状态异常");
		}
	}
}
