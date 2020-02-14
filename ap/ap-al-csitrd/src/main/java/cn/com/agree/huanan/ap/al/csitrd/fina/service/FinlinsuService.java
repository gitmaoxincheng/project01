package cn.com.agree.huanan.ap.al.csitrd.fina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.fina.dao.FinlinsuDao;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 理财保险业务Service层
 * @author jiangzf
 */

@Service
public class FinlinsuService {
	@Autowired
	Logger logger;
	@Autowired
	FinlinsuDao FlsManager;
	@Autowired 
	DbOperator dbo;
	
	/**
	 * 增加动作
	 * @param fls 理财保险业务交易po
	 */
	public void addFinlinsu(Tradfinamain fls) {
		logger.info("新增一条理财保险业务交易记录");
		int count = FlsManager.addFinlinsu(Tradfinamain.getMap(fls));
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
	public void editFinlinsu(Tradfinamain fls) {
		logger.info("更新理财保险业务交易记录：交易日期-->"+fls.getTradeDate()+" 平台交易流水-->"+fls.getSerialNo());
		int count = FlsManager.updateFinlinsu(Tradfinamain.getMap(fls));
		if(count == 1) {
			dbo.commit();
			logger.info("修改成功");
		}else {
			dbo.rollback();
			logger.info("修改失败");
		}
	}
}
