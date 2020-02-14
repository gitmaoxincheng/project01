package cn.com.agree.huanan.ap.al.csitrd.insure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.insure.dao.InsureDao;
import cn.com.agree.huanan.ap.al.csitrd.insure.po.Insure;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 贵金属Service层
 * @author jiangzf
 */
@Service
public class InsureService {
	@Autowired
	Logger logger;
	@Autowired
	InsureDao InsureManager;
	@Autowired 
	DbOperator dbo;
	
	/**
	 * 增加动作
	 * @param fls 理财保险业务交易po
	 */
	public void addInsure(Insure insure) {
		logger.info("新增一条理财保险业务交易记录");
		int count = InsureManager.addInsure(insure);
		if(count > 0) {
			dbo.commit();
			logger.info("新增成功");
		}else {
			dbo.rollback();
			logger.info("新增失败...事务回滚");
		}
	}
	
	/**
	 * 修改动作
	 * @param fls 理财保险业务交易po
	 */
	public void editInsure(Insure insure) {
		logger.info("更新理财保险业务交易记录：交易日期-->"+insure.getTradeDate()+" 平台交易流水-->"+insure.getSerialNo());
		int count = InsureManager.editInsure(Insure.getMap(insure));
		if(count == 1) {
			dbo.commit();
			logger.info("修改成功");
		}else {
			dbo.rollback();
			logger.info("修改失败");
		}
	}
	
}
