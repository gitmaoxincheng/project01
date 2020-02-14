package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 理财产品赎回DAO类
 * @author jiangzf
 */
@Component
public class RedeemDaoImpl implements RedeemDao {

	private static String TABLE = "TRADEINFO_FINLINSU_MAIN";
	
	public final Logger logger = Logger.getLogger(TradfinamainDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	/**
	 * 增加一条理财产品赎回记录
	 * @param 理财业务对象
	 * @return 赎回更新条数
	 */
	@Override
	public int addRedeemRecord(Tradfinamain Redeem) {
		int count = dbo.getInserter().insertInto(TABLE).values(Tradfinamain.getMap(Redeem)).execute();
		return count;
	}

	/**
	 * 更新一条理财产品赎回记录
	 * @param 理财业务对象
	 */
	@Override
	public int updataRedeemRecord(Tradfinamain Redeem) {
		Map<String,Object> rdMap = Tradfinamain.getMap(Redeem);
		// TODO 自动生成的方法存根
		
		if(StringUtils.isEmpty(rdMap.get("tradeDate")) || StringUtils.isEmpty(rdMap.get("serialNo"))) {
			throw new ApIllegalParamException("缺少交易日期或交易流水");
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE).where((w)->{
			w.eq("tradedate", rdMap.get("tradeDate"));
			w.eq("serialno", rdMap.get("serialNo"));
		}).set(rdMap).execute();
		return count;
	}

}
