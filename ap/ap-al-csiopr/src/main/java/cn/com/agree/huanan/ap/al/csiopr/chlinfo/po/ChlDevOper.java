package cn.com.agree.huanan.ap.al.csiopr.chlinfo.po;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@Table(ChlDevOper.csis_channel_dev_oper.class)
public class ChlDevOper implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3893980180338209352L;
	private String seriNo;//流水号
	private String optType;//操作类型
	private String sysId;//渠道代码
	private String chnlCode;//渠道代码
	private String devIp;//Ip地址
	private String devNo;//设备编号
	private String devName;//设备名称
	private String devAddr;//设备地址
	private String status;//状态
	private String crtDate;//操作日期
	private String crtTime;//操作时间
	private String crtBrno;//操作行所
	private String crtTlr;//操作柜员
	private String auDate;//审批日期
	private String audTime;//审批时间
	private String audBrno;//审批行所
	private String audTlr;//审批柜员
	private String authStatus;//审批状态
	private String authRemarks;//审批意见

	public static class csis_channel_dev_oper{
		
	}

	public static ChlDevOper instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(ChlDevOper chlDevOper){
		 Map<String, Object> map = new HashMap<>();
		 map.put("serino", chlDevOper.getSeriNo());
		 map.put("opttype", chlDevOper.getOptType());
		 map.put("sysid", chlDevOper.getSysId());
		 map.put("chnlcode", chlDevOper.getChnlCode());
		 map.put("devip", chlDevOper.getDevIp());
		 map.put("devno", chlDevOper.getDevNo());
		 map.put("devname", chlDevOper.getDevName());
		 map.put("devaddr", chlDevOper.getDevAddr());
		 map.put("status", chlDevOper.getStatus());
		 map.put("crtdate", chlDevOper.getCrtDate());
		 map.put("crttime", chlDevOper.getCrtTime());
		 map.put("crtbrno", chlDevOper.getCrtBrno());
		 map.put("crttlr", chlDevOper.getCrtTlr());
		 map.put("audate", chlDevOper.getAuDate());
		 map.put("audtime", chlDevOper.getAudTime());
		 map.put("audbrno", chlDevOper.getCrtBrno());
		 map.put("audtlr", chlDevOper.getAudTlr());
		 map.put("authstatus", chlDevOper.getAuthStatus());
		 map.put("authremarks", chlDevOper.getAuthRemarks());
		return map;
	}
	
}
