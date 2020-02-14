package cn.com.agree.huanan.ap.al.csitrd.rtmh.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.dao.RtmhGlobalDao;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.exception.InsertInfoException;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.exception.UpdateInfoException;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

public class RtmhGlobalService {

	
	@Autowired RtmhGlobalDao rtmhGlobalDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	/**
	 * @summary 登记ATM特色P流水
	 * @param appHeader  请求
	 * @param csisHeader 
	 * @param header 
	 * @param appBody
	 * @param ServeCodeOut 外部服务码
	 * @param SceneCodeOut 外部场景码
	 * @param ServeCode 内部服务码
	 * @param SceneCode 内部场景码
	 * @param serialno 流水号
	 * @return
	 */
	public Map<String ,Object> registerRtmhTradFlow(Map<String,Object> appHeader, Map<String,Object> csisHeader, Map<String,Object> header,
			Map<String,Object> appBody, String ServeCodeOut,String SceneCodeOut,String ServeCode,String SceneCode,String serialno){
		
		logger.info("开始登记流水");
		Map<String ,Object> rtmhMap=new HashMap();
		rtmhMap.put("TRADEDATE", DateTimeUtil.getSysDate());
		rtmhMap.put("SERIALNO", serialno);
		rtmhMap.put("TRADETIME", DateTimeUtil.getSysTime());
		rtmhMap.put("SUBTRANSFLAG", "0");
		rtmhMap.put("BUSSCENO", (String)appHeader.get("billno"));// 业务场景流水号
		rtmhMap.put("SERVECODE_OUT",ServeCodeOut);
		rtmhMap.put("SCENECODE_OUT", SceneCodeOut);
		rtmhMap.put("SERVECODE", ServeCode);
		rtmhMap.put("SCENECODE", SceneCode);
		rtmhMap.put("REQSYSID", (String)header.get("sysId"));
		rtmhMap.put("REQCALCOD", (String)csisHeader.get("ReqCalCod"));
		//atmMap.put("REQDATE", null);
		//atmMap.put("REQTIME", null);
		rtmhMap.put("REQSERIALNO", (String)csisHeader.get("channelserno"));
		rtmhMap.put("TELLERNO", (String)csisHeader.get("tellerno"));
		rtmhMap.put("TELLERTP", (String)csisHeader.get("tellertp"));
		rtmhMap.put("MYBANK",(String)csisHeader.get("myBank") );
		rtmhMap.put("ZONENO", (String)csisHeader.get("zoneno"));
		rtmhMap.put("MBRNO", (String)appHeader.get("mbrno"));
		rtmhMap.put("BRNO",  (String)csisHeader.get("brno"));
		rtmhMap.put("DEVNO", (String)appHeader.get("devno"));
		rtmhMap.put("AUTHTELLERNO", appHeader.get("authno"));
		rtmhMap.put("BACKSERVECODE", ServeCode);
		rtmhMap.put("BACKSCENECODE", SceneCode);
		
		//去数据库进行插入操作
		int count=0;
		count=rtmhGlobalDao.insertRtmh(rtmhMap);
		if(count!=1) {
			logger.info("登记流水失败");
			throw new InsertInfoException("登记流水失败");
		}
		logger.info("登记流水结束");
		Map<String,Object> backMap = new HashMap<>();
		backMap.put("serialno", serialno);
		backMap.put("tradedate", rtmhMap.get("TRADEDATE"));
		
		return backMap;				
	}
	
	
	/**
	 * @summary 更新其他P(回单机)流水表
	 * @param backMap   
	 * @param returnMap  核心返回Map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int updateRtmhTradFlow(Map<String,Object> paramMap ,Map<String,Object> csisHeader){
		logger.info("更新其他P(回单机)流水表 开始");
		//获取返回数据数据
		String serialno = (String)csisHeader.get("serialno");
		String tradedate = (String)csisHeader.get("tradedate");
		String transStatus =(String)csisHeader.get("respsts");
		String errorCode = (String)csisHeader.get("errorCode");
		String errorMsg = (String)csisHeader.get("errorMsg");
		String backServeCode = (String) paramMap.get("backServeCode");
		String backSceneCode = (String) paramMap.get("backSceneCode");
		String backSysDate = DateTimeUtil.getSysDate();
		String backSysNo = (String)csisHeader.get("backSysNo");
		String backSysSts = (String)csisHeader.get("backSysSts");
		String backSysErroCode = (String)csisHeader.get("backSysErrorCode");
		String bacckSysErrorMsg = (String)csisHeader.get("backSysErrorMsg");
		
		//将数据赋值到Map中
		Map<String,Object> map = new HashMap<>();
		map.put("respsts",transStatus );
		map.put("errorCode",errorCode );
		map.put("errorMsg",errorMsg );
		map.put("backServeCode", backServeCode);
		map.put("backSceneCode", backSceneCode);
		map.put("backSysDate", backSysDate);
		map.put("backSysNo",backSysNo );
		map.put("backSysSts",backSysSts );
		map.put("backSysErroCode",backSysErroCode );
		map.put("bacckSysErrorMsg",bacckSysErrorMsg );
		map.put("upddate",DateTimeUtil.getSysDate() );
		map.put("updtime", DateTimeUtil.getSysTime());
		
		int updateTran = rtmhGlobalDao.updateRtmh(tradedate,serialno,map);
		if(updateTran!=1) {
			dbo.rollback();
			logger.info("更新其他P(回单机)流水表失败");
			throw new UpdateInfoException("更新其他P(回单机)流水表失败");
		}
		
		logger.info("更新其他P(回单机)流水表 结束");
		return updateTran;
		
	}
	
}
