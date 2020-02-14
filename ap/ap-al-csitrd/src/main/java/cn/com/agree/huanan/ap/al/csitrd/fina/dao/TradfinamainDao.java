package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Questionmain;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradriskmain;


public interface TradfinamainDao {
	
	
	/**
	 * 理财保险业务登记
	 * @param tradfinamain
	 * @return int
	 */
	public int tradeinfoInsert(Tradfinamain tradfinamain);
	
	/**
	 * 理财保险业务更新
	 * @param Map
	 * @return int
	 */
	public int tradeinfoUpdate(Map<String, Object> paramMap);
	
	/**
	 * 风险评估业务登记
	 * @param tradfinamain
	 *  @return int
	 */
	public int traderiskInsert(Tradriskmain tradriskmain);
	
	/**
	 * 风险评估业务登记
	 * @param Map
	 *  @return int
	 */
	public int traderiskUpdate(Map<String, Object> paramMap);
	
	/**
	 * 评估问卷查询
	 * @param clienttype
	 * @param clientgroup
	 * @param papertype
	 * @param paperno
	 * @return Map
	 */
	public Map<String,Object> selectquestionnaireSuervey(String clienttype,String clientgroup,String papertype,String paperno);
	

	/**
	 * 清空评估问卷表
	 * @return
	 */
	public int deletequestionSuervey();
	
	/**
	 * 插入评估问卷
	 * @param question
	 * @return
	 */
	public int insertquestionSuervey(Questionmain question);
}
