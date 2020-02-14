package cn.com.agree.huanan.ap.al.csiusr.teller.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.exittellerno.exception.ExitTellerAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.InsertInfoException;
import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerLogDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.NotSelectTellerLogException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.NotUpdateTellerLogException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TransStatusNotCorrectException;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 柜员操作流水层
 * @author Maoxc
 */
@Service
public class TellerLogService {
	@Autowired TellerLogDao tellerLogDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	//柜员调出预受理撤销 
	public void changeTellerLog(String optdate,String serialno ) {

		logger.info("----------查询是否有记录----------");
		TellerLog tellerLog = tellerLogDao.selectTellerLog(optdate, serialno);
		if(tellerLog == null) {
			throw new NotSelectTellerLogException("查询异常");
		}

		logger.info("----------记录是否为待处理状态----------");
		if(!"W".equals(tellerLog.getTransStatus())) {
			throw new TransStatusNotCorrectException("柜员不属于待处理状态");
		}
		
		logger.info("----------更新数据----------");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("transstatus", "C");
		int count = tellerLogDao.updateTellerLogMap(serialno, optdate, paramMap);
		if(count != 1) {
         	dbo.rollback();
			throw new NotUpdateTellerLogException("更新异常");
		}
		dbo.commit();		
	}
	
	/**
     * 插入柜员操作流水记录
     * @param tellerLog
     * @return
     */
	public int insertTellerLog(TellerLog tellerLog) {
		
		int countLog = tellerLogDao.insertTellerLog(tellerLog);
		if (1 != countLog) {
			dbo.rollback();
			throw new InsertInfoException("插入柜员操作流水记录出错");
		}
		dbo.commit();
		return countLog;
	}
	
	/**
	 * 用户中心超时处理
	 * @param oriTradeDate 原交易日期
	 * @param oriSerialNo 原交易流水
	 * @param sysId 应用系统标识
	 * @return
	 */
	public Map<String, Object> userCenterOverTimeDeal(String oriTradeDate, String oriSerialNo, String sysId){
		logger.info("查询柜员操作流水表");
		TellerLog tellerLog = tellerLogDao.queryByOri(oriTradeDate, oriSerialNo, sysId);
		Map<String, Object> map = new HashMap<>();
		if(tellerLog == null) {
			map.put("tradedate", "");
			map.put("serialno", "");
			map.put("status", "N");
			logger.debug("交易状态为：N");
			map.put("errorcode", "");
			map.put("errormsg", "");
		}else {
			map.put("tradedate", tellerLog.getOptDate());
			map.put("serialno", tellerLog.getSerialNo());
			map.put("errorcode", tellerLog.getErrorCode());
			map.put("errormsg", tellerLog.getErrorMsg());
			String status = tellerLog.getTransStatus();
			switch(status) {
			case "W":
				logger.debug("原交易状态为：" + status);
				status = "I";
				break;
			case "C":
				logger.debug("原交易状态为：" + status);
				status = "F";
				break;
			default:
				logger.debug("原交易状态为：" + status);
				break;
			}
			logger.debug("现交易状态为：" + status);
			map.put("status", status);
		}
		return map;
	}

	/**
	 * 操作流水登记
	 * @param map
	 */
	public void serialnoRegister(Map<String, Object> map) {
		int count = tellerLogDao.serialnoRegister(map);
		if(1 != count) {
			dbo.rollback();
			throw new InsertInfoException("登记操作流水失败");
		}
		dbo.commit();
	}

	/**
	 * 更新操作流水
	 * @param serialno 操作流水
	 * @param optDate 操作日期
	 * @param status 操作状态
	 * @param errorCode 响应码
	 * @param errorMsg 响应信息
	 */
	public void updateSatusAndMsg(String serialno, String optDate, String status, String errorCode, String errorMsg) {
		if ("F".equals(status)) {
			dbo.rollback();
		}
		
		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put("transstatus", status);
		updateMap.put("errorcode", errorCode);
		updateMap.put("errormsg", errorMsg);
		
		int count = tellerLogDao.updateTellerLogMap(serialno, optDate, updateMap);
		if(1 != count) {
			dbo.rollback();
			throw new NotUpdateTellerLogException();
		}
		dbo.commit();
	}

	public void checkTellerLogTime(String strTellerNo, String strBrNo, String svrCode) {
		String optDate = DateTimeUtil.getSysDate();
		// 查询最新一笔记录
		Map<String, Object> map = tellerLogDao.checkTellerLogTime(strTellerNo, strBrNo, svrCode, optDate);
		
		// 不存在或状态不为3-处理中或存在但是日期+时间间隔超过5分钟(300)，继续后续流程，否则存在但是状态为3-处理中但是时间间隔未超过5分钟则报错提示
		if (null != map) {
			if ("I".equals(map.get("transstatus"))) {
				String curTime = DateTimeUtil.getSysTime();
				Integer time = Integer.valueOf(curTime) - Integer.valueOf(String.valueOf(map.get("opttime")));
				if (time < 300) {
					throw new ExitTellerAddFailException("日终签退处理中，请稍后");
				}
			}
		}
		
	}

}
