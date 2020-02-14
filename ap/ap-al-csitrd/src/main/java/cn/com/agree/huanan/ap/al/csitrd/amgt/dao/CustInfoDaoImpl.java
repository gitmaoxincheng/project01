package cn.com.agree.huanan.ap.al.csitrd.amgt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.amgt.po.CustInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;


/**
 * 个人客户信息dao实现类
 * @author Maoxc
 *
 */
@Component
public class CustInfoDaoImpl {//implements CustInfoDao {
//	private static String TABLE = "TRADEINFO_PER_CUST_MAIN";
//	@Autowired CustInfoDao custInfoDao;
//	@Autowired DbOperator dbOperator;
//	@Autowired OrmOperator ormOperator;
//	@Autowired DbOperator dbo;
//
//	
//    
//	@Override//插入数据
//	public int insertCustInfo(CustInfo custInfo) {
//		Inserter inserter = dbo.getInserter();
//		int count = inserter.insertInto(TABLE).values(CustInfo.getMap(custInfo)).execute();
//		return count;
//	}
//
//   
//	@Override //更改数据
//	public int updateCustInfo(Map<String, Object> paramMap) {
//		//参数检验
//		if (StringUtils.isEmpty(paramMap.get("TradeDate"))) {		
//			throw new ApIllegalParamException("TradeDate");	
//		}		
//		if (StringUtils.isEmpty(paramMap.get("SerialNo"))) {
//			throw new ApIllegalParamException("SerialNo");	
//		}
//		//更新数据
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("TradeDate", paramMap.get("TradeDate"));
//			w.eq("SerialNo", paramMap.get("SerialNo"));
//		}).set(paramMap).execute();		
//		return count;
//	}

	
}

