package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeSignDaoImpl implements TradeSignDao {
	
	private static String TABLE1="TRADEINFO_SIGN_MAIN";
    public final Logger logger = Logger.getLogger(TradeSignDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    
	//新增签约信息
	@Override
	public int insertTradeSignInfo(TradeSignInfo signInfoMap) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(TradeSignInfo.getMap(signInfoMap)).execute();
		return count;
	}

	//更新数据
	@Override
	public int updateTradeSignInfo(Map<String,Object> paramMap) {	
		//参数检验
		logger.info("检查tradeDate是否为空"+paramMap.get("tradeDate"));
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
	
	//修改签约信息    Maoxc
	@Override
	public int updateTradeSignInfoTwo(Map<String,Object> MyMap) {	
		//参数检验
		logger.info("检查@Component_MyMap:"+MyMap);
		if (StringUtils.isEmpty(MyMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}	
		if (StringUtils.isEmpty(MyMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		//更新
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("tradeDate", MyMap.get("tradeDate"));
			w.eq("serialNo", MyMap.get("serialNo"));
		}).set(MyMap).execute();
		return count;
	}
		
	
	//新增签约信息
		@Override
		public int insertAutoRepaymentInfo(TradeSignInfo signInfoMap) {
			Inserter inserter = dbo.getInserter();
			int count = inserter.insertInto(TABLE1).values(TradeSignInfo.getMap(signInfoMap)).execute();
			return count;
		}

		//更新数据
		@Override
		public int updateAutoRepaymentInfo(Map<String,Object> map) {
			// 检验参数
			if (null == map.get("tradeDate") || StringUtils.isEmpty(map.get("tradeDate"))) {
				throw new ApIllegalParamException("tradeDate");	
			}
			
			if (null == map.get("serialNo") || StringUtils.isEmpty(map.get("serialNo"))) {
				throw new ApIllegalParamException("serialNo");	
			}
			
			//更新数据
			int count = dbo.getUpdater().update(TABLE1).where(w -> {
				w.eq("tradeDate", map.get("tradeDate"));
				w.eq("serialNo", map.get("serialNo"));
				}).set(map).execute();
			return count;
		}

		

}
