package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.dao;

import java.util.List;
import java.util.Map;

/**
 * 文件处理流水表Dao
 * 
 * @author guyulong
 */
public interface MbsGbbFileFlowDao {
	/**
	 * 查询当天文件是否有处理
	 * 
	 * @param filedate
	 *            文件日期
	 * @return
	 */
	int findFilepathCount(String filedate);

	/**
	 * 插入当天记录
	 * 
	 * @param filepathInfo
	 *            记录信息
	 * @return
	 */
	int insertFilepath(Map<String, Object> filepathInfo);

	/**
	 * 查询十天内的记录
	 * 
	 * @param filedate
	 *            文件日期
	 * @param fileendate
	 *            文件开始日期
	 * @return
	 */
	List<Map<String, Object>> findFilepath(String filedate, String fileendate);

	/**
	 * 更新文件记录信息
	 * 
	 * @param updateInfo
	 *            更新信息
	 * @return
	 */
	int updateFilepath(String filedate, Map<String, Object> updateInfo);
}
