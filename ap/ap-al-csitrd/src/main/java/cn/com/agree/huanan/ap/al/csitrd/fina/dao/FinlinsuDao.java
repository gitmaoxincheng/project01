package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;

/**
 * 理财保险业务登记簿Dao
 * @author jiangzf
 * @category 理财保险业务登记簿Dao
 */
public interface FinlinsuDao {
	
	/**
	 * 插入一条理财保险业务交易记录
	 * @return
	 */
	public int addFinlinsu(Map<String,Object> Fls);
	
	/**
	 * 通过id获取一条理财保险业务交易记录
	 * @return 
	 */
	public Tradfinamain getFinlinById(int id);
	
	public int updateFinlinsu(Map<String,Object> Fls);
	
}
