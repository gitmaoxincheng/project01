package cn.com.agree.huanan.ap.al.atmp.atm.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.atmp.atm.po.CsisChannelInfo.CSIS_CHANNEL_INFO;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(CSIS_CHANNEL_INFO.class)
public class CsisChannelInfo implements Serializable{
	private static final long serialVersionUID = 8294137370489448041L;
	
	private String chnlcode;
	private String srcsysid;
	private String chnlname;
	private String chnlstatus;
	private String chkflag;


	
	public static class CSIS_CHANNEL_INFO{
		
	}
	
	public static CsisChannelInfo instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(CsisChannelInfo csisChannelInfo){
		 Map<String, Object> map = new HashMap<>();
		 map.put("chnlcode", csisChannelInfo.getChnlcode());
		 map.put("srcsysid", csisChannelInfo.getSrcsysid());
		 map.put("chnlname", csisChannelInfo.getChnlname());
		 map.put("chnlstatus", csisChannelInfo.getChnlstatus());
		 map.put("chkflag", csisChannelInfo.getChkflag());
		 return map;

	}
	
}
