package cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.dao.MbsReseNumInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.po.MbsReseNumInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 预约信息编号表service
 * 
 * @author xuzhen
 *
 */

@Service
public class MbsReseNumInfoService {
	@Autowired
	private MbsReseNumInfoDao mbsReseNumInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 新增预约编号表记录
	 * 
	 * @param reseNumInfoMap
	 *            预约编号信息
	 * @return
	 */
	public int register(Map<String, Object> reseNumInfoMap) {
		logger.info("新增预约编号表记录");
		int count = mbsReseNumInfoDao.insert(reseNumInfoMap);
		if (count != 1) {
			logger.error("新增预约编号表记录失败");
			throw new InsertException("新增预约编号表记录失败");
		}
		dbo.commit();
		return count;
	}

	/**
	 * 查询所有预约操作记录
	 * 
	 * @param phone
	 *            手机号
	 * @param appisval
	 *            申请有效标识
	 * @param trantype
	 *            办理状态
	 * @param numberType
	 *            编号类型
	 * @param tradedate
	 *            交易日期
	 * @param distance
	 *            距离
	 * @return
	 */
	public List<Map<String, Object>> queryReseNumInfoList(String phone, String appisval, String trantype,
			String numberType, String tradedate, String distance) {
		logger.info("查询预约操作记录");
		List<Map<String, Object>> reseNumInfoList = mbsReseNumInfoDao.findReseNumInfoList(phone, appisval, trantype,
				numberType, tradedate);
		if (reseNumInfoList.size() < 1) {
			logger.error("查询无数据");
			throw new SelectException("查询无数据");
		}
		// 返回信息
		List<Map<String, Object>> rspList = new ArrayList<>();
		// 判断查询类型
		if (!StringUtils.isEmpty(trantype)) {
			// 查询所有未办理的预约操作
			for (Map<String, Object> reseNumInfo : reseNumInfoList) {
				Map<String, Object> rspMap = new HashMap<>();
				rspMap.put("serialno", reseNumInfo.get("serialno"));
				rspMap.put("tradedate", reseNumInfo.get("tradedate"));
				rspMap.put("queue_num", reseNumInfo.get("queue_num"));
				rspMap.put("reserv_begin_date", reseNumInfo.get("reserv_begin_date"));
				rspMap.put("reserv_end_date", reseNumInfo.get("reserv_end_date"));
				rspMap.put("reserv_begin_time", reseNumInfo.get("reserv_begin_time"));
				rspMap.put("reserv_end_time", reseNumInfo.get("reserv_end_time"));
				rspMap.put("reserv_bs_id", reseNumInfo.get("reserv_bs_id"));
				rspMap.put("custinfo_type", reseNumInfo.get("custinfo_type"));
				rspMap.put("custinfo_num", reseNumInfo.get("custinfo_num"));
				rspMap.put("branchno", reseNumInfo.get("branchno"));
				rspMap.put("phone", reseNumInfo.get("phone"));
				rspMap.put("rese_status", reseNumInfo.get("rese_status"));
				rspMap.put("distance", distance);
				rspList.add(rspMap);
			}
		} else {
			// 查询所有的预约操作
			for (Map<String, Object> reseNumInfo : reseNumInfoList) {
				Map<String, Object> rspMap = new HashMap<>();
				rspMap.put("tradewin", reseNumInfo.get("tradewin"));
				rspMap.put("custtypes_ch", reseNumInfo.get("custtypes_ch"));
				rspMap.put("hand_product", reseNumInfo.get("hand_product"));
				rspMap.put("phone_status", reseNumInfo.get("phone_status"));
				rspMap.put("queue_num", reseNumInfo.get("queue_num"));
				rspMap.put("tradedate", reseNumInfo.get("tradedate"));
				rspMap.put("tradetime", reseNumInfo.get("tradetime"));
				rspMap.put("trantype", reseNumInfo.get("trantype"));
				rspMap.put("maamoney", reseNumInfo.get("maamoney"));
				rspMap.put("trandate", reseNumInfo.get("trandate"));
				rspMap.put("trantime", reseNumInfo.get("trantime"));
				rspMap.put("custno", reseNumInfo.get("custno"));
				rspMap.put("serialno", reseNumInfo.get("serialno"));
				rspMap.put("bs_name_ch", reseNumInfo.get("bs_name_ch"));
				rspMap.put("rese_date", reseNumInfo.get("rese_date"));
				rspMap.put("rese_time", reseNumInfo.get("rese_time"));
				rspMap.put("branch_name", reseNumInfo.get("branch_name"));
				rspMap.put("branchno", reseNumInfo.get("branchno"));
				rspMap.put("rese_status", reseNumInfo.get("rese_status"));
				rspMap.put("distance", distance);
				rspList.add(rspMap);
			}
		}
		return rspList;
	}

	/**
	 * 修改预约编号表信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @param updInfo
	 *            更新信息
	 * @return
	 */
	public int changeReseInfo(String serialno, String tradedate, Map<String, Object> updInfo) {
		logger.info("修改预约编号表信息");
		// 查询预约编号是否存在
		MbsReseNumInfo reseNumInfo = mbsReseNumInfoDao.findReseNumInfo(serialno, tradedate);
		if (reseNumInfo == null) {
			throw new SelectException("修改预约信息失败,预约记录不存在");
		}
		// 修改预约编号信息
		int count = mbsReseNumInfoDao.updReseInfo(serialno, tradedate, updInfo);
		if (count != 1) {
			logger.error("修改预约编号表信息失败");
			dbo.rollback();
			throw new UpdateException("修改预约编号表信息失败");
		}
		dbo.commit();
		return count;
	}

	/**
	 * 查询预约记录
	 * 
	 * @param serialno
	 *            流水号
	 * @param phone
	 *            手机号
	 * @param appisval
	 *            申请有效性标识
	 * @return
	 */
	public Map<String, Object> queryCancelRese(String serialno, String phone, String appisval) {
		logger.info("查询预约记录");
		Map<String, Object> cancelRese = mbsReseNumInfoDao.findCancelRese(serialno, phone, appisval);
		// 判断查询是否有值
		if (cancelRese == null || cancelRese.size() < 1) {
			throw new SelectException("查询无数据");
		}
		return cancelRese;
	}

	/**
	 * 查询预约记录
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	public Map<String, Object> queryReseNumInfo(String serialno, String tradedate) {
		logger.info("查询预约记录信息");
		MbsReseNumInfo reseNumInfo = mbsReseNumInfoDao.findReseNumInfo(serialno, tradedate);
		// 判断查询是否为空
		if (reseNumInfo == null) {
			throw new SelectException("查询无数据");
		}
		// 返回信息
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", reseNumInfo.getSerialno());
		map.put("bs_name_ch", reseNumInfo.getBs_name_ch());
		map.put("rese_date", reseNumInfo.getRese_date());
		map.put("rese_time", reseNumInfo.getRese_time());
		map.put("branch_name", reseNumInfo.getBranch_name());
		map.put("tradedate", reseNumInfo.getTradedate());
		map.put("tradetime", reseNumInfo.getTradetime());
		map.put("queue_num", reseNumInfo.getQueue_num());
		map.put("tradewin", reseNumInfo.getTradewin());
		map.put("custtypes_ch", reseNumInfo.getCusttypes_ch());
		map.put("hand_product", reseNumInfo.getHand_product());
		map.put("phone_status", reseNumInfo.getPhone_status());
		return map;
	}

	/**
	 * 更新过期状态
	 * 
	 * @param phone
	 *            手机号
	 * @param nowDate
	 *            当前日期
	 * @param nowTime
	 *            当前时间
	 * @return
	 */
	public int changeOverdue(String phone, String nowDate, String nowTime, Map<String, Object> updInfo) {
		logger.info("更新过期状态");
		int count = mbsReseNumInfoDao.updOverdue(phone, nowDate, nowTime, updInfo);
		if (count < 1) {
			logger.info("无过期记录");
		}
		dbo.commit();
		return count;
	}
}
