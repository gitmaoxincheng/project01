package cn.com.agree.huanan.ap.al.csiopr.mutitable.dao;

import java.util.Map;

/**
 * 渠道认证方式多表查询
 * @author HCP
 *
 */
public interface AtnAuthOperMutiDao {

	/**
	 * 获取渠道认证信息审批记录分页列表
	 * @param pageFlag 页码
	 * @param maxNum 每页最多记录数
	 * @param chnlCode 渠道代码
	 * @param authType 认证方式
	 * @return
	 */
	public Map<String, Object> getAtnAuthOperPageList(int pageFlag, int maxNum, String chnlCode,String authType);
}
