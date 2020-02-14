package cn.com.agree.huanan.ap.al.csitrd.paym.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.PaySubInfo.TRADEINFO_PAY_MAIN_SUB;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 支付结算业务登记簿子表bean
 * @author zengs
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_PAY_MAIN_SUB.class)
public class PaySubInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String subSerialNo;//子交易序号
	private String subTradeTime;//子交易时间
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String respSts;//交易状态
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
	
	public static class TRADEINFO_PAY_MAIN_SUB{
		
	}
	
	
	public static Map<String,Object> getMap(PaySubInfo paySubInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subserialno",paySubInfo.getSubSerialNo());
		map.put("subtradetime",paySubInfo.getSubTradeTime());
		map.put("tradedate",paySubInfo.getTradeDate());
		map.put("serialno",paySubInfo.getSerialNo());
		map.put("respsts",paySubInfo.getRespSts());
		map.put("errorcode",paySubInfo.getErrorCode());
		map.put("errormsg",paySubInfo.getErrorMsg());
		map.put("backservecode",paySubInfo.getBackServeCode());
		map.put("backscenecode",paySubInfo.getBackSceneCode());
		map.put("backsysdate",paySubInfo.getBackSysDate());
		map.put("backsysno",paySubInfo.getBackSysNo());
		map.put("backsyssts",paySubInfo.getBackSysSts());
		map.put("backsyserrorcode",paySubInfo.getBackSysErrorCode());
		map.put("backsyserrormsg",paySubInfo.getBackSysErrorMsg());
		map.put("upddate",paySubInfo.getUpdDate());
		map.put("updtime",paySubInfo.getUpdTime());

		
		return map;
	}

}
