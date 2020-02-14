package cn.com.agree.huanan.ap.al.csicop.mbs.zcd.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.zcd.po.ZcdReservedInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 政采贷预约信息表dao层实现层
 * 
 * @author guyulong
 */
@Component
public class ZcdReservedInfoDaoImpl implements ZcdReservedInfoDao {
	private static String TABLE = "CSIS_ZCD_RESERVED_INFO";

	@Autowired
	private OrmOperator ormOper;
	@Autowired
	private DbOperator dbo;

	/** 向政财贷预约信息表中插入预约信息 */
	@Override
	public int insertInfo(Map<String, Object> zcdReservedInfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(zcdReservedInfo).execute();
		return count;
	}

	/** 政采贷申请概要信息查询 */
	@Override
	public List<Map<String, Object>> findOutlineInfos(String busiNo, String status, String staDate, String endDate,
			String pageSize, String pageNumb, String linkPhone) {
		Integer pagesize = Integer.parseInt(pageSize);
		Integer pagenumb = Integer.parseInt(pageNumb);
		List<Map<String, Object>> outlineInfos = dbo.getSelecter()
				.select("busino", "finaname", "linkphone as mobitl", "finamoney", "tradetime as tranti",
						"tradedate as systdt", "serialno as transq", "status as transt", "succitem as succitem")
				.from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(busiNo)) {
						w.eq("busino", busiNo);
					}
					if (!StringUtils.isEmpty(status)) {
						w.eq("status", status);
					}
					if (!StringUtils.isEmpty(staDate) || !StringUtils.isEmpty(endDate)) {
						w.op("tradedate", ">=", staDate);
						w.op("tradedate", "<=", endDate);
					}
					w.eq("linkPhone", linkPhone);
				}).orderBy("serialno desc", "tradedate desc").fetch((pagenumb - 1) * pagesize, pagesize);
		return outlineInfos;
	}

	/** 查询总记录数 */
	@Override
	public int findOutlineInfoAll(String busiNo, String status, String staDate, String endDate, String linkPhone) {
		long count = dbo.getSelecter().from(TABLE).where(w -> {
			if (!StringUtils.isEmpty(busiNo)) {
				w.eq("busino", busiNo);
			}
			if (!StringUtils.isEmpty(status)) {
				w.eq("status", status);
			}
			if (!StringUtils.isEmpty(staDate) || !StringUtils.isEmpty(endDate)) {
				w.op("tradedate", ">=", staDate);
				w.op("tradedate", "<=", endDate);
			}
			w.eq("linkPhone", linkPhone);
		}).count();
		return (int) count;
	}

	/** 政采贷申请明细信息查询 */
	@Override
	public ZcdReservedInfo findDetailedInfo(String serialno, String tradedate) {
		// 查询
		return ormOper.getOrmSelecter(ZcdReservedInfo.class).where(w -> {
			w.setTradedate(tradedate);
			w.setSerialno(serialno);
		}).fetchOne();
	}

	/** 更改政采贷审核申请信息 */
	@Override
	public int updateInfo(String tradeDate, String serialNo, Map<String, Object> updateInfo) {
		int count = dbo.getUpdater().update(TABLE).set(updateInfo).where(w -> {
			if (!StringUtils.isEmpty(serialNo) && !StringUtils.isEmpty(tradeDate)) {
				w.eq("serialno", serialNo);
				w.eq("tradedate", tradeDate);
			}
		}).execute();
		return count;
	}

	/** MNTW0020 政采贷数据同步 对应的 MBS021 政采贷待办事宜查询 */
	@Override
	public List<Map<String, Object>> findWaitHandleInfos(String serialNo, String tradeDate, String pageSize) {
		Integer pagesize = Integer.parseInt(pageSize);
		List<Map<String, Object>> waitHandleInfos = dbo.getSelecter()
				.select("serialno as transq", "tradedate as systdt", "tradetime as tranti", "status as transt",
						"busino", "compname", "finaname", "linkphone as mobitl", "succitem", "succmoney", "finamoney",
						"checktellerno", "checkdate", "checktime", "checkmark", "upddate", "updtime", "result")
				.from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(serialNo)) {
						w.op("serialno", ">", serialNo);
					}
					if (!StringUtils.isEmpty(tradeDate)) {
						w.op("tradedate", ">=", tradeDate);
					}
					w.eq("status", "0");
				}).orderBy("tradedate asc", "serialno asc").fetch(0, pagesize);
		return waitHandleInfos;
	}

	/** 政采贷待办事宜查询总数 */
	@Override
	public int findWaitHandleInfoAll(String serialNo, String tradeDate) {
		long count = dbo.getSelecter().from(TABLE).where(w -> {
			if (!StringUtils.isEmpty(serialNo)) {
				w.op("serialno", ">", serialNo);
			}
			if (!StringUtils.isEmpty(tradeDate)) {
				w.op("tradedate", ">=", tradeDate);
			}
			w.eq("status", "0");
		}).count();
		return (int) count;
	}

	/** 查询政采贷审核数据是否存在 */
	@Override
	public int findInfo(String serialNo, String tradeDate) {
		long count = dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("serialno", serialNo);
			w.eq("tradedate", tradeDate);
		}).count();
		return (int) count;
	}

	/** 查询手机号 */
	@Override
	public Map<String, Object> findPhoneNumber(String serialno, String tradedate) {
		return dbo.getSelecter().select("linkphone").from(TABLE).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).fetchOne();
	}
}
