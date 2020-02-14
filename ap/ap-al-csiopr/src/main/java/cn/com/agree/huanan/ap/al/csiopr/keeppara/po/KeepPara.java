package cn.com.agree.huanan.ap.al.csiopr.keeppara.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.keeppara.po.KeepPara.csis_keep_para;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * csis_keep_para 代保管物品参数表
 * @author chents
 * */
@Getter
@Setter
@ToString
@Table(csis_keep_para.class)
public class KeepPara implements Serializable{
	
	private static final long serialVersionUID = 86975916108329934L;
	
	private String keepTypeNo;//代保管品种类编号
	private String keepType;//代保管品种类
	private String unit;//代保管品单位
	private String currType;//货币代号
	private String remarks;//中文说明
	private String tellerNo;//柜员号
	private String recordDate;//登记日期
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String myBank;//法人号
	
	public static class csis_keep_para{
		
	}
	
	public static Map<String, Object> getMap(KeepPara keepPara) {
		Map<String, Object> map = new HashMap<>();
		map.put("keepTypeNo", keepPara.getKeepTypeNo());
		map.put("keepType", keepPara.getKeepType());
		map.put("unit", keepPara.getUnit());
		map.put("currType", keepPara.getCurrType());
		map.put("remarks", keepPara.getRemarks());
		map.put("tellerNo", keepPara.getTellerNo());
		map.put("recordDate", keepPara.getRecordDate());
		map.put("updDate", keepPara.getUpdDate());
		map.put("updTime", keepPara.getUpdTime());
		map.put("myBank", keepPara.getMyBank());
		return map;
	}
	
}
