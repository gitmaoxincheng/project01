package cn.com.agree.huanan.ap.al.csiopr.swalcard.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.SwalCard.csis_swall_card;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 吞没卡信息表Bean 
 * @author jiangzf 复制自旧核心
 */
@Getter
@Setter
@ToString
@Table(csis_swall_card.class)
public class SwalCard implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4453158862823703984L;
	
	private String serialNo;//流水
	private String recordBranch;//登记机构号
	private String keepBranch;//当前保管机构号
	private String keepTellerNo;//当前保管柜员
	private String swallDate;//吞卡日期
	private String recoardType;//登记类型
	private String swallTime;//时间
	private String bankType;//所属行别
	private String cardType;//凭证类别
	private String card;//卡号
	private String cardName;//户名
	private String status;//状态
	private String devNo;//自助设备机编号
	private String devType;//设备类型
	private String devName;//设备资产归属机构
	private String devBranch;//设备管理归属机构
	private String recordTellerNo;//登记柜员号
	private String checkInfo;//联网核查信息
	private String remarks;//备注
	private String reciidType;//领回人证件类型
	private String reciidNo;//领回人证件号码
	private String reciName;//领回人姓名
	private String turnDate;//上缴日期
	private String recvDate;//接收日期
	private String outDate;//调出日期
	private String inDate;//调入日期
	private String inBranch;//调入机构
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String outBranch;//调出日期
	private String outlrNo;//调出柜员

	public static enum Status{
		FOR_TAKE_BACK("00"),OBSOLETED_FOR_RECEIVE("01"),FOR_CLEAR("02"),
		DISPATCHED_FOR_RECEIVE("03"),OBSOLETED_AND_RECEIVED("04"),DELETED("05"),TAKED_BACK("06");
		private String type;
	  	private Status(String type){
	  		this.type = type;
	  	}
		public String getStatus() {
			// TODO 自动生成的方法存根
			return type;
		};
	}
	
	public static enum CardType{
		IC_DEBIT_CARD("00"),STRIPE_CARD("01"),CREDIT_CARD("02"),
		SOCIAL_CARDS("03"),OTHER_BANK_CARD("04");
		private String type;
	  	private CardType(String type){
	  		this.type = type;
	  	};
	  	public String getStatus() {
	  		return type;
	  	}
	}
	
	public static class csis_swall_card {
		
	}
	
	/**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return SwalCard
     */
    public static SwalCard instance(Map<String, Object> map){
        return null;
    }
    
    public static Map<String, Object> getMap(SwalCard swalCard){
    	Map<String, Object> map = new HashMap<>();
    	map.put("serialNo",swalCard.getSerialNo());
		map.put("recordBranch",swalCard.getRecordBranch());
		map.put("keepBranch",swalCard.getKeepBranch());
		map.put("keepTellerNo",swalCard.getKeepTellerNo());
		map.put("swallDate",swalCard.getSwallDate());
		map.put("recoardType",swalCard.getRecoardType());
		map.put("swallTime",swalCard.getSwallTime());
		map.put("bankType",swalCard.getBankType());
		map.put("cardType",swalCard.getCardType());
		map.put("card",swalCard.getCard());
		map.put("cardName",swalCard.getCardName());
		map.put("status",swalCard.getStatus());
		map.put("devNo",swalCard.getDevNo());
		map.put("devType",swalCard.getDevType());
		map.put("devName",swalCard.getDevName());
		map.put("devBranch",swalCard.getDevBranch());
		map.put("recordTellerNo",swalCard.getRecordTellerNo());
		map.put("checkInfo",swalCard.getCheckInfo());
		map.put("remarks",swalCard.getRemarks());
		map.put("reciidType",swalCard.getReciidType());
		map.put("reciidNo",swalCard.getReciidNo());
		map.put("reciName",swalCard.getReciName());
		map.put("turnDate",swalCard.getTurnDate());
		map.put("recvDate",swalCard.getRecvDate());
		map.put("outDate",swalCard.getOutDate());
		map.put("inDate",swalCard.getInDate());
		map.put("inBranch",swalCard.getInBranch());
		map.put("updDate",swalCard.getUpdDate());
		map.put("updTime",swalCard.getUpdTime());
		map.put("outBranch",swalCard.getOutBranch());
		map.put("outlrNo",swalCard.getOutlrNo());
		return map;
    }

}
