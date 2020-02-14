package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.List;
import java.util.Map;

/**
 * 超时交易配置表Dao层
 * 
 * @author guyulong
 */
public interface TimeoutCfgDao {
	/**
	 * 查询接口目标信息
	 * 
	 * @param trancode
	 *            交易码（服务码+场景号）
	 * @return
	 */
	Map<String, Object> findCodeInfo(String trancode);

	/**
	 * 查询超时交易表
	 * 
	 * @param pageflag
	 *            页码
	 * @param maxnum
	 *            每页最大查询数
	 * @param begdate
	 *            起始日期
	 * @param endate
	 *            终止日期
	 * @param map
	 * @return
	 */
	Map<String, Object> queryTimeOut(String pageflag, String maxnum, String begdate, String endate,
			Map<String, Object> map);

	/**
	 * 查询超时交易配置表
	 * @param svccode 内部服务码
	 * @param scncode 内部场景码
	 * @return
	 */
	Map<String, Object> queryTrantype(String svccode,String scncode);

	/**
	 * 查询交易登记表
	 * @param tradeDate	交易日期
	 * @param serialNo	交易流水
	 * @return
	 */
	Map<String, Object> TimeoutRegister(String tradeDate, String serialNo);

	/**
	 * 更新交易对应登记簿
	 * @param tradeDate		交易日期
	 * @param serialNo		交易流水
	 * @param tableName		交易对应登记簿
	 * @param paramMap		
	 * @return
	 */
	long updateTradeTable(String tradeDate, String serialNo, String tableName,
			Map<String, Object> paramMap);

	/**
	 * 查询子表返回所有该流水号的全部子交易
	 * @param serialNo
	 */
	List<Map<String,Object>> querySignSub(String serialNo);

	/**
	 * 查询交易映射表
	 * @param servecodeOut	外部服务码
	 * @param scenecodeOut	外部场景码
	 */
	Map<String,Object> queryTranmapp(String servecodeOut, String scenecodeOut);

	/**
	 * 查询交易渠道编码和交易状态
	 * @param tradeDate	交易日期
	 * @param serialNo	交易流水
	 * @param mainTable	交易所登记的表
	 * @return
	 */
	Map<String,Object> queryTableCalcod(String tradeDate, String serialNo, String mainTable);

}
