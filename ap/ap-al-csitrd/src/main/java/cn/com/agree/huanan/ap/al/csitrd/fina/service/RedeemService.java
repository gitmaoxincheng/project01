package cn.com.agree.huanan.ap.al.csitrd.fina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.fina.dao.FinlinsuDao;
import cn.com.agree.huanan.ap.al.csitrd.fina.dao.RedeemDao;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;


/**
 * 理财产品赎回服务类
 * @author jiangzf
 */
@Service
public class RedeemService {
	
	@Autowired
	Logger logger;
	@Autowired
	RedeemDao reDeemManager;
	@Autowired 
	DbOperator dbo;
	
	/**
	 * 增加一条赎回记录
	 */
	public void addRedeemRecord(Tradfinamain reDeem) {
		logger.info("增加一条理财产品赎回记录");
		int count = reDeemManager.addRedeemRecord(reDeem);
		if(count > 0) {
			dbo.commit();
			logger.info("新增成功");
		}else {
			dbo.rollback();
			logger.info("新增失败...事务回滚");
		}
	}
	
	
	/**
	 * 更新产品赎回记录
	 */
	public void updataRedeemRecord(Tradfinamain reDeem) {
		logger.info("更新理财保险业务交易记录：交易日期-->"+reDeem.getTradeDate()+" 平台交易流水-->"+reDeem.getSerialNo());
		int count = reDeemManager.updataRedeemRecord(reDeem);
		if(count == 1) {
			dbo.commit();
			logger.info("修改成功");
		}else {
			dbo.rollback();
			logger.info("修改失败");
		}
	}
}
