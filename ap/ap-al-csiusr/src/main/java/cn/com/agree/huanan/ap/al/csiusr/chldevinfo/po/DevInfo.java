package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevInfo.csis_channel_devinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 设备信息表Bean
 * @author Maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_channel_devinfo.class)
public class DevInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String devNo;//自助设备号
	private String devType;//设备类型
	private String status;//设备状态
	private String devTypeNo;//设备型号
	private String devTellerNo;//虚拟操作员号
	private String devIp;//IP地址
	private String admBrno;//管理归属机构号
	private String dstBrno;//资产归属机构号
	private String cshBoxFlg;//是否现金钱箱
	private String vchBoxFlg;//是否凭证钱箱
	private String cshBoxNo;//现金钱箱
	private String vchBoxNo;//凭证钱箱
	private String areaCode;//区域代码
	private String offLineFlg;//在行/离行标识
	private String admTellerNo;//管理员
	private String telePhone;//联系电话
	private String applyId;// 设备唯一标识
	private String brName;//机构名称
	private String authCode;//终端类型
	private String terMtp;//终端类型
	private String myBank;//法人号
	private String createDate;//创建日期
	private String createTime;//创建时间
	private String updateDate;//更新日期
	private String updateTime;//更新时间
	private String createUser;//创建者
	private String updateUser;//更新者
	 
	public static class csis_channel_devinfo {
	        
	}
	 
	 
	/**
	 * @param map 数据map，key:属性名(全大写) value：属性值
	 * @return DutyInfo
	 */
	public static Map<String, Object> getMap(DevInfo devInfo) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("devNo",devInfo.getDevNo());
	    map.put("devType",devInfo.getDevType());
	    map.put("status",devInfo.getStatus());
	    map.put("devTypeNo",devInfo.getDevTypeNo());
	    map.put("devTellerNo",devInfo.getDevTellerNo());
	    map.put("devIp",devInfo.getDevIp());
	    map.put("admBrno",devInfo.getAdmBrno());
	    map.put("dstBrno",devInfo.getDstBrno());
	    map.put("cshBoxFlg",devInfo.getCshBoxFlg());
	    map.put("vchBoxFlg",devInfo.getVchBoxFlg());
	    map.put("cshBoxNo",devInfo.getCshBoxNo());
	    map.put("vchBoxNo",devInfo.getVchBoxNo());
	    map.put("areaCode",devInfo.getAreaCode());
	    map.put("offLineFlg",devInfo.getOffLineFlg());
	    map.put("admTellerNo",devInfo.getAdmTellerNo());
	    map.put("telePhone",devInfo.getTelePhone());
	    map.put("applyId",devInfo.getApplyId());
	    map.put("brName",devInfo.getBrName());
	    map.put("terMtp",devInfo.getTerMtp());
	   	map.put("authCode",devInfo.getAuthCode());
		map.put("myBank",devInfo.getMyBank());	   	
		map.put("createDate", devInfo.getCreateDate());
		map.put("createTime", devInfo.getCreateTime());
		map.put("updateDate", devInfo.getUpdateDate());
		map.put("updateTime", devInfo.getUpdateTime());
		map.put("createUser", devInfo.getCreateUser());
		map.put("updateUser", devInfo.getUpdateUser());
	    return map;
	}	

}
