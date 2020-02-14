package cn.com.agree.huanan.ap.al.csiusr.entduty.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty.csis_entduty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 实体岗Bean
 * @author lixq
 */
@Getter
@Setter
@ToString
@Table(csis_entduty.class)
public class Entduty implements Serializable{

	private String cshBoxNo1;//现金钱箱号1
	private String vchBoxNo1;//凭证钱箱1	
	private String entDutyNo;//实体岗编码
	private String dutyNo;//所属岗位类型
	private String entDutyName;//实体岗名称
	private String entDutyDesc;//实体岗描述
	private String zoneNo;//上岗分行号
	private String mBrNo;//上岗支行号
	private String brNo;//上岗网点号
	private String tellerNo;//上岗柜员号
	private String status;//状态 1-在岗,2-空岗
	private String note1;//备注1
	private String note2;//备注2
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String wareHouserFlg;//是否库管员 0-否 1-是

	
	public static class csis_entduty {
        
    }
    
	public static Map<String, Object> getMap(Entduty entduty){
		Map<String, Object> map = new HashMap<>();
		map.put("cshBoxNo1", entduty.getCshBoxNo1());
		map.put("vchboxNo1", entduty.getVchBoxNo1());
		map.put("entdutyNo", entduty.getEntDutyNo());
		map.put("dutyNo", entduty.getDutyNo());
		map.put("entdutyName", entduty.getEntDutyName());
		map.put("entdutyDesc", entduty.getEntDutyDesc());
		map.put("zoneNo", entduty.getZoneNo());
		map.put("mBrNo", entduty.getMBrNo());
		map.put("brNo", entduty.getBrNo());
		map.put("tellerNo", entduty.getTellerNo());
		map.put("status", entduty.getStatus());
		map.put("note1", entduty.getNote1());
		map.put("note2", entduty.getNote2());
		map.put("updDate", entduty.getUpdDate());
		map.put("updTime", entduty.getUpdTime());
		map.put("wareHouserFlg", entduty.getWareHouserFlg());
		return map;
	}
}
