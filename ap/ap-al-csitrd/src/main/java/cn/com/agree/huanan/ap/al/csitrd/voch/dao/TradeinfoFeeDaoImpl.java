package cn.com.agree.huanan.ap.al.csitrd.voch.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.voch.po.TradeinfoFee;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 
 * @author HZP
 *	费用信息登记簿Dao接口实现
 */
@Component
public class TradeinfoFeeDaoImpl implements TradeinfoFeeDao {
	private static String TABLE = "tradeinfo_fee_main";
	public final Logger logger = Logger.getLogger(TradeinfoFeeDaoImpl.class);
	@Autowired
	DbOperator dbo;
	/**
	 * 插入数据
	 * @param tradeinfofee
	 * @return
	 */
	@Override
	public int insertTradeinfoFee(TradeinfoFee tradeinfoFee) {
		int count = dbo.getInserter().insertInto(TABLE).values(TradeinfoFee.getMap(tradeinfoFee)).execute();
		return count;
	}
	/**
	 * 更新数据
	 * @param paramMap
	 * @return
	 */
	@Override
	public int updateTradeinfoFee(Map<String, Object> paramMap) {
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
