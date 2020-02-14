package cn.com.agree.huanan.ap.al.csitrd.paym.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.TradeClearInfo;
import cn.com.agree.huanan.ap.al.csitrd.sign.dao.TradeSignSubDaoImpl;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
@Component
/**
 * 收支清分登记簿DaoImpl
 * @author ZS
 *
 */
public class TradeClearInfoDaoImpl implements TradeClearInfoDao {
	
	private static String TABLE="TRADEINFO_CLEAR_DETAIL";
	private static String TABLE_CSIS_SYSPARA = "csis_syspara";
    public final Logger logger = Logger.getLogger(TradeSignSubDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
    // 新增 收支清分登记簿信息
	@Override
	public int insertTradeClearInfo(TradeClearInfo tradeClearInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(TradeClearInfo.getMap(tradeClearInfo)).execute();
		return count;
	}
	
	// 修改收支清分登记簿信息
	@Override
	public int updateTradeClearInfo(Map<String, Object> map) {
		if(null == map) {
			throw new ApIllegalParamException("集合为空");
		}
		if(null == map.get("tradeDate") || null == map.get("serialNo")) {
			throw new ApIllegalParamException("数据异常");
		}
		int count = dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("tradeDate", map.get("tradeDate"));
			w.eq("serialNo", map.get("serialNo"));
		}).set(map).execute();
		return count;
	}
	
	// 修改收支清分状态
	@Override
	public int updateTradeClearStatus(String status,String tradeDate,String serialNo) {
		int count = dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("tradeDate",tradeDate);
			w.eq("serialNo", serialNo);
		}).set("STATUS",status).execute();
		return count;
	}

	@Override
	public Map<String, Object> selectTradeClearInfo(String mdcldt, String mdclsq) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE).select("TRADEDATE").select("SERIALNO").where((w)->{
			// 查询条件
			w.eq("COLTDATE", mdcldt); //汇总日期
			w.eq("COLTSERIALNO", mdclsq); //汇总流水
			w.eq("STATUS", "11"); //状态
			
		}).fetchOne();

		return para;
	}
	
	@Override
	public Map<String, Object> selectByDateAndSeri(String coltdate, String coltserialno) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE).select("TRADEDATE").select("SERIALNO").where((w)->{
			// 查询条件
			w.eq("COLTDATE", coltdate); //汇总日期
			w.eq("COLTSERIALNO", coltserialno); //汇总流水
			w.eq("STATUS", "12"); //状态 为总账记账失败
			
		}).fetchOne();
		return para;
	}
	
	@Override
	public Map<String, Object> selectDataCheck(String coltdate, String coltserialno) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE).select("TRADEDATE").select("SERIALNO").where((w)->{
			// 查询条件
			w.eq("COLTDATE", coltdate); //汇总日期
			w.eq("COLTSERIALNO", coltserialno); //汇总流水
			w.in("STATUS","01","03","06","11","13","15","16"); //状态不：02-记账失败、05-已冲正的记录
			
		}).fetchOne();
		return para;
	}
	
	/**
	 * 查询 复核冲正异常的记录
	 */
	@Override
	public Map<String, Object> selectExceptionData(String coltdate, String coltserialno) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE)
				.select("TRADEDATE").select("SERIALNO").select("BRNO").select("CHECKTLRNO")
				.where((w)->{
			// 查询条件
			w.eq("COLTDATE", coltdate); //汇总日期
			w.eq("COLTSERIALNO", coltserialno); //汇总流水
			w.in("STATUS", "01","15"); //状态 
		}).fetchOne();
		return para;
	}
	
	
	/**
	 * 根据枚举值查询和参数码查询入账内部账户信息
	 */
	@Override
	public Map<String, Object> queryOutAcctNoAndName(String paracode) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE_CSIS_SYSPARA).select("PARAVALUE1").select("PARAVALUE2").where((w)->{
			w.eq("paraitem", "000012"); //参数类别000012
			w.eq("PARACODE", paracode); //枚举类型
		}).fetchOne();

		return para;
	}
	
	/**
	 * 根据 日期 和 汇总流水 进行 分页查询
	 */
	@Override
	public IPage<Map<String, Object>> selectTradeExeception(String strartdate, String enddate, String coltserialno,
			String brNo,Integer pageflag, Integer maxnum) {
		Selecter selecter = dbo.getSelecter().from(TABLE).select("tradedate","serialno","mybank","coltdate","coltserialno",
				"projcode","projname","subprojcode","subprojname","cleanbegdate","cleanenddate","expdflag","relateamt",
				"acctamt","outacctno","outacctname","subject","subjectname","inacctno","inacctname","txccy","status",
				"regtlrno","checktlrno","batchname").where((w) -> {
					w.between("TRADEDATE", strartdate, enddate);    // 交易开始日期 到 截止日期
					if (! StringUtils.isEmpty(coltserialno)) {
						w.eq("COLTSERIALNO", coltserialno);
					}
					w.eq("BRNO", brNo);
					w.in("STATUS", "01","15");
				});
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageflag,maxnum);
		return iPage;
	}

}
