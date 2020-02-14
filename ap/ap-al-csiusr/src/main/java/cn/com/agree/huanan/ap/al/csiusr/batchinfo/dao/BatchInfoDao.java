package cn.com.agree.huanan.ap.al.csiusr.batchinfo.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.batchinfo.po.BatchInfo;

public interface BatchInfoDao {

	/**
	 * 插入批次流水表
	 * @param batchInfo
	 * @return
	 */
	public int insertTradeinfo(BatchInfo batchInfo);

	/**
	 * 更新批次流水表
	 * @param paramMap
	 * @return
	 */
	public int updateTradeinfo(Map<String, Object> paramMap);

	/**
	 * 查询批次流水表
	 * @param srcsysid 源请求方系统标识
	 * @param gloseqno 源全局流水
	 * @return
	 */
	public Map<String, Object> QueryGenerateInfo(String srcsysid, String gloseqno);

	




}
