package cn.com.agree.huanan.ap.al.csitrd.paym.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.PayInfo;

/**
 * 支付结算业务登记簿dao
 * @author MAOW
 *
 */
public interface PayInfoDao {
	
	/**
	 * 新增支付结算业务信息
	 * @param payInfo 支付结算业务信息
	 * @return
	 */
	public int addPayInfo(PayInfo payInfo);
	
	/**
	 * 更新支付结算业务信息
	 * @param payInfo 支付结算业务信息
	 * @return
	 */
	public int updatePayInfo(Map<String, Object> paramMap);
	
	/**
	 * 查询支付结算业务信息
	 * @param tradeDate 交易日期
	 * @param serialNo  交易流水
	 * @return
	 */
	public Map<String,Object> selectPayInfo(String tradeDate,String serialNo);

}
