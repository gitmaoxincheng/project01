package cn.com.agree.huanan.ap.al.csitrd.mide.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csitrd.mide.po.IntermediateMain;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TuitionPaymentDaoImpl implements TuitionPaymentDao{
	
	@Autowired DbOperator dbo;
	@Autowired OrmOperator  ormOper;
	private static String TABLE1= "TRADEINFO_INTERMEDIATE_MAIN";
	public final Logger logger = Logger.getLogger(TuitionPaymentDaoImpl.class);
	
	
	//记录到特色业务
	@Override
	public int insertIntermediateMain(IntermediateMain intermediateMain) {
		
		int count = dbo.getInserter().insertInto(TABLE1).values(IntermediateMain.getMap(intermediateMain)).execute();
		return count;
		
	}

	//更新特色业务
	@Override
	public int updateIntermediateMain(Map<String, Object> paramMap) {
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
	

}


















