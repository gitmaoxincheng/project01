package cn.com.agree.huanan.ap.al.csitrd.percust.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCustSub.TRADEINFO_PER_CUST_SUB;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 个人客户信息登记簿子表bean
 * @author czp
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_PER_CUST_SUB.class)
public class PerCustSub implements Serializable{
	
	private static final long serialVersionUID = -3041760289391068565L;
	private String backServeCode;//后台服务码
	private String backSceneCode;//后台场景码
	private String backSysDate;//后台交易日期
	private String backSysNo;//后台交易流水
	private String backSysSts;//后台交易状态
	private String backSysErrorCode;//后台消息码
	private String backSysErrorMsg;//后台消息码描述
	private String updDate;//最后更新日期
	private String updTime;//最后更新时间
	private String subSerialNo;//子交易序号
	private String subTradeTime;//子交易时间
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String respSts;//交易状态
	private String errorCode;//消息码
	private String errorMsg;//消息码描述
	
	public static class TRADEINFO_PER_CUST_SUB{
		
	}
	
	public static Map<String,Object> getMap(PerCustSub tradeSignSub){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("backServeCode",tradeSignSub.getBackServeCode());
		map.put("backSceneCode",tradeSignSub.getBackSceneCode());
		map.put("backSysDate",tradeSignSub.getBackSysDate());
		map.put("backSysNo",tradeSignSub.getBackSysNo());
		map.put("backSysSts",tradeSignSub.getBackSysSts());
		map.put("backSysErrorCode",tradeSignSub.getBackSysErrorCode());
		map.put("backSysErrorMsg",tradeSignSub.getBackSysErrorMsg());
		map.put("updDate",tradeSignSub.getUpdDate());
		map.put("updTime",tradeSignSub.getUpdTime());
		map.put("subSerialNo",tradeSignSub.getSubSerialNo());
		map.put("subTradeTime",tradeSignSub.getSubTradeTime());
		map.put("tradeDate",tradeSignSub.getTradeDate());
		map.put("serialNo",tradeSignSub.getSerialNo());
		map.put("respSts",tradeSignSub.getRespSts());
		map.put("errorCode",tradeSignSub.getErrorCode());
		map.put("errorMsg",tradeSignSub.getErrorMsg());
		
		return map;
	}

}
