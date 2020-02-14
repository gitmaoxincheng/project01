package cn.com.agree.huanan.ap.al.csitrd.fina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.fina.dao.FundDao;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 基金产品服务类
 * @author jiangzf
 */
@Service
public class FundService {
	@Autowired
	Logger logger;
	@Autowired
	FundDao fundDao;
	@Autowired 
	DbOperator dbo;
	
	/**
	 * 开通基金交易登记--定期定额开通交易
	 * @param Tfina
	 */
	public void bookFund(Tradfinamain Tfina) {
		logger.info("增加一条开通基金交易登记");
		int count = fundDao.addFundTrade(Tfina);
		if(count > 0) {
			dbo.commit();
			logger.info("新增成功");
		}else {
			dbo.rollback();
			logger.info("新增失败...事务回滚");
		}
	}
	
	/**
	 * 修改基金交易登记--定期定额修改交易
	 * @param Tfina
	 */
	public void updataFund(Tradfinamain Tfina) {
		logger.info("更新理财保险业务交易记录：交易日期-->"+Tfina.getTradeDate()+" 平台交易流水-->"+Tfina.getSerialNo());
		int count = fundDao.updataFundTrade(Tfina);
		if(count == 1) {
			dbo.commit();
			logger.info("修改成功");
		}else {
			dbo.rollback();
			logger.info("修改失败");
		}
	}
	
	/**
	 * 基金交易登记--定期定额关闭交易
	 * @param Tfina
	 */
	public void closeFund(Tradfinamain Tfina) {
		logger.info("增加一条关闭基金交易登记");
		int count = fundDao.addFundTrade(Tfina);
		if(count > 0) {
			dbo.commit();
			logger.info("新增成功");
		}else {
			dbo.rollback();
			logger.info("新增失败...事务回滚");
		}
	}
}
