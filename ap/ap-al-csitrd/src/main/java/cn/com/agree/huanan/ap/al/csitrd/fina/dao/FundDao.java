package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;

/**
 * 基金定投DAO层
 * @author jiangzf
 */
public interface FundDao {
	
	/**
	 * 增加一条基金定投记录
	 * @return 增加条数
	 */
	public int addFundTrade(Tradfinamain tFina);
	
	/**
	 * 更新一条基金定投记录
	 * @return 更新条数
	 */
	public int updataFundTrade(Tradfinamain tFina);
	
}
