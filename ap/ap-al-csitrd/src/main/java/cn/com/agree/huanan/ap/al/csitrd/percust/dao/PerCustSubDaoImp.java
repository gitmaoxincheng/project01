package cn.com.agree.huanan.ap.al.csitrd.percust.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csitrd.percust.po.PerCustSub;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

/**
 * 个人客户信息登记簿子表dao实现类
 * @author czp
 */
@Component
public class PerCustSubDaoImp implements PerCustSubDao {
	private static String TABLE = "TRADEINFO_PER_CUST_SUB";
	@Autowired PerCustSubDao perCustSubDao;
	@Autowired DbOperator dbo;
	
	@Override // 插入
	public int insertPerCustSub(PerCustSub perCustSub) {
		int inserter = dbo.getInserter().insertInto(TABLE).values(PerCustSub.getMap(perCustSub)).execute();
		return inserter;
	}

	@Override // 更新
	public int updatePerCustSub(Map<String, Object> paramMap) {
		//参数检验
		if (StringUtils.isEmpty(paramMap.get("subSerialNo"))) {
			throw new ApIllegalParamException("subSerialNo");	
		}
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("subSerialNo", paramMap.get("subSerialNo"));
		}).set(paramMap).execute();		
		return count;
	}

}
