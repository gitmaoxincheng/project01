package cn.com.agree.huanan.ap.al.csiusr.exitbrno.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.exitbrno.po.ExitBrno.csis_exitbrno;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 机构签退受控系统表Bean
 * @author Maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_exitbrno.class)
public class ExitBrno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tradeDate;//受控日期
	private String brno;//网点号
	private String sysId;//日终受控系统
	private String syscName;//日终受控系统名称
	private String status;//状态 0-已完成,1-未完成
	private String exitDesc;//签退结果描述
	
	private String zoneNo;//分行号
	private String mBrno;//支行号
	private String note1;//备注1
	private String note2;//备注2
	private String updDate;//更新日期
	private String updTime;//更新时间

    public static class csis_exitbrno {
        
    }
    
    public static Map<String, Object> getMap(ExitBrno exitBrno) {
    	Map<String, Object> map = new HashMap<>(); 	
    	map.put("tradeDate", exitBrno.getTradeDate());
    	map.put("brno", exitBrno.getBrno());
    	map.put("sysId", exitBrno.getSysId());
    	map.put("syscName", exitBrno.getSyscName());
    	map.put("status", exitBrno.getStatus());
    	map.put("exitDesc", exitBrno.getExitDesc());
    	
    	map.put("zoneNo", exitBrno.getZoneNo());
    	map.put("mBrno", exitBrno.getMBrno());
    	map.put("note1", exitBrno.getNote1());
    	map.put("note2", exitBrno.getNote2());
    	map.put("updDate", exitBrno.getUpdDate());
    	map.put("updTime", exitBrno.getUpdTime());
    	return map;
    }
    
}
