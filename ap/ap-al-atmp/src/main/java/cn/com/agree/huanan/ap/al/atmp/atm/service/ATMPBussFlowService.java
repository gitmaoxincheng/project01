package cn.com.agree.huanan.ap.al.atmp.atm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.atmp.atm.dao.AtmBussFlowDao;
import cn.com.agree.huanan.ap.al.atmp.atm.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.atmp.atm.po.ATMPBussFlow;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * Atmtranflow服务层
 * @author hys
 * 
 */
@Service
public class ATMPBussFlowService {
	@Autowired AtmBussFlowDao atmBussFlowDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	
	
	/**
	 * 登记atm业务流水表
	 * @param ctrl
	 * @param body
	 * @param backBody
	 * @param backCsisHeader
	 * @param sceneCode
	 * @return
	 */
	public int regAtmBussFlow(Map<String,Object> ctrl,Map<String, Object> body,Map<String, Object> backBody,Map<String, Object> backCsisHeader,String sceneCode) {
		logger.info("开始登记业务流水");
		logger.info("开始登记业务流水");
		//整理要插入的数据
		String status="";
		Map<String ,Object> atmMap=new HashMap();
		atmMap.put("TRADEDATE", DateTimeUtil.getSysDate());
		atmMap.put("SERIALNO", (String)ctrl.get("channelserno"));
		atmMap.put("TRADETIME", DateTimeUtil.getSysTime());
		atmMap.put("SUBTRANSFLAG", "0");
		atmMap.put("SERVECODE_OUT",(String)ctrl.get("eciSeverId"));
		atmMap.put("SCENECODE_OUT", (String)ctrl.get("prcscd"));
		atmMap.put("SERVECODE", "ATMP");
		atmMap.put("SCRSYSID", "0186");
		atmMap.put("SCENECODE", sceneCode);
		atmMap.put("REQSYSID", (String)ctrl.get("sysId"));
		atmMap.put("REQDATE", DateTimeUtil.getSysDate());
		atmMap.put("REQTIME",DateTimeUtil.getSysTime());
		atmMap.put("REQCALCOD", (String)ctrl.get("subchannelCode")); 
		atmMap.put("REQSERIALNO", (String)ctrl.get("channelserno"));
		atmMap.put("TELLERNO", (String)ctrl.get("tellerno"));	
		atmMap.put("TELLERTP", (String)ctrl.get("tellertp"));
		atmMap.put("MYBANK",(String)ctrl.get("myBank") );
		atmMap.put("ZONENO", (String)ctrl.get("zoneno"));
		atmMap.put("MBRNO", (String)ctrl.get("mbrno"));
		atmMap.put("BRNO",  (String)ctrl.get("brno"));
		atmMap.put("DEVNO", (String)ctrl.get("devno"));
		atmMap.put("AUTHTELLERNO", ctrl.get("authno"));
		atmMap.put("BACKSERVECODE", "ATMP");
		atmMap.put("BACKSCENECODE", sceneCode);
		atmMap.put("GOLSEQNO", (String)backCsisHeader.get("GloSeqNo"));
		atmMap.put("UPDTIME", DateTimeUtil.getSysTime());
		atmMap.put("UPDDATE", DateTimeUtil.getSysDate());
		atmMap.put("AMT", (String)backBody.get("txn_amt"));
		atmMap.put("ACCTNO", (String)backBody.get("rcev_mny_lblty_acct_num"));
		atmMap.put("DCFLAG", "D");
		atmMap.put("TCFLAG", "T");
		atmMap.put("correct_hostls", (String)backCsisHeader.get("ReqNo"));
		atmMap.put("correct_num", "0");
		//判断处理状态
		if(((String)backCsisHeader.get("ErrorCode")).equals("AAAAAAAAAA")) {
			status="S";
		}else {
			status="F";
		}
		atmMap.put("BACKSYSSTS", status);
		logger.info("登记流水atmMap表:"+atmMap);
		int count=0;	
		//向数据库插入数据
		if(atmBussFlowDao.queryBuss((String)atmMap.get("REQSERIALNO"))==null) {
			count=atmBussFlowDao.insertBuss(atmMap);
		}else {
			atmBussFlowDao.deleteBuss((String)atmMap.get("REQSERIALNO"));
			count=atmBussFlowDao.insertBuss(atmMap);
		}
		if(count!=1) {
			logger.info("登记流水失败");
			throw new CheckNotDataException("登记流水失败");
		}
		logger.info("登记流水结束");
		
		dbo.commit();
		
		return 0;
	}
	
	
	
	/**
	 * 登记业务流水表
	 * @param ctrl
	 * @param body
	 * @param returnbody
	 * @param returncsisheader
	 * @param serialno
	 * @param sceneCode
	 * @return
	 */
	public int registerAtmBussFlow(Map<String,Object> ctrl,Map<String,Object> body,Map<String,Object> returnbody,Map<String,Object> returncsisheader,String sceneCode) {
		logger.info("开始登记业务流水流水");
		String status="";
		//整理要插入的数据
		Map<String ,Object> atmMap=new HashMap();
		atmMap.put("TRADEDATE", DateTimeUtil.getSysDate());
		atmMap.put("SERIALNO", (String)ctrl.get("channelserno"));
		atmMap.put("TRADETIME", DateTimeUtil.getSysTime());
		atmMap.put("SUBTRANSFLAG", "0");
		atmMap.put("SERVECODE_OUT",(String)ctrl.get("eciSeverId"));
		atmMap.put("SCENECODE_OUT", (String)ctrl.get("prcscd"));
		atmMap.put("SERVECODE", "ATMP");
		atmMap.put("SCRSYSID", "0186");
		atmMap.put("SCENECODE", sceneCode);
		atmMap.put("REQSYSID", (String)ctrl.get("sysId"));
		atmMap.put("REQDATE", DateTimeUtil.getSysDate());
		atmMap.put("REQTIME",DateTimeUtil.getSysTime());
		atmMap.put("REQCALCOD", (String)ctrl.get("subchannelCode")); 
		atmMap.put("REQSERIALNO", (String)body.get("ATSN"));
		atmMap.put("TELLERNO", (String)ctrl.get("tellerno"));	
		atmMap.put("TELLERTP", (String)ctrl.get("tellertp"));
		atmMap.put("MYBANK",(String)ctrl.get("myBank") );
		atmMap.put("ZONENO", (String)ctrl.get("zoneno"));
		atmMap.put("MBRNO", (String)ctrl.get("mbrno"));
		atmMap.put("BRNO",  (String)ctrl.get("brno"));
		atmMap.put("DEVNO", (String)ctrl.get("devno"));
		atmMap.put("AUTHTELLERNO", ctrl.get("authno"));
		atmMap.put("BACKSERVECODE", "ATMP");
		atmMap.put("BACKSCENECODE", sceneCode);
		atmMap.put("GOLSEQNO", (String)returncsisheader.get("GloSeqNo"));
		atmMap.put("UPDTIME", DateTimeUtil.getSysTime());
		atmMap.put("UPDDATE", DateTimeUtil.getSysDate());
		atmMap.put("AMT", (String)returnbody.get("txn_amt"));
		atmMap.put("ACCTNO", (String)body.get("CDNO"));
		atmMap.put("DCFLAG", "D");
		atmMap.put("TCFLAG", "C");
		atmMap.put("correct_hostls", (String)returncsisheader.get("ReqNo"));
		atmMap.put("correct_num", "0");
		//判断处理状态
		if(((String)returncsisheader.get("ErrorCode")).equals("AAAAAAAAAA")) {
			status="S";
		}else {
			status="F";
		}
		atmMap.put("BACKSYSSTS", status);
		//atmMap.put("AMT", (String)returnbody.get("txn_amt"));
		//atmMap.put("AMT", (String)returnbody.get("txn_amt"));
		//atmMap.put("AMT", (String)returnbody.get("txn_amt"));
		logger.info("atmMap:"+atmMap);
		//去数据库进行插入操作,如果数据库里已有reqserialno这条数据，则删掉再插入
		int count=0;
		if(atmBussFlowDao.queryBuss((String)atmMap.get("REQSERIALNO"))==null) {
			count=atmBussFlowDao.insertBuss(atmMap);
		}else {
			atmBussFlowDao.deleteBuss((String)atmMap.get("REQSERIALNO"));
			count=atmBussFlowDao.insertBuss(atmMap);
		}
		if(count!=1) {
			logger.info("登记流水失败");
			throw new CheckNotDataException("登记流水失败");
		}
		logger.info("登记流水结束");
		dbo.commit();
		return 0;
	}
	
	/**
	 * 查询核心返回流水号
	 * @param serialno
	 * @return
	 */
	public String selectReturnSerialno(String serialno) {
		ATMPBussFlow atmpBussFlow=null;
		atmpBussFlow=atmBussFlowDao.queryBuss(serialno);
		if(atmpBussFlow==null) {
			logger.info("查询无数据");
			throw new CheckNotDataException("查询无数据");
		}else {
			return atmpBussFlow.getCorrect_hostls();
		}
	}
	
	/**
	 * 查询返回的客户账号
	 * @param serialno
	 * @return
	 */
	public String queryAcctno(String serialno) {
		
		ATMPBussFlow atmpBussFlow=null;
		atmpBussFlow=atmBussFlowDao.queryBySerinal(serialno);
		if(atmpBussFlow==null) {
			logger.info("查询无记录");
			throw new CheckNotDataException("查询无数据");
		}else {
			return atmpBussFlow.getAcctNo();
		}	
	}
	
	/**
	 * 更新ATMP业务流水表
	 * @param cnrf
	 * @return
	 */
	public int updateAtmBussFlow(String cnrf,String errorcode) {
		ATMPBussFlow atmpBussFlow=atmBussFlowDao.queryBuss(cnrf);
		Map<String ,Object> atmMap=ATMPBussFlow.getMap(atmpBussFlow);
		String status=(String)atmMap.get("correct_num");
		int correctnum=Integer.parseInt(status);
		//判断冲正状态
		if(errorcode.equals("AAAAAAAAAA")) {
			correctnum=-1;
		}else {
			correctnum++;
		}
		status=String.valueOf(correctnum);
		atmMap.put("correct_num", status);
		return atmBussFlowDao.updateBuss(cnrf, atmMap);
	}
	
}
