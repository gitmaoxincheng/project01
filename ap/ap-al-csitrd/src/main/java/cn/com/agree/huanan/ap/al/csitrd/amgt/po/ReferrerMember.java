package cn.com.agree.huanan.ap.al.csitrd.amgt.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.amgt.po.ReferrerMember.TRADEINFO_REFERRER;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 营销人员推荐人信息bean
 * @author lanshaojun
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_REFERRER.class)
public class ReferrerMember implements Serializable{
	
	private static final long serialVersionUID = -8381660742768753669L;

	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String marketerId;//营销人员编码
	private String marketerName;//营销人员姓名
	private String referrerId;//推荐人员编码
	private String referrerName;//推荐人员姓名
	private String updDate;//更新日期
	private String updTime;//更新时间
	
	public static class TRADEINFO_REFERRER{
		
	}
	
	public static Map<String, Object> getMap(ReferrerMember referrerMember){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("tradeDate",referrerMember.getTradeDate());
		map.put("serialNo",referrerMember.getSerialNo());
		map.put("marketerId",referrerMember.getMarketerId());
		map.put("marketerName",referrerMember.getMarketerName());
		map.put("referrerId",referrerMember.getReferrerId());
		map.put("referrerName",referrerMember.getReferrerName());
		map.put("updDate",referrerMember.getUpdDate());
		map.put("updTime",referrerMember.getUpdTime());

		return map;
	}
}
