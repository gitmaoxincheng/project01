package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.dao;

import java.util.List;
import java.util.Map;

/**
 * 亲子卡信息录入表dao
 * 
 * @author xuzhen
 *
 */
public interface MbsGbbReseInfoDao {

	/**
	 * 亲子卡申请信息录入
	 * 
	 * @param mbsGbbMap
	 *            亲子卡申请信息
	 * @return
	 */
	int insertInfo(Map<String, Object> mbsGbbMap);

	/**
	 * 查询所有用户开卡记录
	 * 
	 * @param idtftp
	 *            证件类型
	 * @param idtfno
	 *            证件号码
	 * @return
	 */
	List<Map<String, Object>> findAllRese(String idtftp, String idtfno);

	/**
	 * 亲子卡申请信息查询
	 * 
	 * @param tobrno
	 *            查询信息所属机构号
	 * @param status
	 *            申请状态
	 * @param card_type
	 *            申领卡类型
	 * @param idtfno
	 *            证件号码
	 * @param phone
	 *            手机号码
	 * @param pagesize
	 *            每页条数
	 * @param pagenum
	 *            查询页面号
	 * @return
	 */
	List<Map<String, Object>> findParentChildCardApplyInformations(String tobrno, String status, String card_type,
			String idtfno, String phone, String pagesize, String pagenum);

	/**
	 * 查询亲子卡申请信息条数
	 * 
	 * @param tobrno
	 *            查询信息所属机构号
	 * @param status
	 *            申请状态
	 * @param card_type
	 *            申领卡类型
	 * @param idtfno
	 *            证件号码
	 * @param phone
	 *            手机号码
	 * @param pagesize
	 *            每页条数
	 * @param pagenum
	 *            查询页面号
	 * @return
	 */
	int findParentChildCardApplyInformationCount(String tobrno, String status, String card_type, String idtfno,
			String phone);

	/**
	 * 查询是否办理过亲子卡
	 * 
	 * @param date
	 *            领卡截止日期
	 * @return
	 */
	List<Map<String, Object>> findGBB_TYPE(String date);

	/**
	 * 亲子卡申请状态录入
	 * 
	 * @param tradedate
	 *            交易日期
	 * @param serialno
	 *            交易流水号
	 * @param status
	 *            亲子卡申请状态
	 * @return
	 */
	int updateStatus(String tradedate, String serialno, String status);

	/**
	 * 亲子卡申请状态更新
	 * 
	 * @param name
	 *            姓名
	 * @param idtfno
	 *            证件号
	 * @param fileDate
	 *            前一天
	 * @param sdate
	 *            前三十天
	 * @return
	 */
	int updateStatus(String name, String idtfno, String fileDate, String sdate);
}
