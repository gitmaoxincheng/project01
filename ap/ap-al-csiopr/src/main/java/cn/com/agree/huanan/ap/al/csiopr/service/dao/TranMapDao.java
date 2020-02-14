package cn.com.agree.huanan.ap.al.csiopr.service.dao;

import cn.com.agree.huanan.ap.al.csiopr.service.po.TranMapp;

public interface TranMapDao {
	
	/**
	 * 查询交易映射信息
	 * @param svcCodeOut 对外服务码
	 * @param scnCodeOut 对外场景码
	 * @return
	 */
	
    public TranMapp selectTranMap(String svcOutCode, String scnOutCode);
    
}
