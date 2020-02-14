package cn.com.agree.huanan.ap.al.csiopr.service.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.service.dao.ServiceCenterDao;
import cn.com.agree.huanan.ap.al.csiopr.service.po.ServiceCenter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 服务中心相关服务
 * @author hcp
 *
 */
@Service
public class ServiceCenterService {
	
	@Autowired private Logger logger;
	@Autowired private ServiceCenterDao serviceCenterDao;

	public Map<String,Object> queryServiceCenterlist(int curpage , int pageSize) {
		if (curpage < 1){
			logger.info("页码小于1，返回第1页");
			curpage = 1;
		}
		IPage<ServiceCenter> pageDatas = serviceCenterDao.selectServiceCenterlist(curpage,curpage);
		Map<String,Object> result = new HashMap<>();
		result.put("",pageDatas.getTotal());
		result.put("",pageDatas.getPages());
		result.put("",pageDatas.getRecords());
		return  result;
	}
}
