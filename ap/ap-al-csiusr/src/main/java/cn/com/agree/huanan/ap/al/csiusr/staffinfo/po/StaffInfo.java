package cn.com.agree.huanan.ap.al.csiusr.staffinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.staffinfo.po.StaffInfo.csis_staffinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 行员信息表Bean
 * @author maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_staffinfo.class)
public class StaffInfo implements Serializable {
	private String name;//操作员姓名
	private String tellerType;
	//操作员类型 01-正式行员 02-临时员工 03-外包人员 04-虚拟操作员 05-超级管理员
	private String myBank;//法人号
	private String idType;
	//证件类型 A-身份证 B-外国公民护照 C-户口本(身份证号) D-港澳居民通行证 E-还乡证 
	//F-边民出入境通行证 G-军官证 H-士兵证 I-军事院校学员证 J-军队离休干部荣誉证 K-军官退休证
	//L-军人文职干部退休证 M-营业执照 N-批文 O-开户证明 P-其他 Q-武警身份证 R-台湾居民通行证(停用) 
	//S-中国公民护照 T-台湾居民来往大陆通证行 U-临时身份证 U1-统一社会信用代码 V-户口本(户口本号) 
	//Y-企业名称预先核准通知书 Z-无 W-组织机构代码证 W1-组织机构代码证（特殊机构代码赋码通知）
	//W2-组织机构代码（系统自编） X1-境外公司注册证书 Y1-企业SwiftCode证明 
	//X-事业单位登记证 1-外国永久居留身份证 3-港澳居民居住证 4-台湾居民居住证
	private String idCode;//证件号码
	private String regisDate;//注册时间
	private String cancelDate;//注销时间
	private String onDate;//启用日期
	private String offDate;//停用日期
	private String status;//操作员状态 0-停用1-正常2-注销
	private String isps;//内网邮箱
	private String otps;//外网邮箱
	private String phone;//手机号码
	private String termid;//设备号
	private String termidTp;//设备类型
	private String upddate;//更新日期
	private String updtime;//更新时间
	private String tellerNo;//操作员号

    public static class csis_staffinfo {
        
    }
    
    public static Map<String, Object> getMap(StaffInfo staffInfo) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("name",staffInfo.getName());
    	map.put("tellerType", staffInfo.getTellerType());
    	map.put("myBank", staffInfo.getMyBank());
    	map.put("idType", staffInfo.getIdType());
    	map.put("idCode",staffInfo.getIdCode());
    	map.put("regisDate", staffInfo.getRegisDate());
    	map.put("cancelDate", staffInfo.getCancelDate());
    	map.put("onDate", staffInfo.getOnDate());
    	map.put("status", staffInfo.getStatus());
    	map.put("offDate",staffInfo.getOffDate());
    	map.put("isps", staffInfo.getIsps());
    	map.put("otps", staffInfo.getOtps());
    	map.put("phone", staffInfo.getPhone());
    	map.put("termid", staffInfo.getTermid());
    	map.put("upddate", staffInfo.getUpddate());
    	map.put("updtime", staffInfo.getUpdtime());
    	map.put("termidTp", staffInfo.getTermidTp());
    	map.put("tellerNo", staffInfo.getTellerNo());
    	
    	return map;
    }
    
}
