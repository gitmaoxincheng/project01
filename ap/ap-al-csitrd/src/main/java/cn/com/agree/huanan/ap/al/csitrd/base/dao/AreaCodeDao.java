package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.AreaCode;

/**
 * @author liaowen
 */
public interface AreaCodeDao {

	/**
	 * 查询区域代码
	 * @param querycont 查询要素
	 * @param i  查询标识
	 * @return 
	 */
	List<Map<String, Object>> queryAreaCode(String querycont, String query);
	
	
	
	/**
	 * 查询行政区域代码的所有数据
	 * @return
	 */
	List<AreaCode> queryAreaCodeAll();
}
