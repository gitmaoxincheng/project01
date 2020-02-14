package cn.com.agree.huanan.ap.al.csitrd.cert.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cert.po.VochManagerInfo.TRADEINFO_CERT_DETAIL;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 凭证管理明细信息 Bean
 * @author ZengS
 *
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_CERT_DETAIL.class)
public class VochManagerInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2390138061665107183L;
	
	public static class TRADEINFO_CERT_DETAIL{
		
	}
	
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String certType;//凭证种类
	private String parval;//面值
	private String brCode;//分行代码
	private String certUnit;//凭证单位
	private String totNum;//数量
	private String strtNum;//起始凭证序号
	private String endNum;//终止凭证序号 
	private String certNum;//凭证张数
	
	
	public static Map<String, Object> getMap(VochManagerInfo vochManagerInfo){
		Map<String, Object> map = new HashMap<>();

		map.put("tradedate",vochManagerInfo.getTradeDate());
		map.put("serialno",vochManagerInfo.getSerialNo());
		map.put("tradetime",vochManagerInfo.getTradeTime());
		map.put("certtype",vochManagerInfo.getCertType());
		map.put("parval",vochManagerInfo.getParval());
		map.put("brcode",vochManagerInfo.getBrCode());
		map.put("certunit",vochManagerInfo.getCertUnit());
		map.put("totnum",vochManagerInfo.getTotNum());
		map.put("strtnum",vochManagerInfo.getStrtNum());
		map.put("endnum",vochManagerInfo.getEndNum());
		map.put("certnum",vochManagerInfo.getCertNum());

		return map;
	}
}
