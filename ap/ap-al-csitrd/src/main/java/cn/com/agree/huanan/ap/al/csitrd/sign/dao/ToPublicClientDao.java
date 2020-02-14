package cn.com.agree.huanan.ap.al.csitrd.sign.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToPublicClient;
import cn.com.agree.huanan.ap.al.csitrd.sign.po.ToSubClient;

public interface ToPublicClientDao {
	
	/**
	 * 新增对公客户信息
	 * @param publicClientInfo 对公客户信息实体类
	 * @return 
	 */
	int insertPublicClientInfo(ToPublicClient publicClientInfo);
	
	/**
	 * 修改对公客户信息
	 * @param map 签约信息map
	 * @return
	 */
	int updatePublicClientInfo(Map<String,Object> map);
	
}
