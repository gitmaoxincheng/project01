package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToPublicClient;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
@Component
public class ToPublicClientDaoImpl implements ToPublicClientDao {
	
	private static String TABLE1="TRADEINFO_CORP_CUST_MAIN";
    public final Logger logger = Logger.getLogger(ToPublicClientDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
    // 更新对公客户信息
	@Override
	public int insertPublicClientInfo(ToPublicClient publicClientInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(ToPublicClient.getMap(publicClientInfo)).execute();
		return count;
	}
	
	// 修改对公客户信息
	@Override
	public int updatePublicClientInfo(Map<String, Object> map) {
		//参数检验
		logger.info("检查tradeDate是否为空"+map.get("tradeDate"));
		if (null == map.get("tradeDate") || StringUtils.isEmpty(map.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == map.get("serialNo") || StringUtils.isEmpty(map.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("tradeDate", map.get("tradeDate"));
			w.eq("serialNo", map.get("serialNo"));
		}).set(map).execute();
		return count;
	}

}
