package cn.com.agree.huanan.ap.al.csitrd.rcpt.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillImageInfo;

/**
 * 存储单据图片表
 * @author WB
 *
 */
public interface TradeBillImageInfoDao {
	/**
	 * 登记单据
	 * @param tradeBillInfo 单据图片实体
	 */
	public int insertTradeBillImageInfo(TradeBillImageInfo tradeBillImageInfo);
	/**
	 * 批量插入单据图片表
	 * @param tradeBillInfo 单据图片实体
	 */
	public int insertBatchTradeBillImageInfo(List<Map<String,Object>> list,String bill);
	/**
	 * 根据单据号和类型更新单据图片表
	 * @param map 单据图片信息
	 */
	public int updateTradeBillImageInfo(Map<String,Object> map);
	/**
	 * 查询单据图片
	 * @param map 单据图片信息
	 */
	public List<TradeBillImageInfo> queryTradeBillImageInfos(String bill);
	/**
	 * 
	 * @param bill 单据号
	 * @param type 图片类型
	 * @return  单据图片信息
	 */
	public TradeBillImageInfo queryTradeBillImageInfoByType(String bill,String type);
	
	/**
	 * 根据单据号查找字段
	 * @param bill
	 * @return
	 */
	public List<Map<String, Object>> selectBillImageInfo(String bill);
	/**
	 * 根据单据号查找图片和日期
	 * @param bill
	 * @return
	 */
	public List<Map<String, Object>> selectBillImageInfosDate(String bill);
}
