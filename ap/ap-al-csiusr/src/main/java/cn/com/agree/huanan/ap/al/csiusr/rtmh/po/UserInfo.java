package cn.com.agree.huanan.ap.al.csiusr.rtmh.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.UserInfo.csis_sbm_userinfo;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 回单机用户 bean
 * @author yfk
 */
@Getter
@Setter
@ToString
@Table(csis_sbm_userinfo.class)
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 9081414180398771574L;
	
	private String tlId;//柜员号
	private String persId;//员工号
	private String orgNo;//机构号
	private String Pwd;//柜员密码
	private String edt;//密码有效期
	private String name;//柜员名称
	private String document_Type;//证件类型
	private String idNo;//证件号码
	private String loginWay;//登录方式
	
	public static class csis_sbm_userinfo{
		
	}
	
	public static Map<String, Object> getMap(UserInfo userinfo) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("tlId", userinfo.getTlId());
		map.put("persId", userinfo.getPersId());
		map.put("orgNo", userinfo.getOrgNo());
		map.put("Pwd", userinfo.getPwd());
		map.put("edt", userinfo.getEdt());
		map.put("name", userinfo.getName());
		map.put("document_Type", userinfo.getDocument_Type());
		map.put("idNo", userinfo.getIdNo());
		map.put("loginWay", userinfo.getLoginWay());
		
		return map;
		
	}
	
}
