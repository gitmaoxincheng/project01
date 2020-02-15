package cn.com.agree.huanan.ap.al.atmp.atm.dao;

import java.util.Map;


import cn.com.agree.huanan.ap.al.atmp.atm.po.ATMPBussFlow;

/**
 * atm特色P业务流水表Dao层
 * @author huangys
 *
 */
public interface AtmBussFlowDao {
	/**
	 * 登记特色p交易业务流水表
	 * @param atmpMap 
	 * @return qqqqqq
	 */
	public int insertBuss(Map<String,Object>atmpMap);
	
	/**
	 * 通过交易日期和交易流水查询业务交易表记录
	 * @param serialNo 交易流水
	 * @return 查询到的交易流水记录
	 */
	public ATMPBussFlow queryBuss(String serialNo);

	/**
	 * 根据交易日期和交易流水更新交易记录
	 * @param traneDate 交易日期
	 * @param serialNo 交易流水
	 * @param atmpBuss 要跟新的信息
	 * @return
	 */
	public int updateBuss(String serialNo,Map<String,Object>atmpBuss);
	
	/**
	 * 根据流水号删除一条记录
	 * @param reqserialno
	 * @return
	 */
	public int deleteBuss(String reqserialno);

	/**
	 * 根据流水号查询该交易的客户账号
	 * @param serialNo
	 * @return
	 */
	public ATMPBussFlow queryBySerinal(String channelserno );
}
