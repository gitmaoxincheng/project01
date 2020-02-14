package cn.com.agree.huanan.ap.al.atmp.atm.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.al.atmp.atm.dao.AtmRaskDao;
import cn.com.agree.huanan.ap.al.atmp.atm.dao.AtmTranFlowDao;
import cn.com.agree.huanan.ap.al.atmp.atm.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * Atmtranflow服务层
 * @author hys
 * 
 */
@Service
public class AtmTranFlowService {
	@Autowired AtmTranFlowDao atmTranFlowDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired AtmRaskDao atmRaskDao;
	 
	/**
	 * @summary 登记ATM特色P流水
	 * @param ctrl  请求APPHeader
	 * @param serialno	流水号
	 * @param sceneCode 内部场景码
	 * @return
	 */
	public Map<String ,Object> registerAtmTranFlow(Map<String,Object> ctrl,String serialno,String sceneCode) {
		logger.info("开始登记流水");
		Map<String ,Object> atmMap=new HashMap();
		atmMap.put("TRADEDATE", DateTimeUtil.getSysDate());
		atmMap.put("SERIALNO", serialno);
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
		atmMap.put("SCRCALCOD", "");
		atmMap.put("GOLSEQNO", "");
		atmMap.put("UPDTIME", "");
		atmMap.put("UPDDATE", "");
		logger.info("atmMap:"+atmMap);
		//去数据库进行插入操作
		int count=0;
		count=atmTranFlowDao.insertTran(atmMap);
		if(count!=1) {
			logger.info("登记流水失败");
			throw new CheckNotDataException("登记流水失败");
		}
		logger.info("登记流水结束");
		//处理信息返回APPBody
		Map<String,Object> backMap = new HashMap<>();
		backMap.put("serialno", serialno);
		backMap.put("tradedate", atmMap.get("TRADEDATE"));
		backMap.put("tradetime", atmMap.get("TRADETIME"));
		dbo.commit();
		return backMap;
	}
	
	/**
	 * @summary 更新ATM特色P流水表
	 * @param backMap   
	 * @param returnMap  核心返回Map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int updateAtmTranFlow(Map<String,Object> backMap ,Map<String,Object> returnMap){
		logger.info("更新ATM特色P流水表 开始");
		//获取backMap中的数据
		String serialno = (String)backMap.get("serialno");
		String tradedate = (String)backMap.get("tradedate");
		//获取returnMap中数据
		String transStatus = (String) ((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("RespSts");
		String errorCode = (String) ((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("ErrorCode");
		String errorMsg = (String)((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("ErrorMsg");
		String backSysDate = (String)((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("BackSysDate");
		String backSysNo = (String)((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("BackSysNo");
		String backSysSts = (String)((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("BackSysSts");
		String backSysErroCode = (String)((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("BackSysErrorCode");
		String bacckSysErrorMsg = (String)((HashMap<Object, Object>) returnMap.get("CsisHeader")).get("BackSysErrorMsg");
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
		int updateTran = atmTranFlowDao.updateTran(tradedate,serialno,map);
		if(updateTran!=1) {
			dbo.rollback();
			logger.info("更新ATM特色P流水表失败");
			throw new CheckNotDataException("更新ATM特色P流水表失败");
		}
		
		logger.info("更新ATM特色P流水表 结束");
		dbo.commit();
		return updateTran;
	}
	
	/**
	 * @summary 校验短息验证参数
	 * @param useropt
	 * @param msginsro
	 * @param insrotxt
	 * @param msgpwd
	 * @return
	 */
	public int checkMessageParam(String useropt,String msginsro,String insrotxt,String msgpwd) {
		int flag=1;
		if(useropt.equals("2")&&(msgpwd.length()==0||msgpwd==null)) {
			logger.info("操作标识useropt为2时，msgpwd为必传字段");
			flag=0;
			throw new CheckNotDataException("参数校验失败");
		}
		if(msginsro.equals("00000000")&&(insrotxt.length()==0||insrotxt==null)) {
			logger.info("msginsro为“00000000”时，insrotxt为必传字段");
			flag=0;
			throw new CheckNotDataException("参数校验失败");
		}
		return flag;
	}
	
	/**
	 * 校验客户号是否为空
	 * @param custno
	 * @param acctno
	 * @return
	 */
	public int checkAcctOrCustnoParam(String custno,String acctno) {
		int flag=1;
		if(acctno.length()==0&&acctno.equals("")&&custno.length()==0&&custno.equals("")) {
			throw new CheckNotDataException("客户号账号同时为空，参数校验失败~！");
		}else if(!(custno.length()==0&&custno.equals(""))) {		
			//如果是客户号得话flag值为0
			flag=0;
		}
		return flag;
	}

	/**
	 * @summary 本行卡转本行卡延时入账
	 */
	public List<Map<String,Object>> delayedPaid() {
		//1.查询数据库，查出所有记录
		List<Map<String, Object>> list = atmRaskDao.delayedPaid();
		//2.筛选出控制时间大于一天的记录，封装到新的list中
		//获取系统日期时间
		String sysDateTime = DateTimeUtil.getSysDateTime("yyyyMMddHHmmss");
		List<Map<String,Object>> newList =new LinkedList(); ;
		for(Map<String,Object> map:list) {
			String oldDateTime = String.valueOf(map.get("controller_date_time"));
			//比较时间差，大于一天时间差则放进新的list中
			Long timeDelta = DateTimeUtil.getTimeDelta(sysDateTime, oldDateTime, "s");
			if(timeDelta>=86400) {
				newList.add(map);
			}
		}
		//3.返回List
		return newList;
	}
	/**
	 * @summary  更新定时流水
	 * @param condition 
	 * @param list 
	 * 
	 */
	public void updateRaskSerino(JavaList list, String condition) {
		int i = Integer.parseInt(condition);
		Map<String,Object> map = (Map)list.get(i);
		atmRaskDao.updateRaskSerino(map);
		dbo.commit();
	}

	/**
	 * @summary ATM本代本流水登记
	 * @param map
	 */
	public void registerATMTrans(Map<String, Object> map) {
		logger.info("开始登记流水");
		int count = atmTranFlowDao.registerATMTrans(map);
		logger.info("登记流水 结束");
		if(1!=count) 
		{
			logger.info("登记流水失败");
			throw new CheckNotDataException("登记流水失败");
		}
		dbo.commit();
		
	}
	/**
	 * @summary 查询ATM主机交易流水
	 * @param map
	 * @return
	 */
	public Map<String, Object> selectATMSerialno(Map<String, Object> map) {
		if(!"3".equals(map.get("busitp"))) 
		{
			logger.info("业务类型不匹配");
			throw new CheckNotDataException("业务类型不匹配");
		}
		IPage<Map<String,Object>> pageInfo = atmTranFlowDao.selectATMSerialno(map);
	    Map<String, Object> result = new HashMap<>();
		result.put("listnm", Long.toString(pageInfo.getTotal()));// 总笔数
		result.put("rownum", Long.toString(pageInfo.getSize()));// 返回记录数
		result.put("bodrcd_list", pageInfo.getRecords());// 返回数据
		return result;
	}
	
}
