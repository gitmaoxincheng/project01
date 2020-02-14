package cn.com.agree.huanan.ap.al.csiopr.cardbin.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinInfo.csis_crd_bin;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(csis_crd_bin.class)
public class CardbinInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6106550021117005414L;
	private String cardbin;		//卡bin
	private String cardType;	//卡种
	private String cardbinStByte;	//发卡行标识起始字节
	private String crdbinLen;	//发卡行标识长度
	private String cardbinTrack;	//发卡行标识读取磁道
	private String chgFlag;		//本期增减 A-新增 U-更新 D-删除 空表示无变化
	private String bankCode;	//机构代码
	private String bankName;	//发卡行名称
	private String cardName;	//卡名
	private String amtFlag;		//是否适用ATM 0-适用 1-不适用
	private String posFlag;		//是否适用POS 0-适用 1-不适用
	private String trackNo;		//磁道信息读取磁道
	private String trackStByte;	//磁道信息起始字节
	private String trackLen;	//磁道信息长度
	private String cardStByte;	//主帐号起始字节
	private String cardLen;		//主帐号长度
	private String cardNo;		//主帐号
	private String cardTrack;	//主帐号读取磁道
	
	public static class csis_crd_bin {
		
	}
	public static CardbinInfo instance(Map<String, Object> map) {
		return null;
	}
	 public static Map<String, Object> getMap(CardbinInfo cardbinInfo){
		 Map<String, Object> map = new HashMap<>();
		 map.put("cardbin", cardbinInfo.getCardbin());
		 map.put("cardType", cardbinInfo.getCardType());
		 map.put("cardbinStByte", cardbinInfo.getCardbinStByte());
		 map.put("crdbinLen", cardbinInfo.getCrdbinLen());
		 map.put("cardbinTrack", cardbinInfo.getCardbinTrack());
		 map.put("chgFlag", cardbinInfo.getChgFlag());
		 map.put("bankCode", cardbinInfo.getBankCode());
		 map.put("bankName", cardbinInfo.getBankName());
		 map.put("cardName", cardbinInfo.getCardName());
		 map.put("amtFlag", cardbinInfo.getAmtFlag());
		 map.put("posFlag", cardbinInfo.getPosFlag());
		 map.put("trackNo", cardbinInfo.getTrackNo());
		 map.put("trackStByte", cardbinInfo.getTrackStByte());
		 map.put("trackLen", cardbinInfo.getTrackLen());
		 map.put("cardStByte", cardbinInfo.getCardStByte());
		 map.put("cardLen", cardbinInfo.getCardLen());
		 map.put("cardNo", cardbinInfo.getCardNo());
		 map.put("cardTrack", cardbinInfo.getCardTrack());
		 return map;
		 
	 }
}
