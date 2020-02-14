package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignInfo;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignSub;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeSignSubDaoImpl implements TradeSignSubDao {
	
	private static String TABLE1="TRADEINFO_SIGN_SUB";
    public final Logger logger = Logger.getLogger(TradeSignSubDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    
	//新增签约子信息
	@Override
	public int insertTradeSignInfoSub(TradeSignSub signSub) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(TradeSignSub.getMap(signSub)).execute();
		return count;
	}

	//更新签约子信息
	@Override
	public int updateTradeSignInfoSub(Map<String, Object> map) {
		// 检验参数
		if (StringUtils.isEmpty(map)) {
			throw new ApIllegalParamException("map");
		}
		if (StringUtils.isEmpty(map.get("subSerialNo"))) {
			throw new ApIllegalParamException("subSerialNo");
		}
		
		//更新数据
		int count = dbo.getUpdater().update(TABLE1).where(w -> {w.eq("subSerialNo", map.get("subSerialNo"));}).set(map).execute();
		return count;
	}

}
