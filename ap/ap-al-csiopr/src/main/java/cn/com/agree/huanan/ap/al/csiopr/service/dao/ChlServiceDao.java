package cn.com.agree.huanan.ap.al.csiopr.service.dao;


import cn.com.agree.huanan.ap.al.csiopr.service.po.ChlService;

public interface ChlServiceDao {
	/**
	 * 根据模板码、应用码，查询渠道服务
	 * @param svcCode 服务码
	 * @param scnCode 场景码
	 * @return  渠道服务
	 */
    public ChlService selectChlService(String svcCode, String scnCode);
}
