package cn.com.agree.huanan.ap.al.csiusr.rtmh.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.DevcInfo;

public interface UserRegisterDao {

	
	/**
	 * 获取设备信息
	 * devNo 设备号
	 */
	public DevcInfo selectDevcInfo(String devno,String applyid,String admbrno);
	
	
	/**
	 * 更新设备信息
	*/
	public DevcInfo updateInfo(String devno, String applyid, String pinkey, String status);


	/**
	 * 根据设备号修改设备信息
	*/
	int updateDevcInfoNo(Map<String, Object> devcInfo);

	/**
	 * 查询 设备号
	*/
	DevcInfo updateDevno(String devno);

	/**
	 * 更新设备认证码
	*/
	int updateDevcAuthcode(Map<String, Object> devcInfo);
	
	
}
