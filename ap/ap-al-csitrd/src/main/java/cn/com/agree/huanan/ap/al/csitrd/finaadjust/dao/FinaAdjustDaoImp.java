package cn.com.agree.huanan.ap.al.csitrd.finaadjust.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cn.com.agree.afa.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.finaadjust.po.FinaAdjust;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * @author JZF
 *	资金调剂Dao
 */
@Component
public class FinaAdjustDaoImp implements FinaAdjustDao {

	public final Logger logger = Logger.getLogger(FinaAdjustDaoImp.class);

	@Autowired
	DbOperator dbOperator;
	@Autowired 
	OrmOperator  ormOper;

	private String ADJUST_TABLE = "TRADEINFO_ADJUST_DETAIL";
	private String DEVCLR_TABLE = "TRADEINFO_DEVCLR_DETAIL";

	/**
	 * 增方法实现
	 */
	@Override
	public int addAdjust(FinaAdjust fa) {
		if (StringUtils.isNullOrEmpty(fa.getTradedate())) {
			throw new ApIllegalParamException("tradeDate");
		}
		if (StringUtils.isNullOrEmpty(fa.getSerialno())) {
			throw new ApIllegalParamException("serialNo");
		}

		int count = dbOperator.getInserter().insertInto(ADJUST_TABLE).values(FinaAdjust.getMap(fa)).execute();
		return count;
	}

	/**
	 * 改方法实现
	 */
	@Override
	public int editAdjust(FinaAdjust fa) {

		if (StringUtils.isNullOrEmpty(fa.getTradedate())) {
			throw new ApIllegalParamException("tradeDate");
		}
		if (StringUtils.isNullOrEmpty(fa.getSerialno())) {
			throw new ApIllegalParamException("serialNo");
		}
		int count = dbOperator.getUpdater().update(ADJUST_TABLE).where((w) -> {
			w.eq("tradedate", fa.getTradedate());
			w.eq("serialNo", fa.getSerialno());
		}).set(FinaAdjust.getMap(fa)).execute();
		return count;
	}

	@Override
	public int updateAdjustStatus(String serialNo,String tradeDate,String status) {
		int count = dbOperator.getUpdater().update(ADJUST_TABLE).where((w) -> {
			w.eq("tradedate", tradeDate);
			w.eq("serialNo", serialNo);
		}).set("status",status).execute();
		return count;
	}

	/**
	 * 查方法实现
	 */
	@Override
	public Map<String, Object> getAdjust(FinaAdjust fa, Integer pageflag, Integer maxnum, String startDate, String endDate) {

		// 结果集Map
		Map<String, Object> result = new HashMap<>();

		// 总数查询
		Long total = dbOperator.getSelecter().select("tradedate", "serialNo").from(ADJUST_TABLE).where((w) -> {

			if (!StringUtils.isNullOrEmpty(fa.getAdjtype())) {
				w.eq("adjtype", fa.getAdjtype());
			}
			if (!StringUtils.isNullOrEmpty(fa.getStatus())) {
				w.eq("status", fa.getStatus());
			}
			if (!StringUtils.isNullOrEmpty(fa.getDevtellerno())) {
				w.eq("devtellerno", fa.getDevtellerno());
			}
			if (!StringUtils.isNullOrEmpty(fa.getSerialno())) {
				w.eq("serialno", fa.getSerialno());
			}
			if (!StringUtils.isNullOrEmpty(startDate)) {
				w.op("TRADEDATE", ">=" ,startDate);
			}
			if (!StringUtils.isNullOrEmpty(endDate)) {
				w.op("TRADEDATE", "<=" ,startDate);
			}

		}).count();

		//表的字段较多
		List<Map<String, Object>> datas = dbOperator.getSelecter()
				.select("adj.tradedate as tradedate", "adj.serialno as serialno", "adj.tradetime as tradetime", "adj.branchno as branchno", "adjtype",
						"status", "realtellerno", "realcshbox", "devtellerno", "devcshbox",
						"adj.txccy as txccy", "amount", "summary", "oritradedate", "oriserialno",
						"sndtellerno", "sndauthtellerno", "rcvtellerno", "rcvauthtellerno", "cleantime", "lastcleantime", "rboxamt",
						"tboxamt", "otheramt", "matramt", "hostamt1", "addamt", "adjamt",
						"hostamt2", "remark", "diffflag", "diffamt", "diffreason",
						"diffsummary", "diffnum", "writeacctno")
				.from(ADJUST_TABLE + " adj").join(JoinType.LeftJoin, DEVCLR_TABLE + " dev", (w) -> {
					w.op("adj.tradedate", "=", SqlUtil.getSqlExp("dev.tradedate"));
					w.op("adj.serialno", "=", SqlUtil.getSqlExp("dev.serialno"));
				}).where((w) -> {

					if (!StringUtils.isNullOrEmpty(fa.getAdjtype())) {
						w.eq("adj.adjtype", fa.getAdjtype());
					}
					if (!StringUtils.isNullOrEmpty(fa.getStatus())) {
						w.eq("adj.status", fa.getStatus());
					}
					if (!StringUtils.isNullOrEmpty(fa.getDevtellerno())) {
						w.eq("adj.devtellerno", fa.getDevtellerno());
					}
					if (!StringUtils.isNullOrEmpty(fa.getSerialno())) {
						w.eq("adj.serialno", fa.getSerialno());
					}
					if (!StringUtils.isNullOrEmpty(startDate)) {
						w.op("adj.tradedate", ">=" ,startDate);
					}
					if (!StringUtils.isNullOrEmpty(endDate)) {
						w.op("adj.tradedate", "<=" ,startDate);
					}
				}).orderBy("adj.tradedate").fetch((pageflag - 1) * maxnum, maxnum);

		result.put("total", total);
		result.put("listnm", datas.size());
		result.put("datas", datas);
		return result;
	}

	/**
	 * 查找唯一的资金调剂交易
	 */
	@Override
	public FinaAdjust getBySerialAndTrade(String serialno, String tradeDate) {
		if (StringUtils.isNullOrEmpty(serialno)) {
			throw new ApIllegalParamException("交易流水不可为空");
		}
		if (StringUtils.isNullOrEmpty(tradeDate)) {
			throw new ApIllegalParamException("交易日期不可为空");
		}
		List<FinaAdjust> FinaAdjusts = ormOper.getOrmSelecter(FinaAdjust.class).where((w)->{
			w.setSerialno(serialno);
			w.setTradedate(tradeDate);
		}).fetchAll();
		if (FinaAdjusts.size() > 0) {
			return FinaAdjusts.get(0);
		}else {
			return null;
		}

	}

	@Override
	public Map<String, Object> getAdjustDev(FinaAdjust fa, Integer pageflag, Integer maxnum, String startDate,
			String endDate) {
		//自助设备查询不同

		// 结果集Map
		Map<String, Object> result = new HashMap<>();

		//查询条件
		String adjtype = fa.getAdjtype();
		Consumer<WhereExp> type = (w)->{

			//查询范围确定
			if (StringUtils.isNullOrEmpty(adjtype)) {	//查询全部
				w.op("ADJTYPE", "!=", SqlUtil.getSqlExp("0"));
				w.op("ORISERIALNO", "is not", SqlUtil.getSqlExp("null"));
			}else if (adjtype.equals("0") || adjtype.equals("1")) {
				w.op("ORISERIALNO", "is", SqlUtil.getSqlExp("null"));
			}else{
				w.op("ADJTYPE", "=", SqlUtil.getSqlExp("1"));
				w.op("ORISERIALNO", "is not", SqlUtil.getSqlExp("null"));
			}

			if (!StringUtils.isNullOrEmpty(fa.getAdjtype())) {
				w.eq("adjtype", fa.getAdjtype());
			}
			if (!StringUtils.isNullOrEmpty(fa.getStatus())) {
				w.eq("status", fa.getStatus());
			}
			if (!StringUtils.isNullOrEmpty(fa.getDevtellerno())) {
				w.eq("devtellerno", fa.getDevtellerno());
			}
			if (!StringUtils.isNullOrEmpty(fa.getSerialno())) {
				w.eq("serialno", fa.getSerialno());
			}
			if (!StringUtils.isNullOrEmpty(startDate)) {
				w.op("TRADEDATE", ">=" ,startDate);
			}
			if (!StringUtils.isNullOrEmpty(endDate)) {
				w.op("TRADEDATE", "<=" ,startDate);
			}
		};

		// 总数查询
		Long total = dbOperator.getSelecter().select("tradedate", "serialNo").from(ADJUST_TABLE).where(type).count();

		//表的字段较多
		List<Map<String, Object>> datas = dbOperator.getSelecter()
				.select("adj.tradedate as tradedate", "adj.serialno as serialno", "adj.tradetime as tradetime", "adj.branchno as branchno", "adjtype",
						"status", "realtellerno", "realcshbox", "devtellerno", "devcshbox",
						"adj.txccy as txccy", "amount", "summary", "oritradedate", "oriserialno",
						"sndtellerno", "sndauthtellerno", "rcvtellerno", "rcvauthtellerno", "cleantime", "lastcleantime", "rboxamt",
						"tboxamt", "otheramt", "matramt", "hostamt1", "addamt", "adjamt",
						"hostamt2", "remark", "diffflag", "diffamt", "diffreason",
						"diffsummary", "diffnum", "writeacctno")
				.from(ADJUST_TABLE + " adj").join(JoinType.LeftJoin, DEVCLR_TABLE + " dev", (w) -> {
					w.op("adj.tradedate", "=", SqlUtil.getSqlExp("dev.tradedate"));
					w.op("adj.serialno", "=", SqlUtil.getSqlExp("dev.serialno"));
				}).where(type).orderBy("adj.tradedate").fetch((pageflag - 1) * maxnum, maxnum);

		result.put("rowcnt", total);
		result.put("listnm", datas.size());
		result.put("detail_list", datas);
		return result;

	}

}
