package cn.com.agree.huanan.ap.al.csiopr.chlinfo.po;


import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 渠道服务权限审核Bean 
 * @author hcp
 */
@Getter
@Setter
@ToString
@Table(ChlSvcAuthOper.csis_channelsvc_auth_oper.class)
public class ChlSvcAuthOper implements Serializable {
	private String seriNo;//流水号
	private String optType;//操作类型 0-新增		1-修改	2-删除
	private String sysId;//渠道ID
	private String chnlCode;//渠道代码
	private String chnlName;//渠道名称
	private String svcOutCode;//渠道代码
	private String scnOutCode;//渠道名称
	private String crtDate;//操作日期
	private String crtTime;//操作时间
	private String crtBrNo;//操作行所
	private String crtTlr;//操作柜员
	private String audDate;//审批日期
	private String audTime;//审批时间
	private String audBrNo;//审批行所
	private String audTlr;//审批柜员
	private String audStatus;//审批状态 0-待审批		1-通过	2-拒绝
	private String audRemark;//审批意见

	public static class csis_channelsvc_auth_oper {
        
    }
    

    public static Map<String, Object> getMap(ChlSvcAuthOper svrAuthOper) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("seriNo", svrAuthOper.getSeriNo());
    	map.put("optType", svrAuthOper.getOptType());
    	map.put("sysId", svrAuthOper.getSysId());
		map.put("chnlCode", svrAuthOper.getChnlCode());
		map.put("chnlName", svrAuthOper.getChnlName());
		map.put("svcOutCode", svrAuthOper.getSvcOutCode());
    	map.put("scnOutCode", svrAuthOper.getScnOutCode());
    	map.put("crtDate", svrAuthOper.getCrtDate());
    	map.put("crtTime", svrAuthOper.getCrtTime());
    	map.put("crtBrNo", svrAuthOper.getCrtBrNo());
    	map.put("crtTlr", svrAuthOper.getCrtTlr());
    	map.put("audDate", svrAuthOper.getAudDate());
    	map.put("audTime", svrAuthOper.getAudTime());
    	map.put("audBrNo", svrAuthOper.getAudBrNo());
    	map.put("audTlr", svrAuthOper.getAudTlr());
    	map.put("audStatus", svrAuthOper.getAudStatus());
    	map.put("audRemark", svrAuthOper.getAudRemark());
    	return map;
    }
}
