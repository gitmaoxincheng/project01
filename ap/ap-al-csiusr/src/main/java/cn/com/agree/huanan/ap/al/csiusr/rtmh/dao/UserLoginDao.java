package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.RTMHTradInfo;

public interface UserLoginDao {

	/**
	 * 根据渠道信息代码查询渠道信息
	 * @param chnlCode
	 * @return 渠道信息
	 */
	String queryUserNo(String scrSysId);
	
	
	
	/**
	 * 新增用户账号
	 * @param UserMap 用户对象
	 * @return 
	 */
	int insertUserNo(RTMHTradInfo RtmhInfo);

	/**
	 * 更新用户账号
	 * @param UserMap 用户对象
	 * @return 
	 */
	public int updateUserNo(Map<String,Object> map);

	
}
