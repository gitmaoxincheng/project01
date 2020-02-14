package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.Map;

/**
 * 批量开户个人信息采集表dao层
 * 
 * @author guyulong
 *
 */
public interface MbsPerBatchDao {
	/**
	 * 批量开户个人信息采集
	 * 
	 * @param infoMap
	 *            采集的信息
	 * @return
	 */
	int insertInfo(Map<String, Object> infoMap);
}
