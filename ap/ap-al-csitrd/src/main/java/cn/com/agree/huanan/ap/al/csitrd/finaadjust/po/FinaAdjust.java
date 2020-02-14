package cn.com.agree.huanan.ap.al.csitrd.finaadjust.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csitrd.finaadjust.po.FinaAdjust.TRADEINFO_ADJUST_DETAIL;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author JZF
 * 设备资金调剂表
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_ADJUST_DETAIL.class)

public class FinaAdjust implements Serializable{


	public static class TRADEINFO_ADJUST_DETAIL{

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6595287288857674730L;

	private String tradedate;//平台交易日期
	private String serialno;//平台交易流水
	private String tradetime;//平台交易时间
	private String branchno;//网点
	private String adjtype;//调剂类型0-加钞1-减钞
	private String status;//调剂状态00-在途01-在途记账中02-入库03-入库记账中04-冲销05-冲销记账中06-记账失败 "
	private String realtellerno;//实体柜员 
	private String realcshbox;//实体钱箱
	private String devtellerno;//自助设备柜员号
	private String devcshbox;//自助设备柜员号钱箱
	private String txccy;//币种
	private String amount;//金额
	private String summary;//摘要
	private String oritradedate;//原交易日期
	private String oriserialno;//原交易流水
	private String sndtellerno;//发起在途操作员
	private String sndauthtellerno;//发起在途复核员
	private String rcvtellerno;//发起入库操作员
	private String rcvauthtellerno;//发起入库复核员
	private String upddate;//更新日期
	private String updtime;//更新时间

	public static Map<String, Object> getMap(FinaAdjust finaAdjust){
		Map<String, Object> map = new HashMap<>();
		map.put("tradeDate",finaAdjust.getTradedate());
		map.put("serialNo",finaAdjust.getSerialno());
		map.put("tradeTime",finaAdjust.getTradetime());
		map.put("branchNo",finaAdjust.getBranchno());
		map.put("adjType",finaAdjust.getAdjtype());
		map.put("status",finaAdjust.getStatus());
		map.put("realtellerNo",finaAdjust.getRealtellerno());
		map.put("realcshBox",finaAdjust.getRealcshbox());
		map.put("devtellerNo",finaAdjust.getDevtellerno());
		map.put("devcshBox",finaAdjust.getDevcshbox());
		map.put("txccy",finaAdjust.getTxccy());
		map.put("amount",finaAdjust.getAmount());
		map.put("summary",finaAdjust.getSummary());
		map.put("oritradeDate",finaAdjust.getOritradedate());
		map.put("oriserialNo",finaAdjust.getOriserialno());
		map.put("sndtellerNo",finaAdjust.getSndtellerno());
		map.put("sndauthtellerno",finaAdjust.getSndauthtellerno());
		map.put("rcvtellerno",finaAdjust.getRcvtellerno());
		map.put("rcvauthtellerNo",finaAdjust.getRcvauthtellerno());
		map.put("updDate",finaAdjust.getUpddate());
		map.put("updTime",finaAdjust.getUpdtime());
		return map;
	}

	public static enum AdjustStatus{

		ON_WAY("00"),ON_WAY_ACCOUNTING("01"),STORED("02"),
		STORED_ACCOUNTING("03"),FLUSHED("04"),FLUSHED_ACCOUNTING("05"),FAILURE("06");
		private String type;
		private AdjustStatus(String type){
			this.type = type;
		};
		public String getStatus() {
			return type;
		}
		
	}

}
