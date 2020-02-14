package cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.po.MbsReseNumInfo;

/**
 * 预约信息编号表dao
 * 
 * @author xuzhen
 *
 */
public interface MbsReseNumInfoDao {

	/**
	 * 新增预约编号表记录
	 * 
	 * @param reseNumInfoMap
	 *            预约编号信息
	 * @return
	 */
	int insert(Map<String, Object> reseNumInfoMap);

	/**
	 * 查询所有预约操作记录
	 * 
	 * @param phone
	 *            手机号
	 * @param appisval
	 *            申请有效标识
	 * @param trantype
	 *            办理状态
	 * @param numberType
	 *            编号类型
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	List<Map<String, Object>> findReseNumInfoList(String phone, String appisval, String trantype, String numberType,
			String tradedate);

	/**
	 * 修改预约编号表信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @param updInfo
	 *            更新信息
	 * @return
	 */
	int updReseInfo(String serialno, String tradedate, Map<String, Object> updInfo);

	/**
	 * 查询无效预约记录
	 * 
	 * @param serialno
	 *            流水号
	 * @param phone
	 *            手机号
	 * @param appisval
	 *            申请有效性标识
	 * @return
	 */
	Map<String, Object> findCancelRese(String serialno, String phone, String appisval);

	/**
	 * 查询预约记录
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	MbsReseNumInfo findReseNumInfo(String serialno, String tradedate);

	/**
	 * 更新过期状态
	 * 
	 * @param phone
	 *            手机号
	 * @param nowDate
	 *            当前日期
	 * @param nowTime
	 *            当前时间
	 * @param updInfo
	 *            过期状态信息
	 * @return
	 */
	int updOverdue(String phone, String nowDate, String nowTime, Map<String, Object> updInfo);

}
