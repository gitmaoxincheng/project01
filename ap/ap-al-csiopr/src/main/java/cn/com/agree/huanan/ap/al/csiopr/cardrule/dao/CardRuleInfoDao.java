package cn.com.agree.huanan.ap.al.csiopr.cardrule.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface CardRuleInfoDao {

	/**
	 * 根据卡类型查找行内卡规则信息
	 * @param cardtype 卡类型
	 */
	CardRuleInfo findCardRuleInfo(String cardtype);

	/**
	 * 查询行内卡规则分页信息
	 */
	IPage<Map<String, Object>> findCardRuleList(String pageflag, String maxnum, String cardtype, String cardname);

	/**
	 * 行内卡规则信息新增
	 * @param cardRuleMap
	 */
	int insertCardRule(CardRuleInfo cardRuleMap);

	/**
	 * * 行内卡规则信息更新
	 * @param cardRuleMap
	 * @return
	 */
	 
	int updateCardRule(CardRuleInfo cardRuleMap);

	/**
	 * 行内卡规则信息删除
	 * @param cardType
	 * @return
	 */
	int deleteCardRule(String cardType);

}
