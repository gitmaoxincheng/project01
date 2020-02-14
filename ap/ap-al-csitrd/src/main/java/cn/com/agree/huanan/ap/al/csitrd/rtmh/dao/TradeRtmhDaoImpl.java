package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;


@Component
public class TradeRtmhDaoImpl implements TradeRtmhDao{

	private static String TABLE="COMP_TRAD_FLOW";
    public final Logger logger = Logger.getLogger(TradeRtmhDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
	
	/**
	 * 新增账单信息 Dao 层
	 */
	@Override
	public int insertTradeRtmhInfo(Map<String,Object> rtmhInfoMap) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(rtmhInfoMap).execute();
		return count;
	}


	//更新数据
	@Override
	public int updateTradeRtmhInfo(Map<String, Object> map) {
		// 检验参数
		if (null == map.get("tradeDate") || StringUtils.isEmpty(map.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}		
		if (null == map.get("serialNo") || StringUtils.isEmpty(map.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("tradeDate", map.get("tradeDate"));
			w.eq("serialNo", map.get("serialNo"));
			}).set(map).execute();
		return count;
	}

	
	
	
}
