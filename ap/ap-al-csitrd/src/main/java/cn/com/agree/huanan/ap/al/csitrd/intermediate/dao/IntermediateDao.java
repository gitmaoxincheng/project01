package cn.com.agree.huanan.ap.al.csitrd.intermediate.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.intermediate.po.IntermediateInfo;

public interface IntermediateDao {
	
	/**
	 * @summary 新增特色业务记录
	 * @param intermediateInfo 特色业务实体类
	 * @return
	 */
	public int insertIntermediateInfo(IntermediateInfo intermediateInfo);
	
	/**
	 * 修改特色业务记录
	 * @param map 
	 * @return
	 */
	public int updateIntermediateInfo(Map<String,Object> paramMap);
}
