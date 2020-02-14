package cn.com.agree.huanan.ap.al.csitrd.nbnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.nbnt.dao.NbntDao;
import cn.com.agree.huanan.ap.al.csitrd.nbnt.po.Nbnt;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 贵金属Service层
 * @author jiangzf
 */

@Service
public class NbntService {
	@Autowired
	Logger logger;
	@Autowired
	NbntDao NbntManager;
	@Autowired 
	DbOperator dbo;
	
	/**
	 * 增加动作
	 * @param fls 理财保险业务交易po
	 */
	public void addNbnt(Nbnt nbnt) {
		logger.info("新增一条理财保险业务交易记录");
		int count = NbntManager.addNbnt(nbnt);
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
	public void editNbnt(Nbnt nbnt) {
		logger.info("更新理财保险业务交易记录：交易日期-->"+nbnt.getTradeDate()+" 平台交易流水-->"+nbnt.getSerialNo());
		int count = NbntManager.editNbnt(Nbnt.getMap(nbnt));
		if(count == 1) {
			dbo.commit();
			logger.info("修改成功");
		}else {
			dbo.rollback();
			logger.info("修改失败");
		}
	}
	
	
}
