package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RTMHTradInfo;

/**
 * 其它P（微网点、回单机、排队机）流水表Dao层
 *
 */
public interface BillStampDao {

	/**
	 * 根据登录账号 查询账单信息
	 * @param  serialNo 账单流水
	 */
	public RTMHTradInfo queryTrad(String serialNo);

	/**
	 * 新增用户
	 * @param  rtmhtradflowMap 用户信息
	 */
	public int insertTrad(Map<String, Object> rtmhtradflowMap);
	
}
