package cn.com.agree.huanan.ap.al.csiopr.chlinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfo.csis_channel_info;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 渠道信息Bean 
 * @author HCP
 */
@Getter
@Setter
@ToString
@Table(csis_channel_info.class)
public class ChlInfo implements Serializable{
	private String sysId;//系统标识
	private String chnlCode;//渠道代码
	private String chnlName;//渠道名称
	private String status;//渠道状态 00-正常	 01--暂停接入 	02-系统维护 	03-已关闭		04-未启用
	private String chkFlag;//渠道设备ip检查标识 0-不校验 	1-IP地址校验 	2-设备编号校验
//	private String authType;//认证方式 (保留字段)

	public static class csis_channel_info {
        
    }
    

    public static Map<String, Object> getMap(ChlInfo chlInfo) {
    	Map<String, Object> map = new HashMap<>();
		map.put("sysid", chlInfo.getSysId());
		map.put("chnlcode", chlInfo.getChnlCode());
    	map.put("chnlname", chlInfo.getChnlName());
    	map.put("status", chlInfo.getStatus());
    	map.put("chkflag", chlInfo.getChkFlag());
//		map.put("authtype", chlInfo.getAuthType());
		return map;
    }
}
