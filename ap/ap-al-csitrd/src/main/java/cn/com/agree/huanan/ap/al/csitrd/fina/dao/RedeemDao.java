package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;

/**
 * 理财产品赎回DAO类
 * @author jiangzf
 */
public interface RedeemDao {
	
	/**
	 * 增加一条理财产品赎回记录
	 * @param 理财业务对象
	 * @return 赎回更新条数
	 */
	public int addRedeemRecord(Tradfinamain Redeem);
	

	/**
	 * 更新一条理财产品赎回记录
	 * @param 理财业务对象
	 */
	public int updataRedeemRecord(Tradfinamain Redeem);
	
}
