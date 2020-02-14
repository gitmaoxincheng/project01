package cn.com.agree.huanan.ap.al.csiusr.exittellerno.dao;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.exittellerno.po.ExitTellerNo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ExitTellerNoDaoImpl implements ExitTellerNoDao{

	private static String TABLE1="csis_exittellerno";
    public final Logger logger = Logger.getLogger(ExitTellerNoDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    
    @Override
	public List<ExitTellerNo> queryExitTellerNoByNo(String tradeDate, String tellerNo, String sysId, String entdutyNo, String status) {
    	OrmSelecter<ExitTellerNo> ormSelecter = ormOper.getOrmSelecter(ExitTellerNo.class);
		List<ExitTellerNo> list = ormSelecter.where(w ->{
			if (!StringUtils.isEmpty(tradeDate))
    			w.setTradeDate(tradeDate);
    		if (!StringUtils.isEmpty(tellerNo))
    			w.setTellerNo(tellerNo);
    		if (!StringUtils.isEmpty(sysId))
    			w.setSysId(sysId);
    		if (!StringUtils.isEmpty(entdutyNo))
    			w.setEntDutyNo(entdutyNo);
    		if (!StringUtils.isEmpty(status))
    			w.setStatus(status);
    	}).fetchAll();
    	return list;
	}

	@Override
	public int deleteByNoAndDate(String tradeDate, String tellerNo, String brno) {
		
		if (StringUtils.isEmpty(tellerNo)) {
			throw new ApIllegalParamException("tellerNo");	
		}
		
		if (StringUtils.isEmpty(tradeDate)) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (StringUtils.isEmpty(tradeDate)) {
			throw new ApIllegalParamException("brno");	
		}
		
		int count = dbo.getDeleter().deleteFrom(TABLE1).where(w -> {w.eq("tellerNo", tellerNo);w.eq("tradeDate", tradeDate);w.eq("brno", brno);}).execute();
		return count;
	}

	@Override
	public int insertExitTellerInfo(ExitTellerNo exitTellerNo) {
		
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(ExitTellerNo.getMap(exitTellerNo)).execute();
		return count;
	}

	@Override
	public List<ExitTellerNo> queryExitTellerInfo(String tradeDate, String tellerNo, String status) {
		OrmSelecter<ExitTellerNo> ormSelecter = ormOper.getOrmSelecter(ExitTellerNo.class);
		List<ExitTellerNo> list = ormSelecter.where(w ->{
    		w.setTradeDate(tradeDate);
    		w.setTellerNo(tellerNo);
    		w.setStatus(status);
    	}).fetchAll();
    	return list;
	}

	@Override
	public int updateExitTellerInfo(String strTellerNo, String strBrNo, String tradeDate, String sysId, Map<String, Object> paramMap) {
		
		if (StringUtils.isEmpty(strTellerNo))
			throw new ApIllegalParamException("tellerNo");
		
		if (StringUtils.isEmpty(strBrNo))
			throw new ApIllegalParamException("strBrNo");	
		
		if (StringUtils.isEmpty(tradeDate))
			throw new ApIllegalParamException("tradeDate");	
		
		if (StringUtils.isEmpty(sysId))
			throw new ApIllegalParamException("sysId");	
		
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("tellerNo", strTellerNo);
			w.eq("brNo", strBrNo);
			w.eq("tradeDate", tradeDate);
			w.eq("sysId", sysId);
		}).set(paramMap).execute();
		
		return count;
	}

	@Override
	//多表查询
	public IPage<Map<String, Object>> selectDutyExittellerno(int pageFlag, int pageSize, String tradeDate, String strTellerNo, String brNo, String myBank) {
		//查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>(){
			@Override
			public void accept(WhereExp w) {		
				 w.op("t1.brno", "like", myBank + "%");
				 if(!StringUtils.isEmpty(tradeDate)) {w.eq("t1.tradedate", tradeDate);}
				 if(!StringUtils.isEmpty(strTellerNo)) {w.eq("t1.tellerno", strTellerNo);}
				 if(!StringUtils.isEmpty(brNo)) {w.eq("t1.brno", brNo);}
				 w.eq("t1.dutyno", SqlUtil.getSqlExp("t2.dutyno"));
				};
		};
		
		//查询
		String[] tables = new String[] {"csis_exittellerno t1","csis_dutyinfo t2"};
		String[] selectList = new String[] {
				"t1.tradedate as tradedate","t1.tellerno as tellerno","t1.sysid as sysid","t1.syscname as syscname",
				"t1.status as status","t1.zoneno as zoneno","t1.mbrno as mbrno","t1.brno as brno","t1.dutyno as dutyno",
				"t2.dutyname as dutyname"};
		Selecter selecter = dbo.getSelecter().from(tables)
						 .select(selectList)
						 .where(whereExp);
		
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag,pageSize);
		return iPage;
	}

	@Override
	public List<ExitTellerNo> queryInfoByBrno(String tradeDate, String brno) {
		OrmSelecter<ExitTellerNo> ormSelecter = ormOper.getOrmSelecter(ExitTellerNo.class);
		List<ExitTellerNo> list = ormSelecter.where(w ->{
    		w.setTradeDate(tradeDate);
    		w.setBrNo(brno);
    	}).fetchAll();
    	return list;
	}

	@Override
	public List<ExitTellerNo> queryInfoByBrnoAndStatus(String tradeDate, String brno, String status) {
		OrmSelecter<ExitTellerNo> ormSelecter = ormOper.getOrmSelecter(ExitTellerNo.class);
		List<ExitTellerNo> list = ormSelecter.where(w ->{
    		w.setTradeDate(tradeDate);
    		w.setBrNo(brno);
    		w.setStatus(status);
    	}).fetchAll();
    	return list;
	}

	@Override
	public List<ExitTellerNo> queryInfoByDateTellerBrno(String tradeDate, String tellerNo, String brno) {
		OrmSelecter<ExitTellerNo> ormSelecter = ormOper.getOrmSelecter(ExitTellerNo.class);
		List<ExitTellerNo> list = ormSelecter.where(w ->{
			if (!StringUtils.isEmpty(tradeDate)) {
	    		w.setTradeDate(tradeDate);
			}
			if (!StringUtils.isEmpty(tellerNo)) {
				w.setTellerNo(tellerNo);
			}
			if (!StringUtils.isEmpty(brno)) {
				w.setBrNo(brno);
			}
    	}).fetchAll();
    	return list;
	}
}
