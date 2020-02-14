package cn.com.agree.huanan.ap.al.csitrd.card.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.card.po.Trainfomain;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeRegisterException;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CreditCardDaoImpl implements CreditCardDao{

	private static String TABLE="TRADEINFO_MATTER_MAIN";
    public final Logger logger = Logger.getLogger(CreditCardDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	

	@Override
	public int getCreditCardInsert(Trainfomain trainfomain) {
		int count = dbo.getInserter().insertInto(TABLE).values(Trainfomain.getMap(trainfomain)).execute();
		return count;
	}

	@Override
	public int getCreditCardUpdate(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		return count;
	}

	

}
