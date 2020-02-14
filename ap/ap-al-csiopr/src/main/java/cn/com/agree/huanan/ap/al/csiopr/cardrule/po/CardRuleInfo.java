package cn.com.agree.huanan.ap.al.csiopr.cardrule.po;

import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleInfo.csis_crd_rule;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;;

@Setter
@Getter
@ToString
@Table(csis_crd_rule.class)
public class CardRuleInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 764002685195057441L;
	private String cardType;	//卡类型
	private String cardName;	//卡名称
	private String cardLen;		//卡号长度
	private String featCode1;	//特征码1
	private String featPos1;	//特征码1起始位
	private String featLen1;	//特征码1长度
	private String featCode2;	//特征码2
	private String featPos2;	//特征码2起始位
	private String featLen2;	//特征码2长度
	private String featCode3;	//特征码3
	private String featPos3;	//特征码3起始位
	private String featLen3;	//特征码3长度
	private String featCode4;	//特征码4
	private String featPos4;	//特征码4起始位
	private String featLen4;	//特征码4长度
	private String featCode5;	//特征码5
	private String featPos5;	//特征码5起始位
	private String featLen5;	//特征码5长度5
	public static class csis_crd_rule{
		
	}
	
	public static CardRuleInfo instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(CardRuleInfo cardRuleInfo){
		 Map<String, Object> map = new HashMap<>();
		 map.put("cardType", cardRuleInfo.getCardType());
		 map.put("cardName", cardRuleInfo.getCardName());
		 map.put("cardLen", cardRuleInfo.cardLen);
		 map.put("featCode1", cardRuleInfo.getFeatCode1());
		 map.put("featPos1", cardRuleInfo.getFeatPos1());
		 map.put("featLen1", cardRuleInfo.getFeatLen1());
		 map.put("featCode2", cardRuleInfo.getFeatCode2());
		 map.put("featPos2", cardRuleInfo.getFeatPos2());
		 map.put("featLen2", cardRuleInfo.getFeatLen2());
		 map.put("featCode3", cardRuleInfo.getFeatCode3());
		 map.put("featPos3", cardRuleInfo.getFeatPos3());
		 map.put("featLen3", cardRuleInfo.getFeatCode3());
		 map.put("featCode4", cardRuleInfo.getFeatCode4());
		 map.put("featPos4", cardRuleInfo.getFeatPos4());
		 map.put("featLen4", cardRuleInfo.getFeatLen4());
		 map.put("featCode5", cardRuleInfo.getFeatCode5());
		 map.put("featPos5", cardRuleInfo.getFeatPos5());
		 map.put("featLen5", cardRuleInfo.getFeatLen5());
		 return map;
	
	}
}
