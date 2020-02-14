package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.po.Chlclrdtl;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ChlclrdtlDaoImpl implements ChlclrdtlDao {
	private static String TABLE = "TRADEINFO_DEVCLR_DETAIL";
	public final Logger logger = Logger.getLogger(ChlclrdtlDaoImpl.class);
	@Autowired
	OrmOperator ormOper;
	@Autowired
	DbOperator dbo;

	@Override
	public long checkChannelclrdtlInfo(String cleandate, String devno, String atmtellerno) {
		logger.info("-----开始在清机维护明细数据中查询清机日期和ATM设备号-----");
		if (StringUtils.isEmpty(cleandate)) {
			throw new CheckNotDataException("请输入清机日期");
		}
		if (StringUtils.isEmpty(devno)) {
			throw new CheckNotDataException("请输入ATM设备号");
		}
		if (StringUtils.isEmpty(atmtellerno)) {
			throw new CheckNotDataException("请输入ATM柜员号");
		}
		long count = dbo.getSelecter().from(TABLE).select("cleandate", "devno", "atmtellerno").where(w -> {
			w.eq("cleandate", cleandate);
			w.eq("devno", devno);
			w.eq("atmtellerno", atmtellerno);
		}).count();

		return count;
	}

	@Override
	public Map<String, Object> selectChannelclrdtlInfo(String pageflag, String maxnum, String begcleandate,
			String endcleandate, String atmtellerno, String devno) {
		logger.info("清机维护明细数据查询sql语句开始");

		// 查询总记录数
		long rowcnt = dbo.getSelecter().from(TABLE).where(w -> {
			// 查询条件
			w.op("cleandate", ">=", begcleandate);
			w.op("cleandate", "<=", endcleandate);
			if (!StringUtils.isEmpty(atmtellerno) && !"".equals(atmtellerno)) {
				w.eq("atmtellerno", atmtellerno);
			}
			if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
				w.eq("devno", devno);
			}
		}).count();
		// 按页码查询
		int startPage = Integer.parseInt(pageflag);
		int pageSize = Integer.parseInt(maxnum);
		// 查询返回记录
		Selecter selecter = dbo.getSelecter();
		List<Map<String, Object>> mapList = selecter
				.select("atmtellerno", "devno", "cleandate", "cleandate||' '||cleantime as cleantime", "status",
						"lastcleantime", "dpstamt", "drawamt", "rboxamt", "tboxamt", "chnlamt", "otheramt", "hostamt1",
						"matramt", "addamt", "adjamt", "hostamt2", "moreamt", "lessamt", "remark")
				.from(TABLE).where(w -> {

					w.op("cleandate", ">=", begcleandate);
					w.op("cleandate", "<=", endcleandate);
					if (!StringUtils.isEmpty(atmtellerno) && !"".equals(atmtellerno)) {
						w.eq("atmtellerno", atmtellerno);
					}
					if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
						w.eq("devno", devno);
					}
				}).fetch((startPage - 1) * pageSize, pageSize);
		// 返回记录数
		int listnm = mapList.size();

		Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", rowcnt);
		result.put("bodrcd_list", mapList);
		result.put("listnm", listnm);
		logger.info("清机维护明细数据查询sql语句结束");
		return result;

	}

	@Override
	public int deleteChannelclrdtlInfo(String atmtellerno, String devno, String cleandate) {
		logger.info("清机维护明细数据删除sql语句执行开始");

		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {

			w.eq("atmtellerno", atmtellerno);

			w.eq("devno", devno);

			w.eq("cleandate", cleandate);

		}).execute();
		logger.info("清机维护明细数据删除sql语句执行结束");
		return count;
	}

	/**
	 * 修改清机维护明细数据
	 * 
	 * @param map
	 *            代修改的清机条目
	 * @return 修改条目
	 */
	@Override
	public int updateChlclrdtl(Chlclrdtl ccl) {

		// 检验参数
		if (ccl.getSerialno() == null || StringUtils.isEmpty(ccl.getSerialno())) {
			throw new CheckNotDataException("清机流水为空");
		}
		if (ccl.getTradedate() == null || StringUtils.isEmpty(ccl.getTradedate())) {
			throw new CheckNotDataException("清机日期为空");
		}
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("serialno", ccl.getSerialno());
			w.eq("tradedate", ccl.getTradedate());
		}).set(Chlclrdtl.getMap(ccl)).execute();

		return count;
	}

	public int updateChlclrdtl(Map<String, Object> map,String oldCleanTime) {

		// 检验参数
		if (map == null || StringUtils.isEmpty(map.get("devno"))) {
			throw new CheckNotDataException("updateMap's parms error...");
		}

		if (map == null || StringUtils.isEmpty(oldCleanTime)) {
			throw new CheckNotDataException("oldCleanTime parms error...");
		}

		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("devno", map.get("devno"));
			w.eq("cleandate", oldCleanTime );
		}).set(map).execute();

		return count;
	}


	@Override
	public int insertChlClrdtl(Chlclrdtl chlclrdtl) {
		// 检验参数
		int count = dbo.getInserter().insertInto(TABLE).values(Chlclrdtl.getMap(chlclrdtl)).execute();
		if (count == 1) {
			logger.info("清机维护明细新增结束");
		} else {
			dbo.rollback();
			logger.info("清机维护明细新增失败...事务回滚");
		}
		return count;
	}

	@Override
	public Map<String, Object> getLastCleanTimeAndDevno(String atmtellerno) {
		logger.info("查询上次清机时间开始");
		Map<String, Object> map = dbo.getSelecter().select("atmtellerno", "devno", "lastcleantime").from(TABLE)
				.where(w -> {
					if (!StringUtils.isEmpty(atmtellerno)) {
						w.eq("atmtellerno", atmtellerno);
					}
				}).fetchOne();
		logger.info("查询上次清机时间结束");
		return map;
	}
}