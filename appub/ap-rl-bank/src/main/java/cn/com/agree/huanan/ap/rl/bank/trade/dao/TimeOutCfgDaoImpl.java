package cn.com.agree.huanan.ap.rl.bank.trade.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutCfg;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;

/**
 * 超时交易配置表Dao接口实现
 * 
 * @author guyulong
 */
@Component
public class TimeOutCfgDaoImpl implements TimeOutCfgDao {
	//private static String TABLE = "CSIS_TIMEOUT_CFG";
	//@Autowired private DbOperator dbOperator;
	@Autowired
	private OrmOperator ormOperator;

	@Override
	public TimeOutCfg queryTimeout(String tradeCode) {
		return ormOperator.getOrmSelecter(TimeOutCfg.class).where(w -> {
			w.setTradeCode(tradeCode);
		}).fetchOne();
	}
}
