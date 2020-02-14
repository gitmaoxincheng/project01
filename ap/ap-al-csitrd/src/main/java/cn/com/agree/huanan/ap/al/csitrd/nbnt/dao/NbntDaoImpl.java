package cn.com.agree.huanan.ap.al.csitrd.nbnt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.nbnt.po.Nbnt;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;


/**
 * 贵金属Dao层
 * @author jiangzf
 */
@Component
public class NbntDaoImpl implements NbntDao {

	private static String TABLE = "TRADEINFO_FINLINSU_MAIN";
	public final Logger logger = Logger.getLogger(NbntDaoImpl.class);
	@Autowired
	DbOperator dbo;

	/**
	 * 新增一条贵金属相关记录
	 */
	@Override
	public int addNbnt(Nbnt nbnt) {
		Inserter inserter = dbo.getInserter();
		int  count = inserter.insertInto(TABLE).values(Nbnt.getMap(nbnt)).execute();
		return count;
	}

	/**
	 * 修改贵金属相关记录
	 */
	@Override
	public int editNbnt(Map<String,Object> nbnt) {
		if (null == nbnt.get("tradeDate") || StringUtils.isEmpty(nbnt.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == nbnt.get("serialNo") || StringUtils.isEmpty(nbnt.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE).set(nbnt).where((w)->{
			w.eq("tradeDate", nbnt.get("tradeDate"));
			w.eq("serialNo", nbnt.get("serialNo"));
		}).execute();
		return count;
	}

}
