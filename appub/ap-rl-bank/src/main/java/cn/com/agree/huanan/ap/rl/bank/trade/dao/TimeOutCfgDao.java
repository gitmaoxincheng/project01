package cn.com.agree.huanan.ap.rl.bank.trade.dao;

import cn.com.agree.huanan.ap.rl.bank.trade.po.TimeOutCfg;

/**
 * 超时交易配置表Dao接口
 * 
 * @author huangchaopeng
 *
 */
public interface TimeOutCfgDao {

	/**
	 * 查询超时交易信息
	 * 
	 * @param tradecode
	 *            交易码
	 * @return
	 */
	TimeOutCfg queryTimeout(String tradecode);
}
