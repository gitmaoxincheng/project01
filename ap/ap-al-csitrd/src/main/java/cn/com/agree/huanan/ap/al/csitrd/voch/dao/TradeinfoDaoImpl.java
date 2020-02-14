package cn.com.agree.huanan.ap.al.csitrd.voch.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.voch.po.Tradeinfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 
 * @author HZP
 *	事故事项操作Dao实现类
 */
@Component
public class TradeinfoDaoImpl{ //implements TradeinfoDao{
	
	/*private static String TABLE = "tradeinfo_matter_main";
	public final Logger logger = Logger.getLogger(TradeinfoDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	//插入数据
	public int insertTradeinfo(Tradeinfo tradeinfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(Tradeinfo.getMap(tradeinfo)).execute();
		return count;
	}
	
	//更新数据
	public int updateTradeinfo(Map<String, Object> paramMap) {
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
	}*/
}
