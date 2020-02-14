package cn.com.agree.huanan.ap.al.csiopr.chlinfo.po;


import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 渠道设备表Bean 
 * @author HCP
 */
@Getter
@Setter
@ToString
@Table(ChlDev.csis_channel_dev.class)
public class ChlDev implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8287189431867930923L;
	private String sysId;      //系统ID
	private String chnlCode;      //渠道代码
	private String devIp;         //ip地址
	private String devNo;       //设备编号
	private String devName;       //设备名称
	private String devAddr;       //设备地址
	private String status;        //状态


	public static class csis_channel_dev {
	}
	
	public static ChlDev instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(ChlDev chennelDev){
		 Map<String, Object> map = new HashMap<>();
		 map.put("chnlode", chennelDev.getChnlCode());
		 map.put("devip", chennelDev.getDevIp());
		 map.put("devno", chennelDev.getDevNo());
		 map.put("devname", chennelDev.getDevName());
		 map.put("devaddr", chennelDev.getDevAddr());
		 map.put("status", chennelDev.getStatus());

		 return map;
	}
}
