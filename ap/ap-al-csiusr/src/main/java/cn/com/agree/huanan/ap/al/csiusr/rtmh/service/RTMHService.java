package cn.com.agree.huanan.ap.al.csiusr.rtmh.service;

import java.util.HashMap;   
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.dao.RTMHDao;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.InsertInfoException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.UpdateInfoException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

public class RTMHService {

	
	@Autowired RTMHDao rtmhdao;
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
		                                           String ServeCodeOut,String SceneCodeOut,String ServeCode,String SceneCode,String serialno){
		
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
		count=rtmhdao.insertRTMH(rtmhMap);
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
	public int updateRtmhTradFlow(Map<String,Object> backMap ,Map<String,Object> returnMap){
		logger.info("更新其他P(回单机)流水表 开始");
		//获取backMap中的数据
		String serialno = (String)backMap.get("serialno");
		String tradedate = (String)backMap.get("tradedate");
		//获取returnMap中数据
		String transStatus = (String) ((HashMap<Object, Object>) returnMap.get("ctrl")).get("respsts");
		String errorCode = (String) ((HashMap<Object, Object>) returnMap.get("ctrl")).get("errorCode");
		String errorMsg = (String)((HashMap<Object, Object>) returnMap.get("ctrl")).get("errorMsg");
		String backSysDate = (String)((HashMap<Object, Object>) returnMap.get("ctrl")).get("backSysDate");
		String backSysNo = (String)((HashMap<Object, Object>) returnMap.get("ctrl")).get("backSysNo");
		String backSysSts = (String)((HashMap<Object, Object>) returnMap.get("ctrl")).get("backSysSts");
		String backSysErroCode = (String)((HashMap<Object, Object>) returnMap.get("ctrl")).get("backSysErrorCode");
		String bacckSysErrorMsg = (String)((HashMap<Object, Object>) returnMap.get("ctrl")).get("backSysErrorMsg");
		//将数据赋值到Map中
		Map<String,Object> map = new HashMap<>();

		map.put("respsts",transStatus );
		map.put("errorCode",errorCode );
		map.put("errorMsg",errorMsg );
		map.put("backSysDate", backSysDate);
		map.put("backSysNo",backSysNo );
		map.put("backSysSts",backSysSts );
		map.put("backSysErroCode",backSysErroCode );
		map.put("bacckSysErrorMsg",bacckSysErrorMsg );
		map.put("upddate",DateTimeUtil.getSysDate() );
		map.put("updtime", DateTimeUtil.getSysTime());
		
		int updateTran = rtmhdao.updateTtmhTrad(tradedate,serialno,map);
		if(updateTran!=1) {
			dbo.rollback();
			logger.info("更新其他P(回单机)流水表失败");
			throw new UpdateInfoException("更新其他P(回单机)流水表失败");
		}
		
		logger.info("更新其他P(回单机)流水表 结束");
		return updateTran;
		
	}

	
	/**
	 * @summary 更新其他P(回单机)流水表
	 */
	//更新数据
	public int updateTradinfo(Map<String, Object> paramMap) {
		logger.info("用户登录更新表开始");
		int count = rtmhdao.updateTradinfo(paramMap);
		if(count < 1) {
			logger.error("用户登录更新表开始");
			dbo.rollback();
			logger.info("用户登录更新表sql语句失败...事务回滚");
			throw new UpdateInfoException("用户登录更新表sql语句失败");
		}
		dbo.commit();
		logger.info("用户登录更新表成功");
		return count;
	}
	
	
	/**
	 * 登录检查服务
	 */
	public Map<String,Object> LoginCheck(String userCode, String userno){
		logger.info("登录接口开始");
		Map<String,Object> resultMap = new HashMap<>();
		List<RTMHTradInfo> list = rtmhdao.queryListUserByNo(userCode, userno);
		if(null == list || list.size() == 0) {
			logger.error("用户信息不存在！");
			throw new UpdateInfoException("用户信息不存在！");	
		}
		
		if(list.size() > 1 ) {
			
		}
		
		return null;
		
	}


	public Map<String, Object> rtmhTradFlow(Map<String, Object> appHeader, Map<String, Object> csisHeader,
			Map<String, Object> header, Map<String, Object> appBody, String sceneCode, String serialno) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	
}
