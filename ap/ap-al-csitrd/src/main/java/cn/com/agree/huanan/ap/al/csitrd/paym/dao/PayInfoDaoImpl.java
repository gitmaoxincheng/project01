package cn.com.agree.huanan.ap.al.csitrd.paym.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.PayInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

/**
 * 支付结算业务登记簿daoImpl
 * @author MAOW
 *
 */
@Component
public class PayInfoDaoImpl implements PayInfoDao{
	public static String TABLE = "TRADEINFO_PAY_MAIN";
	@Autowired DbOperator dbo;

	@Override
	public int addPayInfo(PayInfo payInfo) {
		// 插入付结算业务信息
		int count = 0;
		if(null != payInfo) {
			count = dbo.getInserter().insertInto(TABLE).values(PayInfo.getMap(payInfo)).execute();
		}
		return count;
	}

	@Override
	public int updatePayInfo(Map<String, Object> paramMap) {
		// 插入付结算业务信息
		if(null == paramMap) {
			throw new ApIllegalParamException("集合为空");
		}
		if(null == paramMap.get("tradeDate") || null == paramMap.get("serialNo")) {
			throw new ApIllegalParamException("数据异常");
		}
		int count = dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		return count;
	}

	@Override
	public Map<String, Object> selectPayInfo(String tradeDate, String serialNo) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE).select("TRADEDATE").select("SERIALNO").where((w)->{
			// 查询条件
			w.eq("TRADEDATE", tradeDate); //交易日期
			w.eq("SERIALNO", serialNo); //交易流水
			w.eq("RESPSTS", "S"); //状态
			w.eq("SCENECODE", "PAYM0013"); //场景码为收支清分复核
			
		}).fetchOne();

		return para;
	}
	
	

}
