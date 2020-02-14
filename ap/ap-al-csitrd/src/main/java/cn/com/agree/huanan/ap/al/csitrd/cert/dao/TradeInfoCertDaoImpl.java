package cn.com.agree.huanan.ap.al.csitrd.cert.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.cert.po.TradeInfoCert;
import cn.com.agree.huanan.ap.al.csitrd.fina.dao.TradfinamainDaoImpl;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 凭证信息登记簿dao实现类
 * @author lanshaojun
 *
 */
@Component
public class TradeInfoCertDaoImpl implements TradeInfoCertDao {
	private static String TABLE = "TRADEINFO_CERT_MAIN";
	@Autowired DbOperator dbOperator;
	
	
	@Autowired 
	OrmOperator  ormOper;
	
	public final Logger logger = Logger.getLogger(TradfinamainDaoImpl.class);
	@Override
	public int insertTradeInfoCert(TradeInfoCert tradeInfoCert) {
		// TODO 自动生成的方法存根
		int count = dbOperator.getInserter().insertInto(TABLE).values(TradeInfoCert.getMap(tradeInfoCert)).execute();
		return count;
	}

	@Override
	public int updateTradeInfoCert(Map<String, Object> paramMap) {
		// TODO 自动生成的方法存根
		int count = dbOperator.getUpdater().update(TABLE).where(w->{
			w.eq("SERIALNO", paramMap.get("serialNo"));
			w.eq("TRADEDATE", paramMap.get("tradeDate"));
		}).set(paramMap).execute();
		return count;
	}

	@Override
	public Map<String, Object> selectGeneralFlush(String startdate, String enddate, String oriserino, String trantlrno,
			Integer pageflag, Integer maxnum) {
		
		logger.info("通用冲正流水查询sql语句开始");

		Map<String,Object> result=new HashMap<String,Object>();
		// 查询总记录数
		long rowcnt = dbOperator.getSelecter().from(TABLE).where(w -> {
			// 查询条件
			if (!StringUtils.isEmpty(oriserino) && !"".equals(oriserino)) {
				w.eq("SERIALNO", oriserino);
			}
			if (!StringUtils.isEmpty(trantlrno) && !"".equals(trantlrno)) {
				w.eq("TELLERNO", trantlrno);
			}
			w.between("tradedate", startdate, enddate);
			w.eq("SCENECODE","CBOX0012");
			w.eq("CERTFLAG", "2");
			w.eq("RESPSTS", "S");
			
		}).count();
		
		// 查询返回记录
		Selecter selecter = dbOperator.getSelecter();
		List<Map<String, Object>> mapList = selecter.select("tradedate", "serialno", "tradetime", "reqserialno", "scrsysid",
				"scrcalcod", "golseqno", "tellerno", "mybank", "brno","devno","authtellerno",
				"respsts","errorcode","errormsg").from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(trantlrno) && !"".equals(trantlrno)) {
						w.eq("TELLERNO", trantlrno);
					}
					if (!StringUtils.isEmpty(oriserino) && !"".equals(oriserino)) {
						w.eq("SERIALNO", oriserino);
					}
					w.between("tradedate", startdate,enddate);
					w.eq("SCENECODE","CBOX0012");
					w.eq("CERTFLAG", "2");
					w.eq("RESPSTS", "S");
					
				}).orderBy("tradedate").fetch((pageflag-1)*maxnum, maxnum);
		result.put("tran_list", mapList);
		result.put("rowcnt", rowcnt);
		// 返回记录数
		result.put("listnum", rowcnt<=maxnum ? rowcnt:maxnum);
		
		logger.info("通用冲正流水查询sql语句结束");
		return result;
	}

	@Override
	public Map<String, Object> selectVochDetails(String tradedate, String serialno) {
		logger.info("柜员尾箱凭证查询sql语句开始");

		Map<String,Object> result=new HashMap<String,Object>();
		// 查询总记录数
		long rowcnt = dbOperator.getSelecter().from(TABLE).where(w -> {
			// 查询条件
			w.eq("tradedate", tradedate);
			w.eq("serialNo", serialno);
			
		}).count();
		
		// 查询返回结果
		Selecter selecter = dbOperator.getSelecter();
		Map<String, Object> map = selecter.select("tradedate", "serialno", "certtype", "virtlr", "cntprtlr",
				"abstcode", "abstdsc", "remarkks").from(TABLE).where(w -> {

					w.eq("tradedate", tradedate);
					w.eq("serialNo", serialno);
					
				}).orderBy("tradedate").fetchOne();
		if(map == null) {
			throw new ApIllegalParamException("查不到对应记录");
		}
		
		result.put("tradedate",map.get("tradedate"));
		result.put("serialno",map.get("serialno"));
		result.put("certdealflg",map.get("certtype"));
		result.put("virtlr",map.get("virtlr"));
		result.put("cntprtlr",map.get("cntprtlr"));
		result.put("abstcode",map.get("abstcode"));
		result.put("abstdsc",map.get("abstdsc"));
		result.put("remarkks",map.get("remarkks"));
		result.put("listnum", rowcnt);
		logger.info("柜员尾箱凭证查询sql语句结束");
		return result;
	}
	
	/**
	 * 
	 * @param tradedate
	 * @param serialno
	 * @return
	 */
	public TradeInfoCert getCert(String tradedate, String serialno) {

		// 查询总记录数
		List<TradeInfoCert> TradeInfoCerts = ormOper.getOrmSelecter(TradeInfoCert.class).where(w -> {
			// 查询条件
			w.setTradeDate(tradedate);
			w.setSerialNo(serialno);
			
		}).fetchAll();
		if (TradeInfoCerts.size() > 0) {
			return TradeInfoCerts.get(0);
		}else {
			return null;
		}
	}
}
