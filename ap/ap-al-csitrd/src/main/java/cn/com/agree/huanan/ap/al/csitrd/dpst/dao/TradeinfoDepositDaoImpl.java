package cn.com.agree.huanan.ap.al.csitrd.dpst.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.dpst.po.TraInfoDpst;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**	
 * 
 * @author HZP
 *	存款业务登记簿Dao实现类
 */
@Component
public class TradeinfoDepositDaoImpl implements TradeinfoDepositDao {
	private static String TABLE = "tradeinfo_deposit_main";
	public final Logger logger = Logger.getLogger(TradeinfoDepositDaoImpl.class);
	@Autowired
	DbOperator dbo;
	//登记到存款业务登记簿
	@Override
	public int insertTraInfoDpst(TraInfoDpst traInfoDpst) {
		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
		return count;
	}
	//更新到存款业务登记簿
	@Override
	public int updateTraInfoDpst(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		return count;
	}
//=======================以下实现废弃==========================================
//	/**
//	 * 新增-定活互转-通知存款支取
//	 */
//	@Override
//	public int insertNoticeMoneyWay(TraInfoDpst traInfoDpst) {
//		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
//		return count;
//	}
//	/**
//	 * 更新-定活互转-通知存款支取
//	 */
//	@Override
//	public int updateNoticeMoneyWay(Map<String, Object> paramMap) {
//		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
//			throw new ApIllegalParamException("tradeDate");	
//		}
//		
//		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
//			throw new ApIllegalParamException("serialNo");	
//		}
//		
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("tradeDate", paramMap.get("tradeDate"));
//			w.eq("serialNo", paramMap.get("serialNo"));
//		}).set(paramMap).execute();
//		return count;
//	}
//	/**
//	 * 新增-定活互转-定期支取
//	 */
//	@Override
//	public int insertRegularWay(TraInfoDpst traInfoDpst) {
//		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
//		return count;
//	}
//	/**
//	 * 更新-定活互转-定期支取
//	 */
//	@Override
//	public int updateRegularWay(Map<String, Object> paramMap) {
//		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
//			throw new ApIllegalParamException("tradeDate");	
//		}
//		
//		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
//			throw new ApIllegalParamException("serialNo");	
//		}
//		
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("tradeDate", paramMap.get("tradeDate"));
//			w.eq("serialNo", paramMap.get("serialNo"));
//		}).set(paramMap).execute();
//		return count;
//	}
//	/**
//	 * 新增-大额存单预约购买
//	 */
//	@Override
//	public int insertLargeAmount(TraInfoDpst traInfoDpst) {
//		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
//		return count;
//	}
//	/**
//	 * 更新-大额存单预约购买
//	 */
//	@Override
//	public int updateLargeAmount(Map<String, Object> paramMap) {
//		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
//			throw new ApIllegalParamException("tradeDate");	
//		}
//		
//		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
//			throw new ApIllegalParamException("serialNo");	
//		}
//		
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("tradeDate", paramMap.get("tradeDate"));
//			w.eq("serialNo", paramMap.get("serialNo"));
//		}).set(paramMap).execute();
//		return count;
//	}
//	/**
//	 * 新增-大额存单支取
//	 */
//	@Override
//	public int insertLargeAmountGet(TraInfoDpst traInfoDpst) {
//		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
//		return count;
//	}
//	/**
//	 * 更新-大额存单支取
//	 */
//	@Override
//	public int updateLargeAmountGet(Map<String, Object> paramMap) {
//		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
//			throw new ApIllegalParamException("tradeDate");	
//		}
//		
//		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
//			throw new ApIllegalParamException("serialNo");	
//		}
//		
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("tradeDate", paramMap.get("tradeDate"));
//			w.eq("serialNo", paramMap.get("serialNo"));
//		}).set(paramMap).execute();
//		return count;
//	}
//	/**
//	 * 新增-结构性存款认购
//	 */
//	@Override
//	public int insertStructMoney(TraInfoDpst traInfoDpst) {
//		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
//		return count;
//	}
//	/**
//	 * 更新-结构性存款认购
//	 */
//	@Override
//	public int updateStructMoney(Map<String, Object> paramMap) {
//		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
//			throw new ApIllegalParamException("tradeDate");	
//		}
//		
//		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
//			throw new ApIllegalParamException("serialNo");	
//		}
//		
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("tradeDate", paramMap.get("tradeDate"));
//			w.eq("serialNo", paramMap.get("serialNo"));
//		}).set(paramMap).execute();
//		return count;
//	}
//	
//	/**
//	 * 新增-定活莞家-资金存入
//	 */
//	@Override
//	public int insertDhgjMoney(TraInfoDpst traInfoDpst) {
//		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
//		return count;
//	}
//	/**
//	 * 更新-定活莞家-资金存入
//	 */
//	@Override
//	public int updateDhgjMoney(Map<String, Object> paramMap) {
//		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
//			throw new ApIllegalParamException("tradeDate");	
//		}
//		
//		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
//			throw new ApIllegalParamException("serialNo");	
//		}
//		
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("tradeDate", paramMap.get("tradeDate"));
//			w.eq("serialNo", paramMap.get("serialNo"));
//		}).set(paramMap).execute();
//		return count;
//	}
//	/**
//	 * 新增-定活莞家-资金支取
//	 */
//	@Override
//	public int insertDhgjMoneyGet(TraInfoDpst traInfoDpst) {
//		int count = dbo.getInserter().insertInto(TABLE).values(TraInfoDpst.getMap(traInfoDpst)).execute();
//		return count;
//	}
//	/**
//	 * 更新-定活莞家-资金支取
//	 */
//	@Override
//	public int updateDhgjMoneyGet(Map<String, Object> paramMap) {
//		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
//			throw new ApIllegalParamException("tradeDate");	
//		}
//		
//		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
//			throw new ApIllegalParamException("serialNo");	
//		}
//		
//		int count = dbo.getUpdater().update(TABLE).where(w -> {
//			w.eq("tradeDate", paramMap.get("tradeDate"));
//			w.eq("serialNo", paramMap.get("serialNo"));
//		}).set(paramMap).execute();
//		return count;
//	}
}
