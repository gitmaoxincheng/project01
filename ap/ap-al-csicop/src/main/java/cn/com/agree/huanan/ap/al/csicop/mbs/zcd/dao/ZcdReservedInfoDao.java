package cn.com.agree.huanan.ap.al.csicop.mbs.zcd.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csicop.mbs.zcd.po.ZcdReservedInfo;

/**
 * 政采贷预约信息表dao层
 * 
 * @author guyulong
 */
public interface ZcdReservedInfoDao {
	/**
	 * 向政财贷预约信息表中插入预约信息
	 * 
	 * @param zcdReservedInfo
	 *            预约信息
	 * @return
	 */
	int insertInfo(Map<String, Object> zcdReservedInfo);

	/**
	 * 政采贷申请概要信息查询
	 * 
	 * @param busiNo
	 *            营业执照号码
	 * @param status
	 *            状态
	 * @param staDate
	 *            起始日期
	 * @param endDate
	 *            截止日期
	 * @param pageSize
	 *            每页查询条数
	 * @param pageNumb
	 *            查询页码
	 * @param linkPhone
	 *            联系人手机号码
	 * @return
	 */
	List<Map<String, Object>> findOutlineInfos(String busiNo, String status, String staDate, String endDate,
			String pageSize, String pageNumb, String linkPhone);

	/**
	 * 查询总记录数
	 * 
	 * @param busiNo
	 *            营业执照号码
	 * @param status
	 *            状态
	 * @param staDate
	 *            起始日期
	 * @param endDate
	 *            截止日期
	 * @param linkPhone
	 *            联系人手机号码
	 * @return
	 */
	int findOutlineInfoAll(String busiNo, String status, String staDate, String endDate, String linkPhone);

	/**
	 * 政采贷申请明细信息查询
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	ZcdReservedInfo findDetailedInfo(String serialno, String tradedate);

	/**
	 * 更改政采贷审核申请信息
	 * 
	 * @param tradeDate
	 *            交易日期
	 * @param serialno
	 *            交易流水号
	 * @param updateInfo
	 *            更改信息
	 * @return
	 */
	int updateInfo(String tradeDate, String serialNo, Map<String, Object> updateInfo);

	/**
	 * MNTW0020 政采贷数据同步 对应的 MBS021 政财贷待办事宜查询
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradeDate
	 *            交易日期
	 * @param pageSize
	 *            每页查询条数
	 * @return
	 */
	List<Map<String, Object>> findWaitHandleInfos(String serialNo, String tradeDate, String pageSize);

	/**
	 * MNTW0020 政采贷数据同步 查询总数
	 * 
	 * @param serialNo
	 *            交易流水号
	 * @param tradeDate
	 *            交易日期
	 * @return
	 */
	int findWaitHandleInfoAll(String serialNo, String tradeDate);

	/**
	 * 查询政采贷审核数据是否存在
	 * 
	 * @param serialNo
	 *            交易流水号
	 * @param tradeDate
	 *            交易日期
	 * @return
	 */
	int findInfo(String serialNo, String tradeDate);

	/**
	 * 查询手机号
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	Map<String, Object> findPhoneNumber(String serialno, String tradedate);
}
