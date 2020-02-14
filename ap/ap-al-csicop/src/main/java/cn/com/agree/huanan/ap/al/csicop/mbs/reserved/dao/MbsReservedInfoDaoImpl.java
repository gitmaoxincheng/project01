package cn.com.agree.huanan.ap.al.csicop.mbs.reserved.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.reserved.po.MbsReservedInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;

/**
 * 微网点预约登记表dao层
 * 
 * @author xuzhen
 *
 */
@Component
public class MbsReservedInfoDaoImpl implements MbsReservedInfoDao {
	private static String TABLE = "CSIS_MBS_RESERVED_INFO";

	@Autowired
	private OrmOperator ormOper;
	@Autowired
	private DbOperator dbo;

	@Override
	public Integer insert(Map<String, Object> mbsReservedInfo) {
		// 向预约登记表中插入数据
		int count = dbo.getInserter().insertInto(TABLE).values(mbsReservedInfo).execute();
		return count;
	}

	// 查询预约登记表记录
	@Override
	public MbsReservedInfo findMbsReservedInfo(String tradedate, String serialno, String appnumber) {
		OrmSelecter<MbsReservedInfo> ormSelecter = ormOper.getOrmSelecter(MbsReservedInfo.class);
		MbsReservedInfo mbsReservedInfo = ormSelecter.where(w -> {
			if (!StringUtils.isEmpty(serialno)) {
				w.setSerialno(serialno);
			}
			// 日期和流水号均不能为空
			if (!StringUtils.isEmpty(tradedate) && !StringUtils.isEmpty(appnumber)) {
				w.setTradedate(tradedate);
				w.setAppnumber(appnumber);
			}
		}).fetchOne();
		return mbsReservedInfo;
	}

	// 登记表查询
	@Override
	public List<Map<String, Object>> findInfoList(String operphone, String sttradedate, String edtradedate,
			String appnumber, String tobrno, String operidno, String status, String lockedtellerno) {
		// 查询返回记录
		Selecter selecter = dbo.getSelecter();
		List<Map<String, Object>> reservedInfoList = selecter.select("tradedate as apptradedate",
				"tradetime as apptradetime", "serialno as appserialno", "compname", "opername", "operphone as mobitl",
				"tobrno as openbr", "appnumber", "status as transt", "appvaldate", "appisval", "checkmark",
				"checkdate as upddate", "checktime as updtime", "applytp").from(TABLE).where(w -> {
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

	// 更新预约信息表信息
	@Override
	public int updateReservedInfo(String serialNo, String tradeDate, Map<String, Object> updateInfo) {
		int count = dbo.getUpdater().update(TABLE).set(updateInfo).where(w -> {
			if (!StringUtils.isEmpty(serialNo) && !StringUtils.isEmpty(tradeDate)) {
				w.eq("serialno", serialNo);
				w.eq("tradedate", tradeDate);
			}
		}).execute();
		return count;
	}

	// 查询一条待审批记录
	@Override
	public List<Map<String, Object>> findCheckInfo(String status, String nowDate, String st_serialno) {
		List<Map<String, Object>> fetch = dbo.getSelecter().select("serialno", "tradedate", "tradetime", "opermantype",
				"operphone", "status", "checktellerno", "checkdate", "checktime", "checkmark", "acctype", "tocity",
				"tobrno", "usccode", "compname", "comptelephone", "compofficeaddrtype", "compofficeaddr", "compaddr",
				"accusagetype", "accusage", "corpname", "corpidtype", "corpidno", "corpidvaldate", "corptelephone",
				"finaname", "finaidtype", "finaidno", "finaidvaldate", "finatelephone", "opername", "operidtype",
				"operidno", "operidvaldate", "authvaldate", "taxtype", "taxinfo", "issbm", "isncb", "isict", "isubc",
				"isebd", "istaxsb", "isonecert", "busiimg", "organimg", "taximg", "corpidfrimg", "corpidbkimg",
				"operidfrimg", "operidbkimg", "busino", "appnumber", "appvaldate", "appisval", "contname", "contidtype",
				"contidno", "contidvaldate", "contsuperior", "contseal", "trusteesealname", "trusteeidno", "sealacctno",
				"sealcardno", "ncbmantype", "ncbname", "ncbidtype", "ncbidno", "ncbtelephone", "ncbcode",
				"ncbusbkeynum", "ncbonelim", "ncbdaylim", "ictphoneno1", "ictphoneno2", "ictphoneno3", "ictphoneno4",
				"ictphoneno5", "ubcname", "ubcidtype", "ubcidno", "ubcidvaldate", "ubctelephone", "upddate", "updtime",
				"orgcode", "autochkstep").from(TABLE).where(w -> {
					w.eq("status", status);
					w.op("appvaldate", ">", nowDate);
					if (!StringUtils.isEmpty(st_serialno)) {
						w.op("serialno", ">", st_serialno);
					}
				}).orderBy("tradedate", "serialno").fetch(0, 1);
		return fetch;
	}
	
	/**
	 * 查询所有待发送集中作业的记录
	 */
	@Override
	public List<MbsReservedInfo>findchkInfoList(){
		OrmSelecter<MbsReservedInfo> ormSelecter = ormOper.getOrmSelecter(MbsReservedInfo.class);
		List<MbsReservedInfo> reseInfoList = ormSelecter.where(w -> {
				w.setStatus("1");
				w.setAppisval("Y");
				w.setSendtype("2");
		}).fetchAll();
		return reseInfoList;
	}
	
	@Override
	public int queryTellerCheck(String startDate,String tradedate,String tellerNo) {
		return (int) dbo.getSelecter().from(TABLE).where(w->{
			w.op("tradedate", ">=", startDate);  
			w.eq("appisval", "Y");
			w.op("tradedate||tradetime", "<=", tradedate+"160000");
			w.eq("status", "1");
			if(!StringUtils.isEmpty(tellerNo)) {
				w.eq("lockedtellerno", tellerNo);
			}
		}).count(); 
	}
}
