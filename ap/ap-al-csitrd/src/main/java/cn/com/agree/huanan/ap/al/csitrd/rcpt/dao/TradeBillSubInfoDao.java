package cn.com.agree.huanan.ap.al.csitrd.rcpt.dao;

import java.util.List;
import java.util.Map;


import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillSubInfo;

/**
 * 存储单据子表
 * @author WB
 *
 */
public interface TradeBillSubInfoDao {
	/**
	 * 登记单据
	 * @param tradeBillInfo 单据子实体
	 */
	public int insertTradeBillInfo(TradeBillSubInfo tradeBillSubInfo);
	/**
	 * 更新单据
	 * @param map 单据子信息
	 */
	public int updateTradeBillSubInfo(Map<String,Object> map);
	/**
	 * 查询单据字表根据单据号
	 * @param map 单据子信息
	 */
	public List<Map<String, Object>> queryTradeBillSubInfos(String bill);
	
	/**
	 * 根据单据号查找字段
	 * @param bill
	 * @return
	 */
	public List<Map<String, Object>> selectBillSubInfo(String bill);
	/**
	 * 根据单据号和单据类型查找单据字表
	 * @param bill
	 * @return
	 */
	public TradeBillSubInfo selectBillSubInfoByBillAndType(String bill,String type);
	/**
	 * 根据单据号查询单据详情列表
	 */
	public List<Map<String, Object>> selectBillSubInfoDetail(String bill);
	/**
	 * 
	 * @param status 单据字表交易状态
	 * @return
	 */
	public List<Map<String, Object>> queryBillSubInfosByStatus(String bill,String status);
}
