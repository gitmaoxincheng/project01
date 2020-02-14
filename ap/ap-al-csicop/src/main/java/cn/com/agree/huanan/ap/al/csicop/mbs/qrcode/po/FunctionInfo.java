package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 功能表
 * 
 * @author guyulong
 */
@Data
@Table(FunctionInfo.CSIS_NAC_FUNCTION_INFO.class)
public class FunctionInfo implements Serializable {
	private static final long serialVersionUID = 632074110636834011L;

	private String funcid;// 功能id
	private String funcna;// 功能名称
	private String funcdesc;// 描述
	private String url;// 基本url
	private String upddate;// 更新日期
	private String updtime;// 更新时间

	public static class CSIS_NAC_FUNCTION_INFO {
	}

	public static Map<String, Object> getMap(FunctionInfo functionInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("funcid", functionInfo.getFuncid());
		map.put("funcna", functionInfo.getFuncna());
		map.put("funcdesc", functionInfo.getFuncdesc());
		map.put("url", functionInfo.getUrl());
		map.put("upddate", functionInfo.getUpddate());
		map.put("updtime", functionInfo.getUpdtime());
		return map;
	}
}
