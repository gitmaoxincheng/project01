package cn.com.agree.huanan.ap.al.csitrd.finaadjust.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.finaadjust.po.FinaAdjust;

/**
 * @author JZF
 *	资金调度Dao层
 */
public interface FinaAdjustDao {
	
	/**
	 * 增加一条记录
	 * @return
	 */
	public int addAdjust(FinaAdjust fa);
	
	/**
	 * 修改方法
	 * @return
	 */
	public int editAdjust(FinaAdjust fa);
	
	/**
	 * 修改设备资金调剂状态
	 * @param serialNo 交易流水
	 * @param tradeDate  交易日期
	 * @param status 修改的状态
	 * @return
	 */
	public int updateAdjustStatus(String serialNo,String tradeDate,String status);
	
	/**
	 * 查方法
	 * @return
	 */
	public Map<String,Object> getAdjust(FinaAdjust fa,Integer pageflag, Integer maxnum,String startDate,String endDate);
	
	/**
	 * 查单笔交易
	 * @param serialno	流水
	 * @param tradeDate		日期
	 * @return
	 */
	public FinaAdjust getBySerialAndTrade(String serialno,String tradeDate) ;
	
	
	/**
	 * 自助设备查询方法
	 * @param fa
	 * @param pageflag
	 * @param maxnum
	 * @param startDate
	 * @param endDate
	 * @param mod
	 * @return
	 */
	public Map<String,Object> getAdjustDev(FinaAdjust fa,Integer pageflag, Integer maxnum,String startDate,String endDate);
}
