package cn.com.agree.huanan.ap.al.atmp.atm.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.atmp.atm.po.ATMPTranFlow;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

/**
 * atm特色P交易流水表Dao层
 * @author xuzhen
 *
 */
public interface AtmTranFlowDao {

	/**
	 * 登记特色p交易流水表
	 * @param atmpMap 
	 * @return
	 */
	public int insertTran(Map<String,Object>atmpMap);
	
	/**
	 * 通过交易日期和交易流水查询交易表记录
	 * @param traneDate 交易日期
	 * @param serialNo 交易流水
	 * @return 查询到的交易流水记录
	 */
	public ATMPTranFlow queryTran(String traneDate,String serialNo);
	
	/**
	 * 根据交易日期和交易流水更新交易记录
	 * @param traneDate 交易日期
	 * @param serialNo 交易流水
	 * @param atmpTran 要跟新的信息
	 * @return
	 */
	public int updateTran(String traneDate,String serialNo,Map<String,Object>atmpTran);

	/**
	 * @summary ATM本代本流水登记
	 * @param map
	 * @return
	 */
	public int registerATMTrans(Map<String, Object> map);

	/**
	 * @summary 查询ATM主机交易流水
	 * @param map
	 * @return
	 */
	public IPage<Map<String, Object>> selectATMSerialno(Map<String, Object> map);
	
}
