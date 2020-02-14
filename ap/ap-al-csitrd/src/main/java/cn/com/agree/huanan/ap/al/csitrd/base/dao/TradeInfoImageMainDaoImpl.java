package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageMain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeInfoImageMainDaoImpl implements TradeInfoImageMainDao{
	
	private static String TABLE_TRADEINFO_IMAGE_MAIN = "tradeinfo_image_main";
	public final Logger logger = Logger.getLogger(TradeInfoImageMainDaoImpl.class);
	@Autowired private DbOperator dbo;
	
	/**
	 * 登记到影像登记簿
	 * */
	public int insertTradeInfoImageMain(TradeInfoImageMain tradeInfoImageMain) {
		
		int count = dbo.getInserter().insertInto(TABLE_TRADEINFO_IMAGE_MAIN).values(TradeInfoImageMain.getMap(tradeInfoImageMain)).execute();
		return count;
	}
	
	
	/**
	 * 更新到影像登记簿
	 * */
	public int updateTradeInfoImageMain(Map<String, Object> paramMap) {
		
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE_TRADEINFO_IMAGE_MAIN).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		
		return count;
	}
}
