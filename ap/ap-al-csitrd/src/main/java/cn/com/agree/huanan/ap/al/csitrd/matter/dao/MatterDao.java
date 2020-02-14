package cn.com.agree.huanan.ap.al.csitrd.matter.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.matter.po.Matter;

/**
 * 
 * @author Maoxc
 *	事故事项登记簿
 */
public interface MatterDao {
	/**
	 * 插入数据
	 * @param matter 事故事项登记簿bean
	 * @return
	 */
	public int insertMatter(Matter matter);
	
	/**
	 * 更新数据
	 * @param paramMap 
	 * @return
	 */
	public int updateMatter(Map<String, Object> paramMap);
}
