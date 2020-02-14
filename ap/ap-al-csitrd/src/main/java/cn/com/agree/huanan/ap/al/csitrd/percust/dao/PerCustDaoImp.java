package cn.com.agree.huanan.ap.al.csitrd.percust.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCust;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

/**
 * 个人客户信息dao实现类
 * @author Maoxc
 */
@Component
public class PerCustDaoImp implements PerCustDao {
	private static String TABLE = "TRADEINFO_PER_CUST_MAIN";
	@Autowired PerCustDao perCustDao;
	@Autowired DbOperator dbo;
	
	@Override // 插入
	public int insertPerCust(PerCust perCust) {
		int inserter = dbo.getInserter().insertInto(TABLE).values(PerCust.getMap(perCust)).execute();
		return inserter;
	}

	@Override // 更新
	public int updatePerCust(Map<String, Object> paramMap) {
		//参数检验
		if (StringUtils.isEmpty(paramMap.get("tradeDate"))) {		
			throw new ApIllegalParamException("tradeDate");	
		}		
		if (StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();		
		return count;
	}

}
