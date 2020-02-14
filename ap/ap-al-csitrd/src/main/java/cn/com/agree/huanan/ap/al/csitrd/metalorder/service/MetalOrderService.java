package cn.com.agree.huanan.ap.al.csitrd.metalorder.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.metalorder.dao.TradeFinlinsuDao;
import cn.com.agree.huanan.ap.al.csitrd.metalorder.exception.TradeFinlinsuInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.metalorder.exception.TradeFinlinsuInfoUpdateException;
import cn.com.agree.huanan.ap.al.csitrd.metalorder.po.TradeFinlinsuInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 登记理财保险业务服务层
 * @author bodadmin
 *
 */
@Service
public class MetalOrderService {
	
	@Autowired
	Logger logger;
	@Autowired
	TradeFinlinsuDao tradeFinlinsuDao;
	@Autowired DbOperator dbo;
	
	/**
	 * 登记理财保险业务记录入库
	 * @param tradeFinlinsuInfo
	 */
	public int insertTradeinfo(TradeFinlinsuInfo tradeFinlinsuInfo) {
		logger.info("登记理财保险业务登记保存接口开始");
 		int count = tradeFinlinsuDao.insertTradeFinlinsuInfo(tradeFinlinsuInfo);
 		if(count < 1) {
 			logger.error("登记理财保险业务登记保存失败");
 			dbo.rollback();
 			throw new TradeFinlinsuInfoAddException("登记理财保险业务登记保存失败");
 		}
 		dbo.commit();
 		
 		return count;
	}
	
	/**
	 * 登记理财保险业务更新信息
	 * @param paramMap
	 * @return
	 */
	public int updateTradeFinlinsuInfo(Map<String, Object> paramMap) {
		
		logger.info("登记理财保险业务登记更新接口开始");
		int count = tradeFinlinsuDao.updateByDate(paramMap);
		if(count < 1) {
			logger.error("登记理财保险业务登记更新失败");
			dbo.rollback();
			throw new TradeFinlinsuInfoUpdateException("登记理财保险业务登记更新失败");
		}
		dbo.commit();
		
		return count;
	}
}
