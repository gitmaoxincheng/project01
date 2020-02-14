package cn.com.agree.huanan.ap.al.csiusr.teller.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerSys.csis_tellersys;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 柜员注册系统表Bean
 * @author HCP
 */
@Getter
@Setter
@ToString
@Table(csis_tellersys.class)
public class TellerSys implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tellerNo;//柜员号
	private String sysId;//应用系统代码
	private String checkPwdMode;//行员所支持的验密方式 1-密文密码,2-指纹,3-柜员卡,4-证书
	private String status;//状态 0-无效,1-有效
	private String loginStatus;//系统签到状态 1-签到,0-签退
	private String sysOperDate;//最近操作日期-签到日期
	private String sysOperTime;//最近操作时间-签到时间
	private String sysOperCode;//最近操作结果-签到处理代码
	private String sysOperRemg;//最近操作结果-签到处理结果
	private String sysUsouDate;//最近操作日期-签退日期
	private String sysUsouTime;//最近操作时间-签退时间
	private String sysUsouCode;//最近操作结果-签退处理代码
	private String sysUsouRemg;//最近操作结果-签退处理结果
	private String optBrNo;//操作网点
	private String optTellerNo;//操作柜员
	private String optDate;//操作日期
	private String optTime;//操作时间
	private String serialNo;//操作流水
	private String registDate;//注册日期
	private String cancelDate;//注销日期
	private String note1;//人事编号
	private String note2;//备注2

    public static class csis_tellersys {
        
    }
    
    public static Map<String, Object> getMap(TellerSys  tellerSys) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("tellerNo", tellerSys.getTellerNo());
    	map.put("sysId", tellerSys.getSysId());
    	map.put("checkPwdMode", tellerSys.getCheckPwdMode());
    	map.put("status", tellerSys.getStatus());
    	map.put("loginStatus", tellerSys.getLoginStatus());
    	map.put("sysOperDate", tellerSys.getSysOperDate());
    	map.put("sysOperTime", tellerSys.getSysOperTime());
    	map.put("sysOperCode", tellerSys.getSysOperCode());
    	map.put("sysOperRemg", tellerSys.getSysOperRemg());
    	map.put("sysUsouDate", tellerSys.getSysUsouDate());
    	map.put("sysUsouTime", tellerSys.getSysUsouTime());
    	map.put("sysUsouCode", tellerSys.getSysUsouCode());
    	map.put("sysUsouRemg", tellerSys.getSysUsouRemg());
    	map.put("optBrNo", tellerSys.getOptBrNo());
    	map.put("optTellerNo", tellerSys.getOptTellerNo());
    	map.put("optDate", tellerSys.getOptDate());
    	map.put("optTime", tellerSys.getOptTime());
    	map.put("serialno", tellerSys.getSerialNo());
    	map.put("registDate", tellerSys.getRegistDate());
    	map.put("cancelDate", tellerSys.getCancelDate());
    	map.put("note1", tellerSys.getNote1());
    	map.put("note2", tellerSys.getNote2());
    	return map;
    }
    
}
