package cn.com.agree.huanan.ap.al.csitrd.exchange.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.exchange.po.TradeExchangeInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeExchangeDaoImpl implements TradeExchangeDao{
	
	private static String TABLE1="TRADEINFO_EXCHANGE_MAIN";
    public final Logger logger = Logger.getLogger(TradeExchangeDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;

    //新增外汇业务记录
	@Override
	public int insertTradeExchangeInfo(TradeExchangeInfo tradeExchangeInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(TradeExchangeInfo.getMap(tradeExchangeInfo)).execute();
		return count;
	}

	//修改外汇业务记录
	@Override
	public int updateTradeExchangeInfo(Map<String,Object> paramMap) {
		//参数校验
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		//更新数据
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		
		return count;
	}

}
