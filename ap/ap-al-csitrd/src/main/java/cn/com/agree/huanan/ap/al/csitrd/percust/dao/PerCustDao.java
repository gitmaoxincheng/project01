package cn.com.agree.huanan.ap.al.csitrd.percust.dao;

import java.util.Map;
import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCust;

/**
 * 个人客户信息登记簿dao
 * @author Maoxc
 *
 */
public interface PerCustDao {
	/**
	 * 插入
	 * @param perCust
	 * @return
	 */
	public int insertPerCust(PerCust perCust);

	/**
	 * 更新
	 * @param paramMap
	 * @return
	 */
	public int updatePerCust(Map<String, Object> paramMap);

}
