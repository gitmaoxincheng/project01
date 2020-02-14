package cn.com.agree.huanan.ap.al.csitrd.voch.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
@Component
public class CheckManageDaoImpl implements CheckManageDao {
	private static String TABLE = "TRADEINFO_CHEQUE_DETAIL";
	private static String TABLE2 = "TRADEINFO_CERT_MAIN tc";
	private static String TABLE3 = "TRADEINFO_AUTHCHECK_MAIN ta";
	@Autowired DbOperator dbOperator;
	
	public final Logger logger = Logger.getLogger(CheckManageDaoImpl.class);
	@Override
	public Map<String, Object> checkReceQuery(String tradedate, String devno,String brno) {
		logger.info("支票受理查询查询sql语句开始");
		Map<String,Object> result=new HashMap<String,Object>();
		// 查询返回记录数
		Map<String, Object> tuoshoucnt = dbOperator.getSelecter().select("count(*) as billpayeecnt0","count(case when STATUS = '00' or STATUS ='03'then 'billpayeecnt5' end) as billpayeecnt5"
				,"count(case when STATUS='01' then 'billpayeecnt1' end) as billpayeecnt1","count(case when STATUS ='02' then 'billpayeecnt2' end) as billpayeecnt2"
				,"count(case when STATUS ='04' then 'billpayeecnt3' end) as billpayeecnt3","count(case when STATUS ='05' then 'billpayeecnt4' end) as billpayeecnt4").from(TABLE).where(w -> {
			// 查询条件
			if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
				w.eq("devno", devno);
			}
			w.eq("tradedate", tradedate);
			w.eq("brno", brno);
			w.eq("TRANTYPE", "0");
		}).fetchOne();
		// 查询返回记录数
		Map<String, Object> trancnt = dbOperator.getSelecter().select("count(*) as billpayercnt0","count(case when STATUS = '00' then 'billpayercnt4' end) as billpayercnt4"
				,"count(case when STATUS='01' then 'billpayercnt1' end) as billpayercnt1","count(case when STATUS ='04' then 'billpayercnt2' end) as billpayercnt2"
				,"count(case when STATUS ='05' then 'billpayercnt3' end) as billpayercnt3").from(TABLE).where(w -> {
			// 查询条件
			if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
				w.eq("devno", devno);
			}
			w.eq("tradedate", tradedate);
			w.eq("brno", brno);
			w.in("TRANTYPE", "1","2");
		}).fetchOne();
		// 查询返回记录数
		Map<String, Object> soldlist = dbOperator.getSelecter().select("count(*) as billsalecnt0","count(case when RESPSTS = 's' then 'billsaleinfocnt1' end) as billsaleinfocnt1"
				,"count(case when RESPSTS !='s' then 'billsaleinfocnt2' end) as billsaleinfocnt2").from(TABLE2).where(w -> {
			// 查询条件
			if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
				w.eq("devno", devno);
			}
			w.eq("tradedate", tradedate);
			w.eq("brno", brno);
		}).fetchOne();
		result.put("billpayeeinfo_list",tuoshoucnt);
		result.put("billpayerinfo_list",trancnt);
		result.put("billsaleinfo_list",soldlist);
		logger.info("支票受理查询查询sql语句结束");
		return result;
	}

	@Override
	public Map<String, Object> checkDetailQuery(Integer pageflag, Integer maxnum, String startdate, String enddate, String busitype,
			String devno, String status,String brno) {
		Map<String,Object> result=new HashMap<String,Object>();
		logger.info("支票转账托收明细查询sql语句开始");
		// 查询总记录数
		long rowcnt = dbOperator.getSelecter().from(TABLE).where(w -> {
			// 查询条件
			if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
				w.eq("DEVNO", devno);
			}
			w.between("tradedate", startdate,enddate);
			if (status.equals("03")) {
				w.in("status", "00",status);
			}else
				w.eq("status", status);
			w.eq("brno", brno);
			w.eq("TRANTYPE", busitype);
		}).count();
		logger.info("支票转账托收明细查询sql语句zhong");
		// 查询返回记录
		Selecter selecter = dbOperator.getSelecter();
		List<Map<String, Object>> mapList = selecter.select("tradedate","serialno","brno as strbrno","trantype","txccy","amount","payerbranch","payeebranch","payeracctbranch",
				"payeracctno","payername","payeeacctbranch","payeeacctno","payeename","remarks",
				"billtype","billno","billdate","svdptg","priority","chrgfg","chargeamount","chargeacctno","reqpostscript",
				"smrycd","dscrtx","paydt","purp","nbofendrsr","nm","status","contentid","frontfileid","backfileid","YY_GUID as yyguid",
				"templet","txttype","devno","taskid","mobile","printtype","tradetype","issmallcode","printt","autoprintresult",
				"printtlrno1","printtlrno2","inputtlrno1","inputtlrno2","inputtlrno3","authtlrno1","authtlrno2","authresult","authbackmsg")
				.from(TABLE).where(w -> {
			if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
				w.eq("DEVNO", devno);
			}
			w.between("tradedate", startdate,enddate);
			w.eq("TRANTYPE", busitype);
			if (status.equals("03")) {
				w.in("status", "00",status);
			}else
				w.eq("status", status);
			w.eq("brno", brno);
		}).fetch((pageflag-1)*maxnum, maxnum);
		result.put("detail_list", mapList);
		result.put("rowcnt", rowcnt);
		// 返回记录数
		result.put("listnm", rowcnt<=maxnum ? rowcnt:maxnum);
		logger.info("支票转账托收明细查询sql语句结束");
		return result;
	}

	@Override
	public Map<String, Object> checkSoldQuery(Integer pageflag, Integer maxnum, String startdate, String enddate, String devno,
			String status,String brno) {
		Map<String,Object> result=new HashMap<String,Object>();
		logger.info("支票出售查询sql语句开始");
		// 查询总记录数
		long rowcnt = dbOperator.getSelecter().from(TABLE2).where(w -> {
			// 查询条件
			if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
				w.eq("TELLERNO", devno);
			}
			w.between("tradedate", startdate,enddate);
			if (status.equals("S")) {
				w.eq("RESPSTS", status);
			}else
			w.op("RESPSTS", "!=", "S");
			w.eq("brno", brno);
			w.eq("SERVECODE_OUT", "CSIST09034");
			w.eq("SCENECODE_OUT", "039");
		}).count();
		// 查询返回记录,"printstatustlrno","printstatus","taskid"
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> mapList2 = new ArrayList<Map<String,Object>>();
		Selecter selecter = dbOperator.getSelecter();
		if(status.equals("S")) {
			mapList = selecter.select("tc.tradedate","tc.serialno","tc.brno as strbrno","tc.backsysdate","tc.backsysno","tc.acctno","tc.accttype",
					"tc.acctname","tc.amount","tc.certtype","tc.certno","tc.feeacctno","tc.feeamout","tc.totnum","tc.RESPSTS as status","tc.taskid",
					"tc.rcvname","tc.rcvcerttype","tc.rcvcertno","ta.YY_GUID as yyguid","ta.caseid","ta.templet","ta.txttype","ta.printtype",
					"ta.issmallcode","ta.printbrno","ta.PRINTUSER1 as printtlrno1","ta.PRINTUSER2 as printtlrno2","ta.printnopass1","ta.printflag","ta.printresult")
					.from(TABLE2,TABLE3).where(w -> {
				if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
					w.eq("TELLERNO", devno);
				}
				w.between("tradedate", startdate,enddate);
				w.eq("tc.RESPSTS", status);
				w.eq("tc.brno", brno);
				w.eq("tc.SERVECODE_OUT", "CSIST09034");
				w.eq("tc.SCENECODE_OUT", "039");
				w.eq("tc.taskid", SqlUtil.getSqlExp("ta.taskid"));
			}).fetch((pageflag-1)*maxnum, maxnum);
			
		}else {
			mapList = selecter.select("tc.tradedate","tc.serialno","tc.brno as strbrno","tc.backsysdate","tc.backsysno","tc.acctno","tc.accttype",
					"tc.acctname","tc.amount","tc.certtype","tc.certno","tc.feeacctno","tc.feeamout","tc.totnum","tc.RESPSTS as status","tc.taskid",
					"tc.rcvname","tc.rcvcerttype","tc.rcvcertno","ta.YY_GUID as yyguid","ta.caseid","ta.templet","ta.txttype","ta.printtype",
					"ta.issmallcode","ta.printbrno","ta.PRINTUSER1 as printtlrno1","ta.PRINTUSER2 as printtlrno2","ta.printnopass1","ta.printflag","ta.printresult")
					.from(TABLE2,TABLE3).where(w -> {
				if (!StringUtils.isEmpty(devno) && !"".equals(devno)) {
					w.eq("TELLERNO", devno);
				}
				w.between("tc.tradedate", startdate,enddate);
				w.op("tc.RESPSTS", "!=", "S");
				w.eq("tc.brno", brno);
				w.eq("tc.SERVECODE_OUT", "CSIST09034");
				w.eq("tc.SCENECODE_OUT", "039");
				w.eq("tc.taskid", SqlUtil.getSqlExp("ta.taskid"));
			}).fetch((pageflag-1)*maxnum, maxnum);
			Map<String,Object> list=new HashMap<String,Object>();

			for (int i = 0; i < mapList.size(); i++) {
				list.putAll(mapList.get(i));
				if(list.containsKey("status"))
					list.put("status", "U");
				//mapList.set(i, list);
				mapList2.add(list);
			}
			

		}
		result.put("detail_list", mapList2);
		result.put("rowcnt", rowcnt);
		// 返回记录数
		result.put("listnm", rowcnt<=maxnum ? rowcnt:maxnum);
		logger.info("支票出售查询sql语句结束");
		return result;
	}

}
