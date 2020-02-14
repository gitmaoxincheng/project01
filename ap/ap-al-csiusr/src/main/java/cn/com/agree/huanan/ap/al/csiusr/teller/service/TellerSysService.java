package cn.com.agree.huanan.ap.al.csiusr.teller.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.teller.dao.TellerSysDao;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.NotTellerSysSysidException;
import cn.com.agree.huanan.ap.al.csiusr.teller.exception.TellerSysAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerSys;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 柜员注册服务类
 * @author HCP
 *
 */
@Service
public class TellerSysService {
	 
	@Autowired Logger logger;
	@Autowired TellerSysDao tellerSysDao;
	@Autowired DbOperator dbo;
	
	public TellerSys getTellerSys(String tellerNo,String sysId) {
		return tellerSysDao.queryTellerSys(tellerNo, sysId);
	}
	
	public void addTellerSys(TellerSys tellerSys) {		
		int count =tellerSysDao.insertTellerSys(tellerSys);
		
		if (count != 1 ) {
			throw new TellerSysAddFailException("新增柜员注册信息失败");
		}
	}
	
	public Map<String, Object> querytTellerSys(String tellerNo,String opwd,String npwd) {
		TellerSys tellerSys =	tellerSysDao.selectTellerSys(tellerNo);
		if(tellerSys ==null) {
			throw new NotTellerSysSysidException("未找到应用系统代码");
		}
		Map<String, Object> resultMap = new HashMap<>();		
		resultMap.put("tellerno", tellerNo);
		resultMap.put("sysid", tellerSys.getSysId());
		resultMap.put("opwd", opwd);
		resultMap.put("npwd", npwd);		
		return resultMap;		
	}
	
	
	
}
