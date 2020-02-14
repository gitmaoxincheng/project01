package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

abstract public class BaseTradfinamainDaoImpl implements BaseTradfinamainDao {
	private static String TABLE = "TRADEINFO_FINLINSU_MAIN";
	protected final Logger logger = Logger.getLogger(TradfinamainDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	@Override
	public int stdInsertTradfinamain(Tradfinamain tFina) {
		int count = dbo.getInserter().insertInto(TABLE).values(Tradfinamain.getMap(tFina)).execute();
		return count;
	}

	@Override
	public int stdUpdataTradfinamain(Tradfinamain tFina) {
		Map<String,Object> Fls = Tradfinamain.getMap(tFina);
		if(StringUtils.isEmpty(Fls.get("tradeDate")) || StringUtils.isEmpty(Fls.get("serialNo"))) {
			throw new ApIllegalParamException("缺少交易日期或交易流水");
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE).where((w)->{
			w.eq("tradedate", Fls.get("tradeDate"));
			w.eq("serialno", Fls.get("serialNo"));
		}).set(Fls).execute();
		return count;
	}

}
