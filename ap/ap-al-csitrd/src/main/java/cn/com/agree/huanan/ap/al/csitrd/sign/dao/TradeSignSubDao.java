package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignSub;

public interface TradeSignSubDao {
	
	/**
	 * 新增签约子信息
	 * @param signInfo 签约信息实体类
	 * @return 
	 */
	int insertTradeSignInfoSub(TradeSignSub signSub);
	
	/**
	 * 修改签约子信息
	 * @param map 签约子信息map
	 * @return
	 */
	int updateTradeSignInfoSub(Map<String,Object> map);
}
