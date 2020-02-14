package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsApplyInfo;

/**
 * 申请记录流水表dao层
 * 
 * @author guyulong
 */
public interface MbsApplyInfoDao {
	/**
	 * 根据申请编号更新信息
	 * 
	 * @param appId
	 *            申请编号
	 * @param updInfo
	 *            更新的信息
	 * @return
	 */
	int updApplyInfo(String appId, Map<String, Object> updInfo);

	/**
	 * 根据申请编号查询信息
	 * 
	 * @param appId
	 *            申请编号
	 * @return
	 */
	MbsApplyInfo findApplyInfo(String appId);

	/**
	 * 查询所有申请记录
	 * 
	 * @param operphone
	 *            查询记录的手机号
	 * @param tradecode
	 *            申请类型
	 * @param status
	 *            申请记录的状态
	 * @param idtfno
	 *            证件号码
	 * @return 申请记录集合
	 */
	List<Map<String, Object>> findApplyInfoList(String operphone, String tradecode, String status, String idtfno);

	/**
	 * 新增申请记录流水表记录
	 * 
	 * @param applyInfo
	 *            申请信息
	 * @return
	 */
	int insertApplyInfo(Map<String, Object> applyInfo);

	/**
	 * 查询子表
	 * 
	 * @param requno
	 *            申请编号
	 * @param trancode
	 *            申请类型
	 * @return 子表名
	 */
	Map<String, Object> findSubTable(String requno, String trancode);

	/**
	 * 查询记录总表获取子表信息
	 * 
	 * @param serialno
	 *            流水号
	 * @return
	 */
	Map<String, Object> getSonTableInformation(String serialno);

	/**
	 * 微网点影像信息查询(个人)
	 * 
	 * @param app_id
	 *            申请编号
	 * @param applystdt
	 *            起始申请日期
	 * @param applyendt
	 *            截止申请日期
	 * @param custname
	 *            姓名
	 * @param operphone
	 *            手机号
	 * @param id_no
	 *            证件号
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @param status
	 *            申请状态
	 * @return
	 */
	List<Map<String, Object>> findApplyInfos(String app_id, String applystdt, String applyendt, String custname,
			String operphone, String id_no, String serialno, String tradedate, String status);
	
	/**
	 * 更新所有超期记录状态
	 * @param nowDate 最后有效期
	 * @param updInfo 更新信息
	 * @return
	 */
	int updateOutOfDate(String nowDate, Map<String, Object> updInfo);

}
