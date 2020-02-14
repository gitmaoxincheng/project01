package cn.com.agree.huanan.ap.al.csiopr.chlinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfoOper.csis_channel_info_oper;
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
@Table(csis_channel_info_oper.class)
public class ChlInfoOper implements Serializable{
	private String seriNo;//流水号
	private String optType;//操作类型 0-新增		1-修改	2-删除
	private String sysId;//系统ID
	private String chnlCode;//渠道代码
	private String chnlName;//渠道名称
	private String Status;//渠道状态 00-正常 01-暂停接入 02-系统维护 03-已关闭 04-未启用
	private String chkFlag;//渠道设备ip检查标识 0-不校验	1-IP地址校验	2-设备编号校验
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

	public static class csis_channel_info_oper {
        
    }
    
    public static Map<String, Object> getMap(ChlInfoOper chlInfoOper) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("serino", chlInfoOper.getSeriNo());
    	map.put("opttype", chlInfoOper.getOptType());
		map.put("sysid", chlInfoOper.getSysId());
		map.put("chnlcode", chlInfoOper.getChnlCode());
    	map.put("chnlname", chlInfoOper.getChnlName());
		map.put("Status", chlInfoOper.getStatus());
    	map.put("chkflag", chlInfoOper.getChkFlag());
    	map.put("crtdate", chlInfoOper.getCrtDate());
    	map.put("crttime", chlInfoOper.getCrtTime());
    	map.put("crtbrNo", chlInfoOper.getCrtBrNo());
    	map.put("crttlr", chlInfoOper.getCrtTlr());
    	map.put("auddate", chlInfoOper.getAudDate());
    	map.put("audtime", chlInfoOper.getAudTime());
    	map.put("audbrNo", chlInfoOper.getAudBrNo());
    	map.put("audtlr", chlInfoOper.getAudTlr());
    	map.put("audstatus", chlInfoOper.getAudStatus());
    	map.put("audremark", chlInfoOper.getAudRemark());
    	return map;
    }
}
