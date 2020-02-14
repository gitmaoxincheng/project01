package cn.com.agree.huanan.ap.al.csiopr.cardrule.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleOper;

public interface CardRuleOperDao {

	/**
	 * 查询行内卡规则审批表数据
	 * @param cardtype 卡类型
	 * @param audstatus 审批状态
	 * @return
	 */
	int findCardRuleOperInfo(String cardtype, String audstatus);

	/**
	 * 行内卡规则新增信息插入到审批表中
	 * @param map
	 * @return
	 */
	int insertCardRuleToOper(Map<String, Object> map);

	/**
	 * 查询行内卡规则审批信息列表
	 * @param map
	 * @return
	 */
	Map<String, Object> findCardRuleOperList(Map<String, Object> map);

	/**
	 * 根据流水号查询行内卡规则审批表
	 * @param serino 流水号
	 * @return
	 */
	CardRuleOper checkCardRuleOper(String serino);

	/**
	 * 
	 * @param audStatus 审批状态
	 * @param audRemarks 审批意见
	 * @param audBrno	操作行员
	 * @param audTlr	
	 * @param auDate	操作日期
	 * @param audTime	操作时间
	 * @return
	 */
	int updateCardRuleOper(Map<String,Object> map);

}
