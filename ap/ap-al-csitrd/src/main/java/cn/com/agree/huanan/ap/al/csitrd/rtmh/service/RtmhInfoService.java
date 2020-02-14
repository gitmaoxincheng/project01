package cn.com.agree.huanan.ap.al.csitrd.rtmh.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.dao.RecesiptDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;


public class RtmhInfoService {

	@Autowired RecesiptDao recesiptDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	//查询数据
	public String queruRtmhInfoByNo(String serialNo) {
		logger.info("插入账单信息开始");
		return recesiptDao.selectRecesipt(serialNo);
		
	}
	
}
