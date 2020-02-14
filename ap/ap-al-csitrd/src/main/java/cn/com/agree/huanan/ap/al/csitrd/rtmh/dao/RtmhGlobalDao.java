package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.Map; 

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;

/**
 * 其他P (回单机)流水表Dao层
 * @author yaofk
 *
 */
public interface RtmhGlobalDao {

	/**
	 * 登记其他p交易流水表
	 * @param rtmhMap 流水信息
	 * @return
	 */
	public int insertRtmh(Map<String,Object> rtmhMap);
	
	/**
	 * 通过交易日期和交易流水查询账单表记录
	 * @param traneDate 交易日期
	 * @param serialNo 交易流水
	 * @return 查询到的交易流水记录
	 */
	public RTMHTradInfo queryRtmh(String traneDate,String serialNo);
	
	/**
	 * 根据交易日期和交易流水更新交易记录
	 * @param traneDate 交易日期
	 * @param serialNo 交易流水
	 * @param rtmhTran 要跟新的信息
	 * @return
	 */
	public int updateRtmh(String traneDate,String serialNo,Map<String,Object>rtmhTran);
	
}
