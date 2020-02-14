package cn.com.agree.huanan.ap.rl.bank.trade.dao;

import java.util.List;
import java.util.Map;

/**
 * @author GYL
 */
public interface TableDao {
	/**
	 * 查询主表信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @param mainTable
	 *            主表名
	 * @return
	 */
	Map<String, Object> findMainTable(String serialno, String tradedate, String mainTable);

	/**
	 * 查询子表信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @param subTable
	 *            子表名
	 * @return
	 */
	List<Map<String, Object>> findSubTable(String serialno, String tradedate, String subTable);

	/**
	 * 更新主表信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @param mainTable
	 *            主表名
	 * @param info
	 *            修改信息
	 * @return
	 */
	int updateMainTable(String serialno, String tradedate, String mainTable, Map<String, Object> info);

	/**
	 * 更新子表信息
	 * 
	 * @param serialno
	 *            流水号
	 * @param tradedate
	 *            交易日期
	 * @param subTable
	 *            子表名
	 * @param info
	 *            修改信息
	 * @return
	 */
	int updateSubTable(String serialno, String tradedate, String subTable, Map<String, Object> info);

	int updateTable(String tableName, String serialno, String tradedate, String status, String errorCode,
			String errorMsg);

	Map<String, Object> selectColumns(String tableName, String[] columns, String[] whereCols, String[] values);
}
