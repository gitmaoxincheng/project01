package cn.com.agree.huanan.ap.al.csitrd.voch.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.voch.po.Tradeinfo;
import cn.com.agree.huanan.ap.al.csitrd.voch.po.TradeinfoFee;

/**
 * 
 * @author HZP
 *	费用信息登记簿Dao接口
 */
public interface TradeinfoFeeDao {
	/**
	 * 插入数据
	 * @param tradeinfofee
	 * @return
	 */
	public int insertTradeinfoFee(TradeinfoFee tradeinfoFee);
	
	/**
	 * 更新数据
	 * @param paramMap
	 * @return
	 */
	public int updateTradeinfoFee(Map<String, Object> paramMap);
}
