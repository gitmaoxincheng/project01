package cn.com.agree.huanan.ap.al.csitrd.voch.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.voch.dao.TradeinfoFeeDaoImpl;
import cn.com.agree.huanan.ap.al.csitrd.voch.exception.InsertTradeinfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.voch.exception.UpdateTradeinfoFailException;
import cn.com.agree.huanan.ap.al.csitrd.voch.po.Tradeinfo;
import cn.com.agree.huanan.ap.al.csitrd.voch.po.TradeinfoFee;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 
 * @author HZP
 *	费用信息登记簿服务操作
 */
@Service
public class TradeinfoFeeService {
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired TradeinfoFeeDaoImpl tradeinfoFeeDao;
	//插入数据
		public int insertTradeinfoFee(TradeinfoFee tradeinfoFee) {
			logger.info("登记费用信息登记簿开始");
			int count = tradeinfoFeeDao.insertTradeinfoFee(tradeinfoFee);
			if(count < 1) {
				logger.error("登记费用信息登记簿失败");
				dbo.rollback();
				logger.info("登记费用信息登记簿失败...事务回滚");
				throw new InsertTradeinfoFailException("登记费用信息登记簿失败");
			}
			dbo.commit();
			logger.info("登记费用信息登记簿成功");
			return count;
		}
		
		//更新数据
		public int updateTradeinfo(Map<String, Object> paramMap) {
			logger.info("更新费用信息登记簿开始");
			int count = tradeinfoFeeDao.updateTradeinfoFee(paramMap);
			if(count < 1) {
				logger.error("更新费用信息登记簿失败");
				dbo.rollback();
				logger.info("更新费用信息登记簿sql语句失败...事务回滚");
				throw new UpdateTradeinfoFailException("更新费用信息登记簿sql语句失败");
			}
			dbo.commit();
			logger.info("更新费用信息登记簿成功");
			return count;
		}
}
