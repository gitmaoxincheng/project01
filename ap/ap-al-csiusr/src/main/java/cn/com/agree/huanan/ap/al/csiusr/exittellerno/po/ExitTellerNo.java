package cn.com.agree.huanan.ap.al.csiusr.exittellerno.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.exittellerno.po.ExitTellerNo.csis_exittellerno;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 柜员签退受控系统表Bean
 * @author maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_exittellerno.class)
public class ExitTellerNo implements Serializable {
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String tradeDate;//受控日期
	private String tellerNo;//柜员号
	private String sysId;//日终受控系统
	private String syscName;//日终受控系统名称
	private String status;//状态 0-已完成,1-未完成
	private String zoneNo;//分行号
	private String mBrNo;//支行号
	private String brNo;//网点号
	private String dutyNo;//柜员岗位类型
	private String note1;//备注1
	private String note2;//备注2
	private String entDutyNo;//实体岗号
	private String exitDesc;//签退结果描述


    public static class csis_exittellerno {
        
    }
    
    public static Map<String, Object> getMap( ExitTellerNo  exitTellerNo) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("upddate", exitTellerNo.getUpdDate());
    	map.put("updtime", exitTellerNo.getUpdTime());
    	map.put("tradeDate", exitTellerNo.getTradeDate());
    	map.put("tellerNo",exitTellerNo.getTellerNo());
    	map.put("sysId", exitTellerNo.getSysId());
    	map.put("syscName", exitTellerNo.getSyscName());
    	map.put("status",exitTellerNo.getStatus());
    	map.put("zoneno",exitTellerNo.getZoneNo());
    	map.put("mBrno", exitTellerNo.getMBrNo());
    	map.put("brno", exitTellerNo.getBrNo());
    	map.put("dutyNo", exitTellerNo.getDutyNo());
    	map.put("note1", exitTellerNo.getNote1());
    	map.put("note2", exitTellerNo.getNote2());
    	map.put("entDutyNo", exitTellerNo.getEntDutyNo());
    	map.put("exitDesc", exitTellerNo.getExitDesc());
    	
    	return map;
    }
    
}
