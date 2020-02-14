package cn.com.agree.huanan.ap.al.csiusr.rtmh.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.dao.RtmhUserDao;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.UserInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;


@Service
public class LoginService {

	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired RtmhUserDao rtmhUserDao;
	
	
	/**
	 * 回单机用户登录
	 */
	public Map<String, Object> loginRtmhUser(String tlid){
		//用户查询
		UserInfo userInfo = rtmhUserDao.queryUserInfo(tlid);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("tlid", userInfo.getTlId());
		resultMap.put("persoid", userInfo.getPersId());
		resultMap.put("orgno", userInfo.getOrgNo());
		resultMap.put("pwd", userInfo.getPwd());
		
		return resultMap;
		
	}
	
}
