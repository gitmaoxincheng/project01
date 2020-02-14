package cn.com.agree.huanan.ap.al.csiopr.chlinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 渠道服务权限Bean 
 * @author lanshaojun
 */
@Getter
@Setter
@ToString
@Table(ChlSvcAuth.csis_channelsvc_auth.class)
public class ChlSvcAuth implements Serializable{
	private static final long serialVersionUID = -3893980180338209351L;
	private String sysId;//系统ID
	private String chnlCode;//渠道代码
	private String svcOutCode;//对外发布服务码
	private String scnOutCode;//对外发布场景码
	private String status;//服务权限状态 0-启用	 1-停用

	public static class csis_channelsvc_auth {
        
    }
    
    public static Map<String, Object> getMap(ChlSvcAuth svrAuth) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("sysid", svrAuth.getSysId());
		map.put("chnlCode", svrAuth.getChnlCode());
    	map.put("svcOutCode", svrAuth.getSvcOutCode());
    	map.put("scnOutCode", svrAuth.getScnOutCode());
    	map.put("status", svrAuth.getStatus());
    	return map;
    }
}
