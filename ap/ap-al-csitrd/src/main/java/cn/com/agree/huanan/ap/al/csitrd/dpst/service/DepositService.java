package cn.com.agree.huanan.ap.al.csitrd.dpst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.dpst.dao.TraInfoDpstDao;
import cn.com.agree.huanan.ap.al.csitrd.dpst.exception.TradeSignInfoAddException;
import cn.com.agree.huanan.ap.al.csitrd.dpst.po.TraInfoDpst;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 存款类业务服务层
 *
 */
@Service
public class DepositService {
	@Autowired Logger logger;
	@Autowired TraInfoDpstDao dpstDao;
	@Autowired DbOperator dbo;
	
	/**
	 * 添加登记信息到存款业务登记簿
	 * @param traInfoDpst 存款业务登记簿实体对象
	 */
	public void addTrainfoDpst(TraInfoDpst traInfoDpst) {
		int count = dpstDao.insertTraInfoDpst(traInfoDpst);
		if(count!=1) {
			throw new TradeSignInfoAddException("新增失败！");
		}
		dbo.commit();	
		
	}
	

}
