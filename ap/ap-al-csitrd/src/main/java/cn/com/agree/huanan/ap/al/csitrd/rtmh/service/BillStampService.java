package cn.com.agree.huanan.ap.al.csitrd.rtmh.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.dao.BillStampDao;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;



/**
 * 其它P（微网点、回单机、排队机）流水表Service层
 *
 */
public class BillStampService {
	@Autowired BillStampDao billStampDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired RTMHTradInfo rtmhTradInfo;
	
	//根据登录(注册)账号插入新的流水信息
	public Map<String ,Object> RtmhTradFlow(Map<Object, Object> appHeader,Map<Object, Object> csisHeader, String serialno) {
		
		Map<String ,Object> rtmhtradflowMap=new HashMap();
		rtmhtradflowMap.put("TRADEDATE", DateTimeUtil.getSysDate());
		rtmhtradflowMap.put("SERIALNO", serialno);
		rtmhtradflowMap.put("TRADETIME", DateTimeUtil.getSysTime());
		rtmhtradflowMap.put("SUBTRANSFLAG", "0");
		rtmhtradflowMap.put("BUSSCENO", appHeader.get("billno"));
		rtmhtradflowMap.put("SERVECODE_OUT", null);
		rtmhtradflowMap.put("SCENECODE_OUT", null);
		rtmhtradflowMap.put("SERVECODE", "ATMP");
		rtmhtradflowMap.put("SCENECODE", null);
		rtmhtradflowMap.put("REQSYSID", csisHeader.get("SrcSysId"));
		rtmhtradflowMap.put("REQCALCOD", csisHeader.get("SrcSysId"));
		rtmhtradflowMap.put("REQDATE", csisHeader.get("SrcDate"));
		rtmhtradflowMap.put("REQTIME", csisHeader.get("SrcTime"));
		rtmhtradflowMap.put("REQSERIALNO", csisHeader.get("ReqNo"));
		rtmhtradflowMap.put("SCRSYSID", csisHeader.get("SrcSysId"));
		rtmhtradflowMap.put("SCRCALCOD", csisHeader.get("SrcCalCod"));
		rtmhtradflowMap.put("GOLSEQNO", csisHeader.get("GloSeqNo"));
		rtmhtradflowMap.put("TELLERNO", csisHeader.get("TellerNo"));
		rtmhtradflowMap.put("TELLERTP", csisHeader.get("TellerTp"));
		rtmhtradflowMap.put("MYBANK", csisHeader.get("MyBank"));
		rtmhtradflowMap.put("ZONENO", csisHeader.get("ZoneNo"));
		rtmhtradflowMap.put("MBRNO", csisHeader.get("mbrno"));
		rtmhtradflowMap.put("BRNO", csisHeader.get("BrNo"));
		rtmhtradflowMap.put("DEVNO", csisHeader.get("devno"));
		rtmhtradflowMap.put("AUTHTELLERNO", csisHeader.get("authbrno"));
		//去数据库进行插入操作
		int count=0;
		count=insertRtmhTradFlow(rtmhtradflowMap);
		return rtmhtradflowMap;
	}
	
	//插入
	public int insertRtmhTradFlow(Map<String,Object> rtmhtradflowMap) {
		int count=0;
		count=billStampDao.insertTrad(rtmhtradflowMap);
		if(count==1) {
			dbo.commit();
		}else {
			dbo.rollback();
		}
		return count;
	}
	
	
}
