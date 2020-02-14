package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

/**
 * 个人开卡申请表dao层
 * 
 * @author guyulong
 */
public interface MbsPerPersonageDao {
	/**
	 * 个人开卡申请信息查询
	 * 
	 * @param idtftp
	 *            证件类型
	 * @param idtfno
	 *            证件号码
	 * @param app_id
	 *            申请编号
	 * @param timeOutFlag
	 *            是否超时查询 0-否/1-是
	 * @param gloseqno
	 *            交易流水号
	 * @return
	 */
	List<Map<String, Object>> findPersonalCardApplicationInformations(String idtftp, String idtfno, String app_id,
			String gloseqNo);

	/**
	 * 个人开卡申请信息总数
	 * 
	 * @param idtftp
	 *            证件类型
	 * @param idtfno
	 *            证件号码
	 * @param app_id
	 *            申请编号
	 * @param timeOutFlag
	 *            是否超时查询 0-否/1-是
	 * @param gloseqno
	 *            交易流水号
	 * @return
	 */
	int findPersonalCardApplicationInformationsCount(String idtftp, String idtfno, String app_id, String gloseqNo);

	/**
	 * 个人开卡申请
	 * 
	 * @param informationMap
	 *            个人开卡申请信息集
	 * @return
	 */
	int insertPersonalCardApplicationInformation(Map<String, Object> informationMap);

	/**
	 * 根据申请编号更新信息
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            更新的信息
	 * @return
	 */
	int updPersonalInfo(String appId, Map<String, Object> updInfo);

	/**
	 * 查询个人开卡申请明细
	 * 
	 * @param serialno
	 *            流水号
	 * @return
	 */
	Map<String, Object> findPersonageDetails(String serialno);

	/**
	 * 根据申请编号查询记录
	 * 
	 * @param appId
	 *            申请编号
	 * @return
	 */
	int findPersonageInfo(String appId);

	
	/**
	 * 更新所有超期记录状态
	 * @param nowDate 最后有效期
	 * @param updInfo 更新信息
	 * @return
	 */
	int updateOutOfDate(String nowDate, Map<String, Object> updInfo);
	
	
}
