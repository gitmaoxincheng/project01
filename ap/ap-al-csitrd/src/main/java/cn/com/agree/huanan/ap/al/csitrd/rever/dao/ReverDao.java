package cn.com.agree.huanan.ap.al.csitrd.rever.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rever.po.Rever;

/**
 * 统一冲正登记簿 Dao
 * @author ZengS
 *
 */
public interface ReverDao {
	
	/**
	 * 插入数据
	 * @param matter 统一冲正登记簿bean
	 * @return 
	 */
	public int insertReverMain(Rever rever);
	
	/**
	 * 更新数据
	 * @param paramMap 
	 * @return
	 */
	public int updateReverMain(Map<String, Object> paramMap);
}
