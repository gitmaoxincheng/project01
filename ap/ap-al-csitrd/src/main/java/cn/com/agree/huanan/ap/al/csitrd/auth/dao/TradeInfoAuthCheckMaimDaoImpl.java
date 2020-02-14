package cn.com.agree.huanan.ap.al.csitrd.auth.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.auth.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csitrd.auth.po.Entduty;
import cn.com.agree.huanan.ap.al.csitrd.auth.po.TradeInfoAuthCheckMaim;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeInfoAuthCheckMaimDaoImpl implements TradeInfoAuthCheckMaimDao{
	
	private static String TABLE1="TRADEINFO_AUTHCHECK_MAIN";
    public final Logger logger = Logger.getLogger(TradeInfoAuthCheckMaimDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;

	@Override
	public int updateByDate(Map<String, Object> paramMap) {
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

	@Override
	public int updateByTaskid(Map<String, Object> paramMap) {
		if (null == paramMap.get("taskid")) {
			throw new ApIllegalParamException("taskid");	
		}
		
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("taskid", paramMap.get("taskid"));
		}).set(paramMap).execute();
		
		return count;
	}
	
	@Override
	public int insertTradeInfoAuthCheckMaim(TradeInfoAuthCheckMaim tradeInfoAuthCheckMaim) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(tradeInfoAuthCheckMaim.getMap(tradeInfoAuthCheckMaim)).execute();
		return count;
	}
	
	 /**
     * 根据柜员号和网点号查询实体岗位
     * */
	@Override
	public Entduty queryEntdutyByCond(String tellerNo, String brno) {
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
		
		Entduty entduty = ormSelecter.where(w ->{
    		w.setTellerno(tellerNo);
    		w.setBrno(brno);
    	}).fetchOne();
		
		return entduty;
	}
	
	/**
	 * 根据岗位类型编号查询岗位类型信息
	 * */
	@Override
	public DutyInfo queryByDutyNo(String dutyNo) {
		OrmSelecter<DutyInfo> ormSelecter = ormOper.getOrmSelecter(DutyInfo.class);
		DutyInfo dutyInfo = ormSelecter.where(w ->{
    		w.setDutyNo(dutyNo);
    	}).fetchOne();
    	return dutyInfo;
	}
	

}
