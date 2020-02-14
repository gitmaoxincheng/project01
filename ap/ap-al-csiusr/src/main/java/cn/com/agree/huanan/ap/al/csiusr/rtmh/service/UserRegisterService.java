package cn.com.agree.huanan.ap.al.csiusr.rtmh.service;

import java.util.HashMap; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.rtmh.dao.UserRegisterDao;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.InsertInfoException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.exception.QueryInfoException;
import cn.com.agree.huanan.ap.al.csiusr.rtmh.po.DevcInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class UserRegisterService {

	
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	@Autowired UserRegisterDao userRegisterDao;
	
	/**
	 * 设备信息查询
	 */
	public Map<String, Object> queryDevcInfo(String devno,String applyid,String admbrno){
		
		//是否存在设备号
		DevcInfo DEVNO = userRegisterDao.updateDevno(devno);
		if(StringUtils.isEmpty(DEVNO)) {
			logger.error("设备不存在!");
			throw new QueryInfoException("设备不存在!");
		}
		
		DevcInfo devcInfo = userRegisterDao.selectDevcInfo(devno,applyid,admbrno);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("devno", devcInfo.getDevNo());
		resultMap.put("applyid", devcInfo.getApplyId());
		resultMap.put("admbrno",devcInfo.getAdmBrno());
		resultMap.put("termtp",devcInfo.getTermTp());
		resultMap.put("devtype",devcInfo.getDevType());
		resultMap.put("authcode",devcInfo.getAuthCode());
		resultMap.put("devip",devcInfo.getDevIp());
		resultMap.put("status",devcInfo.getStatus());
		resultMap.put("termtp",devcInfo.getTermTp());
		resultMap.put("devtypeno", devcInfo.getDevTypeNo());
		//返回参数
		return resultMap;
		
	}
	
	
	/**
	 * 查询设备信息（先修改/后查询）
	 */
	public Map<String, Object> queryDevcInfo(String devno, String applyid, String pinkey, String status){
		
		DevcInfo devcInfo = userRegisterDao.updateInfo(devno, applyid, pinkey, status);
		//查询更新数据
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("devno", devcInfo.getDevNo());
		resultMap.put("applyid", devcInfo.getApplyId());
		resultMap.put("pinkey", devcInfo.getPinKey());
		resultMap.put("status", devcInfo.getStatus());
		
		//返回参数
		return resultMap;
		
	}
	
	/**
	 * 更新设备信息
	 */
	public int updateDevcInfo(Map<String, Object> devcInfo) {
		//设备信息是否存在
		DevcInfo Info = userRegisterDao.updateDevno(String.valueOf(devcInfo.get("devNo")));
		if (StringUtils.isEmpty(Info)) {
			logger.error("设备号不存在，不能修改信息");
			throw new QueryInfoException("设备号不存在，不能修改信息");
		}
		
		int count = userRegisterDao.updateDevcInfoNo(devcInfo);
		if (count != 1) {
			logger.error("更新设备信息失败");
			dbo.rollback();
			throw new InsertInfoException("更新设备信息失败");
		}
		dbo.commit();
		logger.info("更新设备信息成功！");
		return count;
				
	}
	
	
	/**
	 * 更新认证码
	 */
	public int updateAuthCode(Map<String, Object> devcInfo) {
		//设备信息是否存在
		DevcInfo Info = userRegisterDao.updateDevno(String.valueOf(devcInfo.get("devNo")));
		if (StringUtils.isEmpty(Info)) {
			logger.error("设备号不存在，不能修改信息");
			throw new QueryInfoException("设备号不存在，不能修改信息");
		}
		int count = userRegisterDao.updateDevcAuthcode(devcInfo);
		if (count != 1) {
			logger.error("更新认证码失败！");
			dbo.rollback();
			throw new InsertInfoException("更新认证码失败！");
		}
		dbo.commit();
		logger.info("更新认证码成功！");
		return count;		
	}
	
	
}
