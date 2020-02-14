package cn.com.agree.huanan.ap.al.csicop.mbs.reserved.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.ExistToBeProcessed;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.TellerHasLock;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.reserved.dao.MbsReservedInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.reserved.po.MbsReservedInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 微网点预约信息登记表service层
 * 
 * @author xuzhen
 *
 */
@Service
public class MbsReservedService {
	@Autowired
	private MbsReservedInfoDao mbsReservedInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 向微网点预约信息登记表中插入数据
	 * 
	 * @param mbsReservedInfoMap
	 *            登记信息
	 * @return
	 */
	public Map<String, Object> register(Map<String, Object> mbsReservedInfoMap) {
		// 向微网点预约信息登记表中插入数据
		logger.debug("向微网点预约信息登记表中插入数据");
		Integer count = mbsReservedInfoDao.insert(mbsReservedInfoMap);
		if (count != 1) {
			logger.error("插入数据失败");
			throw new InsertException("插入数据失败");
		}
		dbo.commit();
		Map<String, Object> rspMap = new HashMap<>();
		rspMap.put("appnumber", mbsReservedInfoMap.get("appnumber"));
		rspMap.put("appvaldate", mbsReservedInfoMap.get("appvaldate"));
		return rspMap;
	}

	/**
	 * 概要信息查询
	 * 
	 * @param operphone
	 *            经办人手机号
	 * @param tradedate
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
	public List<Map<String, Object>> queryInfoList(String operphone, String sttradedate, String edtradedate,
			String appnumber, String tobrno, String operidno, String status, String lockedtellerno) {
		logger.info("企业开户概要信息查询");
		List<Map<String, Object>> reservedInfoList = mbsReservedInfoDao.findInfoList(operphone, sttradedate,
				edtradedate, appnumber, tobrno, operidno, status, lockedtellerno);
		int listnm = reservedInfoList.size();
		if (listnm == 0) {
			logger.info("无企业开户记录");
		}
		return reservedInfoList;
	}

	/**
	 * 根据申请交易日期和申请交易流水号查询预约信息记录
	 * 
	 * @param tradeDate
	 *            申请交易日期
	 * @param serialNo
	 *            申请交易流水号
	 * @return 预约信息
	 */
	public MbsReservedInfo queryReservedInfo(String tradeDate, String serialNo) {
		logger.info("查询预约信息记录");
		// 查询预约信息记录
		MbsReservedInfo mbsReservedInfo = mbsReservedInfoDao.findMbsReservedInfo(tradeDate, serialNo, "");
		if (mbsReservedInfo == null) {
			logger.error("要查询的预约信息不存在");
			throw new SelectException("要查询的预约信息不存在");
		}
		return mbsReservedInfo;
	};

	/**
	 * 开户预约信息查询
	 * 
	 * @param serialNo
	 *            申请交易流水号
	 * @param tradeDate
	 *            申请交易日期
	 * @param branchNo
	 *            预约机构号
	 * @return 开户概要信息
	 */
	public Map<String, Object> findReservedInfo(String serialNo, String tradeDate) {
		logger.info("开户预约信息查询");
		// 查询预约信息登记表记录
		MbsReservedInfo mbsReservedInfo = queryReservedInfo(tradeDate, serialNo);
		// 查询预约机构信息
		// 开户预约信息
		Map<String, Object> reservedInfo = new HashMap<>();
		reservedInfo.put("appnumber", mbsReservedInfo.getAppnumber());
		reservedInfo.put("appvaldate", mbsReservedInfo.getAppvaldate());
		reservedInfo.put("openbrname", mbsReservedInfo.getOpenbrname());
		reservedInfo.put("openbrname", mbsReservedInfo.getOperphone());
		return reservedInfo;
	}

	/**
	 * 更新预约信息表信息
	 * 
	 * @param taskid 任务号
	 * @param serialNo 申请交易流水号
	 * @param tradeDate 申请交易日期
	 * @param updateInfo 要更新的信息
	 * @return
	 */
	public void changeReservedInfo(String taskid,String serialNo, String tradeDate, Map<String, Object> updateInfo) {
		logger.info("更新预约信息表信息");
		//判断任务号是否为空
		if(!StringUtils.isEmpty(taskid)) {
			//根据任务号更新记录
		}
		// 查询信息记录是否存在
		MbsReservedInfo mbsReservedInfo = mbsReservedInfoDao.findMbsReservedInfo(tradeDate, serialNo, "");
		if (mbsReservedInfo == null) {
			throw new SelectException("记录不存在,无法修改预约信息");
		}
		// 更新信息
		int count = mbsReservedInfoDao.updateReservedInfo(serialNo, tradeDate, updateInfo);
		// 判断是否更新成功
		if (count != 1) {
			logger.error("更新预约信息表失败");
			dbo.rollback();
			throw new UpdateException("更新预约信息表失败");
		}
		dbo.commit();
	}

	/**
	 * 查询一条待审批记录
	 * 
	 * @param status
	 *            审批状态
	 * @param nowDate
	 *            当前时间
	 * @param st_serialno
	 *            上一个待审批记录的流水号
	 * @return
	 */
	public Map<String, Object> getCheckRese(String status, String nowDate, String st_serialno) {
		logger.info("查询一条待审批记录");
		List<Map<String, Object>> findCheckInfo = mbsReservedInfoDao.findCheckInfo(status, nowDate, st_serialno);
		if (findCheckInfo.size() < 1) {
			logger.error("没有待审批记录");
			throw new SelectException("没有待审批记录");
		}
		// 返回
		Map<String, Object> checkRese = findCheckInfo.get(0);
		return checkRese;
	}
	
	/**
	 * 查询所有待发送集中作业记录
	 * @return
	 */
	public List<Map<String,Object>>getChkInfoList(){
		logger.info("查询所有待发送集中作业记录");
		//查询所有待发送记录
		List<MbsReservedInfo> infoList = mbsReservedInfoDao.findchkInfoList();
		if(infoList.size()<=0) {
			logger.debug("没有待发送记录");
			throw new SelectException("没有待发送审核记录");
		}
		//返回值po类转Map
		List<Map<String,Object>>chkInfoList = new ArrayList<>();
		for (int i = 0; i < infoList.size(); i++) {
			Map<String, Object> reseInfoMap = MbsReservedInfo.getMap(infoList.get(i));
			chkInfoList.add(reseInfoMap);
		}
		return chkInfoList;
	}
	
	/**
	 * 柜员日终受控检查
	 * @param startDate 起始日期
	 * @param tradedate 检查日期
	 * @param tellerNo 柜员号
	 * @return
	 */
	public void getTellerCheck(String startDate,String tradeDate,String tellerNo) {
		logger.info("柜员日终受控检查");
		//查询记录数
		int count = mbsReservedInfoDao.queryTellerCheck(startDate, tradeDate, tellerNo);
		//判断是否存在记录
		if(count>0) {
			if(StringUtils.isEmpty(tellerNo)) {
				throw new ExistToBeProcessed(count+"");
			}else {
				throw new TellerHasLock(tellerNo,count+"");
			}
		}
	}
}
