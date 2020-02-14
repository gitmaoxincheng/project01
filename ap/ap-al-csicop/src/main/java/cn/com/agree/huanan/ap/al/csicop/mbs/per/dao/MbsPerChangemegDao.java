package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsPerChangemeg;

/**
 * 客户信息变更申请表dao层
 * 
 * @author guyulong
 */
public interface MbsPerChangemegDao {

	/**
	 * 根据申请编号查询记录
	 * 
	 * @param appId
	 *            申请编号
	 * @return
	 */
	MbsPerChangemeg findByAppId(String appId);

	/**
	 * 客户信息变更申请信息查询
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
	List<Map<String, Object>> findClientChangeApplicationInformations(String idtftp, String idtfno, String app_id,
			String gloseqNo);

	/**
	 * 客户信息变更申请信息总数
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
	int findClientChangeApplicationInformationsCount(String idtftp, String idtfno, String app_id, String gloseqNo);

	/**
	 * 根据申请编号更新信息
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            更新的信息
	 * @return
	 */
	int updPerChangeInfo(String appId, Map<String, Object> updInfo);

	/**
	 * 新增客户信息变更申请表记录
	 * 
	 * @param perChangeInfo
	 *            申请信息
	 * @return
	 */
	int insertPerChangeInfo(Map<String, Object> perChangeInfo);

	/**
	 * 查询客户信息变更明细
	 * 
	 * @param serialno
	 *            流水号
	 * @return
	 */
	Map<String, Object> findChangemegDetails(String serialno);
	
	/**
	 * 更新所有超期记录状态
	 * @param nowDate 最后有效期
	 * @param updInfo 更新信息
	 * @return
	 */
	public int updateOutOfDate(String nowDate, Map<String, Object> updInfo);
}
