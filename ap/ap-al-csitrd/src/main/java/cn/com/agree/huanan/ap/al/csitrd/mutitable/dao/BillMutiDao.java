package cn.com.agree.huanan.ap.al.csitrd.mutitable.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 单据列表关联查询
 * @author wangbo
 *
 */
public interface BillMutiDao {
	/**
	 * 根据条件查询单据列表
	 * @param map
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public HashMap<String, Object> selectTradeBillInfo(Map<String, String> map);
}
