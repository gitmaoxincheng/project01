package cn.com.agree.huanan.ap.al.csitrd.sign.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToSubClient.TRADEINFO_CORP_CUST_SUB;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



/**
 * 对公客户信息登记簿子表Bean
 * @author maowei
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_CORP_CUST_SUB.class)
public class ToSubClient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String subserialno;//子交易序号
	private String subtradetime;//子交易时间
	private String tradeDate;//平台交易日期
	private String serialno;//平台交易流水
	private String respsts;//交易状态  F-失败  S-成功  U-未知  P-部分成功  I-处理中
	private String errorCode;//消息码
	private String errorMsg;//消息码描述
	private String backServeCode;//后台服务码
	private String backSceneCode;//后台场景码
	private String backSysDate;//后台交易日期
	private String backSysNo;//后台交易流水
	private String backSysSts;//后台交易状态
	private String backSysErrorCode;//后台消息码
	private String backSysErrorMsg;//后台消息码描述
	private String updDate;//最后更新日期
	private String updTime;//最后更新时间
	
	public static class TRADEINFO_CORP_CUST_SUB{
			
	}
	
	public static Map<String,Object> getMap(ToSubClient tosubClient){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subserialno",tosubClient.getSubserialno());
		map.put("subtradetime",tosubClient.getSubtradetime());
		map.put("tradedate",tosubClient.getTradeDate());
		map.put("serialno",tosubClient.getSerialno());
		map.put("respsts",tosubClient.getRespsts());
		map.put("errorcode",tosubClient.getErrorCode());
		map.put("errormsg",tosubClient.getErrorMsg());
		map.put("backservecode",tosubClient.getBackServeCode());
		map.put("backscenecode",tosubClient.getBackSceneCode());
		map.put("backsysdate",tosubClient.getBackSysDate());
		map.put("backsysno",tosubClient.getBackSysNo());
		map.put("backsyssts",tosubClient.getBackSysSts());
		map.put("backsyserrorcode",tosubClient.getBackSysErrorCode());
		map.put("backsyserrormsg",tosubClient.getBackSysErrorMsg());
		map.put("upddate",tosubClient.getUpdDate());
		map.put("updtime",tosubClient.getUpdTime());
		
		return map;
	}
}

