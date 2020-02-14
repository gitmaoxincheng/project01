package cn.com.agree.huanan.ap.al.csitrd.cert.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.cert.po.TradeInfoCert;

/**
 * 凭证信息登记簿dao
 * @author lanshaojun
 *
 */
public interface TradeInfoCertDao {

	/**
	 * 插入凭证信息登记簿数据
	 * @param accidentHandle 凭证信息登记簿bean
	 * @return 操作状态
	 */
	int insertTradeInfoCert(TradeInfoCert tradeInfoCert);

	/**
	 * 更新凭证信息登记簿数据
	 * @param paramMap 核心返回值map
	 * @return 操作状态
	 */
	int updateTradeInfoCert(Map<String, Object> paramMap);
	
	/**
	 * 通用冲正流水查询
	 * @param startdate 起始日期
	 * @param enddate	截止日期
	 * @param oriserino 原前平台流水
	 * @param trantlrno 交易柜员
	 * @param pageflag  页码
	 * @param maxnum    每页最多记录数
	 * @return 查询结果
	 */
	Map<String,Object> selectGeneralFlush(String startdate,String enddate,String oriserino,String trantlrno,Integer pageflag,Integer maxnum);
	
	/**
	 * 柜员尾箱凭证查询
	 * @param tradedate 平台交易日期
	 * @param serialNo  平台流水
	 * @return 查询结果
	 */
	Map<String,Object> selectVochDetails(String tradedate,String serialno);

	
	/**
	 * 单独查询
	 * @param tradedate
	 * @param serialno
	 * @return
	 */
	TradeInfoCert getCert(String tradedate, String serialno);

}
