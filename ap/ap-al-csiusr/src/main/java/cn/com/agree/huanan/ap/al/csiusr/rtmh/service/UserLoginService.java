package cn.com.agree.huanan.ap.al.csiusr.rtmh.service;

import java.util.Map; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchHasExistException;
import cn.com.agree.huanan.ap.al.csiusr.branch.exception.BranchInsertException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.dao.UserLoginDao;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.InsertUserLoginException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.UpdateUserLoginException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.UserLoginException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.RTMHTradInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 用户登录Service层
 * @author 
 *
 */
public class UserLoginService {

	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired UserLoginDao userLoginDao;
	
	/**
	 * @summary 查询数据
	 */
	public String queryUserLogin(String scrSysId) {
		logger.info("插入签约信息开始");
		return userLoginDao.queryUserNo(scrSysId);
		
	}
	
	/**
	 * @summary 登记用户
	 * @param RtmhInfo 用户信息
	 * @param UserMap 用户对象
	 * @return
	 */
	public void addUserLogin(RTMHTradInfo RtmhInfo) {
		logger.info("登记用户信息开始");	
		int count = userLoginDao.insertUserNo(RtmhInfo);
		if(count!=1) {
			dbo.rollback();
			logger.info("添加用户信息失败！");
			throw new InsertUserLoginException("添加用户信息失败！");
		}
		dbo.commit();		
		logger.info("登记用户信息结束");		
	}
	
	/**更新用户信息
	 * @return 
	 * @summary 更新用户
	 */
	public void changeUserLogin(Map<String,Object> map ) {
		logger.info("更新用户");		
		int count = userLoginDao.updateUserNo(map);		
		if(count != 1) {
			dbo.rollback();
			logger.info("更新用户信息失败!");
			throw new UpdateUserLoginException("更新用户信息失败!");
		}
		dbo.commit();		
		logger.info("更新用户结束");   
	}
	
}
