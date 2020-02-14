package cn.com.agree.huanan.ap.al.csitrd.rcpt.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

/**
 * 存储单据表
 * @author WB
 *
 */
public interface TradeBillInfoDao {
	/**
	 * 登记单据
	 * @param tradeBillInfo 单据实体
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public int insertTradeBillInfo(TradeBillInfo tradeBillInfo);
	/**
	 * 更新单据
	 * @param map 单据信息
	 */
	public int updateTradeBillInfo(Map<String,Object> map);  
	
	/**
	 * 根据单据号查询主单据
	 * @param map 单据信息
	 */
	public TradeBillInfo queryMainTradeBillInfoByBill(String bill);
	
	/**
	 * 根据条件查询单据列表
	 * @param map
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public HashMap<String, Object> selectTradeBillInfo(Map<String, String> map) throws SQLException, IOException;
}
