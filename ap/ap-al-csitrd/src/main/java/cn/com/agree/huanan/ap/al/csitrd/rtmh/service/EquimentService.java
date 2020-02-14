package cn.com.agree.huanan.ap.al.csitrd.rtmh.service;

import java.util.HashMap;
import java.util.Map; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.dao.EquimentDao;
import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RtmhModelInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class EquimentService {
	@Autowired EquimentDao equimentDao;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	/**
	 * 分页查询查询设备信息
	 *  
	 */

	public Map<String, Object> queryModelInfo(int pageFlag,int pageSize,String modelid,String modelstatus) {
		//查询
		if (pageFlag < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageFlag");	//XXX
		}
		
		return equimentDao.selectModelInfo(pageFlag, pageSize, modelid,modelstatus);
	}

	

	/**
	 * 查询设备信息 
	 */
	public Map<String,Object> findModelInfo(String modelid,String modelstatus){		
		//查询设备信息
		RtmhModelInfo rtmhModelInfo = equimentDao.queryModelInfo(modelid, modelstatus);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("modelid", rtmhModelInfo.getModelId());
		resultMap.put("modelname", rtmhModelInfo.getModelName());
		resultMap.put("modelsp", rtmhModelInfo.getModelSp());
		resultMap.put("modelsx", rtmhModelInfo.getModelSx());
		resultMap.put("modelstatus", rtmhModelInfo.getModelStatus());
		resultMap.put("modelstatpath", rtmhModelInfo.getModStatPath());
		return resultMap;
		
	}
}
