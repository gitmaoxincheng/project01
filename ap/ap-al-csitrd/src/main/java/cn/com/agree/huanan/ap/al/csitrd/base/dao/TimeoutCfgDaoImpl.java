package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 超时交易配置表Dao实现层
 * 
 * @author guyulong
 */
@Component
public class TimeoutCfgDaoImpl implements TimeoutCfgDao {
	private static String TABLE1 = "CSIS_TIMEOUT_CFG";
	private static String TABLE2 = "TRADE_TIMEOUT_FLOW";
	private static String TABLE3 = "TRADEINFO_SIGN_SUB";
	private static String TABLE4 = "csis_tran_mapp";
	
	public final Logger logger = Logger.getLogger(TimeoutCfgDaoImpl.class);
	@Autowired
	DbOperator dbo;
	@Autowired
	OrmOperator ormOper;

	/** 查询接口目标信息 */
	@Override
	public Map<String, Object> findCodeInfo(String trancode) {
		return dbo.getSelecter().select("svccode", "scncode").from(TABLE1).where(w -> {
			w.eq("trancode", trancode);
		}).fetchOne();
	}

	/**
	 * 查询超时交易表数据
	 */
	public Map<String, Object> queryTimeOut(String pageflag, String maxnum, String begdate, String endate,
			Map<String,Object> map) {
		logger.info("超时交易表数据查询sql语句开始");

		String billno = (String)map.get("billno");
		String srcsysid = (String)map.get("srcsysid");
		String trantype = (String)map.get("trantype");
		String tellerno = (String)map.get("tellerno");
		String brno = (String)map.get("brno");
		String svcoutCode = (String)map.get("svcoutCode");
		String scnoutCode = (String)map.get("scnoutCode");
		
		// 查询总记录数
		long rowcnt = dbo.getSelecter().from(TABLE2).where(w -> {
			// 查询条件
			w.op("tradeDate", ">=", begdate);
			w.op("tradeDate", "<=", endate);
			if (!StringUtils.isEmpty(trantype) && !"".equals(trantype)) {
				w.eq("trantype", trantype);
			}
			if (!StringUtils.isEmpty(billno) && !"".equals(billno)) {
				w.eq("billno", billno);
			}
			if (!StringUtils.isEmpty(tellerno) && !"".equals(tellerno)) {
				w.eq("tellerno", tellerno);
			}
			if (!StringUtils.isEmpty(brno) && !"".equals(brno)) {
				w.eq("brno", brno);
			}
			if (!StringUtils.isEmpty(svcoutCode) && !"".equals(svcoutCode)) {
				w.eq("svcoutCode", svcoutCode);
			}
			if (!StringUtils.isEmpty(scnoutCode) && !"".equals(scnoutCode)) {
				w.eq("scnoutCode", scnoutCode);
			}
				w.eq("scrsysid", srcsysid);
		}).count();
		// 按页码查询
		int startPage = Integer.parseInt(pageflag);
		int pageSize = Integer.parseInt(maxnum);
		// 查询返回记录
		Selecter selecter = dbo.getSelecter();
		List<Map<String, Object>> mapList = selecter.select("billno as bill", "billtype", "tradedate", "serialno", "tranname",
				"scrsysid as srcsysid", "gloseqno", "reqserialno as reqno", "tellerno", "authtellerno", "mybank", "brno", "respsts as status"
				).from(TABLE2).where(w -> {

					w.op("tradeDate", ">=", begdate);
					w.op("tradeDate", "<=", endate);
					if (!StringUtils.isEmpty(trantype) && !"".equals(trantype)) {
						w.eq("trantype", trantype);
					}
					if (!StringUtils.isEmpty(billno) && !"".equals(billno)) {
						w.eq("billno", billno);
					}
					if (!StringUtils.isEmpty(tellerno) && !"".equals(tellerno)) {
						w.eq("tellerno", tellerno);
					}
					if (!StringUtils.isEmpty(brno) && !"".equals(brno)) {
						w.eq("brno", brno);
					}
					if (!StringUtils.isEmpty(svcoutCode) && !"".equals(svcoutCode)) {
						w.eq("svcoutCode", svcoutCode);
					}
					if (!StringUtils.isEmpty(scnoutCode) && !"".equals(scnoutCode)) {
						w.eq("scnoutCode", scnoutCode);
					}
						w.eq("scrsysid", srcsysid);
				}).fetch((startPage - 1) * pageSize, pageSize);
		// 返回记录数
		int listnm = mapList.size();
		Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", rowcnt);
		result.put("detail_list", mapList);
		result.put("listnm", listnm);
		logger.info("超时交易表数据查询sql语句结束");
		return result;
	}

	@Override
	public Map<String,Object> queryTrantype(String svccode,String scncode) {

		return dbo.getSelecter().select("trantype","intertype","tosvccode","toscncode","maintable","subtable").from(TABLE1).where(w -> {
			w.eq("svccode", svccode);
			w.eq("scncode", scncode);
		}).fetchOne();
	}

	@Override
	public Map<String, Object> TimeoutRegister(String tradeDate, String serialNo) {
		return dbo.getSelecter().select("svcoutcode","scnoutcode","tottime","respsts","errormsg","errorcode").from(TABLE2).where(w -> {
			w.eq("tradedate", tradeDate);
			w.eq("serialno", serialNo);
		}).fetchOne();
	}

	@Override
	public long updateTradeTable(String tradeDate, String serialNo, String tableName, Map<String, Object> paramMap) {
		if (StringUtils.isEmpty(tradeDate)) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (StringUtils.isEmpty(serialNo)) {
			throw new ApIllegalParamException("serialNo");	
		}
		int length = tableName.length();
		String tablesub = tableName.substring(length - 3,length);		//截取表名后三位，如果为SUB则说明表是子表
		logger.info("-----------tablesub  : "+tablesub);
		int count = dbo.getUpdater().update(tableName).where(w -> {
			w.eq("tradeDate", tradeDate);
			if(tablesub.equals("SUB")) {		
				w.eq("subserialNo", serialNo);
			}else {
				w.eq("serialNo", serialNo);
			}
			
		
		}).set(paramMap).execute();
		return count;
	}

	@Override
	public List<Map<String,Object>> querySignSub(String serialNo) {
		return dbo.getSelecter().select("respsts","subserialno","backscenecode").from(TABLE3).where(w -> {
			w.eq("serialno", serialNo);
		}).fetchAll();
	}

	@Override
	public Map<String, Object> queryTranmapp(String servecodeOut, String scenecodeOut) {
		return dbo.getSelecter().select("svccode", "scncode").from(TABLE4).where(w -> {
			w.eq("svcoutcode", servecodeOut);
			w.eq("scnoutcode", scenecodeOut);
		}).fetchOne();
	}

	@Override
	public Map<String, Object> queryTableCalcod(String tradeDate, String serialNo, String mainTable) {
		return dbo.getSelecter().select("reqcalcod","respsts").from(mainTable).where(w -> {
			w.eq("tradedate", tradeDate);
			w.eq("serialno", serialNo);
		}).fetchOne();
	}

}
