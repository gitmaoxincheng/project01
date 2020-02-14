package cn.com.agree.huanan.ap.al.csitrd.paym.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.PaySubInfo;
/**
 * 支付结算业务登记簿子表Dao
 * @author ZS
 *
 */
public interface PaySubInfoDao {
	
	/**
	 * 新增支付结算业务子信息
	 * @param signInfo 支付结算业务子信息实体类
	 * @return 
	 */
	int insertPaySubInfo(PaySubInfo paySubInfo);
	
	/**
	 * 修改支付结算业务子信息
	 * @param map 支付结算业务子信息map
	 * @return
	 */
	int updatePaySubInfo(Map<String,Object> map);
}
