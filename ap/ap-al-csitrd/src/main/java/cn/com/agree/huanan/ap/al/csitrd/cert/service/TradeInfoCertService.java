package cn.com.agree.huanan.ap.al.csitrd.cert.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.cert.dao.TradeInfoCertDao;
import cn.com.agree.huanan.ap.al.csitrd.cert.dao.VochManagerInfoDao;
import cn.com.agree.huanan.ap.al.csitrd.cert.exception.InsertTradeInfoCertFailException;
import cn.com.agree.huanan.ap.al.csitrd.cert.exception.UpdateTradeInfoCertFailException;
import cn.com.agree.huanan.ap.al.csitrd.cert.po.TradeInfoCert;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 凭证信息登记簿service
 * @author lanshaojun
 *
 */
@Service
public class TradeInfoCertService {
	@Autowired DbOperator dbOperator;
	@Autowired TradeInfoCertDao tradeInfoCertDao;
	@Autowired VochManagerInfoDao vochManagerInfoDao;
	private Logger logger = Logger.getLogger(TradeInfoCertService.class);
	
	/**
	 * 插入凭证信息登记簿
	 * @param tradeInfoCert 凭证信息登记簿bean
	 * @return 操作状态
	 */
	public int insertTradeInfoCert(TradeInfoCert tradeInfoCert) {
		int count = tradeInfoCertDao.insertTradeInfoCert(tradeInfoCert);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("插入 凭证信息登记簿失败！");
			throw new InsertTradeInfoCertFailException();
		}
		dbOperator.commit();
		return count;
	}
	
	/**
	 * 更新凭证信息登记簿
	 * @param paramMap 核心返回值map
	 * @return 操作状态
	 */
	public int updateTradeInfoCert(Map<String, Object> paramMap) {
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		int count = tradeInfoCertDao.updateTradeInfoCert(paramMap);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("更新凭证信息登记簿失败！");
			throw new UpdateTradeInfoCertFailException();
		}
		dbOperator.commit();
		return count;
	}
	/**
	 * 通用冲正流水查询
	 * @param startdate 起始日期
	 * @param enddate   截止日期
	 * @param oriserino 原前平台流水
	 * @param trantlrno 交易柜员
	 * @param pageflag  页码
	 * @param maxnum    每页最大查询数
	 * @return  查询结果
	 */
	public Map<String,Object> queryGeneralFlush(String startdate, String enddate, String oriserino, String trantlrno,
			Integer pageflag, Integer maxnum){
		if(pageflag < 1) {
			logger.error("页码不能小于1");
			throw new ApIllegalParamException("页码"+pageflag+"输入有误");
		}
		if (maxnum < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("查询记录数"+maxnum+"不正确");	
		}
		Map<String,Object> result = tradeInfoCertDao.selectGeneralFlush(startdate, enddate, oriserino, trantlrno, pageflag, maxnum);
		if(result==null) {
			throw new ApIllegalParamException("查不到对应记录");
		}
		return result;
	}
	/**
	 * 柜员尾箱凭证信息明细查询
	 * @param tradedate 交易日期
	 * @param serialno  交易流水
	 * @return 查询结果
	 */
	public Map<String,Object> queryVochDetails(String tradedate,String serialno){
		
		Map<String,Object> result = tradeInfoCertDao.selectVochDetails(tradedate, serialno);
		if(result==null) {
			throw new ApIllegalParamException("查不到对应记录");
		}
		List<Map<String,Object>> cert_list = vochManagerInfoDao.selectVochDetials(tradedate, serialno);
		result.put("cert_list",cert_list);
		return result;
	}
}
