package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.UserInfo;

public interface RtmhUserDao {

	
	/**
	 * 回单机用户登录
	 * tlid 柜员号
	 * persoid 员工号
	 * orgno 机构号
	 * pwd 柜员密码
	 */
	
	public UserInfo queryUserInfo(String tlid);
	
}
