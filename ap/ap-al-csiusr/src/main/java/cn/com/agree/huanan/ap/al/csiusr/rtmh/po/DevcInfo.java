package cn.com.agree.huanan.ap.al.csiusr.rtmh.po;

import java.io.Serializable; 
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevInfo;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.DevcInfo.csis_channel_devinfo;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 设备信息表Bean
 * @author yfk
 */
@Getter
@Setter
@ToString
@Table(csis_channel_devinfo.class)
public class DevcInfo implements Serializable {
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
	private String termTp;//终端类型
	private String authCode;//认证码
	private String pinKey;//主密钥
	
	
	public static class csis_channel_devinfo {
		
	}
	
	/**
	 * @param map 数据map，key:属性名(全大写) value：属性值
	 * @return 
	 */
	public static Map<String, Object> getMap(DevcInfo devcInfo) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("devNo",devcInfo.getDevNo());
	    map.put("devType",devcInfo.getDevType());
	    map.put("status",devcInfo.getStatus());
	    map.put("devTypeNo",devcInfo.getDevTypeNo());
	    map.put("devTellerNo",devcInfo.getDevTellerNo());
	    map.put("devIp",devcInfo.getDevIp());
	    map.put("admBrno",devcInfo.getAdmBrno());
	    map.put("dstBrno",devcInfo.getDstBrno());
	    map.put("cshBoxFlg",devcInfo.getCshBoxFlg());
	    map.put("vchBoxFlg",devcInfo.getVchBoxFlg());
	    map.put("cshBoxNo",devcInfo.getCshBoxNo());
	    map.put("vchBoxNo",devcInfo.getVchBoxNo());
	    map.put("areaCode",devcInfo.getAreaCode());
	    map.put("offLineFlg",devcInfo.getOffLineFlg());
	    map.put("admTellerNo",devcInfo.getAdmTellerNo());
	    map.put("telePhone",devcInfo.getTelePhone());
	    map.put("applyId",devcInfo.getApplyId());
	    map.put("brName",devcInfo.getBrName());
	    map.put("termTp",devcInfo.getTermTp());
	    map.put("authCode",devcInfo.getAuthCode());
	    map.put("pinKey",devcInfo.getPinKey());
	    
	    return map;
	}	
	
}
