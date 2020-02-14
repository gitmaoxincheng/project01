package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToSubClient;

public interface ToSubClientDao {

	
	/**
	 * 新增对公客户信息登记簿子表信息
	 * @param subClientInfo 对公客户信息实体类
	 * @return 
	 */
	int insertSubClientInfo(ToSubClient tosubClient);
	
	/**
	 * 修改对公客户信息登记簿子表信息
	 * @param map 
	 * @return
	 */
	int updateSubClientInfo(Map<String,Object> map);
}
