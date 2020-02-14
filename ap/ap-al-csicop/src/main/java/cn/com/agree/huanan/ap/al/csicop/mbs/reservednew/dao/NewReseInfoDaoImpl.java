package cn.com.agree.huanan.ap.al.csicop.mbs.reservednew.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;

/**
 * 微网点预约登记表dao层
 * 
 * @author xuzhen
 *
 */
@Component
public class NewReseInfoDaoImpl implements NewReseInfoDao {
	private static String TABLE = "CSIS_MBS_RESERVED_INFO_NEW";

	@Autowired
	private DbOperator dbo;

	@Override
	// 向预约登记表中插入数据
	public Integer insert(Map<String, Object> newReseInfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(newReseInfo).execute();
		return count;
	}

	// 概要信息查询
	@Override
	public List<Map<String, Object>> findInfoList(String operphone, String sttradedate, String edtradedate,
			String appnumber, String tobrno, String applytp, String operidno, String status, String lockedtellerno) {
		// 查询返回记录
		Selecter selecter = dbo.getSelecter();
		List<Map<String, Object>> reservedInfoList = selecter.select("tradedate as apptradedate",
				"tradetime as apptradetime", "serialno as appserialno", "applytp", "compname", "opername",
				"operphone as mobitl", "tobrno as openbr", "appnumber", "status as transt", "appvaldate", "appisval",
				"checkmark", "checkdate as upddate", "checktime as updtime").from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(applytp)) {
						w.eq("applytp", applytp);
					}
					if (!StringUtils.isEmpty(operidno)) {
						w.eq("operidno", operidno);
					}
					if (!StringUtils.isEmpty(operphone)) {
						w.eq("operphone", operphone);
					}
					if (!StringUtils.isEmpty(sttradedate)) {
						w.op("tradedate", ">=", sttradedate);
					}
					if (!StringUtils.isEmpty(edtradedate)) {
						w.op("tradedate", "<=", edtradedate);
					}
					if (!StringUtils.isEmpty(appnumber)) {
						w.eq("appnumber", appnumber);
					}
					if (!StringUtils.isEmpty(tobrno)) {
						w.eq("tobrno", tobrno);
					}
					if (!StringUtils.isEmpty(status)) {
						w.eq("status", status);
					}
					if (!StringUtils.isEmpty(lockedtellerno)) {
						w.eq("lockedtellerno", lockedtellerno);
					}
				}).orderBy("tradedate asc", "serialno asc").fetchAll();
		return reservedInfoList;
	}

	// 更新预约信息新表信息
	@Override
	public int updateReseInfo(String serialNo, String appNumber, String tradeDate, Map<String, Object> updateInfo) {
		int count = dbo.getUpdater().update(TABLE).set(updateInfo).where(w -> {
			if (!StringUtils.isEmpty(serialNo)) {
				w.eq("serialno", serialNo);
			}
			if (!StringUtils.isEmpty(serialNo) && !StringUtils.isEmpty(tradeDate)) {
				w.eq("appnumber", appNumber);
				w.eq("tradedate", tradeDate);
			}
		}).execute();
		return count;
	}

	@Override
	public String updateStatus(String appserialno, String appnumber, String apptradedate, String transt) {
		dbo.getUpdater().update(TABLE).set("transt", transt).where(w -> {
			if (!StringUtils.isEmpty(appserialno)) {
				w.eq("appnumber", appnumber);
				w.eq("apptradedate", apptradedate);
			}
		}).execute();
		return transt;
	}

	// 根据审批状态和当前日期查询记录
	@Override
	public List<Map<String, Object>> findApproveList(String status, String nowdate, String appnumber) {
		List<Map<String, Object>> apprList = dbo.getSelecter()
				.select("serialno", "tradedate", "applytp", "bussdata", "appnumber").from(TABLE).where(w -> {
					w.eq("appisval", "Y");
					if (!StringUtils.isEmpty(status) && !StringUtils.isEmpty(nowdate)) {
						w.eq("status", status);
						w.op("appvaldate", ">=", nowdate);
					}
					if (!StringUtils.isEmpty(appnumber)) {
						w.op("appnumber", ">", appnumber);
					}
				}).orderBy("tradedate asc", "appnumber asc").fetch(0, 1);
		return apprList;
	}

	// 查询预约详细信息
	@Override
	public Map<String, Object> findReseInfo(String serialno, String appnumber, String tradedate) {
		Map<String, Object> staAndAppNum = dbo.getSelecter()
				.select("status", "appnumber", "acctno", "operphone as trantl", "opername as tranna",
						"operidtype as tridtp", "operidno as tridno", "bussdata", "contentno", "modelno", "applytp",
						"operchkmsg", "custchkmsg", "fladchkmsg", "exclistret", "blackchkmsg")
				.from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(serialno)) {
						w.eq("serialno", serialno);
					}
					if (!StringUtils.isEmpty(tradedate) && !StringUtils.isEmpty(appnumber)) {
						w.eq("tradedate", tradedate);
						w.eq("appnumber", appnumber);
					}
				}).fetchOne();
		return staAndAppNum;
	}

	// 查询一条即将失效或已失效一天的记录
	@Override
	public List<Map<String, Object>> findNoteInform(String befExpiry, String aftExpiry, String appnumber) {
		List<Map<String, Object>> noteList = dbo.getSelecter().select("serialno", "tradedate", "appnumber", "applytp",
				"operphone", "appvaldate", "appisval", "lastdaysendst", "afterdaysendst").from(TABLE).where(w -> {
					w.in("appvaldate", befExpiry, aftExpiry);
					if (!StringUtils.isEmpty(appnumber)) {
						w.op("appnumber", ">", appnumber);
					}
				}).orderBy("tradedate asc", "appnumber asc").fetch(0, 1);
		return noteList;
	}

	/**
	 * 更新所有过期状态
	 * 
	 * @param nowDate
	 *            当前日期
	 * @return
	 */
	public int updApplyIsVal(String nowDate) {
		int count = dbo.getUpdater().update(TABLE).set("appisval", "N").where(w -> {
			w.op("appvaldate", "<", nowDate);
			w.eq("appisval", "Y");
		}).execute();
		return count;
	}
}
