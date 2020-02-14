package cn.com.agree.huanan.ap.al.csiusr.register.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.register.po.PerCustMain;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

@Component
public class PerCustMainDaoImpl implements PerCustMainDao{
	private static String TABLE="TRADEINFO_PER_CUST_MAIN";
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
	@Override
	public int insertPerCustMain(PerCustMain perCustMain) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(PerCustMain.getMap(perCustMain)).execute();
		dbo.commit();
		return count;
	}

	@Override
	public int updatePerCustMain(PerCustMain perCustMain) {
		if (StringUtils.isEmpty(perCustMain.getTradeDate())) {
			throw new ApIllegalParamException("tradeDate");	
		}
		if (StringUtils.isEmpty(perCustMain.getSerialNo())) {
			throw new ApIllegalParamException("serialNo");	
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE).where(w -> {
			w.eq("tradeDate", perCustMain.getTradeDate());
			w.eq("serialNo", perCustMain.getSerialNo());
		})
		.set(PerCustMain.getMap(perCustMain)).execute();
		return count;
	}
	
}
