package cn.com.agree.huanan.ap.al.csitrd.rcpt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.rcpt.dao.TradeBillSubInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.InsertTradeBillSubFailException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.exception.UpdateTradeBillSubFailException;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillSubInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;



/**
 * 单据子表服务层
 * @author WB
 *
 */
@Service
public class TradeBillSubInfoService {
	@Autowired
	private TradeBillSubInfoDao tradeBillSubDao;
	@Autowired
	DbOperator dbo;
	@Autowired
	Logger logger;
	//插入数据
		public void addTradeBillInfo(TradeBillSubInfo tradeBillSubInfo) {	
			logger.info("登记对单据子表开始");
			 int count=tradeBillSubDao.insertTradeBillInfo(tradeBillSubInfo);
			 if (count == 1) {
					dbo.commit();
					logger.info("登记到单据子表开始结束");
				} else {
					dbo.rollback();
					logger.info("登记到单据子表失败...事务回滚");
					throw new InsertTradeBillSubFailException("登记到单据子表失败");
				}
		}

		public void updateTradeBillInfo(Map<String,Object> map ) {
			logger.info("更新对单据子表开始");		
			int count =tradeBillSubDao.updateTradeBillSubInfo(map);		
			if(count == 0) {
				dbo.rollback();
				logger.info("更新单据子表失败!");
				throw new UpdateTradeBillSubFailException("更新到单据子表失败");
			}
			dbo.commit();		
			logger.info("更新单据子表结束");
		}
		/*public List<Map<String, Object>> queryTradeBillSubInfos(String bill) {
			List<Map<String, Object>> billSubs=tradeBillSubDao.queryTradeBillSubInfos(bill);
			return billSubs;
		}*/
		public TradeBillSubInfo queryTradeBillSubInfoByBillAndType(String bill,String type) {
			return tradeBillSubDao.selectBillSubInfoByBillAndType(bill, type);
		}
		public List<Map<String, Object>> queryTradeBillSubInfosByStatus(String bill,String status) {
			return tradeBillSubDao.queryBillSubInfosByStatus(bill, status);
		}
}
