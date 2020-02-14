/*package cn.com.agree.huanan.ap.al.csicop.mbs.per.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.AmountCheckException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.QueryConditionException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsApplyInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsPerAppointDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsPerChangemegDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.dao.MbsPerPersonageDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsApplyInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.JsonUtil;
import cn.com.agree.huanan.ap.tl.util.MoneyUtil;

*//**
 * 政采贷预约信息表service层
 * 
 * @author guyulong
 *//*
@Service
public class MbsApplyInfoService {
	@Autowired
	private MbsApplyInfoDao mbsApplyInfoDao;
	@Autowired
	private MbsPerPersonageDao mbsPerPersonageDao;
	@Autowired
	private MbsPerChangemegDao mbsPerChangemegDao;
	@Autowired
	private MbsPerAppointDao mbsPerAppointDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	*//**
	 * 更新申请记录流水表
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            要更新的信息
	 * @return
	 *//*
	public int changePerBatchInfo(String appId, Map<String, Object> updInfo) {
		logger.debug("更新申请记录流水表");
		// 判断记录是否存在
		MbsApplyInfo applyInfo = mbsApplyInfoDao.findApplyInfo(appId);
		if (applyInfo == null) {
			throw new SelectException("更新申请记录失败,记录不存在");
		}
		logger.info("更新申请记录流水表信息");
		// 更新预约信息新表信息
		int count = mbsApplyInfoDao.updApplyInfo(appId, updInfo);
		if (count != 1) {
			logger.error("更新申请记录流水表信息失败");
			dbo.rollback();
			throw new UpdateException("更新申请记录流水表信息失败");
		}
		dbo.commit();
		return count;
	}

	*//**
	 * 新增申请记录流水表记录
	 * 
	 * @param applyInfo
	 *            申请信息
	 * @return
	 *//*
	public int addApplyInfo(Map<String, Object> applyInfo) {
		logger.info("申请记录流水录入");
		int count = mbsApplyInfoDao.insertApplyInfo(applyInfo);
		if (count != 1) {
			logger.error("新增申请记录流水失败");
			throw new InsertException("新增申请记录流水失败");
		}
		dbo.commit();
		return count;
	}

	*//**
	 * 查询子表
	 * 
	 * @param requno
	 *            申请编号
	 * @param trancode
	 *            申请类型
	 * @return 子表名
	 *//*
	public String querySubTable(String requno, String trancode) {
		logger.info("查询子表名");
		Map<String, Object> subTable = mbsApplyInfoDao.findSubTable(requno, trancode);
		if (subTable == null || subTable.size() < 1) {
			logger.error("查询无数据");
			throw new SelectException("查询无数据");
		}
		return subTable.get("rel_table").toString();
	}

	*//**
	 * 查询所有申请记录
	 * 
	 * @param operphone
	 *            查询记录的手机号
	 * @param tradecode
	 *            申请类型
	 * @param status
	 *            申请记录的状态
	 * @param idtfno
	 *            证件号码
	 * @return 申请记录集合
	 *//*
	public Map<String, Object> getApplyInfoList(String operphone, String tradecode, String status, String idtfno) {
		if (StringUtils.isEmpty(operphone) && StringUtils.isEmpty(idtfno)) {
			logger.error("证件号码和手机号不能同时为空");
			throw new QueryConditionException("证件号码和手机号不能同时为空");
		}
		List<Map<String, Object>> applyInfoList = mbsApplyInfoDao.findApplyInfoList(operphone, tradecode, status,
				idtfno);
		if (applyInfoList.size() < 1) {
			logger.error("查询无数据");
			throw new SelectException("查询无数据");
		}
		// 返回信息
		Map<String, Object> rspMap = new HashMap<>();
		rspMap.put("count", applyInfoList.size());
		rspMap.put("qrydata_list", applyInfoList);
		return rspMap;
	}

	*//**
	 * 查询申请记录明细
	 * 
	 * @param serialno
	 *            流水号
	 * @return
	 *//*
	public Map<String, Object> findApplyDetails(String serialno) {
		logger.info("查询记录总表获取子表信息");
		Map<String, Object> map = mbsApplyInfoDao.getSonTableInformation(serialno);
		if (map == null || map.size() < 1) {
			logger.error("查询无数据");
			throw new SelectException("查询无数据");
		}
		String key = (String) map.get("tradecode");
		Map<String, Object> data = new HashMap<>();
		switch (key) {
		case "8819702":
			data = mbsPerPersonageDao.findPersonageDetails(serialno);
			break;
		case "8819703":
			data = mbsPerAppointDao.findAppointDetails(serialno);
			break;
		case "8819704":
			data = mbsPerChangemegDao.findChangemegDetails(serialno);
			break;
		case "8819705":
			data = mbsPerAppointDao.findAppointDetails(serialno);
			break;
		}
		String dataString = JsonUtil.getUtil().mapToJsonString(data);
		byte[] encode = Base64.getEncoder().encode(dataString.getBytes());
		Map<String, Object> resultMap = new HashMap<String, Object>(map);
		resultMap.put("data", new String(encode));
		return resultMap;
	}

	*//**
	 * 微网点影像信息查询(个人)
	 * 
	 * @param app_id
	 *            申请编号
	 * @param applystdt
	 *            起始申请日期
	 * @param applyendt
	 *            截止申请日期
	 * @param custname
	 *            姓名
	 * @param operphone
	 *            手机号
	 * @param id_no
	 *            证件号
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @param status
	 *            申请状态
	 * @return
	 *//*
	public Map<String, Object> findApplyInfos(String app_id, String applystdt, String applyendt, String custname,
			String operphone, String id_no, String serialno, String tradedate, String status) {
		logger.info("微网点影像信息查询(个人)");
		List<Map<String, Object>> applyInfo = mbsApplyInfoDao.findApplyInfos(app_id, applystdt, applyendt, custname,
				operphone, id_no, serialno, tradedate, status);
		if (applyInfo.size() < 1) {
			logger.error("查询无数据");
			throw new SelectException("查询无数据");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("applyinfo_list", applyInfo);
		resultMap.put("listnum", applyInfo.size());
		resultMap.put("ttlnum", applyInfo.size());
		return resultMap;
	}

	*//**
	 * 日日盈月月盈
	 * 
	 * @param rese_amount
	 *            保留金额
	 * @param settransfer
	 *            是否设定转账金额
	 * @param depositterm
	 *            存期
	 * @param tran_amount
	 *            转账金额
	 *//*
	public void compareTran_amount(String rese_amount, String settransfer, String depositterm, String tran_amount) {
		logger.debug("判断日日盈月月盈转账金额");
		int result = MoneyUtil.compareTwoAmounts(rese_amount, "1");
		if (result < 0) {
			throw new AmountCheckException("保留金额必须大于等于1元");
		}
		if ("0".equals(settransfer)) {
			if ("1".equals(depositterm)) {
				result = MoneyUtil.compareTwoAmounts(tran_amount, "50000");
				if (result < 0) {
					logger.error("转账金额必须大于等于50000元");
					throw new AmountCheckException("转账金额必须大于等于50000元");
				}
			}
			result = MoneyUtil.compareTwoAmounts(tran_amount, "1000");
			if (result < 0) {
				logger.error("转账金额必须大于等于1000元");
				throw new AmountCheckException("转账金额必须大于等于1000元");
			}
		}
	}

	*//**
	 * 转账金额判断
	 * 
	 * @param hn_transfer
	 *            行内转账
	 * @param kh_transfer
	 *            跨行转账
	 * @param hn_tran_quota
	 *            行内转账日累计限额
	 * @param kh_tran_quota
	 *            跨行转账日累计限额
	 * @param territory_quota
	 *            境内消费日累计限额
	 * @param overseas_quota
	 *            境外消费日累计限额
	 *//*
	public void compareAmounts(String hn_transfer, String kh_transfer, String hn_tran_quota, String kh_tran_quota,
			String territory_quota, String overseas_quota) {
		logger.debug("转账服务金额判断");
		if ("0".equals(hn_transfer)) {
			int result = MoneyUtil.compareTwoAmounts(hn_tran_quota, "0");
			result = MoneyUtil.compareTwoAmounts("50000", hn_tran_quota);
			if (result < 0) {
				logger.error("行内转账日累计限额必须大于0，小于等于5万");
				throw new AmountCheckException("行内转账日累计限额必须大于0，小于等于5万");
			}
		}
		if ("0".equals(kh_transfer)) {
			int result = MoneyUtil.compareTwoAmounts(kh_tran_quota, "0");
			result = MoneyUtil.compareTwoAmounts("50000", kh_tran_quota);
			if (result < 0) {
				logger.error("跨行转账日累计限额必须大于0，小于等于5万");
				throw new AmountCheckException("跨行转账日累计限额必须大于0，小于等于5万");
			}
		}
		int result = MoneyUtil.compareTwoAmounts("10000000", territory_quota);
		if (result < 0) {
			logger.error("境内消费日累计限额不可大于1000万");
			throw new AmountCheckException("境内消费日累计限额不可大于1000万");
		}
		result = MoneyUtil.compareTwoAmounts("10000000", overseas_quota);
		if (result < 0) {
			logger.error("境外消费日累计限额不可大于1000万");
			throw new AmountCheckException("境外消费日累计限额不可大于1000万");
		}
	}
	
	*//**
	 * @param nowDate 当前日期
	 * @param updInfo 更新信息
	 *//*
	public void updOutOfDate(String nowDate ,Map<String,Object>updInfo) {
		logger.debug("更行过期未激活记录状态");
		//查询所有超期未激活记录
		//更新流水表
		int count = mbsApplyInfoDao.updateOutOfDate(nowDate, updInfo);
		logger.debug(count+"");
		//更新子表状态
		Map<String,Object>upd = new HashMap<>();
		upd.put("status", "04");
		upd.put("upddate", updInfo.get("updatedate"));
		upd.put("updtime", updInfo.get("updatetime"));
		//更新个人开卡超期状态
		count = mbsPerPersonageDao.updateOutOfDate(nowDate, upd);
		logger.debug(count+"");
		//更新统一签约超期状态
		count = mbsPerAppointDao.updateOutOfDate(nowDate, upd);
		logger.debug(count+"");
		//更新个人信息变更超期状态
		count = mbsPerChangemegDao.updateOutOfDate(nowDate, upd);
		logger.debug(count+"");
		dbo.commit();
	}
}
*/