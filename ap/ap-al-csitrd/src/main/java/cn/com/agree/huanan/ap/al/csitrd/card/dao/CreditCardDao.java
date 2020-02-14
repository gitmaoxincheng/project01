package cn.com.agree.huanan.ap.al.csitrd.card.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.card.po.Trainfomain;

public interface CreditCardDao {
	
	
	
	/**
	 * 信用卡业务登记
	 * @param tradfinamain
	 * 
	 */
	public int getCreditCardInsert(Trainfomain trainfomain);
	
	/**
	 * 信用卡业务更新
	 * @param Map
	 *
	 */
	public int getCreditCardUpdate(Map<String, Object> paramMap);

}
