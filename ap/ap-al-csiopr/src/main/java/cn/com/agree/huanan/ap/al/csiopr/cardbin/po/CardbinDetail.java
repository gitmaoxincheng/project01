package cn.com.agree.huanan.ap.al.csiopr.cardbin.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinDetail.csis_crdbin_batimport;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(csis_crdbin_batimport.class)
public class CardbinDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8717099204893433839L;
	private String seriNo;		//流水号
	private String audSerino;	//审批流水
	private String cardbin;		//卡bin
	private String cardType;	//卡种
	private String cardbinStByte;	//发卡行标识起始字节
	private String crdBinLen;	//发卡行标识长度
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
	public static class csis_crdbin_batimport{
		
	}
	
	public static CardbinDetail instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(CardbinDetail cardbinDetail){
		 Map<String, Object> map = new HashMap<>();
		 map.put("seriNo", cardbinDetail.getSeriNo());
		 map.put("audSerino", cardbinDetail.getAudSerino());
		 map.put("cardbin", cardbinDetail.getCardbin());
		 map.put("cardType", cardbinDetail.getCardType());
		 map.put("cardbinStByte", cardbinDetail.getCardbinStByte());
		 map.put("crdBinLen", cardbinDetail.getCrdBinLen());
		 map.put("cardbinTrack", cardbinDetail.getCardbinTrack());
		 map.put("chgFlag", cardbinDetail.getChgFlag());
		 map.put("bankCode", cardbinDetail.getBankCode());
		 map.put("bankName", cardbinDetail.getBankName());
		 map.put("cardName", cardbinDetail.getCardName());
		 map.put("amtFlag", cardbinDetail.getAmtFlag());
		 map.put("posFlag", cardbinDetail.getPosFlag());
		 map.put("trackNo", cardbinDetail.getTrackLen());
		 map.put("trackStByte", cardbinDetail.getTrackStByte());
		 map.put("trackLen", cardbinDetail.getTrackLen());
		 map.put("cardStByte", cardbinDetail.getCardStByte());
		 map.put("cardLen", cardbinDetail.getCardLen());
		 map.put("cardNo", cardbinDetail.getCardNo());
		 map.put("cardTrack", cardbinDetail.getCardTrack());
		return map;

	}
}
