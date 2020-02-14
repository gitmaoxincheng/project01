package cn.com.agree.huanan.ap.al.csitrd.cidt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.cidt.po.TradeMessageInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeMessageInfoDaoImpl implements TradeMessageInfoDao{

	private static String TABLE1="TRADEINFO_MESSAGE_MAIN";
    public final Logger logger = Logger.getLogger(TradeMessageInfoDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
	@Override
	public int updateByDate(Map<String, Object> paramMap) {
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

	@Override
	public int insertTradeMessageInfo(TradeMessageInfo tradeMessageInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(TradeMessageInfo.getMap(tradeMessageInfo)).execute();
		return count;
	}

}
