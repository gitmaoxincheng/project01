package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;


/**
 * 理财业务登记表Dao层--客户撤单
 * @author bodadmin
 *
 */
@Component
public class FinlinsuDaoImpl implements FinlinsuDao{
	private static String TABLE = "tradeinfo_finlinsu_main";
	public final Logger logger = Logger.getLogger(FinlinsuDaoImpl.class);
	@Autowired
	DbOperator dbo;
	
	/**
	 * 新增一条记录
	 */
	public int addFinlinsu(Map<String, Object> Fls) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(Fls).execute();
		return count;
	}
	
	/**
	 * 
	 */
	public Tradfinamain getFinlinById(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	/**
	 * 修改一条记录
	 */
	public int updateFinlinsu(Map<String, Object> Fls) {
		if(StringUtils.isEmpty(Fls.get("tradeDate")) || StringUtils.isEmpty(Fls.get("serialNo"))) {
			throw new ApIllegalParamException("缺少交易日期或交易流水");
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE).where((w)->{
			w.eq("tradedate", Fls.get("tradeDate"));
			w.eq("serialno", Fls.get("serialNo"));
		}).set(Fls).execute();
		return count;
	}
}
