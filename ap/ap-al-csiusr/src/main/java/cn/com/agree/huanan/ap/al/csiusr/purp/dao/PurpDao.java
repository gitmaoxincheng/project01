package cn.com.agree.huanan.ap.al.csiusr.purp.dao;

import cn.com.agree.huanan.ap.al.csiusr.purp.po.Purp;

/**
 * 随机数操作Dao
 * @author HWW
 *
 */
public interface PurpDao {
	
	/**
	 * 插入随机数记录
	 * @param purp 随机数Bean
	 * @return 操作状态
	 */
	public int insertPurp(Purp purp);
}
