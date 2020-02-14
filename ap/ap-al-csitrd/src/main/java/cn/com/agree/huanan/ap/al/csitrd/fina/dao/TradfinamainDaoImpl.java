package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Questionmain;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradriskmain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradfinamainDaoImpl implements TradfinamainDao{
	private static String TABLE1 = "TRADEINFO_FINLINSU_MAIN";
	private static String TABLE2 = "TRADEINFO_RISK_TMAIN";
	private static String TABLE3 = "TRADEINFO_RISK_SCORE";
	public final Logger logger = Logger.getLogger(TradfinamainDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	
	public int tradeinfoInsert(Tradfinamain tradfinamain) {
		
		int count = dbo.getInserter().insertInto(TABLE1).values(Tradfinamain.getMap(tradfinamain)).execute();
		
		return count;
	}


	public int tradeinfoUpdate(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		
		return count;
		
	}

	public int traderiskInsert(Tradriskmain tradriskmain) {
		
		int count = dbo.getInserter().insertInto(TABLE2).values(Tradriskmain.getMap(tradriskmain)).execute();
		
		return count;
		
	}


	
	public int traderiskUpdate(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE2).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();

		return count;
		
	}


	@Override
	public Map<String, Object> selectquestionnaireSuervey(String clienttype, String clientgroup, String papertype,
			String paperno) {
		logger.info("评估问卷查询sql语句开始");

		Map<String,Object> result=new HashMap<String,Object>();
		// 查询总记录数
		long rowcnt = dbo.getSelecter().from(TABLE3).where(w -> {
			// 查询条件
			if (!StringUtils.isEmpty(paperno) && !"".equals(paperno)) {
				w.eq("paperno", paperno);
			}
			w.eq("clienttype", clienttype);
			w.eq("clientgroup", clientgroup);
			w.eq("papertype", papertype);
			
		}).count();
		
		// 查询返回记录
				Selecter selecter = dbo.getSelecter();
				List<Map<String, Object>> mapList = selecter.select("clienttype", "clientgroup", "papertype", "paperno", "question",
						"riskoption", "subject", "score", "questiontype", "prdtype").from(TABLE3).where(w -> {
							if (!StringUtils.isEmpty(paperno) && !"".equals(paperno)) {
								w.eq("paperno", paperno);
							}
							w.eq("clienttype", clienttype);
							w.eq("clientgroup", clientgroup);
							w.eq("papertype", papertype);
							
						}).orderBy("paperno","question*1","riskoption").fetchAll();
		result.put("qust_list", mapList);
		result.put("listnum", rowcnt);
		logger.info("评估问卷查询sql语句结束");
		return result;
	}


	@Override
	public int deletequestionSuervey() {
		int count=dbo.getDeleter().deleteFrom(TABLE3).execute();
		return count;
	}


	@Override
	public int insertquestionSuervey(Questionmain question) {
		int count = dbo.getInserter().insertInto(TABLE3).values(Questionmain.getMap(question)).execute();
		return count;
	}
	
}
