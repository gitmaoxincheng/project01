package cn.com.agree.huanan.ap.al.csitrd.percust.dao;

import java.util.Map;
import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCustSub;

/**
 * 个人客户信息登记簿子表dao
 * @author czp
 *
 */
public interface PerCustSubDao {
	/**
	 * 插入
	 * @param PerCustSub
	 * @return
	 */
	public int insertPerCustSub(PerCustSub perCustSub);

	/**
	 * 更新
	 * @param paramMap
	 * @return
	 */
	public int updatePerCustSub(Map<String, Object> paramMap);

}
