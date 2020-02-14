package cn.com.agree.huanan.ap.al.csitrd.fina.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.fina.dao.TradfinamainDao;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeRegisterException;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Questionmain;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradriskmain;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class BankAccountService {

	@Autowired Logger logger;
	@Autowired TradfinamainDao tradfinamainDao;
	@Autowired DictDao dictDao;
	@Autowired DbOperator dbo;
	
	
	/**
	 * 登记到理财保险业务登记簿
	 * @param Tradfinamain 
	 */
	public void insertFundTransition(Tradfinamain tradfinamain) {
		logger.info("登记理财保险业务登记簿开始");
		int count=tradfinamainDao.tradeinfoInsert(tradfinamain);
		if (count == 1) {
			dbo.commit();
			logger.info("登记理财保险业务登记簿结束");
		} else {
			dbo.rollback();
			logger.error("登记理财保险业务登记簿失败");
			throw new TradeRegisterException("登记理财保险业务登记簿失败");
		}
	}
	/**
	 * 更新理财保险业务登记簿
	 * @param  Map
	 */
	public void updateFundTransition(Map<String, Object> paramMap) {
		logger.info("更新理财保险业务登记簿开始");
		int count=tradfinamainDao.tradeinfoUpdate(paramMap);
		if (count == 1) {
			dbo.commit();
			logger.info("更新理财保险业务登记簿结束");
		} else {
			dbo.rollback();
			logger.error("更新理财保险业务登记簿失败");
			throw new TradeRegisterException("更新理财保险业务登记簿失败");
		}
	}
	
	/**
	 * 登记风险评估登记簿
	 * @param tradriskmain
	 */
	public void insertTradeRisk(Tradriskmain tradriskmain) {
		logger.info("登记风险评估登记簿开始");
		int count=tradfinamainDao.traderiskInsert(tradriskmain);
		if (count == 1) {
			dbo.commit();
			logger.info("登记风险评估登记簿结束");
		} else {
			dbo.rollback();
			logger.error("登记风险评估登记簿失败");
			throw new TradeRegisterException("登记风险评估登记簿失败");
		}
	}
	/**
	 * 更新风险评估登记簿
	 * @param tradriskmain
	 */
	public void updatetTradeRisk(Map<String, Object> paramMap) {
		logger.info("更新风险评估登记簿开始");
		int count=tradfinamainDao.traderiskUpdate(paramMap);
		if (count == 1) {
			dbo.commit();
			logger.info("更新风险评估登记簿结束");
		} else {
			dbo.rollback();
			logger.error("更新风险评估登记簿失败");
			throw new TradeRegisterException("更新风险评估登记簿失败");
		}
	}
	
	
	/**
	 * 理财账户登记交易信息登记到理财保险业务登记簿
	 * @param Tradfinamain 
	 */
	public void insertFinanAccount(Tradfinamain tradfinamain) {
		logger.info("理财账户登记交易信息登记开始");
		int count=tradfinamainDao.tradeinfoInsert(tradfinamain);
		if (count == 1) {
			dbo.commit();
			logger.info("理财账户登记交易信息登记结束");
		} else {
			dbo.rollback();
			logger.error("理财账户登记交易信息登记失败");
			throw new TradeRegisterException("理财账户登记交易信息登记失败");
		}
	}
	/**
	 * 理财账户登记交易信息更新
	 * @param Tradfinamain 
	 */
	public void updateFinanAccount(Map<String, Object> paramMap) {
		logger.info("理财账户登记交易信息更新开始");
		int count=tradfinamainDao.tradeinfoUpdate(paramMap);
		if (count == 1) {
			dbo.commit();
			logger.info("理财账户登记交易信息更新结束");
		} else {
			dbo.rollback();
			logger.error("理财账户登记交易信息更新失败");
			throw new TradeRegisterException("理财账户登记交易信息更新失败");
		}
	}
	
	
	
	
	
	
	/**
	 * 插入评估问卷调查问题
	 * @param questionlist
	 */
	public void insertFinanceQuestion(List<Questionmain> questionlist) {
		logger.info("插入评估问卷调查开始");
		logger.info("插入前先清空评估问卷调查表");
		int result=1;
		int count = tradfinamainDao.deletequestionSuervey();
		if(count>0) {
			for (int i = 0; i < questionlist.size(); i++) {
				int count2 = tradfinamainDao.insertquestionSuervey(questionlist.get(i));
				if(count2==0) {
					result=0;
					break;
				}
			}
		}
		if(count>0&&result==1) {
			dbo.commit();
			logger.info("插入评估问卷调查问题结束");
		}else {
			dbo.rollback();
			logger.info("插入评估问卷调查问题失败");
			throw new TradeRegisterException("插入评估问卷调查问题失败");
		}
		
	}
	
	
	
	public Map<String,Object> questionnaireSuerveySelect(String clienttype,String clientgroup,String papertype,String paperno){
		logger.info("评估问卷查询开始");
		Map<String, Object> result = tradfinamainDao.selectquestionnaireSuervey(clienttype,clientgroup,papertype,paperno);
		if(result==null) {
			throw new TradeRegisterException("查不到对应记录");
		}
		logger.info("评估问卷查询结束");
		return result;
		
	}
	
	
	public String queryFilePath(String keyName) {
		//查询文件生成路径
		logger.info("查询文件生成路径");
		return (String) dictDao.queryPath(keyName).get("keyValue");  //文件存放目录
	}
	
	
}
