package cn.com.agree.huanan.ap.al.csiusr.teller.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo.csis_tellerinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 柜员Bean
 * @author Maoxc   2019-07-23
 */
@Getter
@Setter
@ToString
@Table(csis_tellerinfo.class)
public class TellerInfo implements Serializable {
	private static final long serialVersionUID = 9081414180398771574L;
	
	private String tellerNo;//柜员号
	private String zoneNo;//分行号
	private String mBrNo;//支行号
	private String brNo;//网点号
	private String name;//姓名
	
	private String tellerType;//柜员类型 a-atm柜员,c-普通柜员,m-中间业务柜员,n-网上银行柜员,p-pos柜员,t-电话银行柜员,z-非综合业务柜员
	private String mangType;//管理权限 0-总行柜员,1-分行柜员,2-支行柜员,3-网点柜员
	private String cashFlag;//出纳员标志 1-是,2-否
	private String loginStatus;//总签到状态 1-签到,0-签退
	private String chkFlag;//账务检查标志 1-需要检查,0-不需要检查
		
	private String tellerPropty;//操作员属性	
	private String sessId;//会话标识
	private String optBrno;//操作网点
	private String optTellerNo;//操作柜员
	private String optDate;//操作日期
			
	private String optTime;//操作时间
	private String note1;//备注1	
	private String note2;//备注2
	private String myBank;//法人号
	private String tellerPropTy;//操作员属性
	private String status;//状态   0-注销 1-正常

    public static class csis_tellerinfo {
        
    }
    
    public static Map<String, Object> getMap(TellerInfo teller) {
		
    	Map<String, Object> map = new HashMap<>();
    	map.put("tellerNo", teller.getTellerNo());
    	map.put("zoneNo", teller.getZoneNo());
    	map.put("mbrNo", teller.getMBrNo());
    	map.put("brNo", teller.getBrNo());
    	map.put("name", teller.getName());
    	
    	map.put("tellerType", teller.getTellerType());
    	map.put("mangType", teller.getMangType());
    	map.put("cashFlag", teller.getCashFlag());
    	map.put("loginStatus", teller.getLoginStatus());
    	map.put("chkFlag", teller.getChkFlag());
    	
    	map.put("tellerPropty", teller.getTellerPropty());
    	map.put("sessId", teller.getSessId());
    	map.put("optBrno", teller.getOptBrno());
    	map.put("optTellerNo", teller.getOptTellerNo());
    	map.put("optDate", teller.getOptDate());
    	
    	map.put("optTime", teller.getOptTime());	
    	map.put("note1", teller.getNote1()); 
    	map.put("note2", teller.getNote2());
    	map.put("myBank", teller.getMyBank());
    	map.put("tellerPropTy", teller.getTellerPropty());
    	map.put("status", teller.getStatus());
    	return map;
    }
}
