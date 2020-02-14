package cn.com.agree.huanan.ap.al.csiopr.cardbin.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinOper.csis_crd_bin_oper;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;

@Getter
@Setter
@ToString
@Table(csis_crd_bin_oper.class)
public class CardbinOper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8050808599113423346L;
	private String seriNo;		//流水号
	private String optType;		//操作类型 0-新增 1-修改 2-删除 3-批量导入
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
	private String tot_num;		//总笔数
	private String fileName;	//文件名称
	private String crtDate;		//操作日期
	private String crtTime;		//操作时间
	private String crtBrno;		//操作行所
	private String crtTlr;		//操作柜员
	private String auDate;		//审批日期
	private String audTime;		//审批时间
	private String audBrno;		//审批行所
	private String audTlr;		//审批柜员
	private String audStatus;	//审批状态 0-待审批 1-通过 2-拒绝
	private String audRemarks;	//审批意见
	
	public static class csis_crd_bin_oper {
		
	}
	
	public static CardbinOper instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(CardbinOper cardbinOper){
		 Map<String, Object> map = new HashMap<>();
		 map.put("seriNo", cardbinOper.getSeriNo());
		 map.put("optType", cardbinOper.getOptType());
		 map.put("cardbin", cardbinOper.getCardbin());
		 map.put("cardType", cardbinOper.getCardType());
		 map.put("cardbinStByte", cardbinOper.getCardbinStByte());
		 map.put("crdbinLen", cardbinOper.getCrdbinLen());
		 map.put("cardbinTrack", cardbinOper.getCardbinTrack());
		 map.put("chgFlag", cardbinOper.getChgFlag());
		 map.put("bankCode", cardbinOper.getBankCode());
		 map.put("bankName", cardbinOper.getBankName());
		 map.put("cardName", cardbinOper.getCardName());
		 map.put("amtFlag", cardbinOper.getAmtFlag());
		 map.put("posFlag", cardbinOper.getPosFlag());
		 map.put("trackNo", cardbinOper.getTrackNo());
		 map.put("trackStByte", cardbinOper.getTrackStByte());
		 map.put("trackLen", cardbinOper.getTrackLen());
		 map.put("cardStByte", cardbinOper.getCardStByte());
		 map.put("cardLen", cardbinOper.getCardLen());
		 map.put("cardNo", cardbinOper.getCardNo());
		 map.put("cardTrack", cardbinOper.getCardTrack());
		 map.put("tot_num", cardbinOper.getTot_num());
		 map.put("fileName", cardbinOper.getFileName());
		 map.put("crtDate", cardbinOper.getCrtDate());
		 map.put("crtTime", cardbinOper.getCrtTime());
		 map.put("crtBrno", cardbinOper.getCrtBrno());
		 map.put("crtTlr", cardbinOper.getCrtTlr());
		 map.put("auDate", cardbinOper.getAuDate());
		 map.put("audTime", cardbinOper.getAudTime());
		 map.put("audBrno", cardbinOper.getAudBrno());
		 map.put("audTlr", cardbinOper.getAudTlr());
		 map.put("audStatus", cardbinOper.getAudStatus());
		 map.put("audRemarks", cardbinOper.getAudRemarks());
		return map;
		
		 
	}
}






