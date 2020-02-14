package cn.com.agree.huanan.ap.al.csicop.mbs.reservednew.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.QueryConditionException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.reserved.dao.MbsReservedInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.reserved.po.MbsReservedInfo;
import cn.com.agree.huanan.ap.al.csicop.mbs.reserved.service.MbsReservedService;
import cn.com.agree.huanan.ap.al.csicop.mbs.reservednew.dao.NewReseInfoDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.JsonUtil;
import oracle.sql.CLOB;

/**
 * 微网点预约信息登记表service层
 * 
 * @author xuzhen
 */
@Service
public class NewReseInfoService {
	@Autowired
	private NewReseInfoDao newReseInfoDao;
	@Autowired
	private MbsReservedService mbsReservedService;
	@Autowired
	private MbsReservedInfoDao mbsReservedInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 预填单申请录入
	 * 
	 * @param newReseInfoMap
	 *            登记信息
	 * @return 登记状态和申请编号的集合
	 */
	public Map<String, Object> register(Map<String, Object> newReseInfoMap) {
		// 向微网点预约信息登记新表中插入数据
		logger.info("向微网点预约信息登记新表中插入数据");
		Integer count = newReseInfoDao.insert(newReseInfoMap);
		if (count != 1) {
			logger.error("插入数据失败");
			throw new InsertException("插入数据失败");
		}
		// 返回数据结果集
		Map<String, Object> map = new HashMap<>();
		map.put("status", newReseInfoMap.get("status"));
		map.put("appnumber", newReseInfoMap.get("appnumber"));
		return map;
	}

	/**
	 * 我的申请查询
	 * 
	 * @param operphone
	 *            经办人手机号
	 * @param sttradedate
	 *            申请起始日期
	 * @param edtradedate
	 *            申请截止日期
	 * @param appnumber
	 *            申请编号
	 * @param tobrno
	 *            开户网点
	 * @param applytp
	 *            申请类型
	 * @param operidno
	 *            证件号码
	 * @param status
	 *            状态
	 * @param lockedtellerno
	 *            锁定柜员号
	 * @return
	 */
	public Map<String, Object> queryInfoList(String operphone, String sttradedate, String edtradedate, String appnumber,
			String tobrno, String applytp, String operidno, String status, String lockedtellerno) {
		logger.info("我的申请查询");
		// 查询企业开户申请
		List<Map<String, Object>> findInfoList = mbsReservedService.queryInfoList(operphone, sttradedate, edtradedate,
				appnumber, tobrno, operidno, status, lockedtellerno);
		// 查询企业综合签约/企业信息维护申请
		List<Map<String, Object>> infoList = newReseInfoDao.findInfoList(operphone, sttradedate, edtradedate, appnumber,
				tobrno, applytp, operidno, status, lockedtellerno);
		// 判断申请类型是否为空
		int totalnum = 0;
		List<Map<String, Object>> reservedInfoList = null;
		if (!StringUtils.isEmpty(applytp)) {
			// 判断申请类型
			if ("1".equals(applytp)) {
				// 查询企业开户申请
				logger.info("本次只查询企业开户申请");
				totalnum = findInfoList.size();
				reservedInfoList = findInfoList;
			} else if ("2".equals(applytp) || "3".equals(applytp)) {
				// 查询企业综合签约/企业信息维护申请
				logger.info("本次只查询企业综合签约/企业信息维护申请");
				totalnum = infoList.size();
				reservedInfoList = infoList;
			}
		} else {
			// 查询所有申请
			logger.info("本次查询所有申请");
			totalnum = findInfoList.size() + infoList.size();
			reservedInfoList = new ArrayList<>();
			reservedInfoList.addAll(findInfoList);
			reservedInfoList.addAll(infoList);
		}
		if (totalnum == 0) {
			logger.error("查询无记录");
			throw new SelectException("查询无记录");
		}
		// 查询结果集
		Map<String, Object> reseInfoMap = new HashMap<>();
		reseInfoMap.put("totalnum", totalnum);
		reseInfoMap.put("data_list", reservedInfoList);
		return reseInfoMap;
	}

	/**
	 * 查询对公申请详细信息
	 * 
	 * @param serialno
	 *            申请交易流水号
	 * @param appnumber
	 *            申请编号
	 * @param tradedate
	 *            申请交易日期
	 * @return 详细信息
	 * @throws SQLException
	 */
	public Map<String, Object> findDetailedInfo(String serialno, String appnumber, String tradedate)
			throws SQLException {
		logger.info("查询预填单明细记录");
		// 返回信息容器
		Map<String, Object> rspMap = new HashMap<>();
		// 判断是否满足查询条件
		if ((StringUtils.isEmpty(serialno)|| StringUtils.isEmpty(tradedate))&&StringUtils.isEmpty(appnumber)) {
			logger.error("不满足查询条件");
			throw new QueryConditionException();
		}
		logger.debug("满足查询条件,开始查询企业开户申请记录");
		// 查询是否有企业开户申请记录
		MbsReservedInfo mbsReservedInfo = mbsReservedInfoDao.findMbsReservedInfo(tradedate, serialno, appnumber);
		// 判断是否查询到企业开户申请记录
		if (mbsReservedInfo != null) {
			// 开户申请详细信息
			Map<String, Object> detailedInfo = new HashMap<>();
			detailedInfo.put("apptradedate", mbsReservedInfo.getTradedate());
			detailedInfo.put("appserialno", mbsReservedInfo.getSerialno());
			detailedInfo.put("apptradetime", mbsReservedInfo.getTradetime());
			detailedInfo.put("opermantype", mbsReservedInfo.getOpermantype());
			detailedInfo.put("mobitl", mbsReservedInfo.getOperphone());
			detailedInfo.put("transt", mbsReservedInfo.getStatus());
			detailedInfo.put("checktellerno", mbsReservedInfo.getChecktellerno());
			detailedInfo.put("checkdate", mbsReservedInfo.getCheckdate());
			detailedInfo.put("checktime", mbsReservedInfo.getChecktime());
			detailedInfo.put("checkmark", mbsReservedInfo.getCheckmark());
			detailedInfo.put("accttp", mbsReservedInfo.getAcctype());
			detailedInfo.put("tocity", mbsReservedInfo.getTocity());
			detailedInfo.put("openbr", mbsReservedInfo.getTobrno());
			detailedInfo.put("usccode", mbsReservedInfo.getUsccode());
			detailedInfo.put("orgcode", mbsReservedInfo.getOrgcode());
			detailedInfo.put("compname", mbsReservedInfo.getCompname());
			detailedInfo.put("comptelephone", mbsReservedInfo.getComptelephone());
			detailedInfo.put("compofficeaddrtype", mbsReservedInfo.getCompofficeaddrtype());
			detailedInfo.put("compofficeaddr", mbsReservedInfo.getCompofficeaddr());
			detailedInfo.put("compaddr", mbsReservedInfo.getCompaddr());
			detailedInfo.put("accusagetype", mbsReservedInfo.getAccusagetype());
			detailedInfo.put("accusage", mbsReservedInfo.getAccusage());
			detailedInfo.put("corpname", mbsReservedInfo.getCorpname());
			detailedInfo.put("corpidtftp", mbsReservedInfo.getCorpidtype());
			detailedInfo.put("corpidtfno", mbsReservedInfo.getCorpidno());
			detailedInfo.put("corpchkmsg", mbsReservedInfo.getCorpchkmsg());
			detailedInfo.put("corpidvaldate", mbsReservedInfo.getCorpidvaldate());
			detailedInfo.put("corpmobitl", mbsReservedInfo.getCorptelephone());
			detailedInfo.put("finaname", mbsReservedInfo.getFinaname());
			detailedInfo.put("finaidtftp", mbsReservedInfo.getFinaidtype());
			detailedInfo.put("finaidtfno", mbsReservedInfo.getFinaidno());
			detailedInfo.put("finachkmsg", mbsReservedInfo.getFinachkmsg());
			detailedInfo.put("finaidvaldate", mbsReservedInfo.getFinaidvaldate());
			detailedInfo.put("finamobitl", mbsReservedInfo.getFinatelephone());
			detailedInfo.put("opername", mbsReservedInfo.getOpername());
			detailedInfo.put("operidtftp", mbsReservedInfo.getOperidtype());
			detailedInfo.put("operidtfno", mbsReservedInfo.getOperidno());
			detailedInfo.put("operchkmsg", mbsReservedInfo.getOperchkmsg());
			detailedInfo.put("operidvaldate", mbsReservedInfo.getOperidvaldate());
			detailedInfo.put("authvaldate", mbsReservedInfo.getAuthvaldate());
			detailedInfo.put("taxtype", mbsReservedInfo.getTaxtype());
			detailedInfo.put("taxinfo", mbsReservedInfo.getTaxinfo());
			detailedInfo.put("issbm", mbsReservedInfo.getIssbm());
			detailedInfo.put("isncb", mbsReservedInfo.getIsncb());
			detailedInfo.put("isict", mbsReservedInfo.getIsict());
			detailedInfo.put("isubc", mbsReservedInfo.getIsubc());
			detailedInfo.put("isebd", mbsReservedInfo.getIsebd());
			detailedInfo.put("istaxsb", mbsReservedInfo.getIstaxsb());
			detailedInfo.put("isonecert", mbsReservedInfo.getIsonecert());
			detailedInfo.put("iselec", mbsReservedInfo.getIselec());
			detailedInfo.put("elecname1", mbsReservedInfo.getElecname1());
			detailedInfo.put("electelephone1", mbsReservedInfo.getElectelephone1());
			detailedInfo.put("elecname2", mbsReservedInfo.getElecname2());
			detailedInfo.put("electelephone2", mbsReservedInfo.getElectelephone2());
			detailedInfo.put("busino", mbsReservedInfo.getBusino());
			detailedInfo.put("appnumber", mbsReservedInfo.getAppnumber());
			detailedInfo.put("appvaldate", mbsReservedInfo.getAppvaldate());
			detailedInfo.put("appisval", mbsReservedInfo.getAppisval());
			detailedInfo.put("contname", mbsReservedInfo.getContname());
			detailedInfo.put("contidtftp", mbsReservedInfo.getContidtype());
			detailedInfo.put("contidtfno", mbsReservedInfo.getContidno());
			detailedInfo.put("contidvaldate", mbsReservedInfo.getContidvaldate());
			detailedInfo.put("contsuperior", mbsReservedInfo.getContsuperior());
			detailedInfo.put("contseal", mbsReservedInfo.getContseal());
			detailedInfo.put("trusteesealname", mbsReservedInfo.getTrusteesealname());
			detailedInfo.put("trusteeidtfno", mbsReservedInfo.getTrusteeidno());
			detailedInfo.put("sealacctno", mbsReservedInfo.getSealacctno());
			detailedInfo.put("sealcardno", mbsReservedInfo.getSealcardno());
			detailedInfo.put("ncbmantype", mbsReservedInfo.getNcbmantype());
			detailedInfo.put("ncbname", mbsReservedInfo.getNcbname());
			detailedInfo.put("ncbidtftp", mbsReservedInfo.getNcbidtype());
			detailedInfo.put("ncbidtfno", mbsReservedInfo.getNcbidno());
			detailedInfo.put("ncbmobitl", mbsReservedInfo.getNcbtelephone());
			detailedInfo.put("ncbcode", mbsReservedInfo.getNcbcode());
			detailedInfo.put("ncbusbkeynum", mbsReservedInfo.getNcbusbkeynum());
			detailedInfo.put("ncbonelim", mbsReservedInfo.getNcbonelim());
			detailedInfo.put("ncbdaylim", mbsReservedInfo.getNcbdaylim());
			detailedInfo.put("ictmobitl1", mbsReservedInfo.getIctphoneno1());
			detailedInfo.put("ictmobitl2", mbsReservedInfo.getIctphoneno2());
			detailedInfo.put("ictmobitl3", mbsReservedInfo.getIctphoneno3());
			detailedInfo.put("ictmobitl4", mbsReservedInfo.getIctphoneno4());
			detailedInfo.put("ictmobitl5", mbsReservedInfo.getIctphoneno5());
			detailedInfo.put("ubcmantype", mbsReservedInfo.getUbcmantype());
			detailedInfo.put("ubcname", mbsReservedInfo.getUbcname());
			detailedInfo.put("ubcidtftp", mbsReservedInfo.getUbcidtype());
			detailedInfo.put("ubcidtfno", mbsReservedInfo.getUbcidno());
			detailedInfo.put("ubcidvaldate", mbsReservedInfo.getUbcidvaldate());
			detailedInfo.put("ubcmobitl", mbsReservedInfo.getUbctelephone());
			detailedInfo.put("exclistret", mbsReservedInfo.getExclistret());
			detailedInfo.put("blretmsg", mbsReservedInfo.getBlretmsg());
			detailedInfo.put("checknote", mbsReservedInfo.getChecknote());
			detailedInfo.put("postcode", mbsReservedInfo.getPostcode());
			detailedInfo.put("cutonelim", mbsReservedInfo.getCutdaylim());
			detailedInfo.put("cutdaylim", mbsReservedInfo.getCutonelim());
			detailedInfo.put("ncbtype", mbsReservedInfo.getNcbtype());
			detailedInfo.put("ncbukeytype", mbsReservedInfo.getNcbukeytype());
			detailedInfo.put("depotp", mbsReservedInfo.getDepotp());
			detailedInfo.put("deponame", mbsReservedInfo.getDeponame());// 存款人姓名
			detailedInfo.put("contentno", mbsReservedInfo.getContentno());
			detailedInfo.put("modelno", mbsReservedInfo.getModelno());
			detailedInfo.put("applytp", mbsReservedInfo.getApplytp());
			detailedInfo.put("audit_channels", mbsReservedInfo.getAudit_channels());
			detailedInfo.put("corp_cert_result", mbsReservedInfo.getCorp_cert_result());
			detailedInfo.put("corp_check_result", mbsReservedInfo.getCorp_check_result());
			detailedInfo.put("fina_cert_result", mbsReservedInfo.getFina_cert_result());
			detailedInfo.put("fina_check_result", mbsReservedInfo.getFina_check_result());
			detailedInfo.put("oper_cert_result", mbsReservedInfo.getOper_cert_result());
			detailedInfo.put("oper_check_result", mbsReservedInfo.getOper_check_result());
			detailedInfo.put("if_account", mbsReservedInfo.getIf_account());
			detailedInfo.put("if_depotp_name", mbsReservedInfo.getIf_depotp_name());
			detailedInfo.put("if_depotp_type", mbsReservedInfo.getIf_depotp_type());
			detailedInfo.put("if_address", mbsReservedInfo.getIf_address());
			detailedInfo.put("if_corp", mbsReservedInfo.getIf_corp());
			detailedInfo.put("if_registered", mbsReservedInfo.getIf_registered());
			detailedInfo.put("if_business_scope", mbsReservedInfo.getIf_business_scope());
			detailedInfo.put("file_number", mbsReservedInfo.getFile_number());
			detailedInfo.put("taxation", mbsReservedInfo.getTaxation());
			detailedInfo.put("account_one", mbsReservedInfo.getAccount_one());
			detailedInfo.put("other", mbsReservedInfo.getOther());
			detailedInfo.put("establish_date", mbsReservedInfo.getEstablish_date());
			detailedInfo.put("busid_stadate", mbsReservedInfo.getBusid_stadate());
			detailedInfo.put("busid_enddate", mbsReservedInfo.getBusid_enddate());
			detailedInfo.put("enterprise_state", mbsReservedInfo.getEnterprise_state());
			detailedInfo.put("registered", mbsReservedInfo.getRegistered());
			detailedInfo.put("business_scope", mbsReservedInfo.getBusiness_scope());
			detailedInfo.put("residence", mbsReservedInfo.getResidence());
			detailedInfo.put("annual_year", mbsReservedInfo.getAnnual_year());
			detailedInfo.put("annual_daty", mbsReservedInfo.getAnnual_daty());
			detailedInfo.put("annualreport", mbsReservedInfo.getAnnualreport());
			detailedInfo.put("directory_in_time", mbsReservedInfo.getDirectory_in_time());
			detailedInfo.put("directory_out_time", mbsReservedInfo.getDirectory_out_time());
			detailedInfo.put("directory", mbsReservedInfo.getDirectory());
			detailedInfo.put("delict_namelist", mbsReservedInfo.getDelict_namelist());
			detailedInfo.put("lncluded_wh", mbsReservedInfo.getLncluded_wh());
			detailedInfo.put("lncluded_office", mbsReservedInfo.getLncluded_office());
			detailedInfo.put("lncluded_reason", mbsReservedInfo.getLncluded_reason());
			detailedInfo.put("moveout_time", mbsReservedInfo.getMoveout_time());
			detailedInfo.put("moveout_wh", mbsReservedInfo.getMoveout_wh());
			detailedInfo.put("moveout_office", mbsReservedInfo.getMoveout_office());
			detailedInfo.put("moveout_reason", mbsReservedInfo.getMoveout_reason());
			detailedInfo.put("breakfaith_name", mbsReservedInfo.getBreakfaith_name());
			detailedInfo.put("inspect_result", mbsReservedInfo.getInspect_result());
			detailedInfo.put("risk", mbsReservedInfo.getRisk());
			detailedInfo.put("inspect_result_id", mbsReservedInfo.getInspect_result_id());
			detailedInfo.put("black_type_result", mbsReservedInfo.getBlack_type_result());
			detailedInfo.put("gs_usccode", mbsReservedInfo.getGs_usccode());
			detailedInfo.put("gs_corpidfr", mbsReservedInfo.getGs_corpidfr());
			detailedInfo.put("gs_compname", mbsReservedInfo.getGs_compname());
			detailedInfo.put("gs_orgcode", mbsReservedInfo.getGs_orgcode());
			detailedInfo.put("respcode", mbsReservedInfo.getRespcode());
			detailedInfo.put("busistartdate", mbsReservedInfo.getBusistartdate());
			return detailedInfo;
		}
		logger.debug("没有企业开户申请记录,查询是否有企业综合签约/企业信息维护申请记录");
		// 查询是否有企业综合签约/企业信息维护申请记录
		Map<String, Object> reseInfo = newReseInfoDao.findReseInfo(serialno, appnumber, tradedate);
		if (reseInfo == null || reseInfo.size() < 1) {
			logger.error("查询无数据");
			throw new SelectException("查询无数据");
		}
		// 存在有效记录
		// 业务数据CLOB转String
		CLOB clob = (CLOB) reseInfo.get("bussdata");
		String bussdata = clob.stringValue();
		// Json字符串转Map
		Map<String, Object> map = JsonUtil.getUtil().jsonStringToMap(bussdata);
		// 追加审核信息
		map.put("ywjbrckr", reseInfo.get("operchkmsg"));
		map.put("frckr", reseInfo.get("custchkmsg"));
		map.put("cwfzrckr", reseInfo.get("fladchkmsg"));
		map.put("blackresult", reseInfo.get("blackchkmsg"));
		map.put("gsczresult", reseInfo.get("exclistret"));
		// map转Json字符串
		bussdata = JsonUtil.getUtil().mapToJsonString(map);
		String repbussdata = bussdata.replaceAll("\"", "\'");
		// base64加密
		String encodeToString = Base64.getEncoder().encodeToString(repbussdata.getBytes());
		// 将业务数据添加到返回结果集
		rspMap.put("status", reseInfo.get("status"));
		rspMap.put("acctno", reseInfo.get("acctno"));
		rspMap.put("trantl", reseInfo.get("trantl"));
		rspMap.put("tranna", reseInfo.get("tranna"));
		rspMap.put("tridtp", reseInfo.get("tridtp"));
		rspMap.put("tridno", reseInfo.get("tridno"));
		rspMap.put("applytp", reseInfo.get("applytp"));
		rspMap.put("bussdata", encodeToString);
		return rspMap;
	}

	/**
	 * 预约信息修改
	 * 
	 * @param serialNo
	 *            申请交易流水号
	 * @param appNumber
	 *            申请交易流水号
	 * @param tradeDate
	 *            申请交易日期
	 * @param updateInfo
	 *            要更新的信息
	 * @return 预约信息结果集
	 */
	public Map<String, Object> changeReseInfo(String serialNo, String appNumber, String tradeDate,
			Map<String, Object> updateInfo) {
		// 更新预约信息新表信息
		logger.info("更新预约信息表信息");
		// 判断记录是否存在
		Map<String, Object> info = newReseInfoDao.findReseInfo(serialNo, appNumber, tradeDate);
		if (info == null || info.size() < 1) {
			throw new SelectException("记录不存在,不能更新");
		}
		// 执行更新
		int count = newReseInfoDao.updateReseInfo(serialNo, appNumber, tradeDate, updateInfo);
		if (count != 1) {
			logger.error("更新预约信息表失败");
			dbo.rollback();
			throw new UpdateException("更新预约信息表失败");
		}
		dbo.commit();
		// 查询预约信息
		Map<String, Object> reseInfo = newReseInfoDao.findReseInfo(serialNo, appNumber, tradeDate);
		// 取出状态和申请编号
		Map<String, Object> staAndAppNum = new HashMap<>();
		staAndAppNum.put("status", reseInfo.get("status"));
		staAndAppNum.put("appnumber", reseInfo.get("appnumber"));
		return staAndAppNum;
	}

	/**
	 * 修改具体预填单业务的状态
	 * 
	 * @param appserialno
	 *            申请交易流水号
	 * @param appnumber
	 *            申请编号
	 * @param apptradedate
	 *            申请日期
	 * @param updateInfo
	 *            更新信息
	 * @return
	 */
	public Map<String, Object> updateStatus(String serialNo, String appNumber, String tradeDate,
			Map<String, Object> updateInfo) {
		logger.info("修改预填单业务状态");
		// 判断记录是否存在
		Map<String, Object> info = newReseInfoDao.findReseInfo(serialNo, appNumber, tradeDate);
		if (info == null || info.size() < 1) {
			throw new SelectException("记录不存在,不能更新");
		}
		logger.info(info.toString());
		// 修改预填单业务状态
		int count = newReseInfoDao.updateReseInfo(serialNo, appNumber, tradeDate, updateInfo);
		if (count != 1) {
			logger.error("修改预填单业务状态失败");
			dbo.rollback();
			throw new UpdateException("修改预填单业务状态失败");
		}
		dbo.commit();
		// 查询预约信息
		Map<String, Object> reseInfo = newReseInfoDao.findReseInfo(serialNo, appNumber, tradeDate);
		// 返回预约信息结果
		Map<String, Object> map = new HashMap<>();
		map.put("status", reseInfo.get("status"));
		return map;
	}

	/**
	 * 获取一条待审批的有效预约申请
	 * 
	 * @param status
	 * @param nowdate
	 *            当前时间
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getCheckRese(String status, String nowdate, String appnumber) throws SQLException {
		// 更新所有失效记录
		newReseInfoDao.updApplyIsVal(nowdate);
		dbo.commit();
		// 获取待审批记录
		List<Map<String, Object>> approveList = newReseInfoDao.findApproveList(status, nowdate, appnumber);
		if (approveList.size() < 1) {
			logger.error("查询无记录");
			throw new SelectException("查询无记录");
		}
		// 获取第一条数据
		Map<String, Object> map = approveList.get(0);
		// 获取业务数据CLOB字段
		CLOB clob = (CLOB) map.get("bussdata");
		// CLOB转String
		String bussdata = clob.stringValue();
		// 字符串Json转Map
		Map<String, Object> dataMap = JsonUtil.getUtil().jsonStringToMap(bussdata);
		// 将转换后的集合装入返回集合
		Map<String, Object> rspMap = new HashMap<>();
		rspMap.putAll(map);
		rspMap.putAll(dataMap);
		// 判断申请类型
		if ("2".equals(map.get("applytp"))) {
			rspMap.put("applyMsg", "企业账户信息维护申请");
		} else if ("3".equals(map.get("applytp"))) {
			rspMap.put("applyMsg", "企业账户综合签约申请");
		}
		return rspMap;
	}

	/**
	 * 查询所有即将失效和已失效一天的记录
	 * 
	 * @param befExpiry
	 *            即将失效日期
	 * @param aftExpiry
	 *            失效日期后一天
	 * @return
	 */
	public Map<String, Object> getNoteRese(String nowDate, String befExpiry, String aftExpiry, String appnumber) {
		logger.info("查询一条即将失效或已失效一天的记录");
		// 更新所有过期状态
		int count = newReseInfoDao.updApplyIsVal(nowDate);
		dbo.commit();
		logger.debug(count + "");
		List<Map<String, Object>> noteInformList = newReseInfoDao.findNoteInform(befExpiry, aftExpiry, appnumber);
		if (noteInformList.size() < 1) {
			logger.error("查询无记录");
			throw new SelectException("查询无记录");
		}
		// 获取第一条记录
		Map<String, Object> map = noteInformList.get(0);
		return map;
	}

	/**
	 * 查询申请类型
	 * 
	 * @param serialno
	 *            申请流水号
	 * @param appnumber
	 *            申请编号
	 * @param tradedate
	 *            申请日期
	 * @return
	 */
	public String getApplyTp(String serialno, String appnumber, String tradedate) {
		Map<String, Object> reseInfo = newReseInfoDao.findReseInfo(serialno, appnumber, tradedate);
		if (reseInfo.size() <= 0) {
			throw new SelectException("修改失败,数据不存在");
		}
		return reseInfo.get("applytp") + "";
	}
}
