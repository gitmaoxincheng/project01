package cn.com.agree.huanan.ap.al.csitrd.amgt.dao;

import java.util.Map;


public interface CardBoxInfoDao {
		
	
	/**
	 * 调出卡箱更新
	 * @param card
	 * @return
	 * @author jiangzf
	 */
	public int updateTakeCard(Map<String, Object> card);
	
	/**
	 * 查询卡箱总数
	 * @param card
	 * @return
	 * @author jiangzf
	 */
	public Map<String, Object> selectTakeCard(Map<String, Object> card);
	
}
