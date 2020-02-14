package cn.com.agree.huanan.ap.al.atmp.atm.dao;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.atmp.atm.po.ATMPTranFlow;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * atm特色P交易流水表Dao层
 * @author xuzhen
 *
 */
@Component
public class AtmTranFlowDaoImpl implements AtmTranFlowDao {
	
	private static String TABLE="ATMP_TRAD_FLOW";
	private static String TABLE1="ATMP_MACHINE_REGISTER";
	public final Logger logger = Logger.getLogger(AtmTranFlowDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	@Override
	public int insertTran(Map<String, Object> atmpMap) {
		// 向数据库中插入数据
		logger.info("新增atm特色p交易流水表记录");
		int count = dbo.getInserter().insertInto(TABLE).values(atmpMap).execute();
		logger.info("atmpMap:"+atmpMap);
		logger.info("新增atm特色p交易流水表记录  结束");
		return count;
	}

	@Override
	public ATMPTranFlow queryTran(String tradeDate, String serialNo) {
		// 通过交易日期和交易流水查询交易表记录
		logger.info("查询atm特色p交易流水表记录");
		OrmSelecter<ATMPTranFlow> ormSelecter = ormOper.getOrmSelecter(ATMPTranFlow.class);
		ATMPTranFlow atmpTranFlow = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(tradeDate)) {
				w.setTradeDate(tradeDate);
			}
			if(!StringUtils.isEmpty(serialNo)) {
				w.setSerialNo(serialNo);
			}
		}).fetchOne();
		return atmpTranFlow;
	} 

	@Override
	public int updateTran(String tradeDate, String serialNo, Map<String, Object> atmpTran) {
		// 根据交易日期和交易流水更新交易记录
		logger.info("更新atm特色p交易流水表");
		int count = dbo.getUpdater().update(TABLE).set(atmpTran).where(w->{
			if(!StringUtils.isEmpty(tradeDate)) {
				w.eq("tradeDate", tradeDate);
			}
			if(!StringUtils.isEmpty(serialNo)) {
				w.eq("serialNo", serialNo);
			}
		}).execute();
		logger.info("count:"+count);
		return count;
	}

	@Override
	public int registerATMTrans(Map<String, Object> map) {
		int count = dbo.getInserter().insertInto(TABLE1).values(map).execute();
		return count;
	}
	
	@Override
	public IPage<Map<String,Object>>  selectATMSerialno(Map<String, Object> map) {
		logger.info("开始查询数据");
		String pageFlag = (String) map.get("pageflag");
		String maxNum = (String) map.get("maxnum");
		String begidt = (String) map.get("begidt");
		String finidt = (String) map.get("finidt");
		String transtp = (String) map.get("transtp");
		String termid = (String) map.get("termid");
		String cardno = (String) map.get("cardno");
		//检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			logger.info("页码不能为空");
			throw new ApIllegalParamException("页码不能为空");	
		}else if(Integer.parseInt(maxNum)<1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		}
		
		//查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if(!StringUtils.isEmpty(transtp)) {
					w.eq("transtp", transtp);
				}
				if(!StringUtils.isEmpty(termid)) {
					w.eq("termid", termid);
				}
				if(!StringUtils.isEmpty(cardno)) {
					w.eq("cardno", cardno);	
				}
				w.op("transdt", ">=", begidt);
				w.op("transdt", "<=", finidt);
				w.in("transstatus", "2","6","17","20","23","26");
			};
		};	
		//查询
		String[] selectList = new String[]{"transdt","transtm","termid","globalserialno","srcserialno","cardno","transamt","transtp",
						"transstatus","mcid","systrn"};
		Selecter selecter = dbo.getSelecter()
						 .select(selectList)
						 .from(TABLE1)					 
						 .where(whereExp)
						 .orderBy("srcserialno");
		
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(Long.parseLong(pageFlag),Long.parseLong(maxNum));	
		logger.info("结束查询数据");
		return iPage;
	}
}
