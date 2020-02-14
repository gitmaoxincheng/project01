package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

/**
 * 统一签约申请表dao层
 * 
 * @author guyulong
 */
public interface MbsPerAppointDao {
	/**
	 * 统一签约申请信息查询
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
	List<Map<String, Object>> findPersonalUnifySignApplicationInformations(String idtftp, String idtfno, String app_id,
			String gloseqNo);

	/**
	 * 统一签约申请表信息总数
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
	int findPersonalUnifySignApplicationInformationsCount(String idtftp, String idtfno, String app_id, String gloseqNo);

	/**
	 * 根据申请编号更新信息
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            更新的信息
	 * @return
	 */
	int updPerAppoInfo(String appId, Map<String, Object> updInfo);

	/**
	 * 根据申请编号查询申请信息
	 * 
	 * @param appId
	 *            申请编号
	 * @return
	 */
	int findAppoInfoByAppId(String appId);

	/**
	 * 录入统一签约申请信息
	 * 
	 * @param appoInfo
	 * @return
	 */
	int insertInfo(Map<String, Object> appoInfo);

	/**
	 * 查询统一签约申请明细
	 * 
	 * @param serialno
	 *            流水号
	 * @return
	 */
	Map<String, Object> findAppointDetails(String serialno);

	/**
	 * 更新所有超期记录状态
	 * @param nowDate 最后有效期
	 * @param updInfo 更新信息
	 * @return
	 */
	int updateOutOfDate(String nowDate, Map<String, Object> updInfo) ;
}
