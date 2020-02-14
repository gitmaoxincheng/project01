package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToSubClient;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ToSubClientDaoImpl implements ToSubClientDao {
	
	private static String TABLE1="TRADEINFO_CORP_CUST_SUB";
    public final Logger logger = Logger.getLogger(ToSubClientDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
    // 更新对公客户信息
	@Override
	public int insertSubClientInfo(ToSubClient tosubClient) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(ToSubClient.getMap(tosubClient)).execute();
		return count;
	}
	
	// 修改对公客户信息
	@Override
	public int updateSubClientInfo(Map<String, Object> map) {
		//参数检验
		if (StringUtils.isEmpty(map.get("subSerialNo"))) {
			throw new ApIllegalParamException("subSerialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("subSerialNo", map.get("subSerialNo"));
		}).set(map).execute();
		return count;
	}
}
