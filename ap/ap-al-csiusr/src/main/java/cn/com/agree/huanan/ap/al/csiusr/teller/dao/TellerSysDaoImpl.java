package cn.com.agree.huanan.ap.al.csiusr.teller.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerSys;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TellerSysDaoImpl implements TellerSysDao {
    public final Logger logger = Logger.getLogger(TellerSysDaoImpl.class);
	private static String TABLE1="csis_tellersys";
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;

	@Override
	public TellerSys queryTellerSys(String tellerNo, String sysId) {
    	OrmSelecter<TellerSys> ormSelecter = ormOper.getOrmSelecter(TellerSys.class);
    	TellerSys tellerSys = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);
    		w.setSysId(sysId);
    		w.setStatus("1");
    	}).fetchOne();
    	return tellerSys;
	}

	@Override
	public int insertTellerSys(TellerSys tellerSys) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(TellerSys.getMap(tellerSys)).execute();
//		logger.info(inserter.getSql());
		dbo.commit();
		return count;
	}

	//更新柜员注册信息
	@Override
	public int updateTellerInfo(String tellerNo, String sysId, Map<String,Object> map) {
		if(StringUtils.isEmpty(tellerNo) || StringUtils.isEmpty(sysId)) {
			throw new ApIllegalParamException("TellerNo/sysId");	
		}
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("tellerno", tellerNo);
			w.eq("sysid", sysId);
			}).set(map).execute();
		return count;
	}

	@Override
	public TellerSys selectTellerSys(String tellerNo) {
		//参数检验
		if (StringUtils.isEmpty(tellerNo)) {
			throw new ApIllegalParamException("tellerNo");	
		}
		OrmSelecter<TellerSys> ormSelecter = ormOper.getOrmSelecter(TellerSys.class);
    	TellerSys tellerSys = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);   		
    	}).fetchOne();
    	return tellerSys;
	}

}
