package cn.com.agree.huanan.ap.al.csitrd.auth.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.auth.po.Entduty.csis_entduty;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 柜员岗位Bean
 * 
 */
@Getter
@Setter
@ToString
@Table(csis_entduty.class)
public class Entduty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String entDutyno;
	private String entDutyname;
	private String entDutydesc;
	private String dutyno;
	private String cshBoxno1;
	private String vchBoxno1;
	private String zoneno;
	private String mbrno;
	private String brno;
	private String tellerno;
	private String status;
	private String note1;
	private String note2;
	private String updDate;
	private String updTime;
	
	
    public static class csis_entduty {
        
    }
	
	
	
    /**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return DutyInfo
     */
    public static Entduty instance(Map<String, Object> map){
    	Entduty spb=new Entduty();
    	spb.setEntDutyno(map.get("entDutyno").toString());
    	spb.setEntDutyname(map.get("entDutyname").toString());
    	spb.setEntDutydesc(map.get("entDutydesc").toString());
    	spb.setDutyno(map.get("dutyno").toString());
    	spb.setCshBoxno1(map.get("cshBoxno1").toString());
    	spb.setVchBoxno1(map.get("vchBoxno1").toString());
    	spb.setZoneno(map.get("zoneno").toString());
    	spb.setMbrno(map.get("mbrno").toString());
    	spb.setBrno(map.get("brno").toString());
    	spb.setTellerno(map.get("tellerno").toString());
    	spb.setStatus(map.get("status").toString());
    	spb.setNote1(map.get("note1").toString());
    	spb.setNote2(map.get("note2").toString());
    	spb.setUpdDate(map.get("updDate").toString());
    	spb.setUpdTime(map.get("updTime").toString());
        return spb;
    }
    
    public static Map<String, Object> getMap(Entduty entduty) {
		
    	Map<String, Object> map = new HashMap<>();
    	map.put("", entduty.getEntDutyno());
    	map.put("", entduty.getEntDutyname());
    	map.put("dutyNo", entduty.getEntDutydesc());
    	map.put("dutyName", entduty.getDutyno());
    	map.put("status", entduty.getCshBoxno1());
    	map.put("cityNo", entduty.getVchBoxno1());
    	map.put("updDate", entduty.getZoneno());
    	map.put("updTime", entduty.getMbrno());   	
    	map.put("updTime", entduty.getBrno());
    	map.put("updTime", entduty.getTellerno());
    	map.put("updTime", entduty.getStatus());
    	map.put("updTime", entduty.getNote1());
    	map.put("updTime", entduty.getNote2());
    	map.put("updTime", entduty.getUpdDate());
    	map.put("updTime", entduty.getUpdTime());
    	return map;
    }
}
