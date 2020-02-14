package cn.com.agree.huanan.ap.rl.bank.trade.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * @author huangchaopeng
 *
 */
@Component
public class TableDaoImpl implements TableDao {
	@Autowired
	private DbOperator dbOperator;

	/** 查询主表信息 */
	@Override
	public Map<String, Object> findMainTable(String serialno, String tradedate, String mainTable) {
		return dbOperator.getSelecter().select("RESPSTS", // 交易状态
				"ERRORCODE", // 错误码
				"ERRORMSG", // 错误信息
				"BACKSCENECODE"// 交易码
		).from(mainTable).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).fetchOne();
	}

	/** 查询子表信息 */
	@Override
	public List<Map<String, Object>> findSubTable(String serialno, String tradedate, String subTable) {
		return dbOperator.getSelecter().select("RESPSTS", // 交易状态
				"BACKSCENECODE"// 交易码
		).from(subTable).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).fetchAll();
	}

	/** 更新主表信息 */
	@Override
	public int updateMainTable(String serialno, String tradedate, String mainTable, Map<String, Object> info) {
		return 0;
	}

	/** 更新子表信息 */
	@Override
	public int updateSubTable(String serialno, String tradedate, String subTable, Map<String, Object> info) {
		return 0;
	}

	@Override
	public int updateTable(String tableName, String serialno, String tradedate, String status, String errorCode,
			String errorMsg) {
		return dbOperator.getUpdater().update(tableName).set("status", status).set("errorcode", errorCode)
				.set("errormsg", errorMsg).where(w -> {
					w.eq("serialno", serialno);
					w.eq("tradedate", tradedate);
				}).execute();
	}

	@Override
	public Map<String, Object> selectColumns(String tableName, String[] columns, String[] whereCols, String[] values) {
		return dbOperator.getSelecter().from(tableName).select(columns).where(w -> {
			for (int i = 0; i < whereCols.length; i++) {
				w.eq(whereCols[i], values[i]);
			}
		}).fetchOne();
	}
}
