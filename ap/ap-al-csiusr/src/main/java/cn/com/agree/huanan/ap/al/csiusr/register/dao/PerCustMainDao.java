package cn.com.agree.huanan.ap.al.csiusr.register.dao;

import cn.com.agree.huanan.ap.al.csiusr.register.po.PerCustMain;

/**
 * 个人客户信息登记簿Dao
 * @author HWW
 *
 */
public interface PerCustMainDao {
	/**
	 * 插入个人客户信息登记簿记录
	 * @param perCustMain
	 * @return 插入记录个数
	 */
	public int insertPerCustMain(PerCustMain perCustMain);
	
	/**
	 * 更新个人客户信息登记簿记录
	 * @param perCustMain
	 * @return 更新记录个数
	 */
	public int updatePerCustMain(PerCustMain perCustMain);
}
