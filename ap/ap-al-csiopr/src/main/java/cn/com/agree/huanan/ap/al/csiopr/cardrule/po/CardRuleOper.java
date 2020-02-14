package cn.com.agree.huanan.ap.al.csiopr.cardrule.po;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinInfo;
import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleOper.csis_crd_rule_oper;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@Table(csis_crd_rule_oper.class)
public class CardRuleOper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5225841475551950703L;
	private String seriNo;		//流水号
	private String optType;		//操作类型 0-新增 1-修改 2-删除
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
	public static class csis_crd_rule_oper{
		
	}
	public static CardRuleOper instance(Map<String, Object> map) {
		return null;
	}
	 public static Map<String, Object> getMap(CardRuleOper cardRuleOper){
		 Map<String, Object> map = new HashMap<>();
		 map.put("seriNo", cardRuleOper.getSeriNo());
		 map.put("optType", cardRuleOper.getOptType());
		 map.put("cardType", cardRuleOper.getCardType());
		 map.put("cardName", cardRuleOper.getCardName());
		 map.put("cardLen", cardRuleOper.getCardLen());
		 map.put("featCode1", cardRuleOper.getFeatCode1());
		 map.put("featPos1", cardRuleOper.getFeatPos1());
		 map.put("featLen1", cardRuleOper.getFeatLen1());
		 map.put("featCode2", cardRuleOper.getFeatCode2());
		 map.put("featPos2", cardRuleOper.getFeatPos2());
		 map.put("featLen2", cardRuleOper.getFeatLen2());
		 map.put("featCode3", cardRuleOper.getFeatCode3());
		 map.put("featPos3", cardRuleOper.getFeatPos3());
		 map.put("featLen3", cardRuleOper.getFeatLen3());
		 map.put("featCode4", cardRuleOper.getFeatCode4());
		 map.put("featPos4", cardRuleOper.getFeatPos4());
		 map.put("featLen4", cardRuleOper.getFeatLen4());
		 map.put("featCode5", cardRuleOper.getFeatCode5());
		 map.put("featPos5", cardRuleOper.getFeatPos5());
		 map.put("featLen5", cardRuleOper.getFeatLen5());
		 map.put("crtDate", cardRuleOper.getCrtDate());
		 map.put("crtTime", cardRuleOper.getCrtTime());
		 map.put("crtBrno", cardRuleOper.getCrtBrno());
		 map.put("crtTlr", cardRuleOper.getCrtTlr());
		 map.put("auDate", cardRuleOper.getAuDate());
		 map.put("audTime", cardRuleOper.getAudTime());
		 map.put("audBrno", cardRuleOper.getAudBrno());
		 map.put("audTlr", cardRuleOper.getAudTlr());
		 map.put("audStatus", cardRuleOper.getAudStatus());
		 map.put("audRemarks", cardRuleOper.getAudRemarks());
		 return map;
	 }
}
