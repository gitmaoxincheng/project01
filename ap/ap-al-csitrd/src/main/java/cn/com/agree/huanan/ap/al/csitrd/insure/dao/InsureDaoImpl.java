package cn.com.agree.huanan.ap.al.csitrd.insure.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.insure.po.Insure;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 保险Dao层
 * @author jiangzf
 */

@Component
public class InsureDaoImpl  implements InsureDao{
	
	private static String TABLE = "tradeinfo_finlinsu_main";
	public final Logger logger = Logger.getLogger(InsureDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	/**
	 * 增加一条保险相关记录
	 */
	public int addInsure(Insure insure) {
		Inserter inserter = dbo.getInserter();
		int  count = inserter.insertInto(TABLE).values(Insure.getMap(insure)).execute();
		return count;
	}

	/**
	 * 修改一条保险相关记录
	 */
	public int editInsure(Map<String, Object> insure) {
		if (null == insure.get("tradeDate") || StringUtils.isEmpty(insure.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == insure.get("serialNo") || StringUtils.isEmpty(insure.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE).set(insure).where((w)->{
			w.eq("tradeDate", insure.get("tradeDate"));
			w.eq("serialNo", insure.get("serialNo"));
		}).execute();
		return count;
	}

}
